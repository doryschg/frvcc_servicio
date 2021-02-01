package bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras;

public  enum EnumMarcaEspecialId {
    IPN("IPN"),
	SIETERG("7RG"),
	SINMARCA("SM");
    private final String value;


   private EnumMarcaEspecialId(String value) {
        this.value = value;
    }
    public  String value(){
        return value;
    }
}
