package bo.gob.sin.sre.fac.frvcc.misfacturas.formularios.domain;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.*;
import bo.gob.sin.sre.fac.frvcc.shared.test.domain.WordMother;

public class FormularioRazonSocialMother {
	 public static FormularioRazonSocial create(String value){
	        return new FormularioRazonSocial(value);
	    }
	    public static FormularioRazonSocial random(){
	        return create(WordMother.random());
	    }

}
