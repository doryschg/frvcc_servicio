package bo.gob.sin.sre.fac.frvcc.misfacturas.compras.domain;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraCodigoAutorizacion;
import bo.gob.sin.sre.fac.frvcc.shared.test.domain.WordMother;


public final class CompraCodigoAutorizacionMother {
    public static CompraCodigoAutorizacion create(String value) {
        return new CompraCodigoAutorizacion(value);
    }

    public static CompraCodigoAutorizacion random() {
        return create(WordMother.random());
    }

}
