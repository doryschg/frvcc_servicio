package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.service.ventas.registro_agrupadas_masivo;

import java.util.ArrayList;
import java.util.List;

import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.primary.ventas.registro.RegistroVentaCommand;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.primary.ventas.registro_masivo.RegistroVentasCommand;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.secundary.ventas.validadores.VentaAgrupadaValidador;
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
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.UuidGenerator;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandNotRegisteredError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.EventBus;

@Service
public class RegistrarAgrupadasMasivoServiceImpl {
	private final CommandBus commandBus;
	private final UuidGenerator uuidGenerator;

	public RegistrarAgrupadasMasivoServiceImpl(EventBus eventBus, CommandBus pCommandBus, UuidGenerator pUuidGenerator,
			VentaAgrupadaValidador pValidador) {
		this.commandBus = pCommandBus;
		this.uuidGenerator = pUuidGenerator;
	}

	public void registrar(VentaId pId, VentaRecepcionId pRecepcionId, VentaIfcProveedor pIfcProveedor, Long pFila,
			VentaNitProveedor pNitProveedor, VentaFechaFactura pFechaFactura, Long pNumeroFacturaDel,
			Long pNumeroFacturaHasta, VentaCodigoAutorizacion pCodigoAutorizacion, VentaImporteTotal pImporteTotalVenta,
			VentaUsuarioRegistro pUsuarioRegistro, VentaFechaRegistro pFechaRegistro, VentaOrigenId pOrigenId,
			VentaEstadoId pEstadoVenta) {

		List<RegistroVentaCommand> ventaCommands = new ArrayList<>();
		for (long iteracion = pNumeroFacturaDel; iteracion <= pNumeroFacturaHasta; iteracion++) {
			ventaCommands.add(RegistroVentaCommand.newRegistroVentaCommand().id(uuidGenerator.generate())
					.numeroFactura(iteracion).ifcProveedor(pIfcProveedor.value()).nitProveedor(pNitProveedor.value())
					.origenId(pOrigenId.value()).codigoAutorizacion(pCodigoAutorizacion.value()).fila(pFila)
					.fechaFactura(pFechaFactura.value()).usuarioRegistro(pUsuarioRegistro.value())
					.importeTotalVenta(pImporteTotalVenta.value()).build());
		}

		RegistroVentasCommand commands = new RegistroVentasCommand(ventaCommands);
		try {
			commandBus.dispatch(commands);
		} catch (CommandNotRegisteredError commandNotRegisteredError) {
			commandNotRegisteredError.printStackTrace();
		} catch (CommandHandlerExecutionError commandHandlerExecutionError) {
			commandHandlerExecutionError.printStackTrace();
		}
	}
}
