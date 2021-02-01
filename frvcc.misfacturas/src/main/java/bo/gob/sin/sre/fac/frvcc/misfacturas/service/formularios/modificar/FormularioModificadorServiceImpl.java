package bo.gob.sin.sre.fac.frvcc.misfacturas.service.formularios.modificar;

import java.util.Arrays;
import java.util.HashMap;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.*;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.EnumFacFrvccMensajesShared;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.secundary.formularios.validadores.FormularioValidador;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.formularios.modificar.IFormularioModificador;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.formularios.FormularioRepository;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ValidationResponse;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.EventBus;

@Service
public final class FormularioModificadorServiceImpl implements IFormularioModificador {
    private static final Logger LOG = LoggerFactory.getLogger(FormularioModificadorServiceImpl.class);
    private final FormularioRepository repository;
    private final EventBus eventBus;
    private final FormularioValidador validador;

    public FormularioModificadorServiceImpl(FormularioRepository pRepository, EventBus pEventBus, FormularioValidador pValidador) {
        this.repository = pRepository;
        this.eventBus = pEventBus;
        this.validador = pValidador;
    }

    public void modificar(FormularioId pId,
                          FormularioDireccion pDireccion,
                          FormularioDireccionEmpleador pDireccionEmpleador,
                          FormularioUsuarioUltimaModificacion pUsuarioUltimaModificacion,
                          FormularioLugarDepartamento pLugarDepartamento,
                          FormularioFechaPresentacion pFechaPresentacion,
                          FormularioNumeroSucursal pNumeroSucursal,
                          DatosEspecificos pDatosespecificos,
                          FormularioTipoUsoId pEsExDependiente) {
        LOG.info("campos formulario {}, {}, {}, {}, {}, {}",
                pDireccion,
                pDireccionEmpleador,
                pUsuarioUltimaModificacion,
                pLugarDepartamento,
                pFechaPresentacion,
                pNumeroSucursal);
        Formulario vFormulario = repository.search(pId)
                .orElseThrow(() -> new FormularioListaErrores(pId, validador.crearValidacionFormularioNoExistente()));
        boolean vFechaValida = true;
        if (vFormulario.tipoFormularioId().value().equals(EnumTipoFormularioId.FORMULARIO_110.value())) {
            vFechaValida = (pFechaPresentacion.value().getMonthValue() >= vFormulario.mesPeriodo().value()) &&
                    (pFechaPresentacion.value().getYear() >= vFormulario.anioPeriodo().value());
        }

        if (vFechaValida) {
            vFormulario.modificar(pDireccion, pDireccionEmpleador, pUsuarioUltimaModificacion, pLugarDepartamento,
                    pFechaPresentacion,pNumeroSucursal, pDatosespecificos,pEsExDependiente);
            try {
                repository.save(vFormulario);
                eventBus.publish(vFormulario.pullDomainEvents());
            } catch (Exception excepcion) {
                LOG.error(excepcion.getCause().toString(), excepcion);
                System.out.println(excepcion.getCause().toString());
                throw new FormularioListaErrores(pId, crearValidacionException());

            }

        } else {
            throw new FormularioListaErrores(pId, crearValidacionFechaPresentacion());
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
