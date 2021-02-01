package bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.validadores;

import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.EnumFacFrvccMensajesShared;
import bo.gob.sin.str.util.nit.UtilsVerhoeff;

import java.io.Serializable;
import java.util.HashMap;

import static bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ParametrosPattern.COD_AUTORIZACION_PATTERN;
import static bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ParametrosPattern.CUF_PATTERN;
import static bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ParametrosPattern.CODIGO_AUTORIZACION_BOLETO_AVION_PATTERN;

public final class CodigoAutorizacion implements FieldValidator {
    @Override
    public Boolean isValid(String fieldName, HashMap<String, Serializable> fields) {
        String value = fields.get(fieldName).toString();
        if(value.matches(CUF_PATTERN)){
            return Boolean.TRUE;
        }

        if(value.matches(COD_AUTORIZACION_PATTERN)){
            return Boolean.TRUE;
        }
        
        if(value.matches(CODIGO_AUTORIZACION_BOLETO_AVION_PATTERN)){
            return Boolean.TRUE;
        }
        
     return Boolean.FALSE;
    }

    @Override
    public Integer errorMessage(String fieldName)
    {
        return EnumFacFrvccMensajesShared.CODIGO_AUTORIZACION_NO_VALIDO.getId();
    }

    private  Boolean digitoVerhoeff(String value){
        int vCheck = 0;
        int z;
        int x;
        int i, j;
        Long nroautorizacion = Long.parseLong(value);
        char[] snumero = nroautorizacion.toString().toCharArray();
        for (i = snumero.length - 1, j = 0; i >= 0; i--, j++) {
            x = j % 8;
            int y = Integer.parseInt(String.valueOf(snumero[i]));
            z = UtilsVerhoeff.matriz_permutaciones(x, y);
            vCheck = UtilsVerhoeff.matriz_verhoeff(vCheck, z);
        }
        return  (vCheck == 0) ? Boolean.TRUE : Boolean.FALSE;
    }
}
