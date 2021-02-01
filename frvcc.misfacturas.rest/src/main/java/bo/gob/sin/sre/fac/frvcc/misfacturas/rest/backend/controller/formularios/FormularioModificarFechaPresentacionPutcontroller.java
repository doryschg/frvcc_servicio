package bo.gob.sin.sre.fac.frvcc.misfacturas.rest.backend.controller.formularios;

import java.time.LocalDate;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios.modificar_fecha_presentacion.ModificarFormularioFechaPresentacionCommand;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioListaErrores;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioNotExist;
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
public class FormularioModificarFechaPresentacionPutcontroller extends ApiController {

	@Autowired
	private IMensajeAplicacionDomain mensajesDomain;

    public FormularioModificarFechaPresentacionPutcontroller(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @PutMapping(value = "/formulario/modificarFechaPresentacion/{id}")
    public ResponseEntity<ResultadoGenericoDto<String>> index(@PathVariable String id, @RequestBody Request request) throws CommandNotRegisteredError, CommandHandlerExecutionError {
        dispatch(new ModificarFormularioFechaPresentacionCommand(id,
                request.fechaPresentacion(),usuarioId()));
        ResultadoGenericoDto<String> resultadoGenericoDto = new ResultadoGenericoDto<>(id);
 		resultadoGenericoDto.setOk(Boolean.TRUE);
 		resultadoGenericoDto.getMensajes().add(mensajesDomain.getMensaje(EnumSubsistema.RECAUDACIONES,EnumFacFrvccMensajesShared.CAMBIO_FECHA_PRESENTACION_CORRECTO));
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
        private LocalDate fechaPresentacion;


        public Request() {
        }

        public Request(String id, LocalDate fechaPresentacion) {
            this.id = id;
            this.fechaPresentacion = fechaPresentacion;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setFechaPresentacion(LocalDate fechaPresentacion) {
            this.fechaPresentacion = fechaPresentacion;
        }

        public String id() {
            return id;
        }

        private LocalDate fechaPresentacion() {
            return fechaPresentacion;
        }

    }

}
