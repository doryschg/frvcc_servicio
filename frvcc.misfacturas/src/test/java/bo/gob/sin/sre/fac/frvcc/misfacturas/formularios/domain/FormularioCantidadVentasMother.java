package bo.gob.sin.sre.fac.frvcc.misfacturas.formularios.domain;


import bo.gob.sin.sre.fac.frvcc.shared.test.domain.MotherCreator;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.*;
public class FormularioCantidadVentasMother {
    public static FormularioCantidadVentas create(Integer value){
        return new FormularioCantidadVentas(value);
    }
    public static FormularioCantidadVentas random(){
        return create(MotherCreator.random().number().randomDigit());
    }
}
