package bo.gob.sin.sre.fac.frvcc.misfacturas.compras.domain;


import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraTipoSectorId;
import bo.gob.sin.sre.fac.frvcc.shared.test.domain.IntegerMother;

public final class CompraTipoCompraIdMother {
    public static CompraTipoSectorId create(Integer value) {
        return new CompraTipoSectorId(value);
    }

    public static CompraTipoSectorId random() {
        return create(IntegerMother.random());
    }

}
