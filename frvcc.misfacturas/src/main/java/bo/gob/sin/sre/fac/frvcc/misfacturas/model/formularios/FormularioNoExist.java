package bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios;


import bo.gob.sin.sre.fac.frvcc.shared.model.DomainError;

public final class FormularioNoExist extends DomainError {
    public FormularioNoExist(FormularioId id) {
        super("El formulario no existe", String.format("The course <%s> doesn't exist", id.value()));
    }
}

