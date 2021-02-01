package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.recepcion;


import bo.gob.sin.sre.fac.frvcc.shared.model.DomainError;

public final class RecepcionNotExist extends DomainError {
    public RecepcionNotExist(RecepcionId id) {
        super("El archivo no existe", String.format("The course <%s> doesn't exist", id.value()));
    }
}
