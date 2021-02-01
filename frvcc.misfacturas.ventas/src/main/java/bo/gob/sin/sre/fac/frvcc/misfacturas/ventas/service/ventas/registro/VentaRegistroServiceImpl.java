package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.service.ventas.registro;

import java.util.HashMap;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.compras.VerificaCodigoAutorizacionRepository;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.compras.VerificadorNumeroAutoriacion;
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
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaModalidadId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaNitProveedor;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaNombreCliente;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaNumeroDocumentoCliente;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaNumeroFactura;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaOrigenId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaRazonSocialProveedor;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaRecepcionId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaSubTotal;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaUsuarioRegistro;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.use.ports.primary.ventas.registro.IVentaRegistro;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.use.ports.secundary.venta.IVentaRepository;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.contribuyentes.ContribuyenteResponse;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.contribuyentes.BuscarContribuyentePorNitQueryDto;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ValidationResponse;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.EventBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryNotRegisteredError;

@Service
public class VentaRegistroServiceImpl implements IVentaRegistro {
	private static final Logger LOG = LoggerFactory.getLogger(VentaRegistroServiceImpl.class);
	private final IVentaRepository repository;
	private final EventBus eventBus;
	private final QueryBus queryBus;
	private final VentaValidador validador;
	private final VerificaCodigoAutorizacionRepository verificaCodigoAutorizacionRepository;

	public VentaRegistroServiceImpl(IVentaRepository pRepository, EventBus pEventBus, QueryBus pQueryBus,
			VentaValidador pValidador, VerificaCodigoAutorizacionRepository verificaCodigoAutorizacionRepository) {
		this.repository = pRepository;
		this.eventBus = pEventBus;
		this.queryBus = pQueryBus;
		this.validador = pValidador;
		this.verificaCodigoAutorizacionRepository = verificaCodigoAutorizacionRepository;

	}

	@Override
	public void registrar(VentaId pId, VentaRecepcionId pRecepcionId, VentaIfcProveedor pIfcProveedor,
			VentaNitProveedor pNitProveedor, VentaRazonSocialProveedor pRazonSocialProveedor,
			VentaNumeroDocumentoCliente pNumeroDocumentoCliente, VentaNombreCliente pNombreCliente,
			VentaNumeroFactura pNumeroFactura, VentaCodigoAutorizacion pCodigoAutorizacion,
			VentaFechaFactura pFechaFactura, VentaImporteTotal pImporteTotalVenta, VentaCodigoControl pCodigoControl,
			VentaImporteBase pImporteBase, VentaOrigenId pOrigenId, VentaUsuarioRegistro pUsuarioRegistro,
			VentaConDerechoDf pVentaConDerechoDf, VentaMarcaEspecialId pVentaMarcaEspecialId,
			VentaDescuento pVentaDescuento, VentaDebitoFiscal pVentaDebitoFiscal,
			VentaImporteIceIehdTasas pVentaImporteIceIehdTasas, VentaImporteTasaCero pVentaImporteTasaCero,
			VentaImporteNoSujetoDf pVentaImporteNoSujetoDf, VentaImporteExento pVentaImporteExento,
			VentaSubTotal pVentaSubTotal) throws QueryNotRegisteredError, QueryHandlerExecutionError {

		ValidationResponse vResultadoValidacion = validador.validarVenta(new HashMap<>() {
			{
				put("id", pId.value() != null ? pId.value() : "");
				put("fechaFactura", pFechaFactura.value() != null ? pFechaFactura.value().toString() : "");
				put("nitProveedor", pNitProveedor.value() != null ? pNitProveedor.value().toString() : "");
				put("numeroFactura", pNumeroFactura.value() != null ? pNumeroFactura.value().toString() : "");
				put("codigoAutorizacion", pCodigoAutorizacion.value() != null ? pCodigoAutorizacion.value() : "");
				put("importeTotalVenta",
						pImporteTotalVenta.value() != null ? pImporteTotalVenta.value().toString() : "");
			}
		});

		if (vResultadoValidacion.hasErrors()) {
			throw new VentaListaErrores(pId, vResultadoValidacion);
		}

		if (!repository.findById(pId).isPresent()) {
			VentaIfcProveedor vIfcProveedorNb = new VentaIfcProveedor(0L);
			VentaRazonSocialProveedor vRazonSocialProveedor = new VentaRazonSocialProveedor(null);

			ContribuyenteResponse vContribuyenteResponse = (ContribuyenteResponse) Optional
					.ofNullable(queryBus.ask(new BuscarContribuyentePorNitQueryDto(pNitProveedor.value())))
					.orElse(null);
			if (vContribuyenteResponse != null) {
				vIfcProveedorNb = new VentaIfcProveedor(vContribuyenteResponse.ifc());
				vRazonSocialProveedor = new VentaRazonSocialProveedor(vContribuyenteResponse.razonSocial());
			}

			VerificadorNumeroAutoriacion vResultadoVerificadorNumeroAutorizacion = verificaCodigoAutorizacionRepository
					.verificaCodigoAutorizacion(pNitProveedor.value(), pNumeroFactura.value(),
							pCodigoAutorizacion.value(), pNumeroDocumentoCliente.value(), pFechaFactura.value(),
							pCodigoControl.value(), pImporteTotalVenta.value());

			if (vResultadoVerificadorNumeroAutorizacion.isValid()) {
				// VentaDebitoFiscal vDebitoFiscal =
				// VentaDebitoFiscal.creditoFiscal(command.getImporteTotalVenta(),
				// vImporteBaseCf.value(),vResultadoVerificadorNumeroAutorizacion.getMarcaEspecial(),vResultadoVerificadorNumeroAutorizacion.getCreditoFiscal());

				VentaModalidadId vModalidadId = new VentaModalidadId(
						vResultadoVerificadorNumeroAutorizacion.getModalidad());
				VentaImporteBase vImporteBaseCf = VentaImporteBase.importeBaseCreditoFiscal(pImporteTotalVenta.value(),
						pImporteBase.value(), vResultadoVerificadorNumeroAutorizacion.getMarcaEspecial(),
						vResultadoVerificadorNumeroAutorizacion.getCreditoFiscal());
				VentaMarcaEspecialId vMarcaEspecialId = new VentaMarcaEspecialId(
						vResultadoVerificadorNumeroAutorizacion.getMarcaEspecial());
				VentaConDerechoDf vConDerechoCf = new VentaConDerechoDf(
						vResultadoVerificadorNumeroAutorizacion.getConDerechoCf());
				Venta venta = Venta.registro(pId, pRecepcionId, vIfcProveedorNb, pNitProveedor, vRazonSocialProveedor,
						pNumeroDocumentoCliente, pNombreCliente, pNumeroFactura, pCodigoAutorizacion, pFechaFactura,
						pImporteTotalVenta, pCodigoControl, pImporteBase, pOrigenId, pUsuarioRegistro,
						pVentaConDerechoDf, pVentaMarcaEspecialId, pVentaDescuento, pVentaDebitoFiscal,
						pVentaImporteIceIehdTasas, pVentaImporteTasaCero, pVentaImporteNoSujetoDf, pVentaImporteExento,
						// new VentaModalidadId(vModalidadId),
						// new CompraImporteBaseCf(vImporteBaseCf.value()),
						// new VentaConDerechoDf(vConDerechoCf.value()),
						pVentaSubTotal);

				repository.guardar(venta);
				eventBus.publish(venta.pullDomainEvents());

			} else {
				throw new VentaListaErrores(pId, validador.getValidacionNumeroAutorizacionException(
						vResultadoVerificadorNumeroAutorizacion.getErorres()));
			}
		}
	}
}
