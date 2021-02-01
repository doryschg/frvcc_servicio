package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.secundary.sucursal_usuario.validadores;

import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.EnumFacFrvccMensajesShared;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ValidationResponse;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.Validator;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ValidatorNotExist;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.validadores.*;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;

import java.io.Serializable;
import java.util.*;

@Service
public final class SucursalUsuarioValidador {

    private final HashMap<String, String> rules = new HashMap<>() {{
        put("id", "required|uuid");
        }};


    public ValidationResponse validarSucursalUsuario(HashMap<String, Serializable> request) {
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

    public ValidationResponse crearValidacionSucursalUsuarioNoExiste() {
        return new ValidationResponse(new HashMap<>() {{
            put("id", Arrays.asList(3000));
        }});
    }

   
    public ValidationResponse getValidacionExistente() {
        return new ValidationResponse(new HashMap<>() {{
            put("nitProveedor", Arrays.asList(EnumFacFrvccMensajesShared.COMPRA_YA_EXISTE.getId()));
        }});
    }

    public ValidationResponse getValidacionException() {
        return new ValidationResponse(new HashMap<>() {{
            put("id", Arrays.asList(EnumFacFrvccMensajesShared.ERROR_REGISTRO_SUCURSAL_USUARIO.getId()));
        }});
    }

   


}


