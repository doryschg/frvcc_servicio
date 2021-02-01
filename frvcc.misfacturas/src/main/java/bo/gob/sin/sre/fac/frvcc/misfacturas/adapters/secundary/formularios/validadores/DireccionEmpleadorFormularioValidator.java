package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.secundary.formularios.validadores;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.EnumTipoFormularioId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.EnumTipoUsoId;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.EnumFacFrvccMensajesShared;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.validadores.FieldValidator;


import java.io.Serializable;

import java.util.HashMap;

public class DireccionEmpleadorFormularioValidator implements FieldValidator {
    @Override
    public Boolean isValid(String fieldName, HashMap<String, Serializable> fields) {
        String tipoFormulario = fields.get(fieldName).toString().split("|")[0];
        String tipoUsoId = fields.get(fieldName).toString().split("|")[1];
        String direccion = fields.get(fieldName).toString().split("|")[2];

        if(!tipoFormulario.equals(EnumTipoFormularioId.FORMULARIO_110.value())){
            return Boolean.TRUE;
        }
        if(tipoUsoId.equals(EnumTipoUsoId.TIPO_DEPENDIENTE.value()) && direccion != null && direccion.equals("")){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;

    }

    @Override
    public Integer errorMessage(String fieldName) {
        return EnumFacFrvccMensajesShared.ERROR_DIRECCION_EMPLEADOR.getId();
    }
}
