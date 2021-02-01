package bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras;

import bo.gob.sin.sre.fac.frvcc.shared.model.BigDecimalValueObject;
import bo.gob.sin.sre.fac.frvcc.shared.model.Utils;

import java.math.BigDecimal;

public class CompraImporteBaseCf  extends BigDecimalValueObject {
    public CompraImporteBaseCf(BigDecimal value) {
        super(value);
    }

    public CompraImporteBaseCf() {
        super(null);
    }

    public static CompraImporteBaseCf importeBaseCreditoFiscal(BigDecimal pImporteTotal, BigDecimal pImporteBaseCreditoFiscal, String pMarcaEspecial, BigDecimal pCreditoFiscal) {
        if(pMarcaEspecial.equals(EnumMarcaEspecialId.SIETERG.value())||(pCreditoFiscal.compareTo(new BigDecimal("0"))==0)){
            return new CompraImporteBaseCf(BigDecimal.ZERO);
        }
        return new CompraImporteBaseCf(pImporteTotal);
}

    public static CompraImporteBaseCf ajusteImporteBaseCf(CompraConDerechoCf conDerechoCf, CompraImporteBaseCf importeBaseCf){
        if (conDerechoCf.value().equals(ConDerechoCf.NO.toString())){
         return new CompraImporteBaseCf(BigDecimal.ZERO);
        }
        return new CompraImporteBaseCf(importeBaseCf.value());
    }
}
