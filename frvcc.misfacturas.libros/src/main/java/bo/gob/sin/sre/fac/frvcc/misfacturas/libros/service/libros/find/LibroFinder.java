package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.service.libros.find;


import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.adapters.primary.libros.LibroResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.adapters.primary.libros.LibroRespuesta;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.Libro;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroNoExist;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.use.ports.secundary.libros.LibroRepository;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;




@Service
public final class LibroFinder {
    private final LibroRepository repository;

    public LibroFinder(LibroRepository repository) {
        this.repository = repository;
    }

    public LibroResponse find(LibroId id) {
        Libro libro = repository.search(id).orElseThrow(() -> new LibroNoExist(id));
        return new LibroResponse(LibroRespuesta.fromAggregate(libro));
    }

}
