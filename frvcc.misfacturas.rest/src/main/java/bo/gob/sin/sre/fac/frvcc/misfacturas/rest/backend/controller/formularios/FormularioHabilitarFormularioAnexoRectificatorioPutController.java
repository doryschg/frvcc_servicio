package bo.gob.sin.sre.fac.frvcc.misfacturas.rest.backend.controller.formularios;

import java.util.HashMap;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios.habilitar_rectificatorio_fanexo.HabilitarRectificatorioFormularioCommand;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraListaErrores;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioListaErrores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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
public class FormularioHabilitarFormularioAnexoRectificatorioPutController extends ApiController {
	@Autowired
	private IMensajeAplicacionDomain mensajesDomain;
    public FormularioHabilitarFormularioAnexoRectificatorioPutController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
        // TODO Auto-generated constructor stub
    }

    @PutMapping(value = "/formulario/habilitaanexorectificatorio/{id}")
    public ResponseEntity<ResultadoGenericoDto<String>> index(@PathVariable String id,
                                        @RequestBody Request request) throws CommandNotRegisteredError, CommandHandlerExecutionError {
        dispatch(new HabilitarRectificatorioFormularioCommand(id,usuarioId()));

        ResultadoGenericoDto<String> resultadoGenericoDto = new ResultadoGenericoDto<>(id);
 		resultadoGenericoDto.setOk(Boolean.TRUE);
 		resultadoGenericoDto.getMensajes().add(mensajesDomain.getMensaje(EnumSubsistema.RECAUDACIONES,EnumFacFrvccMensajesShared.FORMULARIO_HABILITACION_RECTIFICACION_CORRECTO));
 		return ResponseEntity.ok(resultadoGenericoDto);
    }

    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
    	 return new HashMap<>(){{
             put(FormularioListaErrores.class,HttpStatus.OK);
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
