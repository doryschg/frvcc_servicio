package bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras.registro_libro_compras;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.EnumFacFrvccMensajesShared;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.registro_libro.registro_masivo.ComprasRegistroLibroCommandImpl;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.secundary.compras.validadores_libro_compras.LibroCompraValidador;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.Compra;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraCodigoAutorizacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraCodigoControl;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraComplementoDocumentoCliente;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraConDerechoCf;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraCreditoFiscal;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraDescuento;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraFechaFactura;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraIfcProveedorNb;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraImporteBaseCf;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraImporteNoSujetoCf;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraImporteTotalCompra;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraListaErrores;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraMarcaEspecialId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraModalidadId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraNitProveedor;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraNombreCliente;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraNumeroDocumentoCliente;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraNumeroDui;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraNumeroFactura;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraOrigenId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraRazonSocialProveedor;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraTipoDocumentoCliente;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraUsuarioRegistro;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.ConDerechoCf;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.EnumMarcaEspecialId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.compras.registro_libro_compras.IComprasRegistradorLibro;
//import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.registro.registro_masivo.RegistroComprasCommand;
//import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.secundary.compras.validadores.CompraValidador;
//import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.compras.registro.IComprasRegistrador;
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
public class ComprasRegistradorLibroServiceImpl implements IComprasRegistradorLibro {
	private static final Logger LOG = LoggerFactory.getLogger(ComprasRegistradorLibroServiceImpl.class);
	private final CompraRepository repository;
	private final EventBus eventBus;
	private final QueryBus queryBus;
	private final LibroCompraValidador validador;
	private final VerificaCodigoAutorizacionRepository verificaCodigoAutorizacionRepository;

	public ComprasRegistradorLibroServiceImpl(CompraRepository pRepository, EventBus pEventBus, QueryBus pQueryBus,
			LibroCompraValidador pValidador, VerificaCodigoAutorizacionRepository pVerificaCodigoAutorizacionRepository) {
		this.repository = pRepository;
		this.eventBus = pEventBus;
		this.queryBus = pQueryBus;
		this.validador = pValidador;
		this.verificaCodigoAutorizacionRepository = pVerificaCodigoAutorizacionRepository;
	}

