package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.secundary.compras.validadores_libro_compras;

import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.EnumFacFrvccMensajesShared;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.validadores.FieldValidator;

import java.io.Serializable;
import java.util.HashMap;


public final class OrigenValidator implements FieldValidator {
    @Override
    public Boolean isValid(String fieldName, HashMap<String, Serializable> fields) {
        String value = fields.get(fieldName).toString();
        return value.matches("SER|MOB|APL|SFV|LCV");
    }

    @Override
    public Integer errorMessage(String fieldName) {
        return EnumFacFrvccMensajesShared.ORIGEN_COMPRA_INVALIDO.getId();
    }
}
