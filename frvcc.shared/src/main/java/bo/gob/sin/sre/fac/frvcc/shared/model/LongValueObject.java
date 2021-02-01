package bo.gob.sin.sre.fac.frvcc.shared.model;

public abstract class LongValueObject {
    private Long value;

    public LongValueObject(Long value) {
        this.value = value;
    }

    public Long value(){
        return this.value;
    }

}
