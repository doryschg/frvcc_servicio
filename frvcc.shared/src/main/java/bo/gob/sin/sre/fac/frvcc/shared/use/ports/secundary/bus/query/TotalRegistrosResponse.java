package bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query;

public class TotalRegistrosResponse  implements Response {
	private final Long totalPaginas;


	public TotalRegistrosResponse(Long totalPaginas) {
		this.totalPaginas = totalPaginas;
	}

	public Long totalPaginas() {
		return this.totalPaginas;
	}
}
