package bo.gob.sin.sre.fac.frvcc.misfacturas.formularios.domain;

import bo.gob.sin.sre.fac.frvcc.shared.test.domain.WordMother;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.*;
public final class FormularioTipoFormularioIdMother {
    public static FormularioTipoFormularioId create(String value){
        return new FormularioTipoFormularioId(value);
    }
    public static FormularioTipoFormularioId random(){
        return create(WordMother.random());
    }
}
