package bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.validadores;


import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.EnumFacFrvccMensajesShared;

import java.io.Serializable;
import java.util.HashMap;


import static bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ParametrosPattern.NUMERO_FACTURA_PATTERN;


public final class NumeroFacturaValidator implements FieldValidator {

    @Override
    public Boolean isValid(String fieldName, HashMap<String, Serializable> fields) {
        return fields.get(fieldName).toString().matches(NUMERO_FACTURA_PATTERN);

    }
    @Override
    public Integer errorMessage(String fieldName) {

        return EnumFacFrvccMensajesShared.NUMERO_FACTURA_NO_VALIDO.getId();
    }
}
