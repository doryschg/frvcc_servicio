package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.hformularios.create;


import bo.gob.sin.sre.fac.frvcc.misfacturas.model.hformularios.*;
import bo.gob.sin.sre.fac.frvcc.misfacturas.service.hformularios.HFormularioCreator;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandHandler;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;

@Service
public class CreateHFormularioCommandHandler implements CommandHandler<CreateHFormularioCommand> {
private final HFormularioCreator creator;

    public CreateHFormularioCommandHandler(HFormularioCreator creator) {
        this.creator = creator;
    }



    @Override
    public void handle(CreateHFormularioCommand command) {
/*        creator.create(HFormulario.registro(
        		new HFormularioHistoricoId(command.id()),
                new HFormularioId(command.idFormulario()),
                new HFormularioEstadoFormularioId(command.estadoFormularioId()),
                new HFormularioNumeroOrden(command.numeroOrden()),
                new HFormularioCompras(command.compras()),
                new HFormularioUsuarioRegistro(command.usuarioRegistro()),
                new HFormularioUsuarioUltimaModificacion(command.usuarioUltimaModificacion())
                
               
        ));*/
    }
}
