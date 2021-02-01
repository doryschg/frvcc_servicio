package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.secundary.formularios.validadores;

import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.validadores.FieldValidator;

import java.io.Serializable;
import java.util.HashMap;

public final class TipoPresentacionIdValidator implements FieldValidator {
    @Override
    public Boolean isValid(String fieldName, HashMap<String, Serializable> fields) {
        return null;
    }

    @Override
    public Integer errorMessage(String fieldName) {
        return null;
    }
}
