package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.adapters.primary.libros.declarar;


import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.service.libros.declarar.LibroDeclarar;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandHandler;

@Service
public class DeclararLibroCommandHandler implements CommandHandler<DeclararLibroCommand> {
    private final LibroDeclarar declarar;

    public DeclararLibroCommandHandler(LibroDeclarar declarar) {
        this.declarar = declarar;
    }

    @Override
    public void handle(DeclararLibroCommand command) {

        declarar.declarar(new LibroId(command.id()), command.codAdmin(),new LibroUsuarioUltimaModificacion(command.usuarioUltimaModificacionId()));

    }
}
