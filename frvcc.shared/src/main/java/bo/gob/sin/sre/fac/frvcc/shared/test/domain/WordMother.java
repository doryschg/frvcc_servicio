package bo.gob.sin.sre.fac.frvcc.shared.test.domain;

public final class WordMother {
    public static String random() {
        return MotherCreator.random().lorem().word();
    }
}
