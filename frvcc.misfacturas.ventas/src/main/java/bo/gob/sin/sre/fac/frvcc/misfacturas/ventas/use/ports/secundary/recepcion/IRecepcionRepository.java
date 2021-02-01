package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.use.ports.secundary.recepcion;

import java.util.List;
import java.util.Optional;

import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.recepcion.Recepcion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.recepcion.RecepcionId;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Criteria;

public interface IRecepcionRepository {
	void guardar(Recepcion recepcion);

	Optional<Recepcion> findById(RecepcionId id);

	List<Recepcion> matching(Criteria criteria);
}
