package bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion;

public final class ValidatorNotExist extends Exception {
    public ValidatorNotExist(String name) {
        super(String.format("The validator <%s> does not exist", name));
    }
}
