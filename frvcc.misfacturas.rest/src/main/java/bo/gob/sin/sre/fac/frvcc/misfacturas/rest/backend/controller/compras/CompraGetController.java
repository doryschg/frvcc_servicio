package bo.gob.sin.sre.fac.frvcc.misfacturas.rest.backend.controller.compras;



import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.CompraResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.find.FindCompraQuery;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraListaErrores;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.EnumFacFrvccMensajesShared;
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
public class CompraGetController extends ApiController {
	@Autowired
	private IMensajeAplicacionDomain mensajesDomain;
    public CompraGetController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @GetMapping(value = "/compra/{id}")
    public ResponseEntity<CompraResponse> index(@PathVariable String id) throws QueryNotRegisteredError, QueryHandlerExecutionError {
        CompraResponse vCompraResponse= ask(new FindCompraQuery(id));

        vCompraResponse.setOk(Boolean.TRUE);
        //vCompraResponse.getMensajes().add(mensajesDomain.getMensaje(EnumSubsistema.RECAUDACIONES,EnumFacFrvccMensajesShared.DESASOCIACION_COMPRAS_CORRECTO));//TODO crear mensaje exito
 		return ResponseEntity.ok(vCompraResponse);
    }

    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
    	return new HashMap<>(){{
            put(CompraListaErrores.class,HttpStatus.OK);
        }};    }
}
