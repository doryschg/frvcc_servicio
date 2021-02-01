package bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios;

import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ValidationResponse;
import bo.gob.sin.sre.fac.frvcc.shared.model.DomainError;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public final class FormularioListaErrores  extends DomainError implements Serializable {
    public FormularioListaErrores(FormularioId id) {
        super("El formlario no existe", String.format("El formulario <%s> doesn't exist", id.value()));
    }

    public FormularioListaErrores(FormularioId id,ValidationResponse pHashMapErrorCodigo) {
        super(id.value(),pHashMapErrorCodigo);
    }

    public FormularioListaErrores(HashMap<String, ValidationResponse> plistaErrores ) {
        super(plistaErrores);
    }


}
