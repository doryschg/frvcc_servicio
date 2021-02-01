package bo.gob.sin.sre.fac.frvcc.shared.model.compras;

public enum EnumModalidadId {
	 	MANUAL("MAN"),
	    PREVALORADA("PRE"),
	    COMPUTARIZADA("CMP"),
	    ELECTRONICA("ELE"),
	    ELECTRONICA_CICLOS("CIC"),
	    FACTURA_PORTAL_WB("FPW"),
	    FACTURA_COMPUTARIZADA_LINEA("FCL"),
	    FACTURA_ELECTRONICA_LINEA("FEL");
	    private final String value;


	   private EnumModalidadId(String value) {
	        this.value = value;
	    }
	    public  String value(){
	        return value;
	    }
}
