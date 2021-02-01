package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.archivo;


import bo.gob.sin.sre.fac.frvcc.shared.model.ArrayByteValueObject;

public final class ArchivoByte extends ArrayByteValueObject {
    public ArchivoByte(byte[] value) {
        super(value);
    }
    private ArchivoByte(){
        super(null);
    }

}
