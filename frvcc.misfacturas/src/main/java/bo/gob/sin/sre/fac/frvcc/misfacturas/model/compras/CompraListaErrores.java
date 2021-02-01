package bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras;

import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ValidationResponse;
import bo.gob.sin.sre.fac.frvcc.shared.model.DomainError;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public final class CompraListaErrores  extends DomainError implements Serializable {
    public CompraListaErrores(CompraId id) {
        super("La Compra no existe", String.format("La Compra <%s> doesn't exist", id.value()));
    }

    public CompraListaErrores(CompraId id,ValidationResponse pHashMapErrorCodigo) {
        super(id.value(),pHashMapErrorCodigo);
    }

    public CompraListaErrores(HashMap<String, ValidationResponse> plistaErrores ) {
        super(plistaErrores);
    }


}
