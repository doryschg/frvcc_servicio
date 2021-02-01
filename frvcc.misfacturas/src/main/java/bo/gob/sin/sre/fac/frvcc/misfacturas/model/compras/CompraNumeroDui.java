package bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras;

import bo.gob.sin.sre.fac.frvcc.shared.model.StringValueObject;

public class CompraNumeroDui extends StringValueObject {
    public CompraNumeroDui(String value) {
    	 super( value ==null ? null: value.strip().toUpperCase());
    }

    public CompraNumeroDui() {
    	  super("");
    }
}
