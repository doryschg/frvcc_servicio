package bo.gob.sin.sre.fac.frvcc.shared.test.domain;

import java.util.UUID;

public final class UuidMother {
    public static String random() {
        return UUID.randomUUID().toString();
    }
}
