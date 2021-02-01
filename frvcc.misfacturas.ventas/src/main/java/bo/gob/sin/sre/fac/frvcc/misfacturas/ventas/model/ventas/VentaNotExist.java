package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas;


import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ValidationResponse;
import bo.gob.sin.sre.fac.frvcc.shared.model.DomainError;



public final class VentaNotExist extends DomainError {
    public VentaNotExist(VentaId id) {
        super("La venta no existe", String.format("La venta  <%s> doesn't exist", id.value()));
    }

    public VentaNotExist(ValidationResponse pListErrorCodigo) {
        super(null,pListErrorCodigo);
    }


}
