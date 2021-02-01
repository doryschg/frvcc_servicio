package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.use.ports.secundary.libros;

import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.Libro;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.shared.Pagina;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Criteria;

import java.util.Optional;

public interface LibroRepository {
    void save(Libro course);

    Optional<Libro> search(LibroId id);

    Pagina<Libro> BuscarPorCriteria(Criteria criteria);
    Long countByCriteria(Criteria criteria);
}
