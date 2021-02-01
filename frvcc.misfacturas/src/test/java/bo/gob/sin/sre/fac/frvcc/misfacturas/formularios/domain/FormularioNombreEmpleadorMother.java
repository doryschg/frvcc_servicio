package bo.gob.sin.sre.fac.frvcc.misfacturas.formularios.domain;


import bo.gob.sin.sre.fac.frvcc.shared.test.domain.WordMother;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.*;
public final class FormularioNombreEmpleadorMother {
	  public static FormularioNombreEmpleador create(String value){
	        return new FormularioNombreEmpleador(value);
	    }
	    public static FormularioNombreEmpleador random(){
	        return create(WordMother.random());
	    }

}
