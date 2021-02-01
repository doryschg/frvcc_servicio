package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas;

import java.math.BigDecimal;

import bo.gob.sin.sre.fac.frvcc.shared.model.BigDecimalValueObject;

public class VentaImporteBase extends BigDecimalValueObject {
	public VentaImporteBase(BigDecimal value) {
		super(value);
	}

	public VentaImporteBase() {
		super(null);
	}

	public static VentaImporteBase importeBaseCreditoFiscal(BigDecimal pImporteTotal,
			BigDecimal pImporteBaseCreditoFiscal, String pMarcaEspecial, BigDecimal pCreditoFiscal) {
		if (pMarcaEspecial.equals(EnumMarcaEspecialId.SIETERG.value())
				|| (pCreditoFiscal.compareTo(new BigDecimal("0")) == 0)) {
			return new VentaImporteBase(BigDecimal.ZERO);
		}
		return new VentaImporteBase(pImporteTotal);
	}

	public static VentaImporteBase ajusteImporteBaseCf(VentaConDerechoDf conDerechoCf,
			VentaImporteBase ventaImporteBase) {
		if (conDerechoCf.value().equals(ConDerechoDf.NO.toString())) {
			return new VentaImporteBase(BigDecimal.ZERO);
		}
		return new VentaImporteBase(ventaImporteBase.value());
	}
}
