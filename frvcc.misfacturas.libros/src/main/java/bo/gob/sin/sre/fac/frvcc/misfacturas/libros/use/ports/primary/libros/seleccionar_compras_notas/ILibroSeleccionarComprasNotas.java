package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.use.ports.primary.libros.seleccionar_compras_notas;

import java.util.List;

import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroUsuarioUltimaModificacion;

public interface ILibroSeleccionarComprasNotas {
	
    void incrementarImporteNotas(LibroId pFormularioId, LibroUsuarioUltimaModificacion pUsuarioUltimaModificacion,List<String> pListaIdscompras);
}
