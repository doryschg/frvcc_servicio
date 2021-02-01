package bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion;

import java.util.HashMap;
import java.util.List;

public final class ValidationResponse {
    private HashMap<String, List<Integer>> validationErrors;

    public ValidationResponse(HashMap<String, List<Integer>> validationErrors) {
        this.validationErrors = validationErrors;
    }

    public Boolean hasErrors() {
        return !validationErrors.isEmpty();
    }

    public HashMap<String, List<Integer>> errors() {
        return validationErrors;
    }
}
