package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.adapters.secundary.libros.validadores;

import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.EnumFacFrvccMensajesShared;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ValidationResponse;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.Validator;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ValidatorNotExist;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.validadores.*;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;

import java.io.Serializable;
import java.util.*;

@Service
public final class LibroValidador {

    private final HashMap<String, String> rules = new HashMap<>() {{
        put("id", "required");
        put("nit", "required");
        put("razonSocial", "required");
        put("anioPeriodo", "required");
        put("nombreLibro", "required");
        put("tipoPresentacion", "required");
        put("periodicidadId", "required");
        put("cantidadPeriodicidad", "required");
    }};

    public ValidationResponse validarLibro(HashMap<String, Serializable> request) {
           HashMap<String, FieldValidator> validators = new HashMap<>() {{
            put("uuid", new UuidValidator());
            put("required", new RequiredValidator());
            put("string", new StringValidator());
            put("not_empty", new NotEmptyValidator());
        }};
        try {
            return Validator.validate(request, this.rules, validators);
        } catch (ValidatorNotExist validatorNotExist) {
            return null;
        }
    }
    public ValidationResponse crearValidacionLibroNoExistente(){
        return  new ValidationResponse(new HashMap<>() {{
            put("id", Arrays.asList(EnumFacFrvccMensajesShared.FORMULARIO_NO_EXISTE.getId()));
            }});
    }

}
