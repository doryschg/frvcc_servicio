package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.Response;


public final class FormularioReporteResponse  implements Response {
	private final String archivoBase64;

	public FormularioReporteResponse(String archivoBase64) {
		super();
		this.archivoBase64 = archivoBase64;
	}

	public String getArchivoBase64() {
		return archivoBase64;
	}

}
