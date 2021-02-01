package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.rest.backend.controller.ventas;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.primary.ventas.anular.AnularVentaCommand;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.primary.ventas.modificar.ModificarVentaCommand;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaListaErrores;
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
@RequestMapping("/rest/misfacturas")
public class VentaAnularPutController extends ApiController {
	@Autowired
	private IMensajeAplicacionDomain mensajesDomain;

	public VentaAnularPutController(QueryBus queryBus, CommandBus commandBus) {
		super(queryBus, commandBus);
	}

	@PutMapping(value = "/venta/anular/{id}")
	public ResponseEntity<ResultadoGenericoDto<String>> registrarCompras(@PathVariable String id)
			throws CommandNotRegisteredError, CommandHandlerExecutionError {
		dispatch(new AnularVentaCommand(id, usuarioId()));
		ResultadoGenericoDto<String> resultadoGenericoDto = new ResultadoGenericoDto<>(id);
		resultadoGenericoDto.setOk(Boolean.TRUE);
		resultadoGenericoDto.getMensajes().add(mensajesDomain.getMensaje(EnumSubsistema.RECAUDACIONES,
				EnumFacFrvccMensajesShared.REGISTRO_CORRECTO_FACTURAS_COMPRAS));
		return ResponseEntity.ok(resultadoGenericoDto);
	}

	static final class Request {

		private String id;

		public Request() {
		}

		public String getId() {
			return id;
		}

	}

	@Override
	public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
		return new HashMap<>() {
			{
				put(VentaListaErrores.class, HttpStatus.OK);
			}
		};
	}

}
