package bo.gob.sin.sre.fac.frvcc.misfacturas.rest.backend.controller.compras;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;


import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.registro.RegistroCompraCommand;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraListaErrores;
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
public class CompraRegistrarPostController extends ApiController {
	
	@Autowired
	private IMensajeAplicacionDomain mensajesDomain;
	
        public CompraRegistrarPostController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @PostMapping(value = "/compra")
    public ResponseEntity<ResultadoGenericoDto<String>> registrarCompras(@RequestBody Request request) throws CommandNotRegisteredError, CommandHandlerExecutionError {


   Long startTime = System.nanoTime() ;

        System.out.println("Compra Guardada: " + startTime/1000000 +" Timpo de Ejecucion Guardado");

        dispatch(
              RegistroCompraCommand.newRegistroCompraCommand()
                        .id(request.getId())
                        .fechaFactura(request.getFechaFactura())
                        .nitProveedor(request.getNitProveedor())
                        .numeroFactura(request.getNumeroFactura())
                        .codigoAutorizacion(request.getCodigoAutorizacion())
                        .importeBaseCf(request.getImporteBaseCf())
                        .codigoControl(request.getCodigoControl())
                        .usuarioRegistro(usuarioId())
                        .nombreCliente(request.getNombreCliente())
                        .tipoDocumentoCliente(request.getTipoDocumentoCliente())
                        .numeroDocumentoCliente(request.getNumeroDocumentoCliente())
                        .complementoDocumentoCliente(request.getCompraComplementoDocumentoCliente())
                        .origenId(request.getOrigenId())
                        .importeTotalCompra(request.getImporteTotalCompra())
                        .build()
        );
		ResultadoGenericoDto<String> resultadoGenericoDto = new ResultadoGenericoDto<>(request.getId());
		resultadoGenericoDto.setOk(Boolean.TRUE);
		resultadoGenericoDto.getMensajes().add(mensajesDomain.getMensaje(EnumSubsistema.RECAUDACIONES,EnumFacFrvccMensajesShared.REGISTRO_CORRECTO_FACTURAS_COMPRAS));


        long elapsedTime = System.nanoTime() - startTime;
        System.out.println("Compra Guardada: " + elapsedTime/1000000 +" Timpo de Ejecucion Guardado");
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
        private LocalDate fechaFactura;
        private Long nitProveedor;
        private Long numeroFactura;
        private String codigoAutorizacion;
        private BigDecimal importeBaseCf;
        private String codigoControl;
        private String nombreCliente;
        private String tipoDocumentoCliente;
        private String numeroDocumentoCliente;
        private String compraComplementoDocumentoCliente;
        private String origenId;
        private BigDecimal importeTotalCompra;


        public void setOrigenId(String origenId) {
            this.origenId = origenId;
        }


        public void setNitProveedor(Long nitProveedor) {
            this.nitProveedor = nitProveedor;
        }

        public void setNombreCliente(String nombreCliente) {
            this.nombreCliente = nombreCliente;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setTipoDocumentoCliente(String tipoDocumentoCliente) {
            this.tipoDocumentoCliente = tipoDocumentoCliente;
        }

        public void setNumeroDocumentoCliente(String numeroDocumentoCliente) {
            this.numeroDocumentoCliente = numeroDocumentoCliente;
        }

        public void setCompraComplementoDocumentoCliente(String compraComplementoDocumentoCliente) {
            this.compraComplementoDocumentoCliente = compraComplementoDocumentoCliente;
        }

		public void setImporteTotalCompra(BigDecimal importeTotalCompra) {
			this.importeTotalCompra = importeTotalCompra;
		}


		public Request() {
        }

        public void setFechaFactura(LocalDate fechaFactura) {
            this.fechaFactura = fechaFactura;
        }


        public void setNumeroFactura(Long numeroFactura) {
            this.numeroFactura = numeroFactura;
        }

        public void setCodigoAutorizacion(String codigoAutorizacion) {
            this.codigoAutorizacion = codigoAutorizacion;
        }

        public void setImporteBaseCf(BigDecimal importeBaseCf) {
            this.importeBaseCf = importeBaseCf;
        }

        public void setCodigoControl(String codigoControl) {
            this.codigoControl = codigoControl;
        }

		public String getId() {
            return id;
        }

        public LocalDate getFechaFactura() {
            return fechaFactura;
        }

        public Long getNitProveedor() {
            return nitProveedor;
        }

        public Long getNumeroFactura() {
            return numeroFactura;
        }

        public String getCodigoAutorizacion() {
            return codigoAutorizacion;
        }

        public BigDecimal getImporteBaseCf() {
            return importeBaseCf;
        }

        public String getCodigoControl() {
            return codigoControl;
        }

        public String getNombreCliente() {
            return nombreCliente;
        }

        public String getTipoDocumentoCliente() {
            return tipoDocumentoCliente;
        }

        public String getNumeroDocumentoCliente() {
            return numeroDocumentoCliente;
        }

        public String getCompraComplementoDocumentoCliente() {
            return compraComplementoDocumentoCliente;
        }

        public String getOrigenId() {
            return origenId;
        }
       
		public BigDecimal getImporteTotalCompra() {
			return importeTotalCompra;
		}


    }



}
