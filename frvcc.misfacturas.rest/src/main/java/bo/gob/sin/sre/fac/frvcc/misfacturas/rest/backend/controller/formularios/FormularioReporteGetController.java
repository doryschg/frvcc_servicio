package bo.gob.sin.sre.fac.frvcc.misfacturas.rest.backend.controller.formularios;


import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios.FormularioReporteResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios.reporte.ReporteFormularioQuery;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioListaErrores;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioNotExist;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.EnumFacFrvccMensajesShared;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.ResultadoGenericoDto;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.spring.ApiController;
import bo.gob.sin.sre.fac.frvcc.shared.model.DomainError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryNotRegisteredError;
import bo.gob.sin.str.cmsj.mapl.domain.IMensajeAplicacionDomain;
import bo.gob.sin.str.enumeradores.entorno.EnumSubsistema;

@RestController
@RequestMapping("/rest/misfacturas")
public final class FormularioReporteGetController extends ApiController {
	@Autowired
    private IMensajeAplicacionDomain mensajesDomain;
    public FormularioReporteGetController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }
    @GetMapping(value = "/formulario/reporte/{id}")
    public ResponseEntity<ResultadoGenericoDto<FormularioReporteResponse>> index(@PathVariable String id) throws QueryNotRegisteredError, QueryHandlerExecutionError {
        FormularioReporteResponse vFormReportResponse = ask(new ReporteFormularioQuery(id));
        ResultadoGenericoDto<FormularioReporteResponse> resultadoGenericoDto = new ResultadoGenericoDto<FormularioReporteResponse>(vFormReportResponse);
        resultadoGenericoDto.setOk(Boolean.TRUE);
        if(vFormReportResponse.getArchivoBase64().equals(""))
        {
        	 resultadoGenericoDto.setOk(Boolean.FALSE);
      		resultadoGenericoDto.getMensajes().add(mensajesDomain.getMensaje(EnumSubsistema.RECAUDACIONES,EnumFacFrvccMensajesShared.ERROR_GENERAR_REPORTE));

        }
        else {
     		resultadoGenericoDto.getMensajes().add(mensajesDomain.getMensaje(EnumSubsistema.RECAUDACIONES,EnumFacFrvccMensajesShared.REPORTE_GENERADO_CORRECTO));
        }
        
		return ResponseEntity.ok(resultadoGenericoDto);  
       
    }

    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
    	 return new HashMap<>(){{
             put(FormularioListaErrores.class,HttpStatus.OK);
         }};
    }
}
