package bo.gob.sin.sre.fac.frvcc.misfacturas.rest.backend.controller.sucursal_usuario;


import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios.registro.RegistroFormularioCommand;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.sucursal_usuario.registro.RegistroSucursalUsuarioCommand;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.DatosEspecificos;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioListaErrores;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.EnumFacFrvccMensajesShared;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.ResultadoGenericoDto;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.spring.ApiController;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ValidatorNotExist;
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

import java.time.LocalDate;
import java.util.HashMap;

@RestController
@RequestMapping("/rest/misfacturas")
public final class SucursalUsuarioRegistroPostContoller extends ApiController {

	@Autowired
	private IMensajeAplicacionDomain mensajesDomain;
    public SucursalUsuarioRegistroPostContoller(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @PostMapping(value = "/sucursalUsuario")
    public ResponseEntity<ResultadoGenericoDto<String>> index(@RequestBody Request request) throws CommandNotRegisteredError, CommandHandlerExecutionError, ValidatorNotExist {

        dispatch(
                RegistroSucursalUsuarioCommand.newRegistrosucursalUsuarioCommand()
                        .id(request.id())
                        .ifcAgente(request.ifcAgente())
                        .nitAgente(request.nitAgente())
                        .nroSucursal(request.nroSucursal())
                        .usuarioReceptor(request.usuarioReceptor())
                        .loginUsuarioReceptor(request.loginUsuarioReceptor())
                        .nombreUsuarioReceptor(request.nombreUsuarioReceptor())
                        .usuarioRegistro(usuarioId()).build()
        );
		ResultadoGenericoDto<String> resultadoGenericoDto = new ResultadoGenericoDto<>(request.id());
		resultadoGenericoDto.setOk(Boolean.TRUE);
		resultadoGenericoDto.getMensajes().add(mensajesDomain.getMensaje(EnumSubsistema.RECAUDACIONES,EnumFacFrvccMensajesShared.REGISTRO_CORRECTO_SUCURSAL_USUARIO));
		return ResponseEntity.ok(resultadoGenericoDto);   
    }

    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
    	 return new HashMap<>(){{
             put(FormularioListaErrores.class,HttpStatus.OK);
         }};
    }
    static final class Request {
        private String id;
        private  Long ifcAgente;
        private  Long nitAgente;
        private  Integer nroSucursal;
        private  Long usuarioReceptor;
        private  String loginUsuarioReceptor;
        private  String nombreUsuarioReceptor;

        public Request() {
        }

        public Request(String id,Long ifcAgente, Long nitAgente, Integer nroSucursal, Long usuarioReceptor, String loginUsuarioReceptor, String nombreUsuarioReceptor, Long usuarioRegistro) {
            this.id=id;
            this.ifcAgente = ifcAgente;
            this.nitAgente = nitAgente;
            this.nroSucursal = nroSucursal;
            this.usuarioReceptor = usuarioReceptor;
            this.loginUsuarioReceptor = loginUsuarioReceptor;
            this.nombreUsuarioReceptor = nombreUsuarioReceptor;
        }
        public String id()
        {
            return id;
        }
        public void setId(String id)
        {
            this.id=id;
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

        public Integer nroSucursal() {
            return nroSucursal;
        }

        public void setNroSucursal(Integer nroSucursal) {
            this.nroSucursal = nroSucursal;
        }

        public Long usuarioReceptor() {
            return usuarioReceptor;
        }

        public void setUsuarioReceptor(Long usuarioReceptor) {
            this.usuarioReceptor = usuarioReceptor;
        }

        public String loginUsuarioReceptor() {
            return loginUsuarioReceptor;
        }

        public void setLoginUsuarioReceptor(String loginUsuarioReceptor) {
            this.loginUsuarioReceptor = loginUsuarioReceptor;
        }

        public String nombreUsuarioReceptor() {
            return nombreUsuarioReceptor;
        }

        public void setNombreUsuarioReceptor(String nombreUsuarioReceptor) {
            this.nombreUsuarioReceptor = nombreUsuarioReceptor;
        }


    }

}
