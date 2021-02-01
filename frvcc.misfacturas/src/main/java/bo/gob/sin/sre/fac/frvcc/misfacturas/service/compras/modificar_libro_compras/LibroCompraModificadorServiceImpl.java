package bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras.modificar_libro_compras;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.EnumFacFrvccMensajesShared;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.secundary.compras.validadores_libro_compras.LibroCompraValidador;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.Compra;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraCodigoAutorizacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraCodigoControl;
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
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraNumeroDocumentoCliente;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraNumeroDui;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraNumeroFactura;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraOrigenId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraRazonSocialProveedor;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraTipoCompraId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.ConDerechoCf;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.EnumMarcaEspecialId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.compras.modificar_libro_compras.ILibroCompraModificar;
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
public class LibroCompraModificadorServiceImpl implements ILibroCompraModificar {
	private static final Logger LOG = LoggerFactory.getLogger(LibroCompraModificadorServiceImpl.class);
	private final CompraRepository repository;
	private final EventBus eventBus;
	private final QueryBus queryBus;
	private final LibroCompraValidador validador;
	private final VerificaCodigoAutorizacionRepository verificaCodigoAutorizacionRepository;

	public LibroCompraModificadorServiceImpl(CompraRepository pRepository, EventBus pEventBus, QueryBus pQueryBus,
			LibroCompraValidador pValidador,
			VerificaCodigoAutorizacionRepository pVerificadorCodigoAutorizacionRepository) {
		this.repository = pRepository;
		this.eventBus = pEventBus;
		this.queryBus = pQueryBus;
		this.validador = pValidador;
		this.verificaCodigoAutorizacionRepository = pVerificadorCodigoAutorizacionRepository;
	}

	@Override
	public void modificar(CompraId pId, CompraNitProveedor pNitProveedor, CompraNumeroFactura pNumeroFactura,
			CompraNumeroDui pNumeroDui, CompraCodigoAutorizacion pCodigoAutorizacion, CompraFechaFactura pFechaFactura,
			CompraImporteTotalCompra pImporteTotalCompra, CompraImporteNoSujetoCf pimporteNoSujetoCf,
			CompraDescuento pDescuento, CompraImporteBaseCf pImporteBaseCf, CompraCodigoControl pCodigoControl,
			CompraNumeroDocumentoCliente pNumeroDocumentoCliente, CompraOrigenId pOrigenId,
			CompraTipoCompraId pTipoCompra, CompraUsuarioUltimaModificacion pUsuarioUltimaModificacion)
			throws QueryNotRegisteredError, QueryHandlerExecutionError {

		Compra vCompra = repository.findById(pId).orElseThrow(() -> new CompraListaErrores(pId, validador.crearValidacionCompraNoExiste()));

		 if (pId.value().equals(vCompra.id().value()) &&
				 pNitProveedor.value().equals(vCompra.nitProveedor().value()) &&
				 pNumeroFactura.value().equals(vCompra.numeroFactura().value()) &&
				 pNumeroDui.value().equals(vCompra.numeroDui().value()) &&
				 pCodigoAutorizacion.value().equals(vCompra.codigoAutorizacion().value()) &&
	             pFechaFactura.value().equals(vCompra.fechaFactura().value()) &&
	             pImporteTotalCompra.value().equals(vCompra.importeTotalCompra().value()) &&
	             pimporteNoSujetoCf.value().equals(vCompra.importeNoSujetoCf().value()) &&
	             pDescuento.value().equals(vCompra.descuento().value()) &&
	             pCodigoControl.value().equals(vCompra.codigoControl().value()) &&
	             pNumeroDocumentoCliente.value().equals(vCompra.numeroDocumentoCliente().value())  &&
	             pOrigenId.value().equals(vCompra.origenId().value())
	             ) {
	            return;
	        }

		CompraIfcProveedorNb vIfcProveedorNb = null;
		CompraRazonSocialProveedor vRazonSocialProveedor = null;

		if (!vCompra.nitProveedor().value().equals(pNitProveedor.value())) {
			ContribuyenteResponse vContribuyenteResponse = queryBus.ask(new BuscarContribuyentePorNitQueryDto(pNitProveedor.value()));
			vIfcProveedorNb = new CompraIfcProveedorNb(vContribuyenteResponse.ifc());
			vRazonSocialProveedor = new CompraRazonSocialProveedor(vContribuyenteResponse.razonSocial());
		}

		if (!(pNitProveedor.value().equals(vCompra.nitProveedor().value())
				&& pNumeroFactura.value().equals(vCompra.numeroFactura().value())
				&& pNumeroDui.value().equals(vCompra.numeroDui().value()) 
				&& pCodigoAutorizacion.value().equals(vCompra.codigoAutorizacion().value())
				&& pFechaFactura.value().equals(vCompra.fechaFactura().value())
				&& pImporteTotalCompra.value().equals(vCompra.importeTotalCompra().value())
				&& pimporteNoSujetoCf.value().equals(vCompra.importeNoSujetoCf().value())
				&& pDescuento.value().equals(vCompra.descuento().value()) 
				&& pCodigoControl.value().equals(vCompra.codigoControl().value()))) {
				
			
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
				
				
				if (vCompra.nitProveedor().value().equals(pNitProveedor.value())
	                    && vCompra.codigoAutorizacion().value().equals(pCodigoAutorizacion.value())
	                    && vCompra.numeroFactura().value().equals(pNumeroFactura.value()) 
	                    && vCompra.numeroDui().value().equals(pNumeroDui.value())
	                    ) {
					
					vCompra.modificarLibro(vIfcProveedorNb, pNitProveedor, vRazonSocialProveedor, pNumeroFactura, pNumeroDui,
							pCodigoAutorizacion, pFechaFactura, pImporteTotalCompra, pimporteNoSujetoCf, pDescuento, pImporteBaseCf,
							vCreditoFiscal, pCodigoControl, pOrigenId, vModalidadId, vMarcaEspecialId, pUsuarioUltimaModificacion,
							pTipoCompra);

					try {
						repository.guardar(vCompra);
						LOG.info("compra editada {}", vCompra.tipoCompraId());
					} catch (Exception excepcion) {
						LOG.error(excepcion.getCause().toString(), excepcion);
						throw new CompraListaErrores(pId, crearValidacionException());

					}
					eventBus.publish(vCompra.pullDomainEvents());
					return;
				}else {
					vCompra.modificarLibro(vIfcProveedorNb, pNitProveedor, vRazonSocialProveedor, pNumeroFactura, pNumeroDui,
							pCodigoAutorizacion, pFechaFactura, pImporteTotalCompra, pimporteNoSujetoCf, pDescuento, pImporteBaseCf,
							vCreditoFiscal, pCodigoControl, pOrigenId, vModalidadId, vMarcaEspecialId, pUsuarioUltimaModificacion,
							pTipoCompra);
					  repository.BuscarCompraEstandarExistente(vCompra).ifPresentOrElse(compra -> {
                          throw new CompraListaErrores(compra.id(),crearValidacionCompraExistente());
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
			} 
		  }
		
	

	private ValidationResponse crearValidacionException() {
		return new ValidationResponse(new HashMap<>() {
			{
				put("id", Arrays.asList(EnumFacFrvccMensajesShared.ERROR_EDICION.getId()));
			}
		});
	}

	private ValidationResponse crearValidacionCompraExistente() {
		return new ValidationResponse(new HashMap<>() {
			{
				put("nitProveedor", Arrays.asList(EnumFacFrvccMensajesShared.COMPRA_YA_EXISTE.getId()));
			}
		});
	}
	

}
