package bo.gob.sin.sre.fac.frvcc.misfacturas.formularios.domain;

import bo.gob.sin.sre.fac.frvcc.shared.test.domain.WordMother;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.*;
public class FormularioDireccionMother {
    public static FormularioDireccion create(String value){
        return new FormularioDireccion(value);
    }
    public static FormularioDireccion random(){
        return create(WordMother.random());
    }
}
