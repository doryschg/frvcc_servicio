package bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion;



import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.validadores.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Validator {


    public static ValidationResponse validate(
        HashMap<String, Serializable> input,
        HashMap<String, String> combinedRules,
        HashMap<String, FieldValidator> validators
    ) throws ValidatorNotExist {
        HashMap<String, List<Integer>> validationErrors = new HashMap<>();

        for (Map.Entry<String, String> entry : combinedRules.entrySet()) {
            String[] rules = entry.getValue().split("\\|");

            for (String rule : rules) {
                FieldValidator validator = validators.get(rule);
                if (null == validator) {
                    throw new ValidatorNotExist(rule);
                }
                if (!validator.isValid(entry.getKey(), input)) {
                    List<Integer> existingErrors = validationErrors.getOrDefault(entry.getKey(), new ArrayList<>());
                    existingErrors.add(validator.errorMessage(entry.getKey()));
                    validationErrors.put(entry.getKey(), existingErrors);
                }
            }
        }

        return new ValidationResponse(validationErrors);
    }


}
