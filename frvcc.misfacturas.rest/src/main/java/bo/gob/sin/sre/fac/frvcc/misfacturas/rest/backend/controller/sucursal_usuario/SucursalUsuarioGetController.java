package bo.gob.sin.sre.fac.frvcc.misfacturas.rest.backend.controller.sucursal_usuario;

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
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.sucursal_usuario.SucursalUsuarioResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.sucursal_usuario.find.FindSucursalUsuarioQuery;
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
public class SucursalUsuarioGetController extends ApiController {
	@Autowired
	private IMensajeAplicacionDomain mensajesDomain;
    public SucursalUsuarioGetController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @GetMapping(value = "/sucursalUsuario/{id}")
    public ResponseEntity<SucursalUsuarioResponse> index(@PathVariable String id) throws QueryNotRegisteredError, QueryHandlerExecutionError {
    	SucursalUsuarioResponse vSucursalUsuarioResponse= ask(new FindSucursalUsuarioQuery(id));
        vSucursalUsuarioResponse.setOk(Boolean.TRUE);
 		return ResponseEntity.ok(vSucursalUsuarioResponse);
    }

    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
    	return new HashMap<>(){{
            put(CompraListaErrores.class,HttpStatus.OK);
        }};    }
}
