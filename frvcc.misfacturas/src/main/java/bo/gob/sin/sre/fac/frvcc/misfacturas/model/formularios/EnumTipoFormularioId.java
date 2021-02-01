package bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios;

public enum EnumTipoFormularioId {
	FORMULARIO_110("F110"),
    FORMULARIO_110_AF610("AF610"),
    FORMULARIO_110_AF510("AF510"),
    FORMULARIO_110_AF702("AF702"),
	FORMULARIO_111("F111");
    
    private final String value;


   private EnumTipoFormularioId(String value) {
        this.value = value;
    }
    public  String value(){
        return value;
    }
}
