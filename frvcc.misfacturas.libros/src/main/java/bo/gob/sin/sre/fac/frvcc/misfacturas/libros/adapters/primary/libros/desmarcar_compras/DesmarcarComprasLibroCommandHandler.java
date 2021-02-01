package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.adapters.primary.libros.desmarcar_compras;


import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.service.libros.desmarcar_compras.LibroDesmarcarCompras;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.service.formularios.desmarcar_compras.FormularioDesmarcarComprasServiceImpl;
import bo.gob.sin.sre.fac.frvcc.misfacturas.service.formularios.seleccionar_compras.FormularioSeleccionarComprasServiceImpl;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandHandler;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;

@Service
public class DesmarcarComprasLibroCommandHandler implements CommandHandler<DesmarcarComprasLibroCommand> {
    private final LibroDesmarcarCompras desmarcarCompras;

    public DesmarcarComprasLibroCommandHandler(LibroDesmarcarCompras seleccioanar) {
        this.desmarcarCompras = seleccioanar;
    }

    @Override
    public void handle(DesmarcarComprasLibroCommand command) {

        desmarcarCompras.decrementarImporte(new LibroId(command.id()),
        		new LibroUsuarioUltimaModificacion(command.usuarioUltimaModificacionId()),
        		command.listaIdsCompras());

    }
}
