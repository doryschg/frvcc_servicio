package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.primary.ventas.modificar;

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
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaMarcaEspecialId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaNitProveedor;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaNombreCliente;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaNumeroDocumentoCliente;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaNumeroFactura;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaOrigenId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaRazonSocialProveedor;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaRecepcionId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaSubTotal;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaUsuarioRegistro;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.use.ports.primary.ventas.modificar.IVentaModificar;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandHandler;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryNotRegisteredError;

@Service
public class ModificarVentaCommandHandler implements CommandHandler<ModificarVentaCommand> {
	private final IVentaModificar ventaService;

	public ModificarVentaCommandHandler(IVentaModificar pVentaService) {
		this.ventaService = pVentaService;
	}

	@Override
	public void handle(ModificarVentaCommand command) throws CommandHandlerExecutionError {
		try {
			ventaService.modificar(new VentaId(command.getId()), new VentaRecepcionId(command.getRecepcionId()),
					new VentaIfcProveedor(command.getIfcProveedor()), new VentaNitProveedor(command.getNitProveedor()),
					new VentaRazonSocialProveedor(command.getRazonSocialProveedor()),
					new VentaNumeroDocumentoCliente(command.getNumeroDocumentoCliente()),
					new VentaNombreCliente(command.getNombreCliente()),
					new VentaNumeroFactura(command.getNumeroFactura()),
					new VentaCodigoAutorizacion(command.getCodigoAutorizacion()),
					new VentaFechaFactura(command.getFechaFactura()),
					new VentaImporteTotal(command.getImporteTotalVenta()),
					new VentaCodigoControl(command.getCodigoControl()), new VentaImporteBase(command.getImporteBase()),
					new VentaOrigenId(command.getOrigenId()),
					new VentaUsuarioUltimaModificacion(command.getUsuarioUltimaModificacion()),
					new VentaConDerechoDf("S"), new VentaMarcaEspecialId("SM"),
					new VentaDescuento(command.getDescuento()), new VentaDebitoFiscal(command.getDebitoFiscal()),
					new VentaImporteIceIehdTasas(command.getImporteIceIehdTasas()),
					new VentaImporteTasaCero(command.getImporteTasaCero()),
					new VentaImporteNoSujetoDf(command.getImporteNoSujetoDf()),
					new VentaImporteExento(command.getImporteExento()), new VentaSubTotal(command.getSubTotal()));

		} catch (QueryNotRegisteredError | QueryHandlerExecutionError queryNotRegisteredError) {
			queryNotRegisteredError.printStackTrace();
		}
	}

}
