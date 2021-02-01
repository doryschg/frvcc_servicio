package bo.gob.sin.sre.fac.frvcc.shared.model;

public enum EnumEstadoId {
    ACTIVO("AC"),
    ANULADO("AN"),
    REVERTIDO("RE");
    private String value;

    EnumEstadoId(String value) {
        this.value = value;
    }
    public String value(){
        return this.value;
    }
}
