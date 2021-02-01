package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.rest.backend.controller.libros;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.adapters.primary.libros.ContribuyenteNewtonResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.adapters.primary.libros.LibroResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.adapters.primary.libros.contribuyente_newton.ContribuyenteNewtonQuery;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.adapters.primary.libros.find.FindLibroQuery;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioNotExist;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.spring.ApiController;
import bo.gob.sin.sre.fac.frvcc.shared.model.DomainError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryNotRegisteredError;

@RestController
@RequestMapping("/rest/misfacturas")
public class LibroGetContribuyenteNewton extends ApiController{

	public LibroGetContribuyenteNewton(QueryBus queryBus, CommandBus commandBus) {
		super(queryBus, commandBus);
		// TODO Auto-generated constructor stub
	}

	 @GetMapping(value = "/libro/contribuyenteNewton/{nit}")
	    public ResponseEntity<ContribuyenteNewtonResponse> index(@PathVariable Long nit) throws QueryNotRegisteredError, QueryHandlerExecutionError {
		 ContribuyenteNewtonResponse vNewtonResponse = ask(new ContribuyenteNewtonQuery(nit));
	        vNewtonResponse.setOk(true);
	        return  ResponseEntity.ok(vNewtonResponse);
	      }

	    @Override
	    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping(){
	        return new HashMap<Class<? extends DomainError>, HttpStatus>(){{
	           put(FormularioNotExist.class,HttpStatus.NOT_FOUND);
	        }};
	    }

}
