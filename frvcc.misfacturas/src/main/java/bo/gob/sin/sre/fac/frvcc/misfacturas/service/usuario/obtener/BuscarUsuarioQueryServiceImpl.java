package bo.gob.sin.sre.fac.frvcc.misfacturas.service.usuario.obtener;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.usuario.UsuarioResponseGenerico;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.usuario.UsuariosResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.usuario.obtener.IBuscarUsuarioQueryService;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.usuario.DatosPersona;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.usuario.IObtenerDatosPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BuscarUsuarioQueryServiceImpl implements IBuscarUsuarioQueryService {

    private final IObtenerDatosPersonaRepository datosPersonaRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public BuscarUsuarioQueryServiceImpl(IObtenerDatosPersonaRepository datosPersonaRepository) {
        this.datosPersonaRepository = datosPersonaRepository;
    }

    @Override
    public UsuariosResponse obtenerUsuarios(Long pIfc) {
        UsuariosResponse reponse = new UsuariosResponse(new ArrayList<>());
        String vSql = "";
        try {
            List<DatosPersona> vDatosPersona=datosPersonaRepository.obtenerDatosPersona(pIfc);


            List<UsuarioResponseGenerico> vListaUsuariosRetornar=new ArrayList<>();
            for (DatosPersona persona:vDatosPersona) {
                vSql = "select usuario_id as usuarioId,tipo_usuario_id as tipoUsuarioId, " +
                        "perfil_id as perfilId,oficina_id as oficinaId, persona_id as personaId, " +
                        "usuario_ov_id as usuarioOvId,login as login from sau_usuarios.sau_adm_usuarios " +
                        "where usuario_ov_id=? and estado_id='AC' and fecha_hasta is null";
                RowMapper<UsuarioResponseGenerico> vRowMapper = new BeanPropertyRowMapper<UsuarioResponseGenerico>(UsuarioResponseGenerico.class);
                List<UsuarioResponseGenerico> vListaUsuarios = jdbcTemplate.query(vSql, vRowMapper,persona.getSeqUsuario());
                if(!vListaUsuarios.isEmpty())
                {
                    UsuarioResponseGenerico usuario=vListaUsuarios.get(0);
                    usuario.setDatosPersona(persona);
                    vListaUsuariosRetornar.add(usuario);
                }
            }
            reponse =new UsuariosResponse(vListaUsuariosRetornar);

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return reponse;
    }
}
