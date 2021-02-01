package bo.gob.sin.sre.fac.frvcc.misfacturas.compras.domain;


import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraImpuestoUsoId;
import bo.gob.sin.sre.fac.frvcc.shared.test.domain.WordMother;

public final class CompraImpuestoUsoIdMother {
    public static CompraImpuestoUsoId create(String value) {
        return new CompraImpuestoUsoId(value);
    }

    public static CompraImpuestoUsoId random() {
        return create(WordMother.random());
    }
}
