package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios.modificar;



import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.*;
import bo.gob.sin.sre.fac.frvcc.misfacturas.service.formularios.modificar.FormularioModificadorServiceImpl;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandHandler;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;

@Service
public class ModificarFormularioCommandHandler implements CommandHandler<ModifcarFormularioCommand> {
private final FormularioModificadorServiceImpl modificador;

    public ModificarFormularioCommandHandler(FormularioModificadorServiceImpl modificador) {
        this.modificador = modificador;
    }



    @Override
    public void handle(ModifcarFormularioCommand command) {
        modificador.modificar(
                new FormularioId(command.id()) ,
                new FormularioDireccion(command.direccion()) ,
                new FormularioDireccionEmpleador(command.direccionEmpleador()) ,
                new FormularioUsuarioUltimaModificacion(command.usuarioUltimaModificacion()),
                new FormularioLugarDepartamento(command.lugarDepartamento()),
                new FormularioFechaPresentacion(command.fechaPresentacion()),
                new FormularioNumeroSucursal(command.numeroSucursal()),
                command.datosEspecificos(),
                new FormularioTipoUsoId(command.esExDependiente())
        );
    }
}
