package bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary;



import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.UuidGenerator;


import java.util.UUID;


@Service
public final class JavaUuidGenerator implements UuidGenerator {
    @Override
    public String generate() {

        return UUID.randomUUID().toString();
    }
}
