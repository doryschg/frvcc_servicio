package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.service.libros.lcv;

import java.util.List;

import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.adapters.primary.libros.ConsultaLcvResponse;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.lcv.IResumenLcvRepository;

@Service
public class servicioConsultaLcv implements IResumenLcvRepository{

    private final IResumenLcvRepository resumenLcvRepository;
		
    
	public servicioConsultaLcv(IResumenLcvRepository resumenLcvRepository) {
		this.resumenLcvRepository = resumenLcvRepository;
	}
	
	@Override
	public List<ConsultaLcvResponse> buscarPorNItGestion(Long nit, Integer gestion) {
		return  (List<ConsultaLcvResponse>) resumenLcvRepository.buscarPorNItGestion(nit, gestion);
		
	}

	
}
