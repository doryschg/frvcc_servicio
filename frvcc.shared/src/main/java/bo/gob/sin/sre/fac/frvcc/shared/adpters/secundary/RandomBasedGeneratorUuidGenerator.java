package bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary;




import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.UuidGenerator;
import com.fasterxml.uuid.Generators;
import com.fasterxml.uuid.impl.RandomBasedGenerator;


public final class RandomBasedGeneratorUuidGenerator implements UuidGenerator {
    @Override
    public String generate() {
        RandomBasedGenerator generator = Generators.randomBasedGenerator();
        return generator.generate().toString();
    }
}
