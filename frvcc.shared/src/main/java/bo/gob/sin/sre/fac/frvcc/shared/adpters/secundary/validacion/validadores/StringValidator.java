package bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.validadores;

import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.EnumFacFrvccMensajesShared;

import java.io.Serializable;
import java.util.HashMap;

public final class StringValidator implements FieldValidator {
    @Override
    public Boolean isValid(String fieldName,
                           HashMap<String, Serializable> fields) {
        return true;
    }

    @Override
    public Integer errorMessage(String fieldName) {
        return EnumFacFrvccMensajesShared.CADENA_NO_VALIDA.getId();
    }
}
