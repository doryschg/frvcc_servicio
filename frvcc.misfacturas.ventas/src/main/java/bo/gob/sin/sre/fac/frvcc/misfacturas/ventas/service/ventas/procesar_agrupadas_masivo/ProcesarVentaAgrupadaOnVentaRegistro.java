package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.service.ventas.procesar_agrupadas_masivo;

import java.io.IOException;

import org.springframework.context.event.EventListener;

import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaCodigoAutorizacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaEstadoId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaFechaFactura;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaFechaRegistro;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaIfcProveedor;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaImporteTotal;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaNitProveedor;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaOrigenId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaRecepcionId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaUsuarioRegistro;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.service.ventas.registro_agrupadas_masivo.RegistrarAgrupadasMasivoServiceImpl;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.shared.domain.VentaAgrupadaDomainEvent;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.use.ports.primary.ventas.procesar_agrupadas_masivo.IProcesarVentasAgrupadasService;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.DomainEventSubscriber;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryNotRegisteredError;

@Service
@DomainEventSubscriber(VentaAgrupadaDomainEvent.class)
public class ProcesarVentaAgrupadaOnVentaRegistro {
	private final RegistrarAgrupadasMasivoServiceImpl registrarAgrupadasMasivoService;

	public ProcesarVentaAgrupadaOnVentaRegistro(RegistrarAgrupadasMasivoServiceImpl registrarAgrupadasMasivoService) {
		this.registrarAgrupadasMasivoService = registrarAgrupadasMasivoService;
	}

	@EventListener
	public void on(VentaAgrupadaDomainEvent event)
			throws QueryHandlerExecutionError, QueryNotRegisteredError, IOException {

		registrarAgrupadasMasivoService.registrar(new VentaId(event.id()), new VentaRecepcionId(event.recepcionId()),
				new VentaIfcProveedor(event.ifcProveedor()), event.fila(), new VentaNitProveedor(event.nitProveedor()),
				new VentaFechaFactura(event.fechaFactura()), event.numeroFacturaDel(), event.numeroFacturaHasta(),
				new VentaCodigoAutorizacion(event.codigoAutorizacion()),
				new VentaImporteTotal(event.importeTotalVenta()), new VentaUsuarioRegistro(event.usuarioRegistro()),
				new VentaFechaRegistro(event.fechaRegistro()), new VentaOrigenId(event.origenId()),
				new VentaEstadoId(event.estadoVentaId()));
	}
}
