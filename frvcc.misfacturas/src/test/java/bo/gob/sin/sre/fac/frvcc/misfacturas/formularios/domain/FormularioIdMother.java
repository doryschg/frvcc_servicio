package bo.gob.sin.sre.fac.frvcc.misfacturas.formularios.domain;
import bo.gob.sin.sre.fac.frvcc.shared.test.domain.UuidMother;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.*;
public class FormularioIdMother {
    public static FormularioId create(String value) {
        return new FormularioId(value);
    }

    public static FormularioId random() {
        return create(UuidMother.random());
    }

}
