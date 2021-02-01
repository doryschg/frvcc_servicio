package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.secundary.ventas.validadores;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;

import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.validadores.FieldValidator;
import bo.gob.sin.sre.fac.frvcc.shared.model.Utils;

public final class FechaFacturaValidator implements FieldValidator {


    @Override
    public Boolean isValid(String fieldName, HashMap<String, Serializable> fields) {
        LocalDate FechaMininaFactura = LocalDate.of(2015,12,31);
        LocalDate fechaFactura = Utils.stringToLocalDate(fields.get(fieldName).toString());
        if(fechaFactura.isAfter(FechaMininaFactura) && fechaFactura.isBefore(LocalDate.now().plusDays(1))){
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }

    @Override
    public Integer errorMessage(String fieldName) {
        return 1;
    }
}
