package bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.shared;

import java.io.Serializable;

public class RespuestaConciliacionDto implements Serializable {
	private Long detalleResumenConciliacionId;

	public Long getDetalleResumenConciliacionId() {
		return detalleResumenConciliacionId;
	}

	public void setDetalleResumenConciliacionId(Long detalleResumenConciliacionId) {
		this.detalleResumenConciliacionId = detalleResumenConciliacionId;
	}

}
