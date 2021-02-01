package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.secundary.formularios;
import java.io.InputStream;
import java.util.Base64;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import bo.gob.sin.sre.fac.frvcc.misfacturas.service.formularios.reporte.ParametrosReporte;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.formularios.reportes.IFormularioReporte;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;


@Service
public  class GeneraReporteFormulario110 implements IFormularioReporte {
	private static final Logger LOG= LoggerFactory.getLogger(GeneraReporteFormulario110.class);

	@Override
	public String generarFormulario110(Map<String, Object> vParamReport,
			List<ParametrosReporte> pFacturas) {
		String respuestaBase64 = "";
		try {
			byte[] reportePdf = null;
			JasperPrint vReporteJasper = null;
			vParamReport.put(JRParameter.REPORT_LOCALE, Locale.US);
    		InputStream subReport=getClass().getResourceAsStream("/subReporteFacturas110V2.jasper");
    		InputStream subReport7Rg=getClass().getResourceAsStream("/subReporteFacturas110V2.jasper");
    		vParamReport.put("IMAGE_logo", getClass().getResourceAsStream("/logo.png"));
    		vParamReport.put("SUBREPORT", subReport);
    		vParamReport.put("SUBREPORT7RG", subReport7Rg);
    		InputStream archivoReport = getClass().getResourceAsStream("/reporteFormulario110V2.jasper");
			vReporteJasper = JasperFillManager.fillReport(archivoReport, vParamReport,
					new JRBeanCollectionDataSource(pFacturas));
			reportePdf = JasperExportManager.exportReportToPdf(vReporteJasper);
			respuestaBase64 = Base64.getEncoder().encodeToString(reportePdf);

		} catch (

		JRException exception) {

			LOG.error(exception.getCause().toString(), exception);
		}

		return respuestaBase64;
	}
	@Override
	public String generarFormulario111(Map<String, Object> vParamReport,
									   List<ParametrosReporte> pFacturas) {
		String respuestaBase64 = "";
		try {
			byte[] reportePdf = null;
			JasperPrint vReporteJasper = null;
			vParamReport.put(JRParameter.REPORT_LOCALE, Locale.US);
			InputStream subReport=getClass().getResourceAsStream("/subReporteFacturas111.jasper");
			System.out.println(getClass().getResourceAsStream("/logo.png"));
			vParamReport.put("IMAGE_logo", getClass().getResourceAsStream("/logo.png"));
			vParamReport.put("SUBREPORT", subReport);
			InputStream archivoReport = getClass().getResourceAsStream("/reporteFormulario111.jasper");
			vReporteJasper = JasperFillManager.fillReport(archivoReport, vParamReport,
					new JRBeanCollectionDataSource(pFacturas));
			reportePdf = JasperExportManager.exportReportToPdf(vReporteJasper);
			respuestaBase64 = Base64.getEncoder().encodeToString(reportePdf);

		} catch (

				JRException exception) {

			LOG.error(exception.getCause().toString(), exception);
		}

		return respuestaBase64;
	}
	}
