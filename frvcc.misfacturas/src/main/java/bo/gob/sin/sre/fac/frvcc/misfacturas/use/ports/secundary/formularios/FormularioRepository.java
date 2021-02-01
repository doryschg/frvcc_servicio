package bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.formularios;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.Formulario;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.shared.Pagina;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Criteria;

import java.util.Optional;

public interface FormularioRepository {
    void save(Formulario course);

    Optional<Formulario>
    search(FormularioId id);

    Pagina<Formulario> BuscarPorCriteria(Criteria criteria);
    Long countByCriteria(Criteria criteria);
    Optional<Formulario> findById(FormularioId id) ;
}
