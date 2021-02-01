package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios.modifcar_compra_seleccionada;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.*;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.formularios.modifcar_compra_seleccionada.IFormularioModificarCompraSeleccionado;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandHandler;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandHandlerExecutionError;
@Service
public final class ModificarCompraSeleccionadaCommandHandler implements CommandHandler<ModificarCompraSeleccionadaCommand> {
    private final IFormularioModificarCompraSeleccionado service;

    public ModificarCompraSeleccionadaCommandHandler(IFormularioModificarCompraSeleccionado service) {
        this.service = service;
    }

    @Override
    public void handle(ModificarCompraSeleccionadaCommand command) throws CommandHandlerExecutionError {
        service.modifciarCompraSeleccionado(
                new CompraId(command.getId()),
                new CompraImporteTotalCompra(command.getImporteTotalCompra()),
                new CompraFechaFactura(command.getFechaFactura()),
                new CompraCodigoControl(command.getCodigoControl()),
                new CompraOrigenId(command.getOrigenId()),
                new FormularioUsuarioUltimaModificacion(command.getUsuarioId())
        );
    }
}
