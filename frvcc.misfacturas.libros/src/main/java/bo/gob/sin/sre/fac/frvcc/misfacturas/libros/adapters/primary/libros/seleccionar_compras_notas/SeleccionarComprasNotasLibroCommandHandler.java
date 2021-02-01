package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.adapters.primary.libros.seleccionar_compras_notas;


import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.service.libros.declarar.LibroDeclarar;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.service.libros.seleccionar_compras.LibroSeleccionarCompras;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.service.libros.seleccionar_compras_notas.LibroSeleccionarComprasNotas;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.service.formularios.declarar.FormularioDeclararServiceImpl;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandHandler;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;

@Service
public class SeleccionarComprasNotasLibroCommandHandler implements CommandHandler<SeleccionarComprasNotasLibroCommand> {
    private final LibroSeleccionarComprasNotas seleccionarComprasNotas;

    public SeleccionarComprasNotasLibroCommandHandler(LibroSeleccionarComprasNotas seleccioanar) {
        this.seleccionarComprasNotas = seleccioanar;
    }

    @Override
    public void handle(SeleccionarComprasNotasLibroCommand command) {

        seleccionarComprasNotas.incrementarImporteNotas(new LibroId(command.id()),new LibroUsuarioUltimaModificacion(command.usuarioUltimaModificacionId()),
        		command.listaIdsCompras() );

    }
}
