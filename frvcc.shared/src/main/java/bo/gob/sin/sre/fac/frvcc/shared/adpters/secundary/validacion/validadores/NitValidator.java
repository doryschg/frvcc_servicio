package bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.validadores;

import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.EnumFacFrvccMensajesShared;
import bo.gob.sin.str.util.nit.UtilsNit;
import java.io.Serializable;
import java.util.HashMap;

import static bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ParametrosPattern.NIT_PATTERN;


public final class NitValidator implements FieldValidator {

    @Override
    public Boolean isValid(String fieldName, HashMap<String, Serializable> fields) {
        return UtilsNit.validarDigitoVerificador(Long.parseLong(fields.get(fieldName).toString()))==1 && fields.get(fieldName).toString().matches(NIT_PATTERN);

    }
    @Override
    public Integer errorMessage(String fieldName) {

        return EnumFacFrvccMensajesShared.NIT_FORMATO_NOVALIDO.getId();
    }
}
