package bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.formularios.reportes;

import java.util.List;
import java.util.Map;

import bo.gob.sin.sre.fac.frvcc.misfacturas.service.formularios.reporte.ParametrosReporte;

public interface IFormularioReporte {
    String generarFormulario110(Map<String, Object> vParamReport, 
    		List<ParametrosReporte> pFacturas);
    String generarFormulario111(Map<String, Object> vParamReport,
                                List<ParametrosReporte> pFacturas);

}
