package bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.hformularios;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.hformularios.HFormulario;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.hformularios.HFormularioHistoricoId;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Criteria;

import java.util.List;
import java.util.Optional;

public interface HFormularioRepository {
    void save(HFormulario course);

    Optional<HFormulario> search(HFormularioHistoricoId id);

    List<HFormulario> matching(Criteria criteria);
    Long countByCriteria(Criteria criteria);
}
