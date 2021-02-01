package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.secundary.compras.validadores_libro_compras;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.secundary.compras.validadores.CodigoControlValidator;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.secundary.compras.validadores.FechaFacturaValidator;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.secundary.compras.validadores.OrigenValidator;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.EnumFacFrvccMensajesShared;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ValidationResponse;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.Validator;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ValidatorNotExist;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.validadores.*;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;

import java.io.Serializable;
import java.util.*;

@Service
public final class LibroCompraValidador {


    private final HashMap<String, String> rules = new HashMap<>() {{
        put("id", "required|uuid");
        put("nitProveedor", "required|nit");
        put("fechaFactura", "required|fecha_emision");
       // put("numeroFactura", "required|numero_factura");
        //put("numeroDui", "required|numero_dui");
        put("codigoAutorizacion", "required|codigo_autorizacion");
        put("importeTotalCompra", "required|importe_total");
        put("importeBaseCf", "required|importe_base_cf");
        put("nombreCliente", "required");
        put("tipoDocumentoCliente", "required");
        put("numeroDocumentoCliente", "required");
        put("origenId", "origen_compra|required");
       
    }};

    public ValidationResponse validarLibroCompra(HashMap<String, Serializable> request) {
        HashMap<String, FieldValidator> validators = new HashMap<>() {{
        	  put("nit", new NitValidator());
              put("uuid", new UuidValidator());
              put("required", new RequiredValidator());
              put("string", new StringValidator());
              put("not_empty", new NotEmptyValidator());
              // put("numero_factura", new NumeroFacturaValidator());
              //put("numero_dui", new NumeroDuiValidator());
              put("codigo_autorizacion", new CodigoAutorizacionEstandar());
              put("origen_compra", new OrigenValidator());
              put("importe_total", new ImporteTotalCompra());
              put("importe_base_cf", new ImporteTotalCompra());
              put("fecha_emision", new FechaFacturaValidator());
              put("codigo_control", new CodigoControlValidator());   
         
     }};
     try {
         return Validator.validate(request, this.rules, validators);
     } catch (ValidatorNotExist validatorNotExist) {
         return null;
     }
 }

    public ValidationResponse getValidacionNumeroAutorizacionException(List<Integer> listaErrores) {
        return new ValidationResponse(new HashMap<>() {{
            listaErrores.stream().forEach(error -> {
                        put("pNumeroAutorizacion", Arrays.asList(error));
                    }
            );
        }});
    }
    
    public ValidationResponse crearValidacionCompraNoExiste(){
        return  new ValidationResponse(new HashMap<>() {{
            put("id", Arrays.asList(EnumFacFrvccMensajesShared.COMPRA_NO_EXISTE.getId()));
        }});
    }}
