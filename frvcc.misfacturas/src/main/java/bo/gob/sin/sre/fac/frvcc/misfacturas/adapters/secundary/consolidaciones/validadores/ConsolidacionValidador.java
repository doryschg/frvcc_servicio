package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.secundary.consolidaciones.validadores;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.EnumFacFrvccMensajesShared;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ValidationResponse;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.Validator;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ValidatorNotExist;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.validadores.*;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

@Service
public final class ConsolidacionValidador {

//TODO crear validacion de not null
    private final HashMap<String, String> rules = new HashMap<>() {{
        put("id", "required|uuid");
        put("ifcAgente", "required");
        put("nitAgente", "required");
        put("razonSocialAgente", "required");
        put("administracion", "required");
        put("gestion", "required");
        put("periodo", "required");
        put("usuarioConsolidador", "required");
        put("loginUsuarioConsolidador", "required");
        put("nombreConsolidador", "required");
        put("usuarioRegistro", "required");
    }};


    public ValidationResponse validarConsolidacion(HashMap<String, Serializable> request) {
           HashMap<String, FieldValidator> validators = new HashMap<>() {{
            put("uuid", new UuidValidator());
            put("required", new RequiredValidator());
            put("string", new StringValidator());
            put("not_empty", new NotEmptyValidator());
        }};
        try {
            HashMap filtros = (HashMap)this.rules.entrySet().stream().filter(rol -> request.keySet().stream().anyMatch(x -> x.equals(rol.getKey()))).collect(Collectors.toMap(k->k.getKey(), v -> v.getValue()));
            return Validator.validate(request, filtros, validators);
        } catch (ValidatorNotExist validatorNotExist) {
            return null;
        }
    }
    public ValidationResponse crearValidacionException() {
        return new ValidationResponse(new HashMap<>() {
            {
                put("id", Arrays.asList(EnumFacFrvccMensajesShared.ERROR_REGISTRO_CONSOLIDACION.getId()));
            }
        });
    }
    public ValidationResponse crearValidacionConsolidacionExistente() {
        return new ValidationResponse(new HashMap<>() {
            {
                put("id", Arrays.asList(EnumFacFrvccMensajesShared.ERROR_CONSOLIDACION_EXISTENTE.getId()));
            }
        });
    }

    public ValidationResponse crearValidacionFormulariosPendientes() {
        return new ValidationResponse(new HashMap<>() {
            {
                put("id", Arrays.asList(EnumFacFrvccMensajesShared.ERROR_FORMULARIOS_PENDIENTES_REVISION.getId()));
            }
        });
    }
}
