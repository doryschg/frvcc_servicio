package bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras;

public  enum EstadoUsoId {
    REGISTRADO("REG"),
    APROPIADO("APR"),
    ASOCIADO("ASC"),
    DECLARADO("DEC"),
    CONSOLIDADO("CON"),
    ENVIADO("ENV");
    private final String value;


    EstadoUsoId(String value) {
        this.value = value;
    }
    public  String value(){
        return value;
    }
}
