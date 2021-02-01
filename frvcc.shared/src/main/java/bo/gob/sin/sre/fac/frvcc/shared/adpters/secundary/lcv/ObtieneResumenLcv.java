package bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.lcv;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.ParameterMode;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import bo.gob.sin.sre.fac.frvcc.shared.model.contribuyentes.Contribuyente;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.lcv.IResumenLcvRepository;

@SuppressWarnings("rawtypes")
@Service
@Transactional("contribuyentes-transaction_manager")
public class ObtieneResumenLcv<ListaConsultaLcvResponse> implements IResumenLcvRepository{

	private final SessionFactory sessionFactory;

    public ObtieneResumenLcv(@Qualifier("contribuyentes-session-factory")
                                         SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	@SuppressWarnings("unchecked")
	public  List<ListaConsultaLcvResponse> buscarPorNItGestion(Long pNit , Integer pGestion) {
        
		List<ListaConsultaLcvResponse>  vRespuesta = new ArrayList<ListaConsultaLcvResponse> ();
		StoredProcedureQuery vProcedimiento = sessionFactory.getCurrentSession().getSession()
                .createStoredProcedureQuery("PSFE_UTILES.p_ObtenerFacilitoLCV");
        vProcedimiento.registerStoredProcedureParameter(1, Long.class, ParameterMode.IN);
        vProcedimiento.registerStoredProcedureParameter(2, Integer.class, ParameterMode.IN);        
        vProcedimiento.registerStoredProcedureParameter(3, ResultSet.class, ParameterMode.REF_CURSOR);
        vProcedimiento.setParameter(1, pNit);
        vProcedimiento.setParameter(2, pGestion);        
        vProcedimiento.execute();
        List<Object[]>  listaResultado =   vProcedimiento.getResultList();
        List<ConsultaLcvResponse> vListaRespuesta = new ArrayList();
		if (!listaResultado.isEmpty()) {
		for (Object[] obj : listaResultado) {
			ConsultaLcvResponse vRegistro = new ConsultaLcvResponse();
			vRegistro.setMesPeriodo((BigDecimal) obj[0]);
			vRegistro.setAnioPeriodo((BigDecimal) obj[1]);
			vRegistro.setTotalCompras((BigDecimal) obj[2]);
			vRegistro.setTotalVentas((BigDecimal) obj[3]); 
			vRegistro.setCantidadCompras((BigDecimal) obj[4]);
			vRegistro.setCantidadVentas((BigDecimal) obj[5]);
			vRegistro.setTotalBCCompras((BigDecimal) obj[6]);
			vRegistro.setTotalBCVentas((BigDecimal) obj[7]);
			vRegistro.setFechaRegistroSistema((Timestamp) obj[8]);			
			vListaRespuesta.add(vRegistro);
		}
		
		vRespuesta = (List<ListaConsultaLcvResponse>) vListaRespuesta;	
        }
		return vRespuesta;

	}
	
}