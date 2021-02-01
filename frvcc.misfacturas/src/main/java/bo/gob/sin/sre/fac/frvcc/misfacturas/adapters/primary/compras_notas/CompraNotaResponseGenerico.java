package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras_notas;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNota;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public final class CompraNotaResponseGenerico {
	private final String id;
    private final Long ifcProveedor;
    private final Long nitProveedor;
    private final String razonSocialProveedor;
    private final Long numeroNota;
    private final String codigoAutorizacion;
    private final LocalDate fechaNota;
    private final BigDecimal importeTotalNota;
    private final BigDecimal creditoFiscalNota;
    private final String codigoControlNota;
    private final String compraId;
    private final String estadoNotaId;
    private final String tipoDocumentoCliente;
    private final String numeroDocumentoCliente;
    private final String complementoDocumentoCliente;
    private final String nombreCliente;
    private final String origenId;
    private final String estadoUsoId;
    private final String impuestoUsoId;
    private final Integer gestionUso;
    private final Integer periodoUso;
    private final String nombreFormularioUso;
    private final String formularioId;
    private final String libroId;
    private final String ventaNotaId;
    private final String recepcionId;
    private final Integer secuencia;
    private final String tipoObservacionId;
    private final Long usuarioRegistro;
    private final LocalDateTime fechaRegistro;
    private final Long usuarioUltimaModificacion;
    private final LocalDateTime fechaUltimaModificacion;
    private final String estadoId;

	public CompraNotaResponseGenerico(String id, Long ifcProveedor, Long nitProveedor, String razonSocialProveedor,
			Long numeroNota, String codigoAutorizacion, LocalDate fechaNota, BigDecimal importeTotalNota,
			BigDecimal creditoFiscalNota, String codigoControlNota, 
			String compraId,
			String estadoNotaId, String tipoDocumentoCliente, String numeroDocumentoCliente,
			String complementoDocumentoCliente, String nombreCliente, String origenId, String estadoUsoId,
			String impuestoUsoId, Integer gestionUso, Integer periodoUso, String nombreFormularioUso,
			String formularioId, String libroId, String ventaNotaId, String recepcionId, Integer secuencia,
			String tipoObservacionId, Long usuarioRegistro, LocalDateTime fechaRegistro, Long usuarioUltimaModificacion,
			LocalDateTime fechaUltimaModificacion, String estadoId

	) {
        this.id = id;
        this.ifcProveedor = ifcProveedor;
        this.nitProveedor = nitProveedor;
        this.razonSocialProveedor = razonSocialProveedor;
        this.numeroNota = numeroNota;
        this.codigoAutorizacion = codigoAutorizacion;
        this.fechaNota = fechaNota;
        this.importeTotalNota = importeTotalNota; 
        this.creditoFiscalNota = creditoFiscalNota;
        this.codigoControlNota = codigoControlNota;
        this.compraId=compraId;
        this.estadoNotaId = estadoNotaId;
        this.tipoDocumentoCliente = tipoDocumentoCliente;
        this.numeroDocumentoCliente = numeroDocumentoCliente;
        this.complementoDocumentoCliente = complementoDocumentoCliente;
        this.nombreCliente = nombreCliente;
        this.origenId = origenId;
        this.estadoUsoId = estadoUsoId;
        this.impuestoUsoId = impuestoUsoId;
        this.gestionUso = gestionUso;
        this.periodoUso = periodoUso;
        this.nombreFormularioUso = nombreFormularioUso;
        this.formularioId = formularioId;
        this.libroId = libroId;
        this.ventaNotaId = ventaNotaId;
        this.recepcionId = recepcionId;
        this.secuencia = secuencia;
        this.tipoObservacionId=tipoObservacionId;
        this.usuarioRegistro = usuarioRegistro;
        this.fechaRegistro = fechaRegistro;
        this.usuarioUltimaModificacion = usuarioUltimaModificacion;
        this.fechaUltimaModificacion = fechaUltimaModificacion;
        this.estadoId = estadoId;
    }

    public static CompraNotaResponseGenerico fromAggregate(CompraNota compra) {
        CompraNotaResponseGenerico compraResponseGenerico = new CompraNotaResponseGenerico(
        		compra.id() != null ? compra.id().value() : null,
        		compra.ifcProveedor() != null ? compra.ifcProveedor().value() : null,
        		compra.nitProveedor() != null ? compra.nitProveedor().value() : null,
        		compra.razonSocialProveedor() != null ? compra.razonSocialProveedor().value() : null,
        		compra.numeroNota() != null ? compra.numeroNota().value() : null,		
        		compra.codigoAutorizacion() != null ? compra.codigoAutorizacion().value() : null,		
        		compra.fechaNota() != null ? compra.fechaNota().value() : null,
        		compra.importeTotalNota() != null ? compra.importeTotalNota().value() : null,				 
        		compra.creditoFiscalNota() != null ? compra.creditoFiscalNota().value() : null,
        		compra.codigoControlNota() != null ? compra.codigoControlNota().value() : null,						 
        		compra.compraId() != null ? compra.compraId().value() : null,        						
        		compra.estadoNotaId() != null ? compra.estadoNotaId().value() : null,
        		compra.tipoDocumentoCliente() != null ? compra.tipoDocumentoCliente().value() : null,
        		compra.numeroDocumentoCliente() != null ? compra.numeroDocumentoCliente().value() : null,
        		compra.complementoDocumentoCliente() != null ? compra.complementoDocumentoCliente().value() : null,
        		compra.nombreCliente() != null ? compra.nombreCliente().value() : null,
        		compra.origenId() != null ? compra.origenId().value() : null,
                compra.estadoUsoId() != null ? compra.estadoUsoId().value() : null,
                compra.impuestoUsoId() != null ? compra.impuestoUsoId().value() : null,
                compra.gestionUso() != null ? compra.gestionUso().value() : null,
                compra.periodoUso() != null ? compra.periodoUso().value() : null,
                compra.nombreFormularioUso() != null ? compra.nombreFormularioUso().value() : null,
                compra.formularioId() != null ? compra.formularioId().value() : null,
                compra.libroId() != null ? compra.libroId().value() : null,
                compra.ventaNotaId() != null ? compra.ventaNotaId().value() : null,
                compra.recepcionId() != null ? compra.recepcionId().value() : null,
                compra.secuencia() != null ? compra.secuencia().value() : null,	
                compra.tipoObservacionId()!=null? compra.tipoObservacionId().value():null,               				
                compra.usuarioRegistro() != null ? compra.usuarioRegistro().value() : null,
                compra.fechaRegistro() != null ? compra.fechaRegistro().value() : null,
                compra.usuarioUltimaModificacion() != null ? compra.usuarioUltimaModificacion().value() : null,
                compra.fechaUltimaModificacion() != null ? compra.fechaUltimaModificacion().value() : null,
                compra.estadoId() != null ? compra.estadoId().value() : null);
        return compraResponseGenerico;

    }


	public String getId() {
		return id;
	}


	public Long getIfcProveedor() {
		return ifcProveedor;
	}


	public Long getNitProveedor() {
		return nitProveedor;
	}


	public String getRazonSocialProveedor() {
		return razonSocialProveedor;
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


	public BigDecimal getCreditoFiscalNota() {
		return creditoFiscalNota;
	}


	public String getCodigoControlNota() {
		return codigoControlNota;
	}


	public String getCompraId() {
		return compraId;
	}


	public String getEstadoNotaId() {
		return estadoNotaId;
	}


	public String getTipoDocumentoCliente() {
		return tipoDocumentoCliente;
	}


	public String getNumeroDocumentoCliente() {
		return numeroDocumentoCliente;
	}


	public String getComplementoDocumentoCliente() {
		return complementoDocumentoCliente;
	}


	public String getNombreCliente() {
		return nombreCliente;
	}


	public String getOrigenId() {
		return origenId;
	}


	public String getEstadoUsoId() {
		return estadoUsoId;
	}


	public String getImpuestoUsoId() {
		return impuestoUsoId;
	}


	public Integer getGestionUso() {
		return gestionUso;
	}


	public Integer getPeriodoUso() {
		return periodoUso;
	}


	public String getNombreFormularioUso() {
		return nombreFormularioUso;
	}


	public String getFormularioId() {
		return formularioId;
	}


	public String getLibroId() {
		return libroId;
	}


	public String getVentaNotaId() {
		return ventaNotaId;
	}


	public String getRecepcionId() {
		return recepcionId;
	}


	public Integer getSecuencia() {
		return secuencia;
	}


	public String getTipoObservacionId() {
		return tipoObservacionId;
	}


	public Long getUsuarioRegistro() {
		return usuarioRegistro;
	}


	public LocalDateTime getFechaRegistro() {
		return fechaRegistro;
	}


	public Long getUsuarioUltimaModificacion() {
		return usuarioUltimaModificacion;
	}


	public LocalDateTime getFechaUltimaModificacion() {
		return fechaUltimaModificacion;
	}


	public String getEstadoId() {
		return estadoId;
	}


	
}
