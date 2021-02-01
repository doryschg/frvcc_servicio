package bo.gob.sin.sre.fac.frvcc.misfacturas.rest.backend.controller.formularios;

import java.util.HashMap;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios.rechazar.RechazarFormularioCommand;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraListaErrores;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioListaErrores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import bo.gob.sin.sre.fac.frvcc.shared.model.DomainError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandNotRegisteredError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryBus;
import bo.gob.sin.str.cmsj.mapl.domain.IMensajeAplicacionDomain;
import bo.gob.sin.str.enumeradores.entorno.EnumSubsistema;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.EnumFacFrvccMensajesShared;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.ResultadoGenericoDto;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.spring.ApiController;

@RestController
@RequestMapping("/rest/misfacturas")
public class FormularioRechazarPutController extends ApiController {
	@Autowired
	private IMensajeAplicacionDomain mensajesDomain;
    public FormularioRechazarPutController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @PutMapping(value = "/formulario/rechazar/")
    public ResponseEntity<ResultadoGenericoDto<String>> index(@RequestBody Request request) throws CommandNotRegisteredError, CommandHandlerExecutionError {
        dispatch(new RechazarFormularioCommand(request.id(),
                usuarioId(),
                request.nombreReceptor(),
                request.loginUsuarioReceptor()));
        ResultadoGenericoDto<String> resultadoGenericoDto = new ResultadoGenericoDto<>(request.id);
 		resultadoGenericoDto.setOk(Boolean.TRUE);
 		resultadoGenericoDto.getMensajes().add(mensajesDomain.getMensaje(EnumSubsistema.RECAUDACIONES,EnumFacFrvccMensajesShared.FORMULARIO_RECHAZADO_CORRECTO));
 		return ResponseEntity.ok(resultadoGenericoDto);
            }

    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
    	 return new HashMap<>(){{
             put(FormularioListaErrores.class,HttpStatus.OK);
         }};   }

    static final class Request {
        private String id;
        private String nombreReceptor;
        private String loginUsuarioReceptor;

        public Request() {
        }

        public Request(String id, String nombreReceptor, String loginUsuarioReceptor) {
            this.id = id;
            this.loginUsuarioReceptor = loginUsuarioReceptor;
            this.nombreReceptor = nombreReceptor;
        }

        public String id() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
        public String loginUsuarioReceptor() {
            return loginUsuarioReceptor;
        }

        public String nombreReceptor() {
            return nombreReceptor;
        }

        public void setNombreReceptor(String nombreReceptor) {
            this.nombreReceptor = nombreReceptor;
        }

        public void setLoginUsuarioReceptor(String loginUsuarioReceptor) {
            this.loginUsuarioReceptor = loginUsuarioReceptor;
        }
    }
}
