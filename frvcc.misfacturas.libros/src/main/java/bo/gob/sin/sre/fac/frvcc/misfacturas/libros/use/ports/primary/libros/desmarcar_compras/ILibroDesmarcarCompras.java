package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.use.ports.primary.libros.desmarcar_compras;

import java.util.List;

import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroUsuarioUltimaModificacion;

public interface ILibroDesmarcarCompras {
	
    void decrementarImporte(LibroId pFormularioId, LibroUsuarioUltimaModificacion pUsuarioUltimaModificacion,List<String> pListaIdscompras);
}
