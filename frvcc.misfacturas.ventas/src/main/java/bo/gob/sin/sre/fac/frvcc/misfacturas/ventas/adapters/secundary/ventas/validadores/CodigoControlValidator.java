package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.secundary.ventas.validadores;

import java.io.Serializable;
import java.util.HashMap;

import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.validadores.FieldValidator;

public final class CodigoControlValidator implements FieldValidator {
    @Override
    public Boolean isValid(String fieldName, HashMap<String, Serializable> fields) {
        return null;
    }

    @Override
    public Integer errorMessage(String fieldName) {
        return null;
    }
}
