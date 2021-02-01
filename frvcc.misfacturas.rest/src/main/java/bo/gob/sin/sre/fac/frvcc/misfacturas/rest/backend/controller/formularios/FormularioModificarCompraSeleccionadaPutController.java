package bo.gob.sin.sre.fac.frvcc.misfacturas.rest.backend.controller.formularios;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios.modifcar_compra_seleccionada.ModificarCompraSeleccionadaCommand;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios.seleccionar_compras.SeleccionarComprasformularioCommand;
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
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/rest/misfacturas")
public class FormularioModificarCompraSeleccionadaPutController extends ApiController {
	@Autowired
	private IMensajeAplicacionDomain mensajesDomain;

    public FormularioModificarCompraSeleccionadaPutController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @PutMapping(value = "/formulario/modificar_compra_selecionada/{id}")
    public ResponseEntity<ResultadoGenericoDto<String>> index(@PathVariable String id, @RequestBody Request request) throws CommandNotRegisteredError, CommandHandlerExecutionError {
         dispatch(new ModificarCompraSeleccionadaCommand(
                 id, request.fechaFactura,request.importeTotalCompra,request.codigoControl,usuarioId(),request.origenId
                 ));

        ResultadoGenericoDto<String> resultadoGenericoDto = new ResultadoGenericoDto<>(id);
		resultadoGenericoDto.setOk(Boolean.TRUE);
		resultadoGenericoDto.getMensajes().add(mensajesDomain.getMensaje(EnumSubsistema.RECAUDACIONES,EnumFacFrvccMensajesShared.ASOCIACION_COMPRAS_CORRECTO));
		return ResponseEntity.ok(resultadoGenericoDto);
    }
    
    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
    	return new HashMap<>(){{
            put(CompraListaErrores.class,HttpStatus.OK);
        }};
    }

    static final class Request {
        private LocalDate fechaFactura;
        private BigDecimal importeTotalCompra;
        private String codigoControl;
        private String origenId;

        public Request() {
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

        public String getCodigoControl() {
            return codigoControl;
        }

        public void setCodigoControl(String codigoControl) {
            this.codigoControl = codigoControl;
        }

        public String getOrigenId() {
            return origenId;
        }

        public void setOrigenId(String origenId) {
            this.origenId = origenId;
        }
    }

}




