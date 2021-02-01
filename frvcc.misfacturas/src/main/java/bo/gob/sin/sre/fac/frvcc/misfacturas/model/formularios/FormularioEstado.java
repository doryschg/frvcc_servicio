package bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios;



public enum  FormularioEstado  {
     REGISTRADO("REG");
 private final String value;
    FormularioEstado(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
