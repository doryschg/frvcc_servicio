package bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras;

import bo.gob.sin.sre.fac.frvcc.shared.model.BigDecimalValueObject;
import bo.gob.sin.sre.fac.frvcc.shared.model.Utils;

import java.math.BigDecimal;

public final class CompraCreditoFiscal extends BigDecimalValueObject {
    public CompraCreditoFiscal(BigDecimal value) {
        super(value);
    }

    public CompraCreditoFiscal() {
        super(null);
    }

    public static CompraCreditoFiscal creditoFiscal(BigDecimal importeBaseCreditoFiscal, String pImpuesto) {
        BigDecimal creditoFiscal = importeBaseCreditoFiscal.multiply(new BigDecimal(pImpuesto));
        return new CompraCreditoFiscal(creditoFiscal);
    }

    public static CompraCreditoFiscal creditoFiscal(BigDecimal importeBaseCreditoFiscal, BigDecimal pImpuesto) {
        BigDecimal porcentaje = pImpuesto.multiply(new BigDecimal(Utils.PORCENTAJE));
        BigDecimal creditoFiscal = importeBaseCreditoFiscal.multiply(porcentaje);
        return new CompraCreditoFiscal(creditoFiscal);
    }


    public static CompraCreditoFiscal creditoFiscal(BigDecimal pImporteTotal, BigDecimal pImporteBaseCreditoFiscal, String pMarcaEspecial, BigDecimal pCreditoFiscal) {
        BigDecimal vCreditoFiscal = (pImporteTotal.multiply(pCreditoFiscal.divide(new BigDecimal(Utils.CIEN))));
        return new CompraCreditoFiscal(vCreditoFiscal);
    }

    public static CompraCreditoFiscal creditoFiscal(BigDecimal pImporteTotalAnterior, BigDecimal pImporteTotalActual, BigDecimal pCreditoFiscalActual) {
        BigDecimal vCreditofiscalPorCentaje = pCreditoFiscalActual.divide(pImporteTotalAnterior);
        BigDecimal vCreditoFiscal = pImporteTotalActual.multiply(vCreditofiscalPorCentaje);
        return new CompraCreditoFiscal(vCreditoFiscal);
    }
}
