package bo.gob.sin.sre.fac.frvcc.misfacturas.model.consolidaciones;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioId;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ValidationResponse;
import bo.gob.sin.sre.fac.frvcc.shared.model.DomainError;

import java.io.Serializable;
import java.util.HashMap;

public final class ConsolidadorListaErrores extends DomainError implements Serializable {
    public ConsolidadorListaErrores(ConsolidacionId id) {
        super("El formlario no existe", String.format("El consolidador <%s> doesn't exist", id.value()));
    }

    public ConsolidadorListaErrores(ConsolidacionId id, ValidationResponse pHashMapErrorCodigo) {
        super(id.value(),pHashMapErrorCodigo);
    }

    public ConsolidadorListaErrores(HashMap<String, ValidationResponse> plistaErrores ) {
        super(plistaErrores);
    }


}
