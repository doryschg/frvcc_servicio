package bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas;


import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ValidationResponse;
import bo.gob.sin.sre.fac.frvcc.shared.model.DomainError;



public final class CompraNotaNotExist extends DomainError {
    public CompraNotaNotExist(CompraNotaId id) {
        super("La Compra nota  no existe", String.format("La Compra nota  <%s> doesn't exist", id.value()));
    }

    public CompraNotaNotExist(ValidationResponse pListErrorCodigo) {
        super(null,pListErrorCodigo);
    }


}
