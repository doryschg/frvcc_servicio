package bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras.registro_libro_compras;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.secundary.compras.validadores_libro_compras.LibroCompraValidador;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.*;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.compras.registro_libro_compras.ICompraRegistradorLibro;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.compras.CompraRepository;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.compras.VerificaCodigoAutorizacionRepository;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.compras.VerificadorNumeroAutoriacion;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.EnumFacFrvccMensajesShared;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.contribuyentes.ContribuyenteResponse;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.contribuyentes.BuscarContribuyentePorNitQueryDto;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ValidationResponse;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.EventBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryNotRegisteredError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Service
public final class CompraRegistradorLibroServiceImpl implements ICompraRegistradorLibro {
    private static final Logger LOG = LoggerFactory.getLogger(CompraRegistradorLibroServiceImpl.class);
    private final CompraRepository repository;
    private final EventBus eventBus;
    private final QueryBus queryBus;
    private final LibroCompraValidador validador;
    private final VerificaCodigoAutorizacionRepository verificaCodigoAutorizacionRepository;

    public CompraRegistradorLibroServiceImpl(CompraRepository pRepository, EventBus pEventBus, QueryBus pQueryBus, LibroCompraValidador pValidador, VerificaCodigoAutorizacionRepository pVerificaCodigoAutorizacionRepository) {
        this.repository = pRepository;
        this.eventBus = pEventBus;
        this.queryBus = pQueryBus;
        this.validador = pValidador;
        this.verificaCodigoAutorizacionRepository = pVerificaCodigoAutorizacionRepository;
    }

