package bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios;

public enum EnumTipoUsoId {
	TIPO_DEPENDIENTE("D"),
    TIPO_EXDEPENDIENTE("E"),
    TIPO_JUBILADO("J"),
    TIPO_REFRIGERIO("R"),
	TIPO_ANEXO("A");

    private final String value;


   private EnumTipoUsoId(String value) {
        this.value = value;
    }
    public  String value(){
        return value;
    }
}
