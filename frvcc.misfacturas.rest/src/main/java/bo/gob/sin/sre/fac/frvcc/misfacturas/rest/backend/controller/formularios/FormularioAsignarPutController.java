package bo.gob.sin.sre.fac.frvcc.misfacturas.rest.backend.controller.formularios;


import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.asignar.AsignarCompraCommandImpl;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraListaErrores;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.EnumFacFrvccMensajesShared;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.ResultadoGenericoDto;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.spring.ApiController;
import bo.gob.sin.sre.fac.frvcc.shared.model.DomainError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandNotRegisteredError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryBus;
import bo.gob.sin.str.cmsj.mapl.domain.IMensajeAplicacionDomain;
import bo.gob.sin.str.enumeradores.entorno.EnumSubsistema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;


@RestController
@RequestMapping("/rest/misfacturas")
public final class FormularioAsignarPutController extends ApiController {
	@Autowired
	private IMensajeAplicacionDomain mensajesDomain;

    public FormularioAsignarPutController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @PutMapping(value = "/formulario/asignar/{id}")
    public ResponseEntity<ResultadoGenericoDto<String>> index(@PathVariable String id, @RequestBody Request request) throws CommandNotRegisteredError, CommandHandlerExecutionError {
         dispatch(new AsignarCompraCommandImpl(id,
                 request.getCompraId(),
                 usuarioId()));

        ResultadoGenericoDto<String> resultadoGenericoDto = new ResultadoGenericoDto<>(id);
		resultadoGenericoDto.setOk(Boolean.TRUE);
		resultadoGenericoDto.getMensajes().add(mensajesDomain.getMensaje(EnumSubsistema.RECAUDACIONES,EnumFacFrvccMensajesShared.ASOCIACION_COMPRAS_CORRECTO));
		return ResponseEntity.ok(resultadoGenericoDto);
    }
    
    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
    	return new HashMap<>(){{
            put(CompraListaErrores.class,HttpStatus.OK);
        }};
    }

    static final class Request {
        private String compraId;

        public Request() {
        }

        public String getCompraId() {
            return compraId;
        }

        public void setCompraId(String compraId) {
            this.compraId = compraId;
        }
    }

}



