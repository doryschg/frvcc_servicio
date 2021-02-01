package bo.gob.sin.sre.fac.frvcc.misfacturas.compras.domain;


import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraCodigoControl;
import bo.gob.sin.sre.fac.frvcc.shared.test.domain.WordMother;

public final class CompraCodigoControlMother {
    public static CompraCodigoControl create(String value) {
        return new CompraCodigoControl(value);
    }

    public static CompraCodigoControl random() {
        return create(WordMother.random());
    }

}
