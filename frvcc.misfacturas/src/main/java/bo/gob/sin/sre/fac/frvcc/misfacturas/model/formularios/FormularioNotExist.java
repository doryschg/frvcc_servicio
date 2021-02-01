package bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios;


import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraId;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ValidationResponse;
import bo.gob.sin.sre.fac.frvcc.shared.model.DomainError;

public final class FormularioNotExist  extends DomainError {

    public FormularioNotExist(FormularioId id) {
        super("formulario_no_existe", String.format("The course <%s> doesn't exist", id.value()));
    }
    public FormularioNotExist(FormularioId id, ValidationResponse pHashMapErrorCodigo) {
        super(id.value(),pHashMapErrorCodigo);
    }
    public FormularioNotExist(String id, ValidationResponse pHashMapErrorCodigo) {
        super(id,pHashMapErrorCodigo);
    }

}
