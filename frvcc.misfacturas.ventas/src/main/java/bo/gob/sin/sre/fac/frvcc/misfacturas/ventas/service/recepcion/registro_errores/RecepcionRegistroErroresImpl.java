package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.service.recepcion.registro_errores;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.recepcion.Recepcion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.recepcion.RecepcionErrores;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.recepcion.RecepcionId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.recepcion.RecepcionNotExist;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.recepcion.RecepcionUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.service.ventas.anular.VentaAnularServiceImpl;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.shared.adapters.secondary.sql2o.RepositoryConfig;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.use.ports.primary.recepcion.registro_errores.IRecepcionRegistroErrores;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.use.ports.secundary.recepcion.IRecepcionRepository;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.EventBus;

@Service
public class RecepcionRegistroErroresImpl implements IRecepcionRegistroErrores {

	private static final Logger LOG = LoggerFactory.getLogger(VentaAnularServiceImpl.class);

	private final IRecepcionRepository repository;
	private final EventBus eventBus;
	private final Environment env;

	public RecepcionRegistroErroresImpl(IRecepcionRepository pRepository, EventBus pEventBus, Environment env) {
		this.repository = pRepository;
		this.eventBus = pEventBus;
		this.env = env;

	}

	@Override

	public void registrar(RecepcionId pId, RecepcionUsuarioUltimaModificacion pUsuarioUltimaModificacion,
			JSONObject pErrores) {

		Recepcion vRecepcion = repository.findById(pId).orElseThrow(() -> new RecepcionNotExist(pId));
		vRecepcion.registarErrores(pUsuarioUltimaModificacion, new RecepcionErrores(pErrores.toString()));
		try {
			repository.guardar(vRecepcion);

//			String updateSql = new StringBuilder().append(
//					"UPDATE sfe_facturacion.tsfe_cv_recepciones set errores_js = to_json(:errores_js::json) where seq_recepcion_vc = :seq_recepcion_vc")
//					.toString();
//			int[] respuesta;
//			Sql2o sql2o = RepositoryConfig.getSql2o(env.getRequiredProperty("datasource.driver"),
//					env.getRequiredProperty("datasource.url"), env.getRequiredProperty("datasource.username"),
//					env.getRequiredProperty("datasource.password"));
//			try (Connection vConnection = sql2o.open()) {
//				Query query = vConnection.createQuery(updateSql);
//				query.addParameter("seq_recepcion_vc", pId.value()).addParameter("errores_js", pErrores.toString());
//				query.executeUpdate();
//			}

 		} catch (Exception excepcion) {
			LOG.error(excepcion.getCause().toString(), excepcion);
		}
	}
}
