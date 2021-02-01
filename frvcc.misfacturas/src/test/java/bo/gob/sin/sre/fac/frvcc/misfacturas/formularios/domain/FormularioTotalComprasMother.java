package bo.gob.sin.sre.fac.frvcc.misfacturas.formularios.domain;

import bo.gob.sin.sre.fac.frvcc.shared.test.domain.MotherCreator;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.*;
import java.math.BigDecimal;

public final class FormularioTotalComprasMother {
    public static FormularioTotalComprasCf create(BigDecimal value){
        return new FormularioTotalComprasCf(value);
    }
    public static FormularioTotalComprasCf random(){
        return create( new BigDecimal(MotherCreator.random().number().randomDouble(2,10,1000)));
    }
}
