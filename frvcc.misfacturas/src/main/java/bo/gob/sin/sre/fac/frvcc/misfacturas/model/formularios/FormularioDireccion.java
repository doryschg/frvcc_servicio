package bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios;

import bo.gob.sin.sre.fac.frvcc.shared.model.StringValueObject;

public final class FormularioDireccion extends StringValueObject {
    public FormularioDireccion(String value) {
        super(value==null? null: value.strip().toUpperCase());
    }
    public FormularioDireccion(){
        super(null);
    }
}
