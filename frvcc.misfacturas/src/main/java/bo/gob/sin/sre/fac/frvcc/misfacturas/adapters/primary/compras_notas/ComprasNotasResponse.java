package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras_notas;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.Response;
import bo.gob.sin.str.cmsj.mapl.dto.ListaMensajesAplicacion;

import java.util.List;
import java.util.Objects;

public final class ComprasNotasResponse extends ListaMensajesAplicacion implements Response  {
	private final List<CompraNotaResponseGenerico> comprasNotasResponse;

	private final Integer totalPaginas;
	private final Long totalElementos;

	public ComprasNotasResponse(List<CompraNotaResponseGenerico> comprasNotasResponse) {
		this.comprasNotasResponse = comprasNotasResponse;
		totalPaginas = null;
		totalElementos = null;
	}

	public ComprasNotasResponse(List<CompraNotaResponseGenerico> comprasNotasResponse, Integer totalPaginas, Long totalElementos) {
		this.comprasNotasResponse = comprasNotasResponse;

		this.totalPaginas = totalPaginas;
		this.totalElementos = totalElementos;
	}


	public List<CompraNotaResponseGenerico> getComprasNotasResponse() {
		return comprasNotasResponse;
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
		ComprasNotasResponse that = (ComprasNotasResponse) o;
		return comprasNotasResponse.equals(that.comprasNotasResponse);
	}

	@Override
	public int hashCode() {
		return Objects.hash(comprasNotasResponse);
	}


}
