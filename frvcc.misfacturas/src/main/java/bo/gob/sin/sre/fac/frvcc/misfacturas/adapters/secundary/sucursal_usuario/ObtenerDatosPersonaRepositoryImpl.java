package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.secundary.sucursal_usuario;

import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.compras.VerificadorNumeroAutoriacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.usuario.DatosPersona;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.usuario.IObtenerDatosPersonaRepository;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.lcv.ConsultaLcvResponse;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.ParameterMode;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional("contribuyentes-transaction_manager")
public class ObtenerDatosPersonaRepositoryImpl implements IObtenerDatosPersonaRepository {
    private final SessionFactory sessionFactory;

    public ObtenerDatosPersonaRepositoryImpl(@Qualifier("contribuyentes-session-factory")
                                                  SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<DatosPersona> obtenerDatosPersona(Long pIfc) {
        StoredProcedureQuery vProcedimiento = sessionFactory.getCurrentSession().getSession()
                .createStoredProcedureQuery("PSFE_UTILES.p_ObtenerUsuariosAgente");
        vProcedimiento.registerStoredProcedureParameter(1, Long.class, ParameterMode.IN);
        vProcedimiento.registerStoredProcedureParameter(2, ResultSet.class, ParameterMode.REF_CURSOR);
        vProcedimiento.setParameter(1, pIfc);
        List<DatosPersona> vListaRespuesta = new ArrayList();
        try {
            vProcedimiento.execute();
//         Query query = sessionFactory
//                    .getCurrentSession()
//                    .getSession().createNativeQuery("select PSFE_UTILES.F_ObtenerUsuariosAgente("+pIfc+") from dual");

            List<Object[]>  listaResultado =   vProcedimiento.getResultList();

            if (!listaResultado.isEmpty()) {
                for (Object[] obj : listaResultado) {
                    DatosPersona vRegistro = new DatosPersona();
                    vRegistro.setSeqUsuario((Long) Long.parseLong(obj[0].toString()));
                    vRegistro.setNombreUsuario((String) obj[1]);
                    vRegistro.setNroDocumento((String) obj[2]);
                    vRegistro.setTipoDocumento((String) obj[3]);
                    vRegistro.setLugarExpedicionId((Integer) Integer.parseInt(obj[4].toString()));
                    vRegistro.setLugarExpedicionDescripcion((String) obj[5]);
                    vListaRespuesta.add(vRegistro);
                }
            }
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }


        return vListaRespuesta;
    }
}

