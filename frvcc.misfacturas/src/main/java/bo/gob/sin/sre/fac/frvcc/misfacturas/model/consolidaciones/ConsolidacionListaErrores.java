package bo.gob.sin.sre.fac.frvcc.misfacturas.model.consolidaciones;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraId;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ValidationResponse;
import bo.gob.sin.sre.fac.frvcc.shared.model.DomainError;

import java.io.Serializable;
import java.util.HashMap;

public final class ConsolidacionListaErrores extends DomainError implements Serializable {
    public ConsolidacionListaErrores(ConsolidacionId id) {
        super("La Consolidacion no existe", String.format("La Consolidacion <%s> doesn't exist", id.value()));
    }

    public ConsolidacionListaErrores(ConsolidacionId id, ValidationResponse pHashMapErrorCodigo) {
        super(id.value(),pHashMapErrorCodigo);
    }

    public ConsolidacionListaErrores(HashMap<String, ValidationResponse> plistaErrores ) {
        super(plistaErrores);
    }


}
