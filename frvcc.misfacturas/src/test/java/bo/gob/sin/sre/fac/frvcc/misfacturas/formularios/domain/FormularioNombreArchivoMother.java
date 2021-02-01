package bo.gob.sin.sre.fac.frvcc.misfacturas.formularios.domain;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.*;
import bo.gob.sin.sre.fac.frvcc.shared.test.domain.WordMother;

public final class FormularioNombreArchivoMother {
	  public static FormularioNombreFormulario create(String value){
	        return new FormularioNombreFormulario(value);
	    }
	    public static FormularioNombreFormulario random(){
	        return create(WordMother.random());
	    }

}

