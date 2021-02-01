package bo.gob.sin.sre.fac.frvcc.misfacturas.compras.domain;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraNombreFormularioUso;
import bo.gob.sin.sre.fac.frvcc.shared.test.domain.WordMother;

public final class CompraNombreArchivoUsoMother {
    public static CompraNombreFormularioUso create(String value) {
        return new CompraNombreFormularioUso(value);
    }

    public static CompraNombreFormularioUso random() {
        return create(WordMother.random());
    }

}
