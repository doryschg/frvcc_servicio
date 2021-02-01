package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.secundary.compras_notas.validadores;

import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.EnumFacFrvccMensajesShared;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ValidationResponse;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.Validator;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ValidatorNotExist;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.validadores.*;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;

import java.io.Serializable;
import java.util.*;

@Service
public final class CompraNotaValidador {


    private final HashMap<String, String> rules = new HashMap<>() {{
        put("id", "required");
        put("nitProveedor", "nit|required");
        put("numeroNota", "required");
        put("codigoAutorizacion", "required");
        put("fechaNota", "required");
        put("importeTotalNota", "required");
        put("compraId", "required");
        put("tipoDocumentoCliente", "required");
        put("numeroDocumentoCliente", "required");
        put("nombreCliente", "required");
        put("origenId", "required");
        put("usuarioRegistro", "required");   
    }};



    public ValidationResponse validarCompraNota(HashMap<String, Serializable> request) {
           HashMap<String, FieldValidator> validators = new HashMap<>() {{
            put("nit",  new NitValidator());
            put("uuid", new UuidValidator());
            put("required", new RequiredValidator());
            put("string", new StringValidator());
            put("not_empty", new NotEmptyValidator());
            put("uuid", new UuidValidator());
//            put("cod_auto", new CodigoAutorizacion());
            put("origen_compra", new OrigenValidator());
        }};
        try {
            return Validator.validate(request, this.rules, validators);
        } catch (ValidatorNotExist validatorNotExist) {
            return null;
        }
    }
    
    public ValidationResponse crearValidacionCompraNotaNoExiste(){
        return  new ValidationResponse(new HashMap<>() {{
            put("id", Arrays.asList(EnumFacFrvccMensajesShared.COMPRA_NOTA_NO_EXISTE.getId()));
        }});
    }
    
}
