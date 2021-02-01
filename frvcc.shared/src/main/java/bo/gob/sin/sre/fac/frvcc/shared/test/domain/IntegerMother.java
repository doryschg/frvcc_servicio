package bo.gob.sin.sre.fac.frvcc.shared.test.domain;

public final class IntegerMother {
    public static Integer random() {
        return MotherCreator.random().number().randomDigit();
    }
}
