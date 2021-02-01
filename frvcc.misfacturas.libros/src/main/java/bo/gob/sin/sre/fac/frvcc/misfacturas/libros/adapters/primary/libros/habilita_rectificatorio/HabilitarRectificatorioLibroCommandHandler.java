package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.adapters.primary.libros.habilita_rectificatorio;


import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.service.libros.habilita_rectificatorio.LibroHabilitaRectificatorio;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandHandler;

@Service
public class HabilitarRectificatorioLibroCommandHandler implements CommandHandler<HabilitarRectificatorioLibroCommand> {
    private final LibroHabilitaRectificatorio service;

    public HabilitarRectificatorioLibroCommandHandler(LibroHabilitaRectificatorio declarar) {
        this.service = declarar;
    }

    @Override
    public void handle(HabilitarRectificatorioLibroCommand command) {

        service.habilitarLibroRectificatorio(new LibroId(command.id()),new LibroUsuarioUltimaModificacion(command.usuarioUltimaModificacionId()));

    }
}
