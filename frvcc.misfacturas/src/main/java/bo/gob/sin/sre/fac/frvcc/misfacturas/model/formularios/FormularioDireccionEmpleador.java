package bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios;

import bo.gob.sin.sre.fac.frvcc.shared.model.StringValueObject;

public class FormularioDireccionEmpleador extends StringValueObject {
    public FormularioDireccionEmpleador(String value) {
        super(value==null? null:value.strip().toUpperCase());
    }
    public FormularioDireccionEmpleador(){
        super(null);
    }
}
