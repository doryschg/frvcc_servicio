package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras;

import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.Response;
import bo.gob.sin.str.cmsj.mapl.dto.ListaMensajesAplicacion;



import java.util.List;
import java.util.Objects;

public final class ComprasResponse extends ListaMensajesAplicacion implements Response  {
	private final List<CompraResponseGenerico> comprasResponse;

	private final Integer totalPaginas;
	private final Long totalElementos;

	public ComprasResponse(List<CompraResponseGenerico> comprasResponse) {
		this.comprasResponse = comprasResponse;
		totalPaginas = null;
		totalElementos = null;
	}

	public ComprasResponse(List<CompraResponseGenerico> comprasResponse, Integer totalPaginas, Long totalElementos) {
		this.comprasResponse = comprasResponse;

		this.totalPaginas = totalPaginas;
		this.totalElementos = totalElementos;
	}

	public List<CompraResponseGenerico> getComprasResponse() {
		return comprasResponse;
	}

	public Integer getTotalPaginas() {
		return totalPaginas;
	}

	public Long getTotalElementos() {
		return totalElementos;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		ComprasResponse that = (ComprasResponse) o;
		return comprasResponse.equals(that.comprasResponse);
	}

	@Override
	public int hashCode() {
		return Objects.hash(comprasResponse);
	}


}
