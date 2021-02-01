package bo.gob.sin.sre.fac.frvcc.misfacturas.rest.backend.controller.formularios;


import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios.modificar.ModifcarFormularioCommand;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.DatosEspecificos;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioListaErrores;
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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;

@RestController
@RequestMapping("/rest/misfacturas")
public final class FormularioModificarPutContoller  extends ApiController {
	@Autowired
	private IMensajeAplicacionDomain mensajesDomain;
    public FormularioModificarPutContoller(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @PutMapping(value = "/formulario/modificar/{id}")
    public ResponseEntity<ResultadoGenericoDto<String>> index(@PathVariable String id, @RequestBody Request request) throws CommandNotRegisteredError, CommandHandlerExecutionError {
        dispatch(new ModifcarFormularioCommand(id,
                request.direccion(),
                request.direccionEmpleador(),
                usuarioId(),
                request.lugarDepartamento(),
                request.fechaPresentacion(),
                request.numeroSucursal(),
                request.datosEspecificos(),
                request.tipoUsoId()));
        ResultadoGenericoDto<String> resultadoGenericoDto = new ResultadoGenericoDto<>(id);
 		resultadoGenericoDto.setOk(Boolean.TRUE);
 		resultadoGenericoDto.getMensajes().add(mensajesDomain.getMensaje(EnumSubsistema.RECAUDACIONES,EnumFacFrvccMensajesShared.EDITADO_CORRECTO));
 		return ResponseEntity.ok(resultadoGenericoDto);
    }

    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
    	 return new HashMap<>(){{
             put(FormularioListaErrores.class,HttpStatus.OK);
         }};
    }

    static final class Request {
        private String direccion;
        private String direccionEmpleador;
        private Integer lugarDepartamento;
        private LocalDate fechaPresentacion;
        private Integer numeroSucursal;
        private DatosEspecificos datosEspecificos;
        private String tipoUsoId;

     

        public Request() {
        }

        public Request(String direccion, String direccionEmpleador,
                       Integer lugarDepartamento,
                       String nombreEmpleador,
                       LocalDate fechaPresentacion,
                       Integer numeroSucursal,
                       DatosEspecificos datosespecificos,
                       String tipoUsoId) {
            this.direccion = direccion;
            this.direccionEmpleador = direccionEmpleador;
            this.lugarDepartamento = lugarDepartamento;
            this.fechaPresentacion=fechaPresentacion;
            this.numeroSucursal=numeroSucursal;
            this.datosEspecificos=datosespecificos;
            this.tipoUsoId =tipoUsoId;
        }



        public void setDireccion(String direccion) {
            this.direccion = direccion;
        }


        public void setDireccionEmpleador(String direccionEmpleador) {
            this.direccionEmpleador = direccionEmpleador;
        }

        public void setLugarDepartamento(Integer lugarDepartamento) {
            this.lugarDepartamento = lugarDepartamento;
        }

        public void setFechaPresentacion(LocalDate fechaPresentacion) {
			this.fechaPresentacion = fechaPresentacion;
		}
        public void setNumeroSucursal(Integer numeroSucursal) {
            this.numeroSucursal = numeroSucursal;
        }
        public void setDatosEspecificos(DatosEspecificos datosEspecificos) {
			this.datosEspecificos = datosEspecificos;
		}

		public String direccion() {
            return direccion;
        }

        public String direccionEmpleador() {
            return direccionEmpleador;
        }


        public Integer lugarDepartamento() {
            return lugarDepartamento;
        }

        private LocalDate fechaPresentacion()
        {
        	return fechaPresentacion;
        }
        private Integer numeroSucursal()
        {
            return numeroSucursal;
        }
        private DatosEspecificos datosEspecificos()
        {
        	return datosEspecificos;
        }

        public String tipoUsoId() {
            return tipoUsoId;
        }

        public void setTipoUsoId(String tipoUsoId) {
            this.tipoUsoId = tipoUsoId;
        }
    }

}
