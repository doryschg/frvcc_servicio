package bo.gob.sin.sre.fac.frvcc.misfacturas.rest.backend.controller.compras;



import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.modificar.ModificarCompraCommand;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraListaErrores;
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

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;


@RestController
@RequestMapping("/rest/misfacturas")
public final class CompraModificarPutController extends ApiController {
	@Autowired
	private IMensajeAplicacionDomain mensajesDomain;
    public CompraModificarPutController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @PutMapping(value = "/compra/{id}")
    public ResponseEntity<ResultadoGenericoDto<String>> index(@PathVariable String id,
                                        @RequestBody Request request) throws CommandNotRegisteredError, CommandHandlerExecutionError {

        dispatch(ModificarCompraCommand.newModificarCompraCommand()
                .id(id)
                .fechaFactura(request.getFechaFactura())
                .nitProveedor(request.getNitProveedor())
                .numeroFactura(request.getNumeroFactura())
                .codigoAutorizacion(request.getCodigoAutorizacion())
                .importeTotalCompra(request.getImporteTotalCompra())
                .importeBaseCf(request.getImporteBaseCf())
                .codigoControl(request.getCodigoControl())
                .usuarioUltimaModificacion(usuarioId())
                .origenId(request.getOrigenId()).build());
        ResultadoGenericoDto<String> resultadoGenericoDto = new ResultadoGenericoDto<>(id);
 		resultadoGenericoDto.setOk(Boolean.TRUE);
 		resultadoGenericoDto.getMensajes().add(mensajesDomain.getMensaje(EnumSubsistema.RECAUDACIONES,EnumFacFrvccMensajesShared.EDITADO_CORRECTO));
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
        private BigDecimal importeTotalCompra;
        private BigDecimal importeBaseCf;
        private String codigoControl;
        private String origenId;



        public Request() {
        }

        public BigDecimal getImporteTotalCompra() {
            return importeTotalCompra;
        }

        public void setImporteTotalCompra(BigDecimal importeTotalCompra) {
            this.importeTotalCompra = importeTotalCompra;
        }

        public void setOrigenId(String origenId) {
            this.origenId = origenId;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public LocalDate getFechaFactura() {
            return fechaFactura;
        }

        public void setFechaFactura(LocalDate fechaFactura) {
            this.fechaFactura = fechaFactura;
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

        public String getCodigoAutorizacion() {
            return codigoAutorizacion;
        }

        public void setCodigoAutorizacion(String codigoAutorizacion) {
            this.codigoAutorizacion = codigoAutorizacion;
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

        public String getOrigenId() {
            return origenId;
        }



    }


}


