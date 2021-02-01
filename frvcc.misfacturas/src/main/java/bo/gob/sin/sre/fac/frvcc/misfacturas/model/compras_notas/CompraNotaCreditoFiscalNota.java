package bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas;

import bo.gob.sin.sre.fac.frvcc.shared.model.BigDecimalValueObject;

import java.math.BigDecimal;

public final class CompraNotaCreditoFiscalNota extends BigDecimalValueObject {
    public CompraNotaCreditoFiscalNota(BigDecimal value) {
        super(value);
    }

    public CompraNotaCreditoFiscalNota() {
        super(null);
    }

//    public static CompraCreditoFiscal creditoFiscal(CompraImporteBaseCf importeBaseCreditoFiscal){
//         BigDecimal creditoFiscal = importeBaseCreditoFiscal.value().multiply(new BigDecimal(Utils.IMPUESTO_IVA));
//        return new CompraCreditoFiscal(creditoFiscal);
//    }
}
