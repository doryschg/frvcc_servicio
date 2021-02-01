package bo.gob.sin.sre.fac.frvcc.misfacturas.rest.backend.controller.compras_notas;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras_notas.modificar.ModificarCompraNotaCommand;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaListaErrores;
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
public final class CompraNotaModificarPutController extends ApiController {
	@Autowired
	private IMensajeAplicacionDomain mensajesDomain;

    public CompraNotaModificarPutController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @PutMapping(value = "/compraNota/{id}")
    public ResponseEntity<ResultadoGenericoDto<String>> index(@PathVariable String id,
                                        @RequestBody Request request) throws CommandNotRegisteredError, CommandHandlerExecutionError {

        dispatch(ModificarCompraNotaCommand.newModificarCompraNotaCommand()
                .id(id)
                .fechaNota(request.getFechaNota())
                .nitProveedor(request.getNitProveedor())
                .numeroNota(request.getNumeroNota())
                .codigoAutorizacion(request.getCodigoAutorizacion())
                .importeTotalNota(request.getImporteTotalNota())
                .codigoControlNota(request.getCodigoControlNota())
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
		private String origenId;

		public Request() {
		}

		public String getId() {
			return id;
		}

		public Long getNitProveedor() {
			return nitProveedor;
		}

		public Long getNumeroNota() {
			return numeroNota;
		}

		public String getCodigoAutorizacion() {
			return codigoAutorizacion;
		}

		public LocalDate getFechaNota() {
			return fechaNota;
		}

		public BigDecimal getImporteTotalNota() {
			return importeTotalNota;
		}

		public String getCodigoControlNota() {
			return codigoControlNota;
		}

		public String getOrigenId() {
			return origenId;
		}

	}


}


