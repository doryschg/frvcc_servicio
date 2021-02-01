package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.primary.ventas;

import java.util.List;

import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.Response;
import bo.gob.sin.str.cmsj.mapl.dto.ListaMensajesAplicacion;

public class VentasResponse extends ListaMensajesAplicacion implements Response  {
		private final List<VentaResponseGenerico> ventasResponse;

		private final Integer totalPaginas;
		private final Long totalElementos;

		public VentasResponse(List<VentaResponseGenerico> ventasResponse) {
			this.ventasResponse = ventasResponse;
			totalPaginas = null;
			totalElementos = null;
		}

		public VentasResponse(List<VentaResponseGenerico> ventasResponse, Integer totalPaginas, Long totalElementos) {
			this.ventasResponse = ventasResponse;

			this.totalPaginas = totalPaginas;
			this.totalElementos = totalElementos;
		}

		public List<VentaResponseGenerico> getVentasResponse() {
			return ventasResponse;
		}

		public Integer getTotalPaginas() {
			return totalPaginas;
		}

		public Long getTotalElementos() {
			return totalElementos;
		}
		
		
}
