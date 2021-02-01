package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas;

import java.io.Serializable;
import java.util.HashMap;

import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ValidationResponse;
import bo.gob.sin.sre.fac.frvcc.shared.model.DomainError;

public final class VentaErrorLecturaExcel extends DomainError implements Serializable {
	public VentaErrorLecturaExcel(VentaId id, ValidationResponse pHashMapErrorCodigo) {
		super(id.value(), pHashMapErrorCodigo);
	}

	public VentaErrorLecturaExcel(HashMap<String, ValidationResponse> plistaErrores) {
		super(plistaErrores);
	}
}