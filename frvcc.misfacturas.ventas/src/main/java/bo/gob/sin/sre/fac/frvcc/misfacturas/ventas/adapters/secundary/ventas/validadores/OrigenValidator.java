package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.secundary.ventas.validadores;

import java.io.Serializable;
import java.util.HashMap;

import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.EnumFacFrvccMensajesShared;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.validadores.FieldValidator;


public final class OrigenValidator implements FieldValidator {
    @Override
    public Boolean isValid(String fieldName, HashMap<String, Serializable> fields) {
        String value = fields.get(fieldName).toString();
        return value.matches("SER|MOB|APL|SFV|LCV");
    }

    @Override
    public Integer errorMessage(String fieldName) {
    	// TODO: Crear mensaje error.
        return EnumFacFrvccMensajesShared.ORIGEN_COMPRA_INVALIDO.getId();
    }
}
