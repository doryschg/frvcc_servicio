package bo.gob.sin.sre.fac.frvcc.misfacturas.formularios.domain;

import bo.gob.sin.sre.fac.frvcc.shared.test.domain.IntegerMother;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.*;

public class FormularioMesPeriodoMother {
    public static FormularioMesPeriodo create(Integer value){
        return new FormularioMesPeriodo(value);
    }
    public static FormularioMesPeriodo random(){
        return create(IntegerMother.random());
    }
}
