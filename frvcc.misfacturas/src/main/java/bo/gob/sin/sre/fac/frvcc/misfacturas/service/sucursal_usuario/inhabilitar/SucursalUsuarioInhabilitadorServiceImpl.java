package bo.gob.sin.sre.fac.frvcc.misfacturas.service.sucursal_usuario.inhabilitar;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.secundary.sucursal_usuario.validadores.SucursalUsuarioValidador;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.sucursal_usuario.SucursalUsuario;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.sucursal_usuario.SucursalUsuarioId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.sucursal_usuario.SucursalUsuarioListaErrores;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.sucursal_usuario.SucursalUsuarioUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.sucursal_usuario.inhabilitar.ISucursalUsuarioInhabilitar;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.sucursal_usuario.ISucursalUsuarioRepository;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.EnumFacFrvccMensajesShared;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ValidationResponse;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.EventBus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashMap;

@Service
public final class SucursalUsuarioInhabilitadorServiceImpl implements ISucursalUsuarioInhabilitar {
    private static final Logger LOG = LoggerFactory.getLogger(SucursalUsuarioInhabilitadorServiceImpl.class);
    private final ISucursalUsuarioRepository repository;
    private final EventBus eventBus;
    private final SucursalUsuarioValidador validador;

    public SucursalUsuarioInhabilitadorServiceImpl(ISucursalUsuarioRepository pRepository, EventBus pEventBus, SucursalUsuarioValidador pValidador) {
        this.repository = pRepository;
        this.eventBus = pEventBus;
        this.validador = pValidador;
    }

    public void inhabilitar(SucursalUsuarioId pId,
                          SucursalUsuarioUsuarioUltimaModificacion pUsuarioUltimaModificacion
                          ) {
        SucursalUsuario sucursalUsuario = repository.search(pId)
                .orElseThrow(() -> new SucursalUsuarioListaErrores(pId, validador.crearValidacionSucursalUsuarioNoExiste()));
        boolean vFechaValida = true;

            sucursalUsuario.inhabilitar(pUsuarioUltimaModificacion);
            try {
                repository.save(sucursalUsuario);
                eventBus.publish(sucursalUsuario.pullDomainEvents());
            } catch (Exception excepcion) {
                LOG.error(excepcion.getCause().toString(), excepcion);
                throw new SucursalUsuarioListaErrores(pId, crearValidacionException());
            }


    }

    private ValidationResponse crearValidacionException() {
        return new ValidationResponse(new HashMap<>() {
            {
                put("id", Arrays.asList(EnumFacFrvccMensajesShared.ERROR_EDICION.getId()));
            }
        });
    }

    private ValidationResponse crearValidacionFechaPresentacion() {
        return new ValidationResponse(new HashMap<>() {{
            put("id", Arrays.asList(EnumFacFrvccMensajesShared.FORMULARIO_FECHA_PRESENTACION.getId()));
        }});
    }

}
