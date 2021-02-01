package bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras;

public  enum ImpuestoUsoId {
	IUE("IUE"),
	IVA("IVA"),
	RCIVA("RC-IVA"),
	RRIVA("RE-IVA");
    private final String value;


   private ImpuestoUsoId(String value) {
        this.value = value;
    }
    public  String value(){
        return value;
    }
}
