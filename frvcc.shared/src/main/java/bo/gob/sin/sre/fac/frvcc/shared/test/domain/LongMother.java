package bo.gob.sin.sre.fac.frvcc.shared.test.domain;

public final class LongMother {
    public static Long random() {
        return MotherCreator.random().number().randomNumber(10,true);
    }
}
