package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas;

import java.io.Serializable;
import java.util.HashMap;

import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ValidationResponse;
import bo.gob.sin.sre.fac.frvcc.shared.model.DomainError;

public final class VentaListaErrores  extends DomainError implements Serializable {
    public VentaListaErrores(VentaId id) {
        super("La Venta no existe", String.format("La Venta <%s> doesn't exist", id.value()));
    }

    public VentaListaErrores(VentaId id,ValidationResponse pHashMapErrorCodigo) {
        super(id.value(),pHashMapErrorCodigo);
    }

    public VentaListaErrores(HashMap<String, ValidationResponse> plistaErrores ) {
        super(plistaErrores);
    }


}
