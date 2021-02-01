package bo.gob.sin.sre.fac.frvcc.misfacturas.model.hformularios;

import bo.gob.sin.sre.fac.frvcc.shared.model.LocalDateValueObject;

import java.time.LocalDate;

public class HFormularioFechaDesde extends LocalDateValueObject {
    public HFormularioFechaDesde(LocalDate value) {
        super(value);
    }
    public HFormularioFechaDesde(){
        super(null);
    }
}
