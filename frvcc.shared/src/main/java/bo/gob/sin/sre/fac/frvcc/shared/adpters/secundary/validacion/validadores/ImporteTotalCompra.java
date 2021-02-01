package bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.validadores;

import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.EnumFacFrvccMensajesShared;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;




public final class ImporteTotalCompra implements FieldValidator {

    @Override
    public Boolean isValid(String fieldName, HashMap<String, Serializable> fields) {
        BigDecimal valor = new BigDecimal(fields.get(fieldName).toString());
        BigDecimal valorMaximo = new BigDecimal("999999999999999.99");
        if (valor.compareTo(BigDecimal.ZERO) < 0) {
            return Boolean.FALSE;
        }
        if (valor.compareTo(valorMaximo) > 0) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;

    }

    @Override
    public Integer errorMessage(String fieldName) {

        return EnumFacFrvccMensajesShared.IMPORTE_NO_VALIDO.getId();
    }
}
