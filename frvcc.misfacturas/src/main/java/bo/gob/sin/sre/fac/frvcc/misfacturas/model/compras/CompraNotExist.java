package bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras;


import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ValidationResponse;
import bo.gob.sin.sre.fac.frvcc.shared.model.DomainError;



public final class CompraNotExist extends DomainError {
    public CompraNotExist(CompraId id) {
        super("La Compra no existe", String.format("La Compra <%s> doesn't exist", id.value()));
    }

    public CompraNotExist(ValidationResponse pListErrorCodigo) {
        super(null,pListErrorCodigo);
    }


}
