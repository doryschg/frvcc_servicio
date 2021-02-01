package bo.gob.sin.sre.fac.frvcc.misfacturas.formularios.domain;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioAnioPeriodo;
import bo.gob.sin.sre.fac.frvcc.shared.test.domain.IntegerMother;


public class FormularioAnioPeriodoMother {
    public static FormularioAnioPeriodo create(Integer value){
        return new FormularioAnioPeriodo(value);
    }
    public static FormularioAnioPeriodo random(){
        return create(IntegerMother.random());
    }
}