    public void registrar(CompraId pId,
    			 CompraNitProveedor pNitProveedor,
    			 CompraNumeroFactura pNumeroFactura,
    			 CompraNumeroDui pNumeroDui,
    			 CompraCodigoAutorizacion pCodigoAutorizacion,
    			 CompraFechaFactura pFechaFactura,
                 CompraImporteTotalCompra pImporteTotalCompra,
                 CompraImporteNoSujetoCf pimporteNoSujetoCf,
                 CompraDescuento pDescuento,
                 CompraImporteBaseCf pImporteBaseCf,
                 CompraCodigoControl pCodigoControl,
                 CompraTipoDocumentoCliente pTipoDocumentoCliente,
                 CompraNumeroDocumentoCliente pNumeroDocumentoCliente,
                 CompraComplementoDocumentoCliente pComplementoDocumentoCliente,
                 CompraNombreCliente pNombreCliente,
                 CompraOrigenId pOrigenId,
                 CompraUsuarioRegistro pUsuarioRegistro)
            throws QueryNotRegisteredError, QueryHandlerExecutionError {

    	//TODO VALORES NULOS
        ValidationResponse vResultadoValidacion = validador.validarLibroCompra(
                new HashMap<>() {{
                    put("id", pId.value() != null ? pId.value() : "");
                    put("nitProveedor", pNitProveedor.value() != null ? pNitProveedor.value().toString() : "");
                    put("numeroFactura", pNumeroFactura.value() != null ? pNumeroFactura.value().toString() : "");
                    put("numeroDui", pNumeroDui.value() != null ? pNumeroDui.value().toString() : "");
                    put("codigoAutorizacion", pCodigoAutorizacion.value() != null ? pCodigoAutorizacion.value() : "");
                    put("fechaFactura", pFechaFactura.value() != null ? pFechaFactura.value().toString() : "");
                    put("importeTotalCompra", pImporteTotalCompra.value() != null ? pImporteTotalCompra.value().toString() : "");
                    put("importeBaseCf", pImporteBaseCf.value() != null ? pImporteBaseCf.value().toString() : "");
                    put("tipoDocumentoCliente", pTipoDocumentoCliente.value() != null ? pTipoDocumentoCliente.value() : "");
                    put("numeroDocumentoCliente", pNumeroDocumentoCliente.value() != null ? pNumeroDocumentoCliente.value() : "");
                    put("nombreCliente", pNombreCliente.value() != null ? pNombreCliente.value() : "");
                    put("origenId", pOrigenId.value() != null ? pOrigenId.value() : "");
                    put("usuarioRegistro", pUsuarioRegistro.value() != null ? pUsuarioRegistro.value().toString() : "");  
                }});

        if (vResultadoValidacion.hasErrors()) {
            throw new CompraListaErrores(pId, vResultadoValidacion);
        }
        
        ContribuyenteResponse vContribuyenteResponse = pNitProveedor.value() == null ? null : queryBus.ask(new BuscarContribuyentePorNitQueryDto(pNitProveedor.value()));
        CompraIfcProveedorNb vIfcProveedorNb = new CompraIfcProveedorNb(vContribuyenteResponse.ifc());
        CompraRazonSocialProveedor vRazonSocialProveedor = new CompraRazonSocialProveedor(vContribuyenteResponse.razonSocial());
        
        CompraModalidadId vModalidadId=new CompraModalidadId(null);
        CompraCreditoFiscal vCreditoFiscal =new CompraCreditoFiscal(null);
        CompraImporteBaseCf vImporteBaseCf=new CompraImporteBaseCf(null);
        CompraMarcaEspecialId vMarcaEspecialId=new CompraMarcaEspecialId(null);
        CompraConDerechoCf vConDerechoCf=new CompraConDerechoCf(null);
        
		if (pNumeroDui.value().equals("0")  && pNumeroFactura.value()!=0) {
			VerificadorNumeroAutoriacion vResultadoVerificadorNumeroAutorizacion = verificaCodigoAutorizacionRepository.verificaCodigoAutorizacion(pNitProveedor.value(), pNumeroFactura.value(),pCodigoAutorizacion.value(), pNumeroDocumentoCliente.value(), pFechaFactura.value(),pCodigoControl.value(), pImporteTotalCompra.value());
			if (!vResultadoVerificadorNumeroAutorizacion.isValid()) {
				throw new CompraListaErrores(pId, validador.getValidacionNumeroAutorizacionException(vResultadoVerificadorNumeroAutorizacion.getErorres()));
			}
			vModalidadId = new CompraModalidadId(vResultadoVerificadorNumeroAutorizacion.getModalidad());
			vCreditoFiscal = CompraCreditoFiscal.creditoFiscal(pImporteTotalCompra.value(),pImporteBaseCf.value(), vResultadoVerificadorNumeroAutorizacion.getMarcaEspecial(),vResultadoVerificadorNumeroAutorizacion.getCreditoFiscal());
			vImporteBaseCf = CompraImporteBaseCf.importeBaseCreditoFiscal(pImporteTotalCompra.value(), pImporteBaseCf.value(),vResultadoVerificadorNumeroAutorizacion.getMarcaEspecial(),vResultadoVerificadorNumeroAutorizacion.getCreditoFiscal());
			vMarcaEspecialId = new CompraMarcaEspecialId(vResultadoVerificadorNumeroAutorizacion.getMarcaEspecial());
			vConDerechoCf = new CompraConDerechoCf(vResultadoVerificadorNumeroAutorizacion.getConDerechoCf());
		}
		if (!pNumeroDui.value().equals("0") && pNumeroFactura.value()==0)  {
			
			//vModalidadId = new CompraModalidadId("DUI");
			vModalidadId = new CompraModalidadId("CMP");
			vImporteBaseCf = new CompraImporteBaseCf(pImporteBaseCf.value());
			vMarcaEspecialId = new CompraMarcaEspecialId(EnumMarcaEspecialId.SINMARCA.value());
			vConDerechoCf = new CompraConDerechoCf(ConDerechoCf.SI.toString());
			vCreditoFiscal = CompraCreditoFiscal.creditoFiscal(pImporteTotalCompra.value(),pImporteBaseCf.value(), vMarcaEspecialId.value(),new BigDecimal("13"));
			
		}
     
       Compra vCompra = Compra.registroCompraLibro(pId,
        		vIfcProveedorNb,
        		pNitProveedor,
        		vRazonSocialProveedor,
        		pNumeroFactura,
        		pNumeroDui,
        		pCodigoAutorizacion,
                pFechaFactura,
                pImporteTotalCompra,
                pimporteNoSujetoCf,
                pDescuento,
                vImporteBaseCf,
                vCreditoFiscal,
                pCodigoControl,
                pTipoDocumentoCliente,
                pNumeroDocumentoCliente,
                pComplementoDocumentoCliente,
                pNombreCliente,
                pOrigenId,
                vModalidadId,
                vMarcaEspecialId,
                pUsuarioRegistro,
                vConDerechoCf);
        repository.BuscarCompraEstandarExistente(vCompra)
                .ifPresentOrElse(compra -> {
                            throw new CompraListaErrores(compra.id(), crearValidacionCompraExistente());
                        },
                        () -> {
                            try {
                                repository.guardar(vCompra);
                                eventBus.publish(vCompra.pullDomainEvents());
                            } catch (Exception excepcion) {
                                LOG.error(excepcion.getCause().toString(), excepcion);
                                throw new CompraListaErrores(pId, crearValidacionException());

                            }
                        });

    }

    public String validarNumeroAutorizacion(String pCodigoAutorizacion) {
		String vModalidad="";
		String vDato = "";
		vDato = pCodigoAutorizacion.substring(3, 4);
		switch (vDato) {
		case "1": {vModalidad = "MAN";break;}
		case "3": {vModalidad = "PRE";break;}
		case "4": {vModalidad = "CMP";break;}
		case "6": {vModalidad = "LIN";break;}
		case "7": {vModalidad = "ELE";break;}
		case "8": {vModalidad = "CIC";break;}
		default: {vModalidad = "";break;}
		}
		return vModalidad;
	}

	private ValidationResponse crearValidacionCompraExistente() {
        return new ValidationResponse(new HashMap<>() {{
            put("nitProveedor", Arrays.asList(EnumFacFrvccMensajesShared.COMPRA_YA_EXISTE.getId()));
        }});
    }

    private ValidationResponse crearValidacionException() {
        return new ValidationResponse(new HashMap<>() {{
            put("id", Arrays.asList(EnumFacFrvccMensajesShared.ERROR_REGISTRO_FACTURAS_COMPRAS.getId()));
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
}
