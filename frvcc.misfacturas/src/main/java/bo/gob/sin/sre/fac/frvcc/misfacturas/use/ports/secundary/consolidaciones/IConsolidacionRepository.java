package bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.consolidaciones;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.Compra;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.consolidaciones.Consolidacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.consolidaciones.ConsolidacionId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.shared.Pagina;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Criteria;

import java.util.List;
import java.util.Optional;

public interface IConsolidacionRepository {
    void guardar(Consolidacion pConsolidacion);
    void guardarTodo(List<Consolidacion> pConsolidacion);
    Optional<Consolidacion> findById(ConsolidacionId id);
    Optional<Consolidacion> BuscarConsolidacionExistente(Consolidacion pConsolidacion);
    Pagina<Consolidacion> BuscarPorCriteria(Criteria criteria);
}
