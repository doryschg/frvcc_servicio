package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.use.ports.primary.libros.desmarcar_compras_notas;

import java.util.List;

import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroUsuarioUltimaModificacion;

public interface ILibroDesmarcarComprasNotas {
	
    void decrementarImporteNotas(LibroId pFormularioId, LibroUsuarioUltimaModificacion pUsuarioUltimaModificacion,List<String> pListaIdscompras);
}
