package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas;

public  enum EnumMarcaEspecialId {
    IPN("CIPN"),
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
