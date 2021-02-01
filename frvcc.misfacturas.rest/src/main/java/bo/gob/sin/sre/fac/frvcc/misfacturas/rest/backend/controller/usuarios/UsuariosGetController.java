package bo.gob.sin.sre.fac.frvcc.misfacturas.rest.backend.controller.usuarios;


import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios.FormularioResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios.find.FindFormularioQuery;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.usuario.UsuariosResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioListaErrores;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.usuario.obtener.IBuscarUsuarioQueryService;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.spring.ApiController;
import bo.gob.sin.sre.fac.frvcc.shared.model.DomainError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryNotRegisteredError;
import bo.gob.sin.str.cmsj.mapl.domain.IMensajeAplicacionDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/rest/misfacturas")
public final class UsuariosGetController extends ApiController {
	@Autowired
	private IMensajeAplicacionDomain mensajesDomain;
    @Autowired
	private IBuscarUsuarioQueryService usuariosService;

    public UsuariosGetController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }
    @GetMapping(value = "/usuarios/{pNit}")
    public ResponseEntity<UsuariosResponse> index(@PathVariable Long pNit) throws QueryNotRegisteredError, QueryHandlerExecutionError {

        UsuariosResponse vFormularioResponse=usuariosService.obtenerUsuarios(pNit);
        vFormularioResponse.setOk(Boolean.TRUE);
 		return ResponseEntity.ok(vFormularioResponse);
      }

    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping(){
    	 return new HashMap<>(){{
             put(FormularioListaErrores.class,HttpStatus.OK);
         }};
    }
}
