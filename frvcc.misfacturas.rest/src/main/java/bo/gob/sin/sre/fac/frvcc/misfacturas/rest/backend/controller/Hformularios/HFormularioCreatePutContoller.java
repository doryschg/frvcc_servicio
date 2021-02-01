package bo.gob.sin.sre.fac.frvcc.misfacturas.rest.backend.controller.Hformularios;



import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.hformularios.create.CreateHFormularioCommand;
import bo.gob.sin.sre.fac.frvcc.shared.model.DomainError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandNotRegisteredError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryBus;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.spring.ApiController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;

@RestController
@RequestMapping("/rest/misfacturas")
public final class HFormularioCreatePutContoller extends ApiController {


    public HFormularioCreatePutContoller(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @PutMapping(value = "/formulario/historico/{id}")
    public ResponseEntity<String> index(@PathVariable String id, @RequestBody Request request) throws CommandHandlerExecutionError, CommandNotRegisteredError, CommandNotRegisteredError, CommandHandlerExecutionError {





        dispatch(new CreateHFormularioCommand(id,request.idFormulario(),
        		request.estadoFormularioId(),request.numeroOrden(),
        		request.compras(),request.usuarioRegistro(),request.usuarioUltimaModificacion()
              ));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return null;
    }

    static final class Request {
    	private String idFormulario;
        private String estadoFormularioId;
        private LocalDate fechaDesde;
        private LocalDate fechaHasta;
        private Long numeroOrden;
        private String compras;
        private Long usuarioRegistro;
        private LocalDateTime fechaRegistro;
        private Long usuarioUltimaModificacion;
        private LocalDateTime fechaUltimaModificacion;
        private String estadoId;

 

		public Request() {
        }



		public Request(String idFormulario, String estadoFormularioId, LocalDate fechaDesde, LocalDate fechaHasta,
				Long numeroOrden, String compras, Long usuarioRegistro, LocalDateTime fechaRegistro,
				Long usuarioUltimaModificacion, LocalDateTime fechaUltimaModificacion, String estadoId) {
			super();
			this.idFormulario = idFormulario;
			this.estadoFormularioId = estadoFormularioId;
			this.fechaDesde = fechaDesde;
			this.fechaHasta = fechaHasta;
			this.numeroOrden = numeroOrden;
			this.compras = compras;
			this.usuarioRegistro = usuarioRegistro;
			this.fechaRegistro = fechaRegistro;
			this.usuarioUltimaModificacion = usuarioUltimaModificacion;
			this.fechaUltimaModificacion = fechaUltimaModificacion;
			this.estadoId = estadoId;
		}



		public String idFormulario() {
			return idFormulario;
		}



		public void setIdFormulario(String idFormulario) {
			this.idFormulario = idFormulario;
		}



		public String estadoFormularioId() {
			return estadoFormularioId;
		}



		public void setEstadoFormularioId(String estadoFormularioId) {
			this.estadoFormularioId = estadoFormularioId;
		}



		public LocalDate fechaDesde() {
			return fechaDesde;
		}



		public void fechaDesde(LocalDate fechaDesde) {
			this.fechaDesde = fechaDesde;
		}



		public LocalDate fechaHasta() {
			return fechaHasta;
		}



		public void setFechaHasta(LocalDate fechaHasta) {
			this.fechaHasta = fechaHasta;
		}



		public Long numeroOrden() {
			return numeroOrden;
		}



		public void setNumeroOrden(Long numeroOrden) {
			this.numeroOrden = numeroOrden;
		}



		public String compras() {
			return compras;
		}



		public void setCompras(String compras) {
			this.compras = compras;
		}



		public Long usuarioRegistro() {
			return usuarioRegistro;
		}



		public void setUsuarioRegistro(Long usuarioRegistro) {
			this.usuarioRegistro = usuarioRegistro;
		}



		public LocalDateTime fechaRegistro() {
			return fechaRegistro;
		}



		public void setFechaRegistro(LocalDateTime fechaRegistro) {
			this.fechaRegistro = fechaRegistro;
		}



		public Long usuarioUltimaModificacion() {
			return usuarioUltimaModificacion;
		}



		public void setUsuarioUltimaModificacion(Long usuarioUltimaModificacion) {
			this.usuarioUltimaModificacion = usuarioUltimaModificacion;
		}



		public LocalDateTime fechaUltimaModificacion() {
			return fechaUltimaModificacion;
		}



		public void setFechaUltimaModificacion(LocalDateTime fechaUltimaModificacion) {
			this.fechaUltimaModificacion = fechaUltimaModificacion;
		}



		public String estadoId() {
			return estadoId;
		}



		public void setEstadoId(String estadoId) {
			this.estadoId = estadoId;
		}
		
		
        

       
    }

}
