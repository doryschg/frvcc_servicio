package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.rest.backend.controller.ventas;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.primary.archivo.registro.RegistroArchivoCommand;
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
public class ArchivoRegistrarPutController extends ApiController {
	@Autowired
	private IMensajeAplicacionDomain mensajesDomain;

	public ArchivoRegistrarPutController(QueryBus queryBus, CommandBus commandBus) {
		super(queryBus, commandBus);
	}

	@PutMapping(value = "/venta/archivo/{id}")
	public ResponseEntity<ResultadoGenericoDto<String>> registrarArchivo(@PathVariable String id,
			@RequestParam("tipoRecepcionId") String tipoRecepcionId, @RequestParam("idPadre") String idPadre,
			@RequestParam("archivo") MultipartFile archivo)
			throws IOException, CommandNotRegisteredError, CommandHandlerExecutionError {

		dispatch(RegistroArchivoCommand.newRegistroArchivoCommand().id(id).idPadre(idPadre)
				.tipoRecepcionId(tipoRecepcionId).archivoByte(archivo.getBytes()).usuarioRegistro(usuarioId()).build());

		ResultadoGenericoDto<String> resultadoGenericoDto = new ResultadoGenericoDto<>(id);
		resultadoGenericoDto.setOk(Boolean.TRUE);
		resultadoGenericoDto.getMensajes().add(mensajesDomain.getMensaje(EnumSubsistema.RECAUDACIONES,
				EnumFacFrvccMensajesShared.REGISTRO_CORRECTO_FACTURAS_COMPRAS));
		return ResponseEntity.ok(resultadoGenericoDto);
	}

	@Override
	public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
		// TODO Auto-generated method stub
		return null;
	}

	final class Request {
		private String id;
		private String tipoRecepcionId;
		private String origenId;
		private String idPadre;
		private byte[] archivoByte;
		private Long usuarioRegistro;
		private Long usuarioUltimaModificacion;
		private LocalDateTime fechaRegistro;
		private LocalDateTime fechaUltimaModificacion;
		private String estadoId;

		private String tipoDocumentoId;
		private Long ifc;
		private Long nit;
		private String recepcionId;

		public String getId() {
			return id;
		}

		public String getTipoRecepcionId() {
			return tipoRecepcionId;
		}

		public String getOrigenId() {
			return origenId;
		}

		public String getIdPadre() {
			return idPadre;
		}

		public byte[] getArchivoByte() {
			return archivoByte;
		}

		public Long getUsuarioRegistro() {
			return usuarioRegistro;
		}

		public Long getUsuarioUltimaModificacion() {
			return usuarioUltimaModificacion;
		}

		public LocalDateTime getFechaRegistro() {
			return fechaRegistro;
		}

		public LocalDateTime getFechaUltimaModificacion() {
			return fechaUltimaModificacion;
		}

		public String getEstadoId() {
			return estadoId;
		}

		public void setId(String id) {
			this.id = id;
		}

		public void setTipoRecepcionId(String tipoRecepcionId) {
			this.tipoRecepcionId = tipoRecepcionId;
		}

		public void setOrigenId(String origenId) {
			this.origenId = origenId;
		}

		public void setIdPadre(String idPadre) {
			this.idPadre = idPadre;
		}

		public void setArchivoByte(byte[] archivoByte) {
			this.archivoByte = archivoByte;
		}

		public void setUsuarioRegistro(Long usuarioRegistro) {
			this.usuarioRegistro = usuarioRegistro;
		}

		public void setUsuarioUltimaModificacion(Long usuarioUltimaModificacion) {
			this.usuarioUltimaModificacion = usuarioUltimaModificacion;
		}

		public void setFechaRegistro(LocalDateTime fechaRegistro) {
			this.fechaRegistro = fechaRegistro;
		}

		public void setFechaUltimaModificacion(LocalDateTime fechaUltimaModificacion) {
			this.fechaUltimaModificacion = fechaUltimaModificacion;
		}

		public void setEstadoId(String estadoId) {
			this.estadoId = estadoId;
		}

		public String getRecepcionId() {
			return recepcionId;
		}

		public void setRecepcionId(String recepcionId) {
			this.recepcionId = recepcionId;
		}

		public String getTipoDocumentoId() {
			return tipoDocumentoId;
		}

		public void setTipoDocumentoId(String tipoDocumentoId) {
			this.tipoDocumentoId = tipoDocumentoId;
		}

		public Long getIfc() {
			return ifc;
		}

		public void setIfc(Long ifc) {
			this.ifc = ifc;
		}

		public Long getNit() {
			return nit;
		}

		public void setNit(Long nit) {
			this.nit = nit;
		}

	}
}
