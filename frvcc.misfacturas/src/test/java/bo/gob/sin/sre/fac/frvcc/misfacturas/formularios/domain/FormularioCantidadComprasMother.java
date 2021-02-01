package bo.gob.sin.sre.fac.frvcc.misfacturas.formularios.domain;


import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioCantidadComprasCf;
import bo.gob.sin.sre.fac.frvcc.shared.test.domain.MotherCreator;

public class FormularioCantidadComprasMother {
    public static FormularioCantidadComprasCf create(Integer value){
        return new FormularioCantidadComprasCf(value);
    }
    public static FormularioCantidadComprasCf random(){
        return create(MotherCreator.random().number().randomDigit());
    }
}
