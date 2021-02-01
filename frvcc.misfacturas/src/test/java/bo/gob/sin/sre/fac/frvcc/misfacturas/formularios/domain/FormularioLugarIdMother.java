package bo.gob.sin.sre.fac.frvcc.misfacturas.formularios.domain;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.*;
import bo.gob.sin.sre.fac.frvcc.shared.test.domain.WordMother;

public class FormularioLugarIdMother {
	  public static FormularioLugarId create(String value){
	        return new FormularioLugarId(value);
	    }
	    public static FormularioLugarId random(){
	        return create(WordMother.random());
	    }

}
