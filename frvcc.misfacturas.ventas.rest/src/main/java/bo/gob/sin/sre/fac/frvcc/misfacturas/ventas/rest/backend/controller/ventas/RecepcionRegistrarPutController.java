package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.rest.backend.controller.ventas;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.primary.recepcion.registro.RegistrarRecepcionCommand;
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
@RequestMapping("/rest/misfacturas/")
public class RecepcionRegistrarPutController extends ApiController {
	@Autowired
	private IMensajeAplicacionDomain mensajesDomain;

	public RecepcionRegistrarPutController(QueryBus queryBus, CommandBus commandBus) {
		super(queryBus, commandBus);
	}

	@PutMapping(value = "/recepcion/{id}")
	public ResponseEntity<ResultadoGenericoDto<String>> index(@PathVariable String id, @RequestBody Request request)
			throws CommandHandlerExecutionError, CommandNotRegisteredError, CommandNotRegisteredError,
			CommandHandlerExecutionError {

		dispatch(new RegistrarRecepcionCommand(id, request.tipoRecepcionId(), request.tipoDocumentoId(),
				request.ifcProveedor(), request.nitProveedor(), usuarioId()));
		ResultadoGenericoDto<String> resultadoGenericoDto = new ResultadoGenericoDto<>(id);
		resultadoGenericoDto.setOk(Boolean.TRUE);

		resultadoGenericoDto.getMensajes().add(mensajesDomain.getMensaje(EnumSubsistema.RECAUDACIONES,
				EnumFacFrvccMensajesShared.REGISTRO_CORRECTO_FACTURAS_COMPRAS));

		return ResponseEntity.ok(resultadoGenericoDto);
	}

	static final class Request {
		private String tipoRecepcionId;
		private String tipoDocumentoId;
		private Long ifcProveedor;
		private Long nitProveedor;
		private Long usuarioRegistro;

		public Request() {
		}

		public String tipoRecepcionId() {
			return tipoRecepcionId;
		}

		public String tipoDocumentoId() {
			return tipoDocumentoId;
		}

		public Long ifcProveedor() {
			return ifcProveedor;
		}

		public Long nitProveedor() {
			return nitProveedor;
		}

		public Long usuarioRegistro() {
			return usuarioRegistro;
		}

		public void setTipoRecepcionId(String tipoRecepcionId) {
			this.tipoRecepcionId = tipoRecepcionId;
		}

		public void setTipoDocumentoId(String tipoDocumentoId) {
			this.tipoDocumentoId = tipoDocumentoId;
		}

		public void setIfcProveedor(Long ifcProveedor) {
			this.ifcProveedor = ifcProveedor;
		}

		public void setNitProveedor(Long nitProveedor) {
			this.nitProveedor = nitProveedor;
		}

		public void setUsuarioRegistro(Long usuarioRegistro) {
			this.usuarioRegistro = usuarioRegistro;
		}
	}

	@Override
	public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
		// TODO Auto-generated method stub
		return null;
	}
}
