package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros;

import java.io.Serializable;
import java.util.HashMap;

import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ValidationResponse;
import bo.gob.sin.sre.fac.frvcc.shared.model.DomainError;

public final class LibroListaErrores  extends DomainError implements Serializable {
    public LibroListaErrores(LibroId id) {
        super("El libro no existe", String.format("El libro <%s> doesn't exist", id.value()));
    }

    public LibroListaErrores(LibroId id,ValidationResponse pHashMapErrorCodigo) {
        super(id.value(),pHashMapErrorCodigo);
    }

    public LibroListaErrores(HashMap<String, ValidationResponse> plistaErrores ) {
        super(plistaErrores);
    }


}
