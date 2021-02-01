package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.service.ventas.modificar;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.secundary.ventas.validadores.VentaValidador;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.Venta;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaCodigoAutorizacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaCodigoControl;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaConDerechoDf;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaDebitoFiscal;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaDescuento;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaFechaFactura;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaIfcProveedor;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaImporteBase;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaImporteExento;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaImporteIceIehdTasas;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaImporteNoSujetoDf;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaImporteTasaCero;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaImporteTotal;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaListaErrores;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaMarcaEspecialId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaNitProveedor;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaNombreCliente;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaNumeroDocumentoCliente;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaNumeroFactura;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaOrigenId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaRazonSocialProveedor;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaRecepcionId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaSubTotal;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.service.ventas.registro.VentaRegistroServiceImpl;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.use.ports.primary.ventas.modificar.IVentaModificar;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.use.ports.secundary.venta.IVentaRepository;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.EnumFacFrvccMensajesShared;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.contribuyentes.ContribuyenteResponse;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.contribuyentes.BuscarContribuyentePorNitQueryDto;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ValidationResponse;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.EventBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryNotRegisteredError;

@Service
public class VentaModificadorServiceImpl implements IVentaModificar {
	private static final Logger LOG = LoggerFactory.getLogger(VentaRegistroServiceImpl.class);
	private final IVentaRepository repository;
	private final EventBus eventBus;
	private final VentaValidador validador;
	private final QueryBus queryBus;

	public VentaModificadorServiceImpl(IVentaRepository pRepository, EventBus pEventBus, VentaValidador pValidador,
			QueryBus pQueryBus) {
		this.repository = pRepository;
		this.eventBus = pEventBus;
		this.validador = pValidador;
		this.queryBus = pQueryBus;
	}

	@Override
	public void modificar(VentaId pId, VentaRecepcionId pRecepcionId, VentaIfcProveedor pIfcProveedor,
			VentaNitProveedor pNitProveedor, VentaRazonSocialProveedor pRazonSocialProveedor,
			VentaNumeroDocumentoCliente pNumeroDocumentoCliente, VentaNombreCliente pNombreCliente,
			VentaNumeroFactura pNumeroFactura, VentaCodigoAutorizacion pCodigoAutorizacion,
			VentaFechaFactura pFechaFactura, VentaImporteTotal pImporteTotalVenta, VentaCodigoControl pCodigoControl,
			VentaImporteBase pImporteBase, VentaOrigenId pOrigenId,
			VentaUsuarioUltimaModificacion pUsuarioUltimaModificacion, VentaConDerechoDf pVentaConDerechoDf,
			VentaMarcaEspecialId pVentaMarcaEspecialId, VentaDescuento pVentaDescuento,
			VentaDebitoFiscal pVentaDebitoFiscal, VentaImporteIceIehdTasas pVentaImporteIceIehdTasas,
			VentaImporteTasaCero pVentaImporteTasaCero, VentaImporteNoSujetoDf pVentaImporteNoSujetoDf,
			VentaImporteExento pVentaImporteExento, VentaSubTotal pVentaSubTotal)
			throws QueryNotRegisteredError, QueryHandlerExecutionError {

		ValidationResponse vResultadoValidacion = validador.validarVenta(new HashMap<>() {
			{
				put("id", pId.value() != null ? pId.value() : "");
				put("fechaFactura", pFechaFactura.value() != null ? pFechaFactura.value().toString() : "");
				put("nitProveedor", pNitProveedor.value() != null ? pNitProveedor.value().toString() : "");
				put("numeroFactura", pNumeroFactura.value() != null ? pNumeroFactura.value().toString() : "");
				put("codigoAutorizacion", pCodigoAutorizacion.value() != null ? pCodigoAutorizacion.value() : "");
				put("importeTotalVenta",
						pImporteTotalVenta.value() != null ? pImporteTotalVenta.value().toString() : "");
				put("origenId", pOrigenId.value() != null ? pOrigenId.value() : "");
				put("codigoControl", pCodigoControl.value() != null ? pCodigoControl.value() : "");
			}
		});

		if (vResultadoValidacion.hasErrors()) {
			throw new VentaListaErrores(pId, vResultadoValidacion);
		}

		Venta vVenta = repository.findById(pId)
				.orElseThrow(() -> new VentaListaErrores(pId, validador.crearValidacionVentaNoExiste()));

		if (pId.value().equals(vVenta.id().value()) && pFechaFactura.value().equals(vVenta.fechaFactura().value())
				&& pNitProveedor.value().equals(vVenta.nitProveedor().value())
				&& pNumeroFactura.value().equals(vVenta.numeroFactura().value())
				&& pCodigoAutorizacion.value().equals(vVenta.codigoAutorizacion().value())
				&& pImporteTotalVenta.value().equals(vVenta.importeTotal().value())
				&& pCodigoControl.value().equals(vVenta.codigoControl().value())
				&& pOrigenId.value().equals(vVenta.origenId())) {
			return;
		}

		VentaIfcProveedor vIfcProveedorNb = new VentaIfcProveedor(0L);
		VentaRazonSocialProveedor vRazonSocialProveedor = new VentaRazonSocialProveedor(null);

		ContribuyenteResponse vContribuyenteResponse = (ContribuyenteResponse) Optional
				.ofNullable(queryBus.ask(new BuscarContribuyentePorNitQueryDto(pNitProveedor.value()))).orElse(null);
		if (vContribuyenteResponse != null) {
			vIfcProveedorNb = new VentaIfcProveedor(vContribuyenteResponse.ifc());
			vRazonSocialProveedor = new VentaRazonSocialProveedor(vContribuyenteResponse.razonSocial());
		}

		vVenta = Venta.modificar(pId, vVenta.recepcionId(), vVenta.ifcProveedor(), vVenta.nitProveedor(),
				vRazonSocialProveedor, pNumeroDocumentoCliente, pNombreCliente, pNumeroFactura, pCodigoAutorizacion,
				pFechaFactura, pImporteTotalVenta, pCodigoControl, pImporteBase, pOrigenId, vVenta.usuarioRegistro(),
				pUsuarioUltimaModificacion, pVentaConDerechoDf, pVentaMarcaEspecialId, pVentaDescuento,
				pVentaDebitoFiscal, pVentaImporteIceIehdTasas, pVentaImporteTasaCero, pVentaImporteNoSujetoDf,
				pVentaImporteExento, pVentaSubTotal, vVenta.fechaRegistro(), vVenta.modalidadId());

		try {

			repository.guardar(vVenta);
		} catch (Exception excepcion) {
			LOG.error(excepcion.getCause().toString(), excepcion);
			throw new VentaListaErrores(pId, crearValidacionException());
		}
		eventBus.publish(vVenta.pullDomainEvents());
		return;

	}

	private ValidationResponse crearValidacionException() {
		return new ValidationResponse(new HashMap<>() {
			{
				put("id", Arrays.asList(EnumFacFrvccMensajesShared.ERROR_EDICION.getId()));
			}
		});
	}

}