	// TODO REFACTORIZAR REGISTRO MASIVO
	@Override
	public void registrar(ComprasRegistroLibroCommandImpl pCommands) {
		HashMap<String, ValidationResponse> vResutaldosValidacion = new HashMap<>(
				pCommands.getRegistroCompras().stream().map(command -> {
					var object = new Object() {
						public final String id = command.getId();
						public final ValidationResponse validationResponse = validador.validarLibroCompra(new HashMap<>() {{
										put("id", command.getId());
										put("nitProveedor",command.getNitProveedor() != null ? command.getNitProveedor().toString(): "");
										put("numeroFactura", command.getNumeroFactura() != null ?command.getNumeroFactura().toString() : "");
										put("numeroDui", command.getNumeroDui() != null ?command.getNumeroDui().toString() : "");   
										put("codigoAutorizacion",command.getCodigoAutorizacion() != null? command.getCodigoAutorizacion(): "");
										put("fechaFactura",command.getFechaFactura() != null ? command.getFechaFactura().toString(): "");
										put("importeTotalCompra",command.getImporteTotalCompra() != null? command.getImporteTotalCompra().toString(): "");
										put("importeBaseCf",command.getImporteBaseCf() != null? command.getImporteBaseCf().toString(): "");
										put("tipoDocumentoCliente",command.getTipoDocumentoCliente() != null? command.getTipoDocumentoCliente(): "");
										put("numeroDocumentoCliente",command.getNumeroDocumentoCliente() != null? command.getNumeroDocumentoCliente(): "");
										put("nombreCliente",command.getNombreCliente() != null ? command.getNombreCliente() : "");
										put("origenId", command.getOrigenId() != null ? command.getOrigenId() : "");
										put("usuarioRegistro",command.getUsuarioRegistro() != null? command.getUsuarioRegistro().toString(): "");
									}});
					};
					return object;
				}).filter(object -> object.validationResponse.hasErrors())
						.collect(Collectors.toMap(object -> object.id, object -> object.validationResponse)));

		if (vResutaldosValidacion.size() > 0) {
			throw new CompraListaErrores(vResutaldosValidacion);
		}
		long startTime = System.nanoTime();
		HashMap<Long, ContribuyenteResponse> vContribuyentes = new HashMap<>();
		List<Compra> vCompras = pCommands.getRegistroCompras().stream().map(command -> {
			ContribuyenteResponse contribuyenteResponse = null;

			try {
				if (!vContribuyentes.containsKey(command.getNitProveedor())) {
					contribuyenteResponse = queryBus
							.ask(new BuscarContribuyentePorNitQueryDto(command.getNitProveedor()));
					vContribuyentes.put(command.getNitProveedor(), contribuyenteResponse);
				}

				CompraIfcProveedorNb ifcProveedorNb = new CompraIfcProveedorNb(vContribuyentes.get(command.getNitProveedor()).ifc());
				CompraRazonSocialProveedor razonSocialProveedor = new CompraRazonSocialProveedor(vContribuyentes.get(command.getNitProveedor()).razonSocial());

				CompraModalidadId vModalidadId = new CompraModalidadId(null);
				CompraCreditoFiscal vCreditoFiscal = new CompraCreditoFiscal(null);
				CompraImporteBaseCf vImporteBaseCf = new CompraImporteBaseCf(null);
				CompraMarcaEspecialId vMarcaEspecialId = new CompraMarcaEspecialId(null);
				CompraConDerechoCf vConDerechoCf = new CompraConDerechoCf(null);

				if (command.getNumeroDui().equals("0") &&  command.getNumeroFactura()!=0) {
					VerificadorNumeroAutoriacion vResultadoVerificadorNumeroAutorizacion = verificaCodigoAutorizacionRepository
							.verificaCodigoAutorizacion(command.getNitProveedor(), command.getNumeroFactura(),
									command.getCodigoAutorizacion(), command.getNumeroDocumentoCliente(),
									command.getFechaFactura(), command.getCodigoControl(),
									command.getImporteTotalCompra());
					if (vResultadoVerificadorNumeroAutorizacion.isValid()) {
						vModalidadId = new CompraModalidadId(vResultadoVerificadorNumeroAutorizacion.getModalidad());
						vImporteBaseCf = CompraImporteBaseCf.importeBaseCreditoFiscal(command.getImporteTotalCompra(),
								command.getImporteBaseCf(), vResultadoVerificadorNumeroAutorizacion.getMarcaEspecial(),
								vResultadoVerificadorNumeroAutorizacion.getCreditoFiscal());
						vCreditoFiscal = CompraCreditoFiscal.creditoFiscal(command.getImporteTotalCompra(),
								vImporteBaseCf.value(), vResultadoVerificadorNumeroAutorizacion.getMarcaEspecial(),
								vResultadoVerificadorNumeroAutorizacion.getCreditoFiscal());
						vMarcaEspecialId = new CompraMarcaEspecialId(vResultadoVerificadorNumeroAutorizacion.getMarcaEspecial());
						vConDerechoCf = new CompraConDerechoCf(vResultadoVerificadorNumeroAutorizacion.getConDerechoCf());

						return Compra.registroCompraLibro(new CompraId(command.getId()), ifcProveedorNb,
								new CompraNitProveedor(command.getNitProveedor()), razonSocialProveedor,
								new CompraNumeroFactura(command.getNumeroFactura()),
								new CompraNumeroDui(command.getNumeroDui()),
								new CompraCodigoAutorizacion(command.getCodigoAutorizacion()),
								new CompraFechaFactura(command.getFechaFactura()),
								new CompraImporteTotalCompra(command.getImporteTotalCompra()),
								new CompraImporteNoSujetoCf(command.getimporteNoSujetoCf()),
								new CompraDescuento(command.getDescuento()), vImporteBaseCf, vCreditoFiscal,
								new CompraCodigoControl(command.getCodigoControl()),
								new CompraTipoDocumentoCliente(command.getTipoDocumentoCliente()),
								new CompraNumeroDocumentoCliente(command.getNumeroDocumentoCliente()),
								new CompraComplementoDocumentoCliente(command.getComplementoDocumentoCliente()),
								new CompraNombreCliente(command.getNombreCliente()),
								new CompraOrigenId(command.getOrigenId()), vModalidadId, vMarcaEspecialId,
								new CompraUsuarioRegistro(command.getUsuarioRegistro()), vConDerechoCf);
					} else {
						vResutaldosValidacion.put(command.getId(), crearValidacionNumeroAutorizacionException(
								vResultadoVerificadorNumeroAutorizacion.getErorres()));
					}
				} 
				if (!command.getNumeroDui().equals("0") &&  command.getNumeroFactura()==0){
					//vModalidadId = new CompraModalidadId("DUI");
					vModalidadId = new CompraModalidadId("CMP");
					vImporteBaseCf = new CompraImporteBaseCf(command.getImporteBaseCf());
					vMarcaEspecialId = new CompraMarcaEspecialId(EnumMarcaEspecialId.SINMARCA.value());
					vConDerechoCf = new CompraConDerechoCf(ConDerechoCf.SI.toString());
					vCreditoFiscal = CompraCreditoFiscal.creditoFiscal(command.getImporteTotalCompra(),command.getImporteBaseCf(), vMarcaEspecialId.value(),new BigDecimal("13"));
					
					return Compra.registroCompraLibro(new CompraId(command.getId()), ifcProveedorNb,
							new CompraNitProveedor(command.getNitProveedor()), razonSocialProveedor,
							new CompraNumeroFactura(command.getNumeroFactura()),
							new CompraNumeroDui(command.getNumeroDui()),
							new CompraCodigoAutorizacion(command.getCodigoAutorizacion()),
							new CompraFechaFactura(command.getFechaFactura()),
							new CompraImporteTotalCompra(command.getImporteTotalCompra()),
							new CompraImporteNoSujetoCf(command.getimporteNoSujetoCf()),
							new CompraDescuento(command.getDescuento()), vImporteBaseCf, vCreditoFiscal,
							new CompraCodigoControl(command.getCodigoControl()),
							new CompraTipoDocumentoCliente(command.getTipoDocumentoCliente()),
							new CompraNumeroDocumentoCliente(command.getNumeroDocumentoCliente()),
							new CompraComplementoDocumentoCliente(command.getComplementoDocumentoCliente()),
							new CompraNombreCliente(command.getNombreCliente()),
							new CompraOrigenId(command.getOrigenId()), vModalidadId, vMarcaEspecialId,
							new CompraUsuarioRegistro(command.getUsuarioRegistro()), vConDerechoCf);
				}

				return null;

			} catch (QueryHandlerExecutionError queryHandlerExecutionError) {
				queryHandlerExecutionError.printStackTrace();
				return null;
			} catch (QueryNotRegisteredError queryNotRegisteredError) {
				queryNotRegisteredError.printStackTrace();
				return null;
			}

		}).collect(Collectors.toList());

		if (vResutaldosValidacion.size() > 0) {
			throw new CompraListaErrores(vResutaldosValidacion);
		}

		long vElapsedTime = System.nanoTime() - startTime;
		System.out.println(
				"Numero de compras: " + vCompras.size() + " Timpo de Ejecucion Sing Guardar" + vElapsedTime / 1000000);
		
		vCompras.stream().filter(compra ->
		repository.BuscarCompraEstandarExistente(compra).isPresent()).forEach(compra -> {
			vResutaldosValidacion.put(compra.id().value(), crearValidacionCompraExistente());
		});
		

		if (vResutaldosValidacion.size() > 0) {
			throw new CompraListaErrores(vResutaldosValidacion);
		}

		repository.guardarTodo(vCompras);
		vCompras.stream().forEach(compra -> eventBus.publish(compra.pullDomainEvents()));
		vElapsedTime = System.nanoTime() - startTime;
		System.out.println(
				"Numero de compras: " + vCompras.size() + " Timpo de Ejecucion Guardado" + vElapsedTime / 1000000);

	}

