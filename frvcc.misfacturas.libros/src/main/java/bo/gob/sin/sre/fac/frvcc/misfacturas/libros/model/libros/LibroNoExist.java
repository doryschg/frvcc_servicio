package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros;


import bo.gob.sin.sre.fac.frvcc.shared.model.DomainError;

public final class LibroNoExist extends DomainError {
    public LibroNoExist(LibroId id) {
        super("El libro no existe", String.format("The course <%s> doesn't exist", id.value()));
    }
}

