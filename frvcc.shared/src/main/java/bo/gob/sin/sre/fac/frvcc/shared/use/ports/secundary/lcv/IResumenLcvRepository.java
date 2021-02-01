package bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.lcv;

import java.util.List;

public interface IResumenLcvRepository<ConsultaLcvResponse> {
	List<ConsultaLcvResponse> buscarPorNItGestion(Long nit, Integer gestion);

}
