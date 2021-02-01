package bo.gob.sin.sre.fac.frvcc.shared.model;

final public class EstadoId extends StringValueObject {
    public EstadoId() {
        super("");
    }

    public EstadoId(String value) {
        super( value ==null ? null: value.strip().toUpperCase());
    }
}
