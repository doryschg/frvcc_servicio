package bo.gob.sin.sre.fac.frvcc.misfacturas.service.sucursal_usuario.modificar;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.secundary.sucursal_usuario.validadores.SucursalUsuarioValidador;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.sucursal_usuario.SucursalUsuario;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.sucursal_usuario.SucursalUsuarioId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.sucursal_usuario.SucursalUsuarioListaErrores;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.sucursal_usuario.SucursalUsuarioUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.sucursal_usuario.modificar.ISucursalUsuarioModificador;
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
public final class SucursalUsuarioModificadorServiceImpl implements ISucursalUsuarioModificador {
    private static final Logger LOG = LoggerFactory.getLogger(SucursalUsuarioModificadorServiceImpl.class);
    private final ISucursalUsuarioRepository repository;
    private final EventBus eventBus;
    private final SucursalUsuarioValidador validador;

    public SucursalUsuarioModificadorServiceImpl(ISucursalUsuarioRepository pRepository, EventBus pEventBus, SucursalUsuarioValidador pValidador) {
        this.repository = pRepository;
        this.eventBus = pEventBus;
        this.validador = pValidador;
    }

    public void modificar(SucursalUsuarioId pId,
                          SucursalUsuarioUsuarioUltimaModificacion pUsuarioUltimaModificacion
                          ) {
        SucursalUsuario vFormulario = repository.search(pId)
                .orElseThrow(() -> new SucursalUsuarioListaErrores(pId, validador.crearValidacionSucursalUsuarioNoExiste()));
        boolean vFechaValida = true;
//        if (vFormulario.tipoFormularioId().value().equals(EnumTipoFormularioId.FORMULARIO_110.value())) {
//            vFechaValida = (pFechaPresentacion.value().getMonthValue() >= vFormulario.mesPeriodo().value()) &&
//                    (pFechaPresentacion.value().getYear() >= vFormulario.anioPeriodo().value());
//        }
//
//        if (vFechaValida) {
//            vFormulario.modificar(pDireccion, pDireccionEmpleador, pUsuarioUltimaModificacion, pLugarDepartamento,
//                    pFechaPresentacion, pDatosespecificos);
//            try {
//                repository.save(vFormulario);
//                eventBus.publish(vFormulario.pullDomainEvents());
//            } catch (Exception excepcion) {
//                LOG.error(excepcion.getCause().toString(), excepcion);
//                throw new FormularioListaErrores(pId, crearValidacionException());
//
//            }
//            eventBus.publish(vFormulario.pullDomainEvents());
//        } else {
//            throw new FormularioListaErrores(pId, crearValidacionFechaPresentacion());
//        }

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
