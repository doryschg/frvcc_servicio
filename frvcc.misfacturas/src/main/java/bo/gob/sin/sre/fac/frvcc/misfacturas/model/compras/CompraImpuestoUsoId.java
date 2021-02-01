package bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras;

import bo.gob.sin.sre.fac.frvcc.shared.model.StringValueObject;

public final class CompraImpuestoUsoId extends StringValueObject {
    public CompraImpuestoUsoId() {
        super("");
    }

    public CompraImpuestoUsoId(String value) {
    	super(value==null?value:value.strip().toUpperCase());
    }
}
