package bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas;

import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ValidationResponse;
import bo.gob.sin.sre.fac.frvcc.shared.model.DomainError;

import java.io.Serializable;
import java.util.HashMap;

public final class CompraNotaListaErrores  extends DomainError implements Serializable {
    public CompraNotaListaErrores(CompraNotaId id) {
        super("La Compra Nota no existe", String.format("La Compra Nota <%s> doesn't exist", id.value()));
    }

    public CompraNotaListaErrores(CompraNotaId id,ValidationResponse pHashMapErrorCodigo) {
        super(id.value(),pHashMapErrorCodigo);
    }

    public CompraNotaListaErrores(HashMap<String, ValidationResponse> plistaErrores ) {
        super(plistaErrores);
    }


}
