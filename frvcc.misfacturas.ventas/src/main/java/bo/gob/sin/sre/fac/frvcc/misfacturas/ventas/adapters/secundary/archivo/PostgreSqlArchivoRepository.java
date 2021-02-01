package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.secundary.archivo;

import java.util.Optional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.archivo.Archivo;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.archivo.ArchivoId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.use.ports.secundary.archivo.IArchivoRepository;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.spring.SpringDataRepository;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;

@Service
@Transactional("misfacturasVentas-transaction_manager")
public class PostgreSqlArchivoRepository extends SpringDataRepository<Archivo> implements IArchivoRepository {

	public PostgreSqlArchivoRepository(@Qualifier("misfacturasVentas-session-factory") SessionFactory sessionFactory) {
		super(sessionFactory, Archivo.class);
	}

	@Override
	public void guardar(Archivo pArchivo) {
		save(pArchivo);
	}

	@Override
	public Optional<Archivo> findById(ArchivoId pId) {
		try {
			return byId(pId);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
