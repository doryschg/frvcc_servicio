package bo.gob.sin.sre.fac.frvcc.shared.model;

public abstract class ArrayByteValueObject {
    private byte[] value;
    public byte[] value(){
        return this.value;
    }

    public ArrayByteValueObject(byte[] value) {
        this.value = value;
    }


}
