package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.shared.adapters.primary;

import bo.gob.sin.str.parametricas.enumeradores.IMensajeAplicacion;

public enum EnumFacVentasMensajesShared implements IMensajeAplicacion {

	EXCEL_INVALIDO(2129);

	private final int id;

	EnumFacVentasMensajesShared(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
}
