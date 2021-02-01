package bo.gob.sin.sre.fac.frvcc.misfacturas.formularios.domain;

import bo.gob.sin.sre.fac.frvcc.shared.test.domain.WordMother;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.*;
public class FormularioDireccionEmpleadorMother {
    public static FormularioDireccionEmpleador create(String value){
        return new FormularioDireccionEmpleador(value);
    }
    public static FormularioDireccionEmpleador random(){
        return create(WordMother.random());
    }
}
