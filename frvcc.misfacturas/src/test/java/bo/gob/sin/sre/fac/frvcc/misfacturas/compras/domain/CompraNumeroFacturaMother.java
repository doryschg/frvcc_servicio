package bo.gob.sin.sre.fac.frvcc.misfacturas.compras.domain;


import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraNumeroFactura;
import bo.gob.sin.sre.fac.frvcc.shared.test.domain.LongMother;

public final class CompraNumeroFacturaMother {
    public static CompraNumeroFactura create(Long value) {
        return new CompraNumeroFactura(value);
    }

    public static CompraNumeroFactura random() {
        return create(LongMother.random());
    }
}
