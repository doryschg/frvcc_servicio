package bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras.registro;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.*;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.shared.ICompraContribuyenteCache;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.EnumFacFrvccMensajesShared;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.registro.registro_masivo.RegistroComprasCommand;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.secundary.compras.validadores.CompraValidador;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.compras.registro.IComprasRegistrador;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.compras.CompraRepository;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.compras.VerificaCodigoAutorizacionRepository;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.compras.VerificadorNumeroAutoriacion;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.contribuyentes.ContribuyenteResponse;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.contribuyentes.BuscarContribuyentePorNitQueryDto;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ValidationResponse;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.EventBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryNotRegisteredError;


@Service
public class ComprasRegistradorServiceImpl implements IComprasRegistrador {
    private static final Logger LOG = LoggerFactory.getLogger(ComprasRegistradorServiceImpl.class);
    private final CompraRepository repository;
    private final EventBus eventBus;
    private final QueryBus queryBus;
    private final CompraValidador validador;
    private final VerificaCodigoAutorizacionRepository verificaCodigoAutorizacionRepository;
    private final ICompraContribuyenteCache compraContribuyenteCache;

    public ComprasRegistradorServiceImpl(CompraRepository pRepository, EventBus pEventBus, QueryBus queryBus, CompraValidador validador, VerificaCodigoAutorizacionRepository verificaCodigoAutorizacionRepository, ICompraContribuyenteCache compraContribuyenteCache) {
        this.repository = pRepository;
        this.eventBus = pEventBus;
        this.queryBus = queryBus;
        this.validador = validador;
        this.verificaCodigoAutorizacionRepository = verificaCodigoAutorizacionRepository;

        this.compraContribuyenteCache = compraContribuyenteCache;
    }
    //TODO REFACTORIZAR REGISTRO MASIVO
    @Override
    public void registrar(RegistroComprasCommand pCommands) {
        HashMap<String, ValidationResponse> vResutaldosValidacion = new HashMap<>(pCommands
                .getRegistroCompras().stream().map(command -> {
                    var object = new Object() {
                        public final String id = command.getId();
                        public final ValidationResponse validationResponse = validador.validarCompra(
                                new HashMap<>() {{
                                    put("id", command.getId());
                                    put("fechaFactura", command.getFechaFactura() != null ? command.getFechaFactura().toString() : "");
                                    put("nitProveedor", command.getNitProveedor() != null ? command.getNitProveedor().toString() : "");
                                    put("numeroFactura", command.getNumeroFactura() != null ? command.getNumeroFactura().toString() : "");
                                    put("codigoAutorizacion", command.getCodigoAutorizacion() != null ? command.getCodigoAutorizacion() : "");
                                    put("importeTotalCompra", command.getImporteTotalCompra() != null ? command.getImporteTotalCompra().toString() : "");
                                    put("codigoControl", command.getCodigoControl() != null ? command.getCodigoControl() : "");
                                    put("usuarioRegistro", command.getUsuarioRegistro() != null ? command.getUsuarioRegistro().toString() : "");
                                    put("nombreCliente", command.getNombreCliente() != null ? command.getNombreCliente() : "");
                                    put("tipoDocumentoCliente", command.getTipoDocumentoCliente() != null ? command.getTipoDocumentoCliente() : "");
                                    put("numeroDocumentoCliente", command.getNumeroDocumentoCliente() != null ? command.getNumeroDocumentoCliente() : "");
                                    put("origenId", command.getOrigenId() != null ? command.getOrigenId() : "");
                                }});
                    };
                    return object;
                }).filter(object -> object.validationResponse.hasErrors())
                .collect(Collectors.toMap(object -> object.id, object -> object.validationResponse)));

        if (vResutaldosValidacion.size() > 0) {
            throw new CompraListaErrores(vResutaldosValidacion);
        }

        HashMap<Long,ContribuyenteCache> contribuyentes = new HashMap<>();
        List<Compra> vCompras = pCommands.getRegistroCompras().stream().map(command -> {
                    ContribuyenteResponse vContribuyenteResponse = null;

					try {

						VerificadorNumeroAutoriacion vResultadoVerificadorNumeroAutorizacion = verificaCodigoAutorizacionRepository
								.verificaCodigoAutorizacion(command.getNitProveedor(), command.getNumeroFactura(),command.getCodigoAutorizacion(), command.getNumeroDocumentoCliente(),command.getFechaFactura(), command.getCodigoControl(),command.getImporteTotalCompra());
						
						if (vResultadoVerificadorNumeroAutorizacion.isValid()) {
							
							CompraModalidadId vModalidadId = new CompraModalidadId(vResultadoVerificadorNumeroAutorizacion.getModalidad());
                            CompraImporteBaseCf vImporteBaseCf = CompraImporteBaseCf.importeBaseCreditoFiscal(command.getImporteTotalCompra(), command.getImporteBaseCf(),vResultadoVerificadorNumeroAutorizacion.getMarcaEspecial(),vResultadoVerificadorNumeroAutorizacion.getCreditoFiscal());
							CompraCreditoFiscal vCreditoFiscal = CompraCreditoFiscal.creditoFiscal(command.getImporteTotalCompra(), vImporteBaseCf.value(),vResultadoVerificadorNumeroAutorizacion.getMarcaEspecial(),vResultadoVerificadorNumeroAutorizacion.getCreditoFiscal());
							CompraMarcaEspecialId vMarcaEspecialId = new CompraMarcaEspecialId(vResultadoVerificadorNumeroAutorizacion.getMarcaEspecial());
							CompraConDerechoCf vConDerechoCf = new CompraConDerechoCf(vResultadoVerificadorNumeroAutorizacion.getConDerechoCf());
                            CompraTipoSectorId vTipoSectorId= new CompraTipoSectorId(vResultadoVerificadorNumeroAutorizacion.getTipoSector());
							if(compraContribuyenteCache.isPresent(command.getNitProveedor())){
                                 contribuyentes.put(command.getNitProveedor(), new ContribuyenteCache(compraContribuyenteCache.getIfcContribuyenteCache(command.getNitProveedor()), compraContribuyenteCache.getRazonSocialContribuyenteCache(command.getNitProveedor())));
                            }

                            if (!contribuyentes.containsKey(command.getNitProveedor())) {
								vContribuyenteResponse = queryBus.ask(new BuscarContribuyentePorNitQueryDto(command.getNitProveedor()));
								contribuyentes.put(command.getNitProveedor(),new ContribuyenteCache(vContribuyenteResponse.ifc(),vContribuyenteResponse.razonSocial()));
							}
							CompraIfcProveedorNb vIfcProveedorNb = new CompraIfcProveedorNb(contribuyentes.get(command.getNitProveedor()).getIfc());
							CompraRazonSocialProveedor razonSocialProveedor = new CompraRazonSocialProveedor(contribuyentes.get(command.getNitProveedor()).getRazonSocial());

							return Compra.registro(new CompraId(command.getId()),
									new CompraFechaFactura(command.getFechaFactura()), 
									vIfcProveedorNb,
									new CompraNitProveedor(command.getNitProveedor()), 
									razonSocialProveedor,
									new CompraNumeroFactura(command.getNumeroFactura()),
									new CompraCodigoAutorizacion(command.getCodigoAutorizacion()),
									new CompraImporteTotalCompra(command.getImporteBaseCf()), 
									vImporteBaseCf,
									new CompraCodigoControl(command.getCodigoControl()),
									new CompraUsuarioRegistro(command.getUsuarioRegistro()),
									new CompraNombreCliente(command.getNombreCliente()),
									new CompraTipoDocumentoCliente(command.getTipoDocumentoCliente()),
									new CompraNumeroDocumentoCliente(command.getNumeroDocumentoCliente()),
									new CompraComplementoDocumentoCliente(command.getComplementoDocumentoCliente()),
									new CompraOrigenId(command.getOrigenId()),
									vModalidadId, 
									vCreditoFiscal,
									vMarcaEspecialId, vConDerechoCf,
                                    vTipoSectorId);
						} else {
							vResutaldosValidacion.put(command.getId(), crearValidacionNumeroAutorizacionException(vResultadoVerificadorNumeroAutorizacion.getErorres()));
						}
						return null;

            } catch (QueryHandlerExecutionError queryHandlerExecutionError) {
                queryHandlerExecutionError.printStackTrace();
                LOG.error(queryHandlerExecutionError.getCause().toString(), queryHandlerExecutionError);
                throw new CompraListaErrores(new CompraId(""), validador.getValidacionException());
            } catch (QueryNotRegisteredError queryNotRegisteredError) {
                queryNotRegisteredError.printStackTrace();
                LOG.error(queryNotRegisteredError.getCause().toString(), queryNotRegisteredError);
                throw new CompraListaErrores(new CompraId(""), validador.getValidacionException());
            }

        }
        ).collect(Collectors.toList());

        if (vResutaldosValidacion.size() > 0) {
            throw new CompraListaErrores(vResutaldosValidacion);
        }

 /*       long elapsedTime = System.nanoTime() - startTime;
        System.out.println("Numero de compras: " + vCompras.size()+" Timpo de Ejecucion Sing Guardar"
                + elapsedTime/1000000);*/

        vCompras.stream().filter(compra ->
            repository.BuscarCompraExistente(compra).isPresent()
        ).forEach( compra -> {
            vResutaldosValidacion.put(compra.id().value(),crearValidacionCompraExistente());
        });

        if (vResutaldosValidacion.size() > 0) {
            throw new CompraListaErrores(vResutaldosValidacion);
        }
     try{
         repository.guardarTodo(vCompras);
         vCompras.stream().forEach(compra -> eventBus.publish(compra.pullDomainEvents()));

     }catch (Exception e){
    	 LOG.error(e.getCause().toString(), e);
         throw new CompraListaErrores(new CompraId(""), validador.getValidacionException());
     }

/*
         elapsedTime = System.nanoTime() - startTime;
        System.out.println("Numero de compras: " + vCompras.size()+" Timpo de Ejecucion Guardado"
                + elapsedTime/1000000);
*/
    }

    private ValidationResponse crearValidacionCompraExistente(){
        return  new ValidationResponse(new HashMap<>() {{
            put("nitProveedor", Arrays.asList(EnumFacFrvccMensajesShared.COMPRA_YA_EXISTE.getId()));
        }});
    }


    private ValidationResponse crearValidacionNumeroAutorizacionException(List<Integer> pListaErrores) {
        return new ValidationResponse(new HashMap<>() {{
            pListaErrores.stream().forEach( error -> {
                        put("pNumeroAutorizacion",Arrays.asList(error));
                    }

            );
        }});
    }
    class ContribuyenteCache {
        private Long ifc;
        private String razonSocial;

        public ContribuyenteCache(Long ifc, String razonSocial) {
            this.ifc = ifc;
            this.razonSocial = razonSocial;
        }

        public Long getIfc() {
            return ifc;
        }

        public String getRazonSocial() {
            return razonSocial;
        }
    }
}


