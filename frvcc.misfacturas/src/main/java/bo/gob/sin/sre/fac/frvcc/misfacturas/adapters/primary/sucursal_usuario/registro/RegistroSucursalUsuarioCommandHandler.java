package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.sucursal_usuario.registro;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios.registro.RegistroFormularioCommand;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.*;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.sucursal_usuario.*;
import bo.gob.sin.sre.fac.frvcc.misfacturas.service.formularios.registro.FormularioRegistradorServiceImpl;
import bo.gob.sin.sre.fac.frvcc.misfacturas.service.sucursal_usuario.registro.SucursalUsuarioRegistradorServiceImpl;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandHandler;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryNotRegisteredError;

@Service
public class RegistroSucursalUsuarioCommandHandler implements CommandHandler<RegistroSucursalUsuarioCommand> {
    private final SucursalUsuarioRegistradorServiceImpl creator;

    public RegistroSucursalUsuarioCommandHandler(SucursalUsuarioRegistradorServiceImpl creator) {
        this.creator = creator;
    }


    @Override
    public void handle(RegistroSucursalUsuarioCommand command) {
        try {
            creator.registrar(
                    new SucursalUsuarioId(command.getId()),
                    new  SucursalUsuarioIfcAgente(command.getIfcAgente()),
                    new SucursalUsuarioNitAgente(command.getNitAgente()),
                    new SucursalUsuarioNumeroSucursal(command.getNroSucursal()) ,
                    new SucursalUsuarioUsuarioReceptor(command.getUsuarioReceptor()),
                    new SucursalUsuarioLoginUsuarioReceptor(command.getLoginUsuarioReceptor()) ,
                    new SucursalUsuarioNombreReceptor(command.getNombreUsuarioReceptor()),
                    new  SucursalUsuarioUsuarioRegistro(command.getUsuarioRegistro()),
                    new SucursalUsuarioUsuarioUltimaModificacion(command.getUsuarioRegistro())
            );
        } catch (QueryNotRegisteredError queryNotRegisteredError) {
            queryNotRegisteredError.printStackTrace();
        } catch (QueryHandlerExecutionError queryHandlerExecutionError) {
            queryHandlerExecutionError.printStackTrace();
        }
    }
}
