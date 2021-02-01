package bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.consolidaciones;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.consolidaciones.ConsolidacionResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios.FormulariosResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.consolidaciones.Consolidacion;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Filters;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Order;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public interface IBuscarConsolidacionPorCriteriaService {
      ConsolidacionResponse search(
             Filters filters,
             Order order,
             Optional<Integer> limit,
             Optional<Integer> offset
     );
}
