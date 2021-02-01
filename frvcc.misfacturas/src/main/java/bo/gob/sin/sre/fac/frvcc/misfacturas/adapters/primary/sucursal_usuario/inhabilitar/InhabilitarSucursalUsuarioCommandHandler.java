package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.sucursal_usuario.inhabilitar;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios.eliminar.EliminarFormularioCommand;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.sucursal_usuario.SucursalUsuarioId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.sucursal_usuario.SucursalUsuarioUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.sucursal_usuario.inhabilitar.ISucursalUsuarioInhabilitar;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandHandler;


@Service
public class InhabilitarSucursalUsuarioCommandHandler implements CommandHandler<InhabilitarSucursalUsuarioCommand> {
private final ISucursalUsuarioInhabilitar service;

    public InhabilitarSucursalUsuarioCommandHandler(ISucursalUsuarioInhabilitar eliminador) {
        this.service = eliminador;
    }

    @Override
    public void handle(InhabilitarSucursalUsuarioCommand command)  {
              service.inhabilitar( new SucursalUsuarioId(command.id()),
                     new SucursalUsuarioUsuarioUltimaModificacion(command.usuarioUltimaModificacion()));

    }
}
