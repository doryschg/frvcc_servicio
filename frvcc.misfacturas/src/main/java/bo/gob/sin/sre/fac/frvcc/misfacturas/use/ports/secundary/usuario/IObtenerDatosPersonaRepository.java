package bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.usuario;

import java.util.List;

public interface IObtenerDatosPersonaRepository {
    List<DatosPersona>  obtenerDatosPersona(Long pUsuarioOvId);
}
