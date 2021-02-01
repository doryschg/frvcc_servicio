package bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.config;

public final class ParameterNotExist extends Throwable {
    public ParameterNotExist(String key) {
        super(String.format("El Parametro <%s> no existe en ambiente", key));
    }
}
