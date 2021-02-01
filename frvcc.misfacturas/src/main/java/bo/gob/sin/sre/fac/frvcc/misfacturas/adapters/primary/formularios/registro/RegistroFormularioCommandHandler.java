package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios.registro;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.*;
import bo.gob.sin.sre.fac.frvcc.misfacturas.service.formularios.registro.FormularioRegistradorServiceImpl;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandHandler;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;

@Service
public class RegistroFormularioCommandHandler implements CommandHandler<RegistroFormularioCommand> {
    private final FormularioRegistradorServiceImpl creator;

    public RegistroFormularioCommandHandler(FormularioRegistradorServiceImpl creator) {
        this.creator = creator;
    }


    @Override
    public void handle(RegistroFormularioCommand command) {
        creator.registro(
                new FormularioId(command.id()),
                new FormularioTipoFormularioId(command.tipoFormularioId()),
                new FormularioNombreFormulario(command.nombreFormulario()),
                new FormularioMesPeriodo(command.mesPeriodo()),
                new FormularioAnioPeriodo(command.anioPeriodo()),
                new FormularioFechaPresentacion(command.fechaPresentacion()),
                new FormularioPeriodicidadId(command.periodicidadId()),
                new FormularioCantidadPeriodicidad(command.cantidadPeriodicidad()),
                new FormularioTipoPresentacionId(command.tipoPresentacionId()),
                new FormularioLugarDepartamento(command.lugarDepartamento()),
                new FormularioNitCi(command.nitCi()),
                new FormularioExpedicionCi(command.expedicionCi()),
                new FormularioIfc(command.ifc()),
                new FormularioRazonSocial(command.razonSocial()),
                new FormularioDireccion(command.direccion()),
                new FormularioCodigoDependiente(command.codigoDependiente()),
                new FormularioNitEmpleador(command.nitEmpleador()),
                new FormularioNombreEmpleador(command.nombreEmpleador()),
                new FormularioDireccionEmpleador(command.direccionEmpleador()),
                new  FormularioUsuarioRegistro(command.usuarioRegistro()),
                new FormularioNumeroSucursal(command.numeroSucursal()),
                command.datosEspecificos(),
                new FormularioTipoUsoId(command.tipoUsoId())
        );
    }
}