	public String validarNumeroAutorizacion(String pCodigoAutorizacion) {
		String vModalidad = "";
		String vDato = "";
		vDato = pCodigoAutorizacion.substring(3, 4);
		switch (vDato) {
		case "1": {
			vModalidad = "MAN";
			break;
		}
		case "3": {
			vModalidad = "PRE";
			break;
		}
		case "4": {
			vModalidad = "CMP";
			break;
		}
		case "6": {
			vModalidad = "LIN";
			break;
		}
		case "7": {
			vModalidad = "ELE";
			break;
		}
		case "8": {
			vModalidad = "CIC";
			break;
		}
		default: {
			vModalidad = "";
			break;
		}
		}
		return vModalidad;
	}

	private ValidationResponse crearValidacionCompraExistente() {
		return new ValidationResponse(new HashMap<>() {
			{
				put("nitProveedor", Arrays.asList(EnumFacFrvccMensajesShared.COMPRA_YA_EXISTE.getId()));
			}
		});
	}

	private ValidationResponse crearValidacionException() {
		return new ValidationResponse(new HashMap<>() {
			{
				put("id", Arrays.asList(EnumFacFrvccMensajesShared.ERROR_REGISTRO_FACTURAS_COMPRAS.getId()));
			}
		});
	}

	private ValidationResponse crearValidacionNumeroAutorizacionException(List<Integer> pListaErrores) {
		return new ValidationResponse(new HashMap<>() {
			{
				pListaErrores.stream().forEach(error -> {
					put("pNumeroAutorizacion", Arrays.asList(error));
				});
			}
		});
	}
}
