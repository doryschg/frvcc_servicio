package bo.gob.sin.sre.fac.frvcc.misfacturas.formularios.domain;


import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.*;
import bo.gob.sin.sre.fac.frvcc.shared.test.domain.WordMother;

public final class FormularioEstadoFormularioIdMother {
    public static FormularioEstadoFormularioId create(String value){
        return new FormularioEstadoFormularioId(value);
    }
    public static FormularioEstadoFormularioId random(){
        return create(WordMother.random());
    }
}
