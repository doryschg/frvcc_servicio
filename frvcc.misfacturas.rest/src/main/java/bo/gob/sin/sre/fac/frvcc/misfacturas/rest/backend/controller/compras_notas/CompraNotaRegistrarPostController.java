package bo.gob.sin.sre.fac.frvcc.misfacturas.rest.backend.controller.compras_notas;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras_notas.registro.RegistroCompraNotaCommand;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaListaErrores;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.EnumFacFrvccMensajesShared;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.ResultadoGenericoDto;

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
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.spring.ApiController;

@RestController
@RequestMapping("/rest/misfacturas")
public class CompraNotaRegistrarPostController extends ApiController {
	
	@Autowired
	private IMensajeAplicacionDomain mensajesDomain;
	
        public CompraNotaRegistrarPostController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @PostMapping(value = "/compraNota")
    public ResponseEntity<ResultadoGenericoDto<String>> registrarCompraNota(@RequestBody Request request) throws CommandNotRegisteredError, CommandHandlerExecutionError { 
        dispatch(
                RegistroCompraNotaCommand.newRegistroCompraNotaCommand()
                          .id(request.getId())
                          .nitProveedor(request.getNitProveedor())
                          .numeroNota(request.getNumeroNota())
                          .codigoAutorizacion(request.getCodigoAutorizacion())
                          .fechaNota(request.getFechaNota())
                          .importeTotalNota(request.getImporteTotalNota())
                          .codigoControlNota(request.getCodigoControlNota())
                          .compraId(request.getCompraId())
                          .tipoDocumentoCliente(request.getTipoDocumentoCliente())
                          .numeroDocumentoCliente(request.getNumeroDocumentoCliente())
                          .complementoDocumentoCliente(request.getComplementoDocumentoCliente())
                          .nombreCliente(request.getNombreCliente())
                          .origenId(request.getOrigenId())
                          .usuarioRegistro(usuarioId())
                          .build()
          );
		ResultadoGenericoDto resultadoGenericoDto = new ResultadoGenericoDto(request.getId());
		resultadoGenericoDto.setOk(Boolean.TRUE);
		resultadoGenericoDto.getMensajes().add(mensajesDomain.getMensaje(EnumSubsistema.RECAUDACIONES,EnumFacFrvccMensajesShared.REGISTRO_CORRECTO_FACTURAS_COMPRAS));
		return ResponseEntity.ok(resultadoGenericoDto);   
    }
    
    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return new HashMap<>(){{
            put(CompraNotaListaErrores.class,HttpStatus.OK);
        }};
    }

	static final class Request {

		private String id;
		private Long nitProveedor;
		private Long numeroNota;
		private String codigoAutorizacion;
		private LocalDate fechaNota;
		private BigDecimal importeTotalNota;
		private String codigoControlNota;
		private String compraId;
		private String tipoDocumentoCliente;
		private String numeroDocumentoCliente;
		private String complementoDocumentoCliente;
		private String nombreCliente;
		private String origenId;

		public Request() {
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public Long getNitProveedor() {
			return nitProveedor;
		}

		public void setNitProveedor(Long nitProveedor) {
			this.nitProveedor = nitProveedor;
		}

		public Long getNumeroNota() {
			return numeroNota;
		}

		public void setNumeroNota(Long numeroNota) {
			this.numeroNota = numeroNota;
		}

		public String getCodigoAutorizacion() {
			return codigoAutorizacion;
		}

		public void setCodigoAutorizacion(String codigoAutorizacion) {
			this.codigoAutorizacion = codigoAutorizacion;
		}

		public LocalDate getFechaNota() {
			return fechaNota;
		}

		public void setFechaNota(LocalDate fechaNota) {
			this.fechaNota = fechaNota;
		}

		public BigDecimal getImporteTotalNota() {
			return importeTotalNota;
		}

		public void setImporteTotalNota(BigDecimal importeTotalNota) {
			this.importeTotalNota = importeTotalNota;
		}

		public String getCodigoControlNota() {
			return codigoControlNota;
		}

		public void setCodigoControlNota(String codigoControlNota) {
			this.codigoControlNota = codigoControlNota;
		}

		public String getCompraId() {
			return compraId;
		}

		public void setCompraId(String compraId) {
			this.compraId = compraId;
		}

		public String getTipoDocumentoCliente() {
			return tipoDocumentoCliente;
		}

		public void setTipoDocumentoCliente(String tipoDocumentoCliente) {
			this.tipoDocumentoCliente = tipoDocumentoCliente;
		}

		public String getNumeroDocumentoCliente() {
			return numeroDocumentoCliente;
		}

		public void setNumeroDocumentoCliente(String numeroDocumentoCliente) {
			this.numeroDocumentoCliente = numeroDocumentoCliente;
		}

		public String getComplementoDocumentoCliente() {
			return complementoDocumentoCliente;
		}

		public void setComplementoDocumentoCliente(String complementoDocumentoCliente) {
			this.complementoDocumentoCliente = complementoDocumentoCliente;
		}

		public String getNombreCliente() {
			return nombreCliente;
		}

		public void setNombreCliente(String nombreCliente) {
			this.nombreCliente = nombreCliente;
		}

		public String getOrigenId() {
			return origenId;
		}

		public void setOrigenId(String origenId) {
			this.origenId = origenId;
		}

	}



}