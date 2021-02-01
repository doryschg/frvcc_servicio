package bo.gob.sin.sre.fac.frvcc.misfacturas.formularios.domain;

import bo.gob.sin.sre.fac.frvcc.shared.test.domain.WordMother;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.*;
public class FormularioEstadoIdMother {


    public static FormularioEstadoId create(String value) {
        return new FormularioEstadoId(value);
    }

    public static FormularioEstadoId random() {
        return create(WordMother.random());
    }
}
