package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.secundary.compras.validadores;

import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.EnumFacFrvccMensajesShared;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.validadores.FieldValidator;

import java.io.Serializable;
import java.util.HashMap;

public final class FueraDePeridicidad implements FieldValidator {
    @Override
    public Boolean isValid(String fieldName, HashMap<String, Serializable> fields) {
        String value = fields.get(fieldName).toString();
        return true;
    }

    @Override
    public Integer errorMessage(String fieldName) {
        return  EnumFacFrvccMensajesShared.CODIGO_AUTORIZACION_NO_VALIDO.getId();
    }
}
