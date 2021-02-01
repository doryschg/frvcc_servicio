package bo.gob.sin.sre.fac.frvcc.misfacturas.model;

public enum EnumtipoBeneficiario {

    JUBILADO("J"),
    DEPENDIENTE("D"),
    INDEPENDIENTE("I");


    private final String value;


    private EnumtipoBeneficiario(String value) {
        this.value = value;
    }
    public  String value(){
        return value;
    }
}
