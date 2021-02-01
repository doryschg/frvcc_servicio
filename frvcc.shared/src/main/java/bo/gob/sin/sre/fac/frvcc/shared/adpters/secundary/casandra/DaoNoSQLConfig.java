package bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.casandra;

import com.datastax.oss.driver.api.core.CqlIdentifier;
import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.type.codec.TypeCodecs;

import java.net.InetSocketAddress;

public class DaoNoSQLConfig {

    private static CqlSession cqlSession = null;

    public static CqlSession openSession() {
        if (cqlSession == null) {
            cqlSession = CqlSession.builder()
                    .addContactPoint(new InetSocketAddress("10.1.17.80", 9042))
                    .addContactPoint(new InetSocketAddress("10.1.17.81", 9042))
                    .addContactPoint(new InetSocketAddress("10.1.17.82", 9042))
                    .withAuthCredentials("usersiat", "siat.usersiat")
                    .withKeyspace(CqlIdentifier.fromCql("pruebakeyspace"))
                    .withLocalDatacenter("uk_dc")
                    .addTypeCodecs(TypeCodecs.ZONED_TIMESTAMP_UTC)
                    .build();
        }
        return cqlSession;
    }

    public static void closeSession() {
        if (cqlSession != null)
            cqlSession.close();
    }

}
