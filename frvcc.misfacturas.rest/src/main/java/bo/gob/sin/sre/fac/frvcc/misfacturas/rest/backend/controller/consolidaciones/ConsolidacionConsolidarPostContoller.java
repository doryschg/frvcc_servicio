package bo.gob.sin.sre.fac.frvcc.misfacturas.rest.backend.controller.consolidaciones;


import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.consolidaciones.consolidar.ConsolidarConsolidacionCommand;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.consolidaciones.registro.RegistroConsolidacionCommand;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.consolidaciones.ConsolidacionListaErrores;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.consolidaciones.ConsolidadorListaErrores;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.HashMap;

@RestController
@RequestMapping("/rest/misfacturas")
public final class ConsolidacionConsolidarPostContoller extends ApiController {

	@Autowired
	private IMensajeAplicacionDomain mensajesDomain;

    public ConsolidacionConsolidarPostContoller(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @PostMapping(value = "/consolidacion/consolidar")
    public ResponseEntity<ResultadoGenericoDto<String>> index(@RequestBody Request request) throws CommandNotRegisteredError, CommandHandlerExecutionError {

        dispatch(
                ConsolidarConsolidacionCommand.newConsolidarConsolidacionCommand()
                        .id(request.id())
                        .ifcAgente(request.ifcAgente())
                        .nitAgente(request.nitAgente())
                        .razonSocialAgente(request.razonSocialAgente())
                        .administracion(request.administracion())
                        .gestion(request.gestion())
                        .periodo(request.periodo())
                        .usuarioConsolidador(request.usuarioConsolidador())
                        .loginUsuarioConsolidador(request.loginUsuarioConsolidador())
                        .nombreConsolidador(request.nombreConsolidador())
                        .usuarioRegistro(usuarioId())
                        .build()
        );
		ResultadoGenericoDto<String> resultadoGenericoDto = new ResultadoGenericoDto<>(request.id());
		resultadoGenericoDto.setOk(Boolean.TRUE);
		resultadoGenericoDto.getMensajes().add(mensajesDomain.getMensaje(EnumSubsistema.RECAUDACIONES,EnumFacFrvccMensajesShared.REGISTRO_CORRECTO_CONSOLIDACION));
		return ResponseEntity.ok(resultadoGenericoDto);   
    }

    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
    	 return new HashMap<>(){{
             put(ConsolidacionListaErrores.class,HttpStatus.OK);
         }};
    }
    static final class Request {
        private  String id;
        private  Long ifcAgente;
        private  Long nitAgente;
        private  String razonSocialAgente;
        private  Long administracion;
        private  Integer gestion;
        private  Integer periodo;
        private  Long usuarioConsolidador;
        private  String loginUsuarioConsolidador;
        private  String nombreConsolidador;


        public Request() {
        }

        public String id() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Long ifcAgente() {
            return ifcAgente;
        }

        public void setIfcAgente(Long ifcAgente) {
            this.ifcAgente = ifcAgente;
        }

        public Long nitAgente() {
            return nitAgente;
        }

        public void setNitAgente(Long nitAgente) {
            this.nitAgente = nitAgente;
        }

        public String razonSocialAgente() {
            return razonSocialAgente;
        }

        public void setRazonSocialAgente(String razonSocialAgente) {
            this.razonSocialAgente = razonSocialAgente;
        }

        public Long administracion() {
            return administracion;
        }

        public void setAdministracion(Long administracion) {
            this.administracion = administracion;
        }

        public Integer gestion() {
            return gestion;
        }

        public void setGestion(Integer gestion) {
            this.gestion = gestion;
        }

        public Integer periodo() {
            return periodo;
        }

        public void setPeriodo(Integer periodo) {
            this.periodo = periodo;
        }

        public Long usuarioConsolidador() {
            return usuarioConsolidador;
        }

        public void setUsuarioConsolidador(Long usuarioConsolidador) {
            this.usuarioConsolidador = usuarioConsolidador;
        }

        public String loginUsuarioConsolidador() {
            return loginUsuarioConsolidador;
        }

        public void setLoginUsuarioConsolidador(String loginUsuarioConsolidador) {
            this.loginUsuarioConsolidador = loginUsuarioConsolidador;
        }

        public String nombreConsolidador() {
            return nombreConsolidador;
        }

        public void setNombreConsolidador(String nombreConsolidador) {
            this.nombreConsolidador = nombreConsolidador;
        }

    }

}
