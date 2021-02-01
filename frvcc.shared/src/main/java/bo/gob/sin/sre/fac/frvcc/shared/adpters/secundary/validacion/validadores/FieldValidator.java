package bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.validadores;

import java.io.Serializable;
import java.util.HashMap;

public interface FieldValidator {
    Boolean isValid(String fieldName, HashMap<String, Serializable> fields);

    Integer errorMessage(String fieldName);
}
