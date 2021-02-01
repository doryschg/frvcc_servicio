package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.rest.backend.controller.libros;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.adapters.primary.libros.habilita_rectificatorio.HabilitarRectificatorioLibroCommand;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroListaErrores;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioListaErrores;
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
public class LibroHabilitarRectificatorioPutController extends ApiController {
	@Autowired
	private IMensajeAplicacionDomain mensajesDomain;
    public LibroHabilitarRectificatorioPutController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @PutMapping(value = "/libro/habilitarectificatorio/{id}")
    public ResponseEntity<ResultadoGenericoDto<String>> index(@PathVariable String id) throws CommandNotRegisteredError, CommandHandlerExecutionError {
        dispatch(new HabilitarRectificatorioLibroCommand(id,usuarioId()));

        ResultadoGenericoDto<String> resultadoGenericoDto = new ResultadoGenericoDto<>(id);
 		resultadoGenericoDto.setOk(Boolean.TRUE);
 		resultadoGenericoDto.getMensajes().add(mensajesDomain.getMensaje(EnumSubsistema.RECAUDACIONES,EnumFacFrvccMensajesShared.LIBRO_HABILITACION_RECTIFICACION_CORRECTO));
 		return ResponseEntity.ok(resultadoGenericoDto);
    }

    @SuppressWarnings("serial")
	@Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
    	 return new HashMap<>(){{
             put(LibroListaErrores.class,HttpStatus.OK);
         }};
    }

    static final class Request {
        private Integer codAdmin;

        public Request(Integer codAdmin) {
            this.codAdmin = codAdmin;
        }

        public Request() {
        }

        public Integer codAdmin() {
            return codAdmin;
        }

        public void setCodAdmin(Integer codAdmin) {
            this.codAdmin = codAdmin;
        }
    }

    }
