package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros;

public  enum EnumEstadoLibroId {
    REGISTRADO("REG"),
    DECLARADO("DEC"),
    RECTIFICADO("REC");
    private final String value;


   private EnumEstadoLibroId(String value) {
        this.value = value;
    }
    public  String value(){
        return value;
    }
}
