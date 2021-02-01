package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.Compra;
import bo.gob.sin.sre.fac.frvcc.shared.model.Utils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public final class CompraResponseGenerico implements Serializable,Cloneable{

    private  String id;
    private  String recepcionId;
    private  Long secuencia;
    private  String tipoDocumentoId;
    private  LocalDate fechaFactura;
    private  Long ifcProveedorNb;
    private  Long nitProveedor;
    private  String razonSocialProveedor;
    private  Long numeroFactura;
    private  String numeroDui;
    private  String codigoAutorizacion;
    private  BigDecimal importeTotalCompra;
    private  BigDecimal importeNoSujetoCf;
    private  BigDecimal subtotal;
    private  BigDecimal descuento;
    private  BigDecimal importeBaseCf;
    private  BigDecimal creditoFiscal;
    private  String codigoControl;
    private  Integer tipoSectorId;
    private  String estadoCompraId;
    private  String estadoUsoId;
    private  String impuestoUsoId;
    private  Integer gestionUso;
    private  String modalidadId;
    private  Integer periodoUso;
    private  String nombreFormularioUso;
    private  String formularioId;
    private  String libroId;
    private  String ventaId;
    private  Long usuarioRegistro;
    private  LocalDateTime fechaRegistro;
    private  Long usuarioUltimaModificacion;
    private  LocalDateTime fechaUltimaModificacion;
    private  String estadoId;
    private  String nombreCliente;
    private  String origenId;

    private  String tipoDocumentoCliente;
    private  String numeroDocumentoCliente;
    private  String complementoDocumentoCliente;
    private  String conDerechoCf;
    private  String tipoCompraId;
    private  String tipoObservacionId;
    private  String marcaEspecialId;

    public void setId(String id) {
        this.id = id;
    }

    public void setRecepcionId(String recepcionId) {
        this.recepcionId = recepcionId;
    }

    public void setTipoDocumentoId(String tipoDocumentoId) {
        this.tipoDocumentoId = tipoDocumentoId;
    }

    public void setFechaFactura(String fechaFactura) {
        this.fechaFactura = Utils.stringToLocalDate(fechaFactura);
    }

    public void setFechaFactura(LocalDate fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public void setIfcProveedorNb(Long ifcProveedorNb) {
        this.ifcProveedorNb = ifcProveedorNb;
    }

    public void setNitProveedor(Long nitProveedor) {
        this.nitProveedor = nitProveedor;
    }

    public void setRazonSocialProveedor(String razonSocialProveedor) {
        this.razonSocialProveedor = razonSocialProveedor;
    }

    public void setNumeroFactura(Long numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public void setNumeroDui(String numeroDui) {
        this.numeroDui = numeroDui;
    }

    public void setCodigoAutorizacion(String codigoAutorizacion) {
        this.codigoAutorizacion = codigoAutorizacion;
    }

    public void setImporteTotalCompra(BigDecimal importeTotalCompra) {
        this.importeTotalCompra = importeTotalCompra;
    }

    public void setImporteNoSujetoCf(BigDecimal importeNoSujetoCf) {
        this.importeNoSujetoCf = importeNoSujetoCf;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    public void setImporteBaseCf(BigDecimal importeBaseCf) {
        this.importeBaseCf = importeBaseCf;
    }

    public void setCreditoFiscal(BigDecimal creditoFiscal) {
        this.creditoFiscal = creditoFiscal;
    }

    public void setCodigoControl(String codigoControl) {
        this.codigoControl = codigoControl;
    }

    public void setTipoSectorId(Integer tipoSectorId) {
        this.tipoSectorId = tipoSectorId;
    }

    public void setEstadoCompraId(String estadoCompraId) {
        this.estadoCompraId = estadoCompraId;
    }

    public void setEstadoUsoId(String estadoUsoId) {
        this.estadoUsoId = estadoUsoId;
    }

    public void setImpuestoUsoId(String impuestoUsoId) {
        this.impuestoUsoId = impuestoUsoId;
    }

    public void setGestionUso(Integer gestionUso) {
        this.gestionUso = gestionUso;
    }

    public void setModalidadId(String modalidadId) {
        this.modalidadId = modalidadId;
    }

    public void setPeriodoUso(Integer periodoUso) {
        this.periodoUso = periodoUso;
    }

    public void setNombreFormularioUso(String nombreFormularioUso) {
        this.nombreFormularioUso = nombreFormularioUso;
    }

    public void setFormularioId(String formularioId) {
        this.formularioId = formularioId;
    }

    public void setLibroId(String libroId) {
        this.libroId = libroId;
    }

    public void setVentaId(String ventaId) {
        this.ventaId = ventaId;
    }

    public void setUsuarioRegistro(Long usuarioRegistro) {
        this.usuarioRegistro = usuarioRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    public void setFechaRegistro(String fechaRegistro) {

        this.fechaRegistro = Utils.stringToLocalDateTime(fechaRegistro);
    }

    public void setUsuarioUltimaModificacion(Long usuarioUltimaModificacion) {
        this.usuarioUltimaModificacion = usuarioUltimaModificacion;
    }

    public void setFechaUltimaModificacion(LocalDateTime fechaUltimaModificacion) {
        this.fechaUltimaModificacion = fechaUltimaModificacion;
    }

    public void setFechaUltimaModificacion(String fechaUltimaModificacion) {
        this.fechaUltimaModificacion = Utils.stringToLocalDateTime(fechaUltimaModificacion);
    }
    public void setEstadoId(String estadoId) {
        this.estadoId = estadoId;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public void setTipoDocumentoCliente(String tipoDocumentoCliente) {
        this.tipoDocumentoCliente = tipoDocumentoCliente;
    }

    public void setNumeroDocumentoCliente(String numeroDocumentoCliente) {
        this.numeroDocumentoCliente = numeroDocumentoCliente;
    }

    public void setComplementoDocumentoCliente(String complementoDocumentoCliente) {
        this.complementoDocumentoCliente = complementoDocumentoCliente;
    }

    public void setConDerechoCf(String conDerechoCf) {
        this.conDerechoCf = conDerechoCf;
    }

    public void setTipoCompraId(String tipoCompraId) {
        this.tipoCompraId = tipoCompraId;
    }

    public void setTipoObservacionId(String tipoObservacionId) {
        this.tipoObservacionId = tipoObservacionId;
    }

    public void setMarcaEspecialId(String marcaEspecialId) {
        this.marcaEspecialId = marcaEspecialId;
    }

    public void setSecuencia(Long secuencia) {
        this.secuencia = secuencia;
    }

    public void setOrigenId(String origenId) {
        this.origenId = origenId;
    }

    public CompraResponseGenerico(String id, String recepcionId, Long secuencia, String tipoDocumentoId,
                                  LocalDate fechaFactura, Long ifcProveedorNb, Long nitProveedor, String razonSocialProveedor,
                                  Long numeroFactura, String numeroDui, String codigoAutorizacion, BigDecimal importeTotalCompra,
                                  BigDecimal importeNoSujetoCf, BigDecimal subtotal, BigDecimal descuento, BigDecimal importeBaseCf,
                                  BigDecimal creditoFiscal, String codigoControl, Integer tipoSectorId, String estadoCompraId,
                                  String estadoUsoId, String impuestoUsoId, Integer periodoUso, String nombreFormularioUso, String formularioId,
                                  String libroId, String ventaId, Long usuarioRegistro, LocalDateTime fechaRegistro, Long usuarioUltimaModificacion,
                                  LocalDateTime fechaUltimaModificacion, String estadoId, String tipoDocumentoCliente,
                                  String numeroDocumentoCliente, String complementoDocumentoCliente, String nombreCliente, String origenId,
                                  Integer gestionUso,
                                  String modalidadId, String conDerechoCf, String tipoCompraId, String tipoObservacionId,
                                  String marcaEspecialId) {
        this.id = id;
        this.recepcionId = recepcionId;
        this.tipoDocumentoId = tipoDocumentoId;
        this.fechaFactura = fechaFactura;
        this.nitProveedor = nitProveedor;
        this.razonSocialProveedor = razonSocialProveedor;
        this.numeroFactura = numeroFactura;
        this.numeroDui = numeroDui;
        this.codigoAutorizacion = codigoAutorizacion;
        this.importeTotalCompra = importeTotalCompra;
        this.importeNoSujetoCf = importeNoSujetoCf;
        this.subtotal = subtotal;
        this.descuento = descuento;
        this.importeBaseCf = importeBaseCf;
        this.creditoFiscal = creditoFiscal;
        this.codigoControl = codigoControl;
        this.tipoSectorId = tipoSectorId;
        this.estadoCompraId = estadoCompraId;
        this.estadoUsoId = estadoUsoId;
        this.impuestoUsoId = impuestoUsoId;
        this.periodoUso = periodoUso;
        this.nombreFormularioUso = nombreFormularioUso;
        this.formularioId = formularioId;
        this.libroId=libroId;
        this.ventaId = ventaId;
        this.usuarioRegistro = usuarioRegistro;
        this.fechaRegistro = fechaRegistro;
        this.usuarioUltimaModificacion = usuarioUltimaModificacion;
        this.fechaUltimaModificacion = fechaUltimaModificacion;
        this.estadoId = estadoId;
        this.tipoDocumentoCliente = tipoDocumentoCliente;
        this.numeroDocumentoCliente = numeroDocumentoCliente;
        this.complementoDocumentoCliente = complementoDocumentoCliente;
        this.origenId = origenId;
        this.nombreCliente = nombreCliente;
        this.secuencia = secuencia;
        this.ifcProveedorNb = ifcProveedorNb;
        this.gestionUso = gestionUso;
        this.modalidadId = modalidadId;
        this.conDerechoCf=conDerechoCf;
        this.tipoCompraId=tipoCompraId;
        this.tipoObservacionId=tipoObservacionId;
        this.marcaEspecialId=marcaEspecialId;

    }


    public static CompraResponseGenerico fromAggregate(Compra compra) {
        CompraResponseGenerico compraResponseGenerico = new CompraResponseGenerico(compra.id() != null ? compra.id().value() : null,
                compra.recepcionId() != null ? compra.recepcionId().value() : null,
                compra.secuencia() != null ? compra.secuencia().value() : null,
                compra.tipoDocumentoId() != null ? compra.tipoDocumentoId().value() : null,
                compra.fechaFactura() != null ? compra.fechaFactura().value() : null,
                compra.ifcProveedorNb() != null ? compra.ifcProveedorNb().value() : null,
                compra.nitProveedor() != null ? compra.nitProveedor().value() : null,
                compra.razonSocialProveedor() != null ? compra.razonSocialProveedor().value() : null,
                compra.numeroFactura() != null ? compra.numeroFactura().value() : null,
                compra.numeroDui() != null ? compra.numeroDui().value() : null,
                compra.codigoAutorizacion() != null ? compra.codigoAutorizacion().value() : null,
                compra.importeTotalCompra() != null ? compra.importeTotalCompra().value() : null,
                compra.importeNoSujetoCf() != null ? compra.importeNoSujetoCf().value() : null,
                compra.subtotal() != null ? compra.subtotal().value() : null,
                compra.descuento() != null ? compra.descuento().value() : null,
                compra.importeBaseCf() != null ? compra.importeBaseCf().value() : null,
                compra.creditoFiscal() != null ? compra.creditoFiscal().value() : null,
                compra.codigoControl() != null ? compra.codigoControl().value() : null,
                compra.tipoSectorId() != null ? compra.tipoSectorId().value() : null,
                compra.estadoCompraId() != null ? compra.estadoCompraId().value() : null,
                compra.estadoUsoId() != null ? compra.estadoUsoId().value() : null,
                compra.impuestoUsoId() != null ? compra.impuestoUsoId().value() : null,
                compra.periodoUso() != null ? compra.periodoUso().value() : null,
                compra.nombreFormularioUso() != null ? compra.nombreFormularioUso().value() : null,
                compra.formularioId() != null ? compra.formularioId().value() : null,
                compra.libroId() != null ? compra.libroId().value() : null,
                compra.ventaId() != null ? compra.ventaId().value() : null,
                compra.usuarioRegistro() != null ? compra.usuarioRegistro().value() : null,
                compra.fechaRegistro() != null ? compra.fechaRegistro().value() : null,
                compra.usuarioUltimaModificacion() != null ? compra.usuarioUltimaModificacion().value() : null,
                compra.fechaUltimaModificacion() != null ? compra.fechaUltimaModificacion().value() : null,
                compra.estadoId() != null ? compra.estadoId().value() : null,
                compra.tipoDocumentoCliente() != null ? compra.tipoDocumentoCliente().value() : null,
                compra.numeroDocumentoCliente() != null ? compra.numeroDocumentoCliente().value() : null,
                compra.complementoDocumentoCliente() != null ? compra.complementoDocumentoCliente().value() : null,
                compra.nombreCliente() != null ? compra.nombreCliente().value() : null,
                compra.origenId() != null ? compra.origenId().value() : null,
                compra.gestionUso() != null ? compra.gestionUso().value() : null,
                compra.modalidadId() != null ? compra.modalidadId().value() : null,
                compra.conDerechoCf()!=null? compra.conDerechoCf().value():null,
                compra.tipoCompraId()!=null? compra.tipoCompraId().value():null,
                compra.tipoObservacionId()!=null? compra.tipoObservacionId().value():null,
                compra.marcaEspecialId()!=null? compra.marcaEspecialId().value():null);
        return compraResponseGenerico;

    }

    public Integer gestionUso() {
        return gestionUso;
    }

    public String modalidadId() {
        return modalidadId;
    }

    public String nombreCliente() {
        return nombreCliente;
    }

    public String origenId() {
        return origenId;
    }

    public Long secuencia() {
        return secuencia;
    }

    public Long ifcProveedorNb() {
        return ifcProveedorNb;
    }

    public String tipoDocumentoCliente() {
        return tipoDocumentoCliente;
    }

    public String numeroDocumentoCliente() {
        return numeroDocumentoCliente;
    }

    public String complementoDocumentoCliente() {
        return complementoDocumentoCliente;
    }

    public String id() {
        return id;
    }

    public String recepcionId() {
        return recepcionId;
    }

    public String tipoDocumentoId() {
        return tipoDocumentoId;
    }

    public LocalDate fechaFactura() {
        return fechaFactura;
    }

    public Long nitProveedor() {
        return nitProveedor;
    }

    public String razonSocialProveedor() {
        return razonSocialProveedor;
    }

    public Long numeroFactura() {
        return numeroFactura;
    }

    public String numeroDui() {
        return numeroDui;
    }

    public String codigoAutorizacion() {
        return codigoAutorizacion;
    }

    public BigDecimal importeTotalCompra() {
        return importeTotalCompra;
    }

    public BigDecimal importeNoSujetoCf() {
        return importeNoSujetoCf;
    }

    public BigDecimal subtotal() {
        return subtotal;
    }

    public BigDecimal descuento() {
        return descuento;
    }

    public BigDecimal importeBaseCf() {
        return importeBaseCf;
    }

    public BigDecimal creditoFiscal() {
        return creditoFiscal;
    }

    public String codigoControl() {
        return codigoControl;
    }

    public Integer tipoSectorId() {
        return tipoSectorId;
    }

    public String estadoCompraId() {
        return estadoCompraId;
    }

    public String estadoUsoId() {
        return estadoUsoId;
    }

    public String impuestoUsoId() {
        return impuestoUsoId;
    }

    public Integer periodoUso() {
        return periodoUso;
    }

    public String nombreFormularioUso() {
        return nombreFormularioUso;
    }

    public String formularioId() {
        return formularioId;
    }
    public String libroId() {
    	return libroId;
    }
    

    public String ventaId() {
        return ventaId;
    }

    public Long usuarioRegistro() {
        return usuarioRegistro;
    }

    public LocalDateTime fechaRegistro() {
        return fechaRegistro;
    }

    public Long usuarioUltimaModificacion() {
        return usuarioUltimaModificacion;
    }

    public LocalDateTime fechaUltimaModificacion() {
        return fechaUltimaModificacion;
    }

    public String estadoId() {
        return estadoId;
    }

    public String conDerechoCf() {
    	return conDerechoCf;
    }

    public String tipoCompraId() {
    	return tipoCompraId;
    }
    
    public String tipoObservacionId() {
    	return tipoObservacionId;
    }
    
    public String marcaEspecialId() {
    	return marcaEspecialId;
    }
    public String getId() {
        return id;
    }

    public String getRecepcionId() {
        return recepcionId;
    }

    public String getTipoDocumentoId() {
        return tipoDocumentoId;
    }

    public LocalDate getFechaFactura() {
        return fechaFactura;
    }

    public Long getIfcProveedorNb() {
        return ifcProveedorNb;
    }

    public Long getNitProveedor() {
        return nitProveedor;
    }

    public String getRazonSocialProveedor() {
        return razonSocialProveedor;
    }

    public Long getNumeroFactura() {
        return numeroFactura;
    }

    public String getNumeroDui() {
        return numeroDui;
    }

    public String getCodigoAutorizacion() {
        return codigoAutorizacion;
    }

    public BigDecimal getImporteTotalCompra() {
        return importeTotalCompra;
    }

    public BigDecimal getImporteNoSujetoCf() {
        return importeNoSujetoCf;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public BigDecimal getDescuento() {
        return descuento;
    }

    public BigDecimal getImporteBaseCf() {
        return importeBaseCf;
    }

    public BigDecimal getCreditoFiscal() {
        return creditoFiscal;
    }

    public String getCodigoControl() {
        return codigoControl;
    }

    public Integer getTipoSectorId() {
        return tipoSectorId;
    }

    public String getEstadoCompraId() {
        return estadoCompraId;
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

    public String getModalidadId() {
        return modalidadId;
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
    public String getLibroId()
    {
    	return libroId;
    }

    public String getVentaId() {
        return ventaId;
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

    public String getNombreCliente() {
        return nombreCliente;
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
    
    public String getConDerechoCf() {
		return conDerechoCf;
	}


	public String getTipoCompraId() {
		return tipoCompraId;
	}


	public String getTipoObservacionId() {
		return tipoObservacionId;
	}

    public Long getSecuencia() {
        return secuencia;
    }

    public String getOrigenId() {
        return origenId;
    }

    public String getMarcaEspecialId() {
		return marcaEspecialId;
	}
	public CompraResponseGenerico()
	{
		this.id = null;
        this.recepcionId = null;
        this.tipoDocumentoId = null;
        this.fechaFactura = null;
        this.nitProveedor = null;
        this.razonSocialProveedor = null;
        this.numeroFactura = null;
        this.numeroDui = null;
        this.codigoAutorizacion = null;
        this.importeTotalCompra = null;
        this.importeNoSujetoCf = null;
        this.subtotal = null;
        this.descuento = null;
        this.importeBaseCf = null;
        this.creditoFiscal = null;
        this.codigoControl = null;
        this.tipoSectorId = null;
        this.estadoCompraId = null;
        this.estadoUsoId = null;
        this.impuestoUsoId = null;
        this.periodoUso = null;
        this.nombreFormularioUso = null;
        this.formularioId = null;
        this.libroId=null;
        this.ventaId = null;
        this.usuarioRegistro = null;
        this.fechaRegistro = null;
        this.usuarioUltimaModificacion = null;
        this.fechaUltimaModificacion = null;
        this.estadoId = null;
        this.tipoDocumentoCliente = null;
        this.numeroDocumentoCliente = null;
        this.complementoDocumentoCliente = null;
        this.origenId = null;
        this.nombreCliente = null;
        this.secuencia = null;
        this.ifcProveedorNb = null;
        this.gestionUso = null;
        this.modalidadId = null;
        this.conDerechoCf=null;
        this.tipoCompraId=null;
        this.tipoObservacionId=null;
        this.marcaEspecialId=null;
		
	}

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
