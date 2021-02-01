package bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.contribuyentes;


import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.model.contribuyentes.Contribuyente;
import bo.gob.sin.sre.fac.frvcc.shared.model.contribuyentes.ContribuyenteIfc;
import bo.gob.sin.sre.fac.frvcc.shared.model.contribuyentes.ContribuyenteNit;
import bo.gob.sin.sre.fac.frvcc.shared.model.contribuyentes.ContribuyenteRezonSocial;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.contribuyentes.IContribuyenteRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

@Service
@Transactional("contribuyentes-transaction_manager")
public class ContribuyenteOracleRepositoryImpl implements IContribuyenteRepository {
    private final SessionFactory sessionFactory;

    public ContribuyenteOracleRepositoryImpl(@Qualifier("contribuyentes-session-factory")
                                                 SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Optional<Contribuyente> buscarPorNIt(Long nit) {

        StoredProcedureQuery vProcedimiento = sessionFactory.getCurrentSession().getSession()
                .createStoredProcedureQuery("PSIN_INTERFACES_PDR.p_ObtenerDatosBasicosXNIT");
        vProcedimiento.registerStoredProcedureParameter(1, Long.class, ParameterMode.IN);
        vProcedimiento.registerStoredProcedureParameter(2, ResultSet.class, ParameterMode.REF_CURSOR);
        vProcedimiento.registerStoredProcedureParameter(3, ResultSet.class, ParameterMode.REF_CURSOR);
        vProcedimiento.setParameter(1, nit);
        vProcedimiento.execute();
        List<Object[]>  querey = vProcedimiento.getResultList();
        if (vProcedimiento.hasMoreResults()) {
            ResultSet vRespuestaContribuyente = (ResultSet) vProcedimiento.getOutputParameterValue(2);
            return Optional.of(new Contribuyente(new ContribuyenteNit(Long.parseLong(querey.get(0)[0].toString())),
                    new ContribuyenteIfc(Long.parseLong(querey.get(0)[8].toString())), new ContribuyenteRezonSocial(querey.get(0)[2].toString())));
        }
        return Optional.empty();

    }



}
