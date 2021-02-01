package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.adapters.primary.libros.registro;

import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.*;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.service.libros.registro.LibroRegistrador;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandHandler;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;

@Service
public class RegistroLibroCommandHandler implements CommandHandler<RegistroLibroCommand> {
    private final LibroRegistrador creator;

    public RegistroLibroCommandHandler(LibroRegistrador creator) {
        this.creator = creator;
    }


    @Override
    public void handle(RegistroLibroCommand command) {
        creator.registro(
                new LibroId(command.id()),
                new LibroNombreLibro(command.nombreLibro()),
                new LibroMesPeriodo(command.mesPeriodo()),
                new LibroAnioPeriodo(command.anioPeriodo()),
                new LibroPeriodicidadId(command.periodicidadId()),
                new LibroCantidadPeriodicidad(command.cantidadPeriodicidad()),
                new LibroTipoPresentacionId(command.tipoPresentacionId()),
                new LibroNit(command.nit()),
                new LibroIfc(command.ifc()),
                new LibroRazonSocial(command.razonSocial()),
                new LibroCodigoAdministracion(command.codAdministracion()),
     			new LibroAdministracion(command.administracion()),
                new  LibroUsuarioRegistro(command.usuarioRegistro())
        );
    }
}
