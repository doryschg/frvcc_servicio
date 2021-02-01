package bo.gob.sin.sre.fac.frvcc.misfacturas.rest.backend.controller.compras_notas;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras_notas.CompraNotaResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras_notas.find.FindCompraNotaQuery;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraListaErrores;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.spring.ApiController;
import bo.gob.sin.sre.fac.frvcc.shared.model.DomainError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryNotRegisteredError;
import bo.gob.sin.str.cmsj.mapl.domain.IMensajeAplicacionDomain;

@RestController
@RequestMapping("/rest/misfacturas")
public class CompraNotaGetController extends ApiController {
	@Autowired
	private IMensajeAplicacionDomain mensajesDomain;
    public CompraNotaGetController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @GetMapping(value = "/compraNota/{id}")
    public ResponseEntity<CompraNotaResponse> index(@PathVariable String id) throws QueryNotRegisteredError, QueryHandlerExecutionError {
        CompraNotaResponse vCompraResponse= ask(new FindCompraNotaQuery(id));

        vCompraResponse.setOk(Boolean.TRUE);
 		return ResponseEntity.ok(vCompraResponse);
    }

    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
    	return new HashMap<>(){{
            put(CompraListaErrores.class,HttpStatus.OK);
        }};    }
}
