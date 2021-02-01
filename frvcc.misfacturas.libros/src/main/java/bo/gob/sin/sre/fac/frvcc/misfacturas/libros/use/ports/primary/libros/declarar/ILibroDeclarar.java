package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.use.ports.primary.libros.declarar;

import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroUsuarioUltimaModificacion;

public interface ILibroDeclarar {
    void declarar(LibroId pFormularioId, Integer pCodAdmin, LibroUsuarioUltimaModificacion pUsuarioUltimaModificacion);
}
