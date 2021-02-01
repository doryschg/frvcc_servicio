package bo.gob.sin.sre.fac.frvcc.misfacturas.model.hformularios;

import bo.gob.sin.sre.fac.frvcc.shared.model.LocalDateValueObject;

import java.time.LocalDate;

public class HFormularioFechaHasta extends LocalDateValueObject {
    public HFormularioFechaHasta(LocalDate value) {
        super(value);
    }
    public HFormularioFechaHasta(){
        super(null);
    }
}
