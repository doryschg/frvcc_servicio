package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.adapters.secundary.libros.validadores;

import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.validadores.FieldValidator;

import java.io.Serializable;
import java.util.HashMap;

public final class IfcValidator implements FieldValidator {
    @Override
    public Boolean isValid(String fieldName, HashMap<String, Serializable> fields) {
        return null;
    }

    @Override
    public Integer errorMessage(String fieldName) {
        return null;
    }
}
