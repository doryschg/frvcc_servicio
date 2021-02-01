package bo.gob.sin.sre.fac.frvcc.misfacturas.rest.backend.controller.compras;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.registro_libro_compras.CompraRegistroLibroCommand;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraListaErrores;
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
import java.time.LocalDate;
import java.util.HashMap;

@RestController
@RequestMapping("/rest/misfacturas")
public class CompraLibroRegistrarPostController extends ApiController {

	@Autowired
	private IMensajeAplicacionDomain mensajesDomain;

        public CompraLibroRegistrarPostController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @PostMapping(value = "/compra_libro")
    public ResponseEntity<ResultadoGenericoDto<String>> registrarCompras(@RequestBody Request request) throws CommandNotRegisteredError, CommandHandlerExecutionError {
        dispatch(
                CompraRegistroLibroCommand.newCompraRegistroLibroCommand()
                        .id(request.getId())
                        .nitProveedor(request.getNitProveedor())
                        .numeroFactura(request.getNumeroFactura())
                        .numeroDui(request.getNumeroDui())
                        .codigoAutorizacion(request.getCodigoAutorizacion())
                        .fechaFactura(request.getFechaFactura())
                        .importeTotalCompra(request.getImporteTotalCompra())
                        .importeNoSujetoCf(request.getimporteNoSujetoCf())
                        .descuento(request.getDescuento())
                        .importeBaseCf(request.getImporteBaseCf())
                        .codigoControl(request.getCodigoControl())
                        .tipoDocumentoCliente(request.getTipoDocumentoCliente())
                        .numeroDocumentoCliente(request.getNumeroDocumentoCliente())
                        .complementoDocumentoCliente(request.getCompraComplementoDocumentoCliente())
                        .nombreCliente(request.getNombreCliente())
                        .origenId(request.getOrigenId())
                        .usuarioRegistro(usuarioId())
                        .build()
        );
		ResultadoGenericoDto<String> resultadoGenericoDto = new ResultadoGenericoDto<>(request.getId());
		resultadoGenericoDto.setOk(Boolean.TRUE);
		resultadoGenericoDto.getMensajes().add(mensajesDomain.getMensaje(EnumSubsistema.RECAUDACIONES,EnumFacFrvccMensajesShared.REGISTRO_CORRECTO_FACTURAS_COMPRAS));
		return ResponseEntity.ok(resultadoGenericoDto);   
    }

    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return new HashMap<>(){{
            put(CompraListaErrores.class,HttpStatus.OK);
        }};
    }

    static final class Request {
        private String id;
        private Long nitProveedor;
        private Long numeroFactura;
        private String numeroDui;
        private String codigoAutorizacion;
        private LocalDate fechaFactura;
        private BigDecimal importeTotalCompra;
        private BigDecimal importeNoSujetoCf;
        private BigDecimal descuento;
        private BigDecimal importeBaseCf;
        private String codigoControl;
        private String tipoDocumentoCliente;
        private String numeroDocumentoCliente;
        private String complementoDocumentoCliente;
        private String nombreCliente;
        private String origenId;
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
		public Long getNumeroFactura() {
			return numeroFactura;
		}
		public void setNumeroFactura(Long numeroFactura) {
			this.numeroFactura = numeroFactura;
		}
		public String getNumeroDui() {
			return numeroDui;
		}
		public void setNumeroDui(String numeroDui) {
			this.numeroDui = numeroDui;
		}
		public String getCodigoAutorizacion() {
			return codigoAutorizacion;
		}
		public void setCodigoAutorizacion(String codigoAutorizacion) {
			this.codigoAutorizacion = codigoAutorizacion;
		}
		public LocalDate getFechaFactura() {
			return fechaFactura;
		}
		public void setFechaFactura(LocalDate fechaFactura) {
			this.fechaFactura = fechaFactura;
		}
		public BigDecimal getImporteTotalCompra() {
			return importeTotalCompra;
		}
		public void setImporteTotalCompra(BigDecimal importeTotalCompra) {
			this.importeTotalCompra = importeTotalCompra;
		}
		public BigDecimal getimporteNoSujetoCf() {
			return importeNoSujetoCf;
		}
		public void setimporteNoSujetoCf(BigDecimal importeNoSujetoCf) {
			this.importeNoSujetoCf = importeNoSujetoCf;
		}
		public BigDecimal getDescuento() {
			return descuento;
		}
		public void setDescuento(BigDecimal descuento) {
			this.descuento = descuento;
		}
		public BigDecimal getImporteBaseCf() {
			return importeBaseCf;
		}
		public void setImporteBaseCf(BigDecimal importeBaseCf) {
			this.importeBaseCf = importeBaseCf;
		}
		public String getCodigoControl() {
			return codigoControl;
		}
		public void setCodigoControl(String codigoControl) {
			this.codigoControl = codigoControl;
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
		public String getCompraComplementoDocumentoCliente() {
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
