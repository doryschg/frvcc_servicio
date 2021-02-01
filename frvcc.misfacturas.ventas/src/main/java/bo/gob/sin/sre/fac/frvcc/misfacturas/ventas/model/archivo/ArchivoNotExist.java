package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.archivo;


import bo.gob.sin.sre.fac.frvcc.shared.model.DomainError;

public final class ArchivoNotExist extends DomainError {
    public ArchivoNotExist(ArchivoId id) {
        super("El archivo no existe", String.format("The course <%s> doesn't exist", id.value()));
    }
}
