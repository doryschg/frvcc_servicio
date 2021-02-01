package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.secundary.formularios.validadores;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioNombreEmpleador;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.EnumFacFrvccMensajesShared;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ValidationResponse;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.Validator;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ValidatorNotExist;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.validadores.*;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

@Service
public final class FormularioValidador {
	
    public static final String TIPO_FORMULARIO_110="F110";

    private final HashMap<String, String> rules = new HashMap<>() {{
        put("id", "required|uuid");
        put("tipoFormularioId", "required");
        put("nitCi", "required");
        put("razonSocial", "required");
        put("anioPeriodo", "required");
        put("nombreFormulario", "required");
        put("lugarDepartamento", "required");
        put("tipoPresentacion", "required");
        put("direccion", "required");
        put("periodicidadId", "required");
        put("cantidadPeriodicidad", "required");
        put("direccionEmpleador", "direccion_empleador");
    }};

    public ValidationResponse validarFormulario(HashMap<String, Serializable> request) {
           HashMap<String, FieldValidator> validators = new HashMap<>() {{
            put("uuid", new UuidValidator());
            put("required", new RequiredValidator());
            put("string", new StringValidator());
            put("not_empty", new NotEmptyValidator());
            put("direccion_empleador", new DireccionEmpleadorFormularioValidator());
        }};
        try {
            HashMap filtros = (HashMap)this.rules.entrySet().stream().filter(rol -> request.keySet().stream().anyMatch(x -> x.equals(rol.getKey()))).collect(Collectors.toMap(k->k.getKey(), v -> v.getValue()));
            return Validator.validate(request, filtros, validators);
        } catch (ValidatorNotExist validatorNotExist) {
            return null;
        }
    }

    
    public Boolean validarRazonSocialEmpleador(FormularioNombreEmpleador pRazonSocialEmpleador, String pTipoFormulario)
    {
    	if(pTipoFormulario.equals(TIPO_FORMULARIO_110)) {
    		
    		String pRazonSocial= pRazonSocialEmpleador!=null?pRazonSocialEmpleador.value():null;
    		return pRazonSocial==null;
    	}
    	else {
    		return false;
    	}
    }
    public ValidationResponse crearValidacionNombreEmpleador(){
        return  new ValidationResponse(new HashMap<>() {{
            put("id", Arrays.asList(EnumFacFrvccMensajesShared.NOMBRE_EMPLEADOR_NOT_NULL.getId()));
            }});
    }
    
    public ValidationResponse crearValidacionFormularioNoExistente(){
        return  new ValidationResponse(new HashMap<>() {{
            put("id", Arrays.asList(EnumFacFrvccMensajesShared.FORMULARIO_NO_EXISTE.getId()));
            }});
    }

    public ValidationResponse crearValidacionFormularioNoTieneCompras(){
        return  new ValidationResponse(new HashMap<>() {{
            put("id", Arrays.asList(EnumFacFrvccMensajesShared.COMPRA_NO_EXISTE.getId()));
        }});
    }

    public ValidationResponse crearValidacion(EnumFacFrvccMensajesShared EnumFacFrvccMensajesShared){
        return  new ValidationResponse(new HashMap<>() {{
            put("id", Arrays.asList(EnumFacFrvccMensajesShared.getId()));
        }});
    }
    public ValidationResponse crearValidacionconsolidacionRealizadaAgente(){
        return  new ValidationResponse(new HashMap<>() {{
            put("id", Arrays.asList(EnumFacFrvccMensajesShared.ERROR_CONSOLIDACION_REALIZADA.getId()));
        }});
    }

    public ValidationResponse crearValidacionConciliacionExistentye(){
        return  new ValidationResponse(new HashMap<>() {{
            put("id", Arrays.asList(EnumFacFrvccMensajesShared.ERROR_CONCILICION_EXISTENTE.getId()));
        }});
    }

    public ValidationResponse crearValidacionconsolidacionDireccionEmpleadorRequerida()
    {
        return  new ValidationResponse(new HashMap<>() {{
            put("id", Arrays.asList(EnumFacFrvccMensajesShared.ERROR_DIRECCION_EMPLEADOR.getId()));
        }});
    }


}
