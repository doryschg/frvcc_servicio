package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.rest.backend.controller.ventas;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
public class VentaModificarPutController extends ApiController {
	@Autowired
	private IMensajeAplicacionDomain mensajesDomain;

	public VentaModificarPutController(QueryBus queryBus, CommandBus commandBus) {
		super(queryBus, commandBus);
	}

	@PutMapping(value = "/venta/{id}")
	public ResponseEntity<ResultadoGenericoDto<String>> registrarCompras(@RequestBody Request request)
			throws CommandNotRegisteredError, CommandHandlerExecutionError {
		dispatch(ModificarVentaCommand.newModificarVentaCommand().id(request.venta.getId())
				.fechaFactura(LocalDate.parse(request.venta.getFchFactura(), DateTimeFormatter.ofPattern("dd/MM/yyyy")))
				.nitProveedor(request.venta.getNitCliente()).numeroFactura(request.venta.getNroFactura())
				.codigoAutorizacion(request.venta.getCodAutorCuf()).codigoControl(request.venta.getCodControl())
				.usuarioUltimaModificacion(usuarioId()).nombreCliente(request.venta.getRazonSocial())
				.numeroDocumentoCliente(request.getVenta().getNitCliente().toString())
				.importeTotalVenta(request.venta.getImprtTotal()).importeIceIehdTasas(request.venta.getImprtTasas())
				.importeTasaCero(request.venta.getVntasTsaCero()).subTotal(request.venta.getSubTotal())
				.descuento(request.venta.getDescuento()).debitoFiscal(request.venta.getDbitoFiscal())
				.importeExento(request.venta.getImprtExntas()).importeBase(request.venta.getImprtBaseDf())
				.importeNoSujetoDf(request.venta.getDbitoFiscal()).nitProveedor(request.getNitProveedor())
				.ifcProveedor(request.getIfcProveedor()).origenId(request.getOrigen()).build());

		ResultadoGenericoDto<String> resultadoGenericoDto = new ResultadoGenericoDto<>(request.venta.getId());
		resultadoGenericoDto.setOk(Boolean.TRUE);
		resultadoGenericoDto.getMensajes().add(mensajesDomain.getMensaje(EnumSubsistema.RECAUDACIONES,
				EnumFacFrvccMensajesShared.REGISTRO_CORRECTO_FACTURAS_COMPRAS));
		return ResponseEntity.ok(resultadoGenericoDto);
	}

	static final class Request {
		private Long nitProveedor;
		private Long ifcProveedor;
		private String origen;
		private Venta venta;

		static final class Venta {
			private String id;
			private String fchFactura;
			private Long nroFactura;
			private Long nitCliente;
			private String razonSocial;
			private BigDecimal imprtTotal;
			private BigDecimal imprtTasas;
			private BigDecimal imprtExntas;
			private BigDecimal vntasTsaCero;
			private BigDecimal subTotal;
			private BigDecimal descuento;
			private BigDecimal imprtBaseDf;
			private BigDecimal dbitoFiscal;

			private String codAutorCuf;
			private String codControl;
			private String estado;

			public String getId() {
				return id;
			}

			public void setId(String id) {
				this.id = id;
			}

			public String getFchFactura() {
				return fchFactura;
			}

			public void setFchFactura(String fchFactura) {
				this.fchFactura = fchFactura;
			}

			public Long getNroFactura() {
				return nroFactura;
			}

			public void setNroFactura(Long nroFactura) {
				this.nroFactura = nroFactura;
			}

			public Long getNitCliente() {
				return nitCliente;
			}

			public void setNitCliente(Long nitCliente) {
				this.nitCliente = nitCliente;
			}

			public String getRazonSocial() {
				return razonSocial;
			}

			public void setRazonSocial(String razonSocial) {
				this.razonSocial = razonSocial;
			}

			public BigDecimal getImprtTotal() {
				return imprtTotal;
			}

			public void setImprtTotal(BigDecimal imprtTotal) {
				this.imprtTotal = imprtTotal;
			}

			public BigDecimal getImprtTasas() {
				return imprtTasas;
			}

			public void setImprtTasas(BigDecimal imprtTasas) {
				this.imprtTasas = imprtTasas;
			}

			public BigDecimal getImprtExntas() {
				return imprtExntas;
			}

			public void setImprtExntas(BigDecimal imprtExntas) {
				this.imprtExntas = imprtExntas;
			}

			public BigDecimal getVntasTsaCero() {
				return vntasTsaCero;
			}

			public void setVntasTsaCero(BigDecimal vntasTsaCero) {
				this.vntasTsaCero = vntasTsaCero;
			}

			public BigDecimal getSubTotal() {
				return subTotal;
			}

			public void setSubTotal(BigDecimal subTotal) {
				this.subTotal = subTotal;
			}

			public BigDecimal getDescuento() {
				return descuento;
			}

			public void setDescuento(BigDecimal descuento) {
				this.descuento = descuento;
			}

			public BigDecimal getImprtBaseDf() {
				return imprtBaseDf;
			}

			public void setImprtBaseDf(BigDecimal imprtBaseDf) {
				this.imprtBaseDf = imprtBaseDf;
			}

			public BigDecimal getDbitoFiscal() {
				return dbitoFiscal;
			}

			public void setDbitoFiscal(BigDecimal dbitoFiscal) {
				this.dbitoFiscal = dbitoFiscal;
			}

			public String getCodAutorCuf() {
				return codAutorCuf;
			}

			public void setCodAutorCuf(String codAutorCuf) {
				this.codAutorCuf = codAutorCuf;
			}

			public String getCodControl() {
				return codControl;
			}

			public void setCodControl(String codControl) {
				this.codControl = codControl;
			}

			public String getEstado() {
				return estado;
			}

			public void setEstado(String estado) {
				this.estado = estado;
			}

		}

		public Request() {
		}

		public Long getNitProveedor() {
			return nitProveedor;
		}

		public void setNitProveedor(Long nitProveedor) {
			this.nitProveedor = nitProveedor;
		}

		public Long getIfcProveedor() {
			return ifcProveedor;
		}

		public void setIfcProveedor(Long ifcProveedor) {
			this.ifcProveedor = ifcProveedor;
		}

		public String getOrigen() {
			return origen;
		}

		public void setOrigen(String origen) {
			this.origen = origen;
		}

		public Venta getVenta() {
			return venta;
		}

		public void setVenta(Venta venta) {
			this.venta = venta;
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
