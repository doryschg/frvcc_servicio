package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.rest.backend.controller.ventas;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.primary.ventas.registro.RegistroVentaCommand;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.primary.ventas.registro_masivo.RegistroVentasCommand;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaListaErrores;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.EnumFacFrvccMensajesShared;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.ResultadoGenericoDto;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.ResultadoGenericoListaDto;
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
public class VentasRegistrarPostController extends ApiController {
	@Autowired
	private IMensajeAplicacionDomain mensajesDomain;

	public VentasRegistrarPostController(QueryBus queryBus, CommandBus commandBus) {
		super(queryBus, commandBus);
	}

	@PostMapping(value = "/ventas")
	public ResponseEntity<ResultadoGenericoListaDto<ResultadoGenericoDto<String>>> registrarVentas(
			@RequestBody Request request) throws CommandNotRegisteredError, CommandHandlerExecutionError {
		List<RegistroVentaCommand> resultado = request.ventas.stream().map(venta -> {
			return getRegistroVentaCommand(venta, request.nitProveedor, request.ifcProveedor, request.origen);
		}).collect(Collectors.toList());
		dispatch(new RegistroVentasCommand(resultado));

		ResultadoGenericoListaDto<ResultadoGenericoDto<String>> vResultadoGenericoListaDto = new ResultadoGenericoListaDto();
		vResultadoGenericoListaDto.setOk(Boolean.TRUE);
		vResultadoGenericoListaDto.getMensajes().add(mensajesDomain.getMensaje(EnumSubsistema.RECAUDACIONES,
				EnumFacFrvccMensajesShared.REGISTRO_CORRECTO_FACTURAS_COMPRAS));
		return ResponseEntity.ok(vResultadoGenericoListaDto);
	}

	private RegistroVentaCommand getRegistroVentaCommand(Venta pVenta, Long pNitProvedor, Long pIfcProvedor,
			String pOrigen) {
		return RegistroVentaCommand.newRegistroVentaCommand().id(pVenta.getId())
				.fechaFactura(LocalDate.parse(pVenta.getFchFactura(), DateTimeFormatter.ofPattern("dd/MM/yyyy")))
				.nitProveedor(pVenta.getNitCliente()).numeroFactura(pVenta.getNroFactura())
				.codigoAutorizacion(pVenta.getCodAutorCuf()).codigoControl(pVenta.getCodControl())
				.usuarioRegistro(usuarioId()).nombreCliente(pVenta.getRazonSocial())
				.numeroDocumentoCliente(pVenta.getNitCliente().toString()).importeTotalVenta(pVenta.getImprtTotal())
				.importeIceIehdTasas(pVenta.getImprtTasas()).importeTasaCero(pVenta.getVntasTsaCero())
				.subTotal(pVenta.getSubTotal()).descuento(pVenta.getDescuento()).debitoFiscal(pVenta.getDbitoFiscal())
				.importeExento(pVenta.getImprtExntas()).importeBase(pVenta.getImprtBaseDf())
				.importeNoSujetoDf(pVenta.getDbitoFiscal()).nitProveedor(pNitProvedor).ifcProveedor(pIfcProvedor)
				.origenId(pOrigen).fila(pVenta.getFila()).build();

	}

	static final class Request {
		private Long nitProveedor;
		private Long ifcProveedor;
		private String origen;
		private List<Venta> ventas;

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

		public List<Venta> getVentas() {
			return ventas;
		}

		public void setVentas(List<Venta> ventas) {
			this.ventas = ventas;
		}

	}

	static final class Venta {
		private Long fila;
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

		public Long getFila() {
			return fila;
		}

		public void setFila(Long fila) {
			this.fila = fila;
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
