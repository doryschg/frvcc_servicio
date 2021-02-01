package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.adapters.primary.libros.seleccionar_compras;


import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.service.libros.declarar.LibroDeclarar;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.service.libros.seleccionar_compras.LibroSeleccionarCompras;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.service.formularios.declarar.FormularioDeclararServiceImpl;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandHandler;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;

@Service
public class SeleccionarComprasLibroCommandHandler implements CommandHandler<SeleccionarComprasLibroCommand> {
    private final LibroSeleccionarCompras seleccionarcompras;

    public SeleccionarComprasLibroCommandHandler(LibroSeleccionarCompras seleccioanar) {
        this.seleccionarcompras = seleccioanar;
    }

    @Override
    public void handle(SeleccionarComprasLibroCommand command) {

        seleccionarcompras.incrementarImporte(new LibroId(command.id()),new LibroUsuarioUltimaModificacion(command.usuarioUltimaModificacionId()),
        		command.listaIdsCompras() );

    }
}
