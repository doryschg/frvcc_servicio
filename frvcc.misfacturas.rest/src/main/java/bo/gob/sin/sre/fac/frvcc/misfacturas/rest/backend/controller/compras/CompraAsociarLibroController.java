package bo.gob.sin.sre.fac.frvcc.misfacturas.rest.backend.controller.compras;




import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.asociar_libro.AsociarLibroCompraCommandImpl;
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


@RestController
@RequestMapping("/rest/misfacturas")
public final class CompraAsociarLibroController extends ApiController {
	@Autowired
	private IMensajeAplicacionDomain mensajesDomain;
    public CompraAsociarLibroController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @PutMapping(value = "/compra/asociarlibro/{id}")
    public ResponseEntity<ResultadoGenericoDto<String>> index(@PathVariable String id, @RequestBody Request request) throws CommandNotRegisteredError, CommandHandlerExecutionError {
         dispatch(new AsociarLibroCompraCommandImpl(id,
                 request.libroId(),
                 usuarioId(),request.tipoCompraId()));

         ResultadoGenericoDto<String> resultadoGenericoDto = new ResultadoGenericoDto<>(id);
 		resultadoGenericoDto.setOk(Boolean.TRUE);
 		resultadoGenericoDto.getMensajes().add(mensajesDomain.getMensaje(EnumSubsistema.RECAUDACIONES,EnumFacFrvccMensajesShared.ASOCIACION_COMPRAS_CORRECTO));
 		return ResponseEntity.ok(resultadoGenericoDto);    }

    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
    	return new HashMap<>(){{
            put(CompraListaErrores.class,HttpStatus.OK);
        }};
    }

    static final class Request{
        private String libroId;
        private String tipoCompraId;
        public Request() {
        }

       public Request(String libroId,String tipoCompraId) {
           this.libroId = libroId;
       }

       public String libroId() {
            return libroId;
        }

        public void setLibroId(String libroId) {
            this.libroId = libroId;
        }
        public String tipoCompraId()
        {
        	return tipoCompraId;
        }
        public void setTipoCompraId(String tipoCompraId)
        {
        	this.tipoCompraId=tipoCompraId;
        }
    }

}



