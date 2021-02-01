package bo.gob.sin.sre.fac.frvcc.misfacturas.shared.domain.compra;

import bo.gob.sin.sre.fac.frvcc.shared.model.Utils;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.DomainEvent;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;

public final class CompraRegistradaDomainEvent extends DomainEvent {
    private final Long ifcProveedorNb;
    private final Long nitProveedor;
    private final String razonSocialProveedor;
    private final Long numeroFactura;
    private final String numeroDui;
    private final String codigoAutorizacion;
    private final LocalDate fechaFactura;
    private final BigDecimal importeTotalCompra;
    private final BigDecimal importeNoSujetoCf;
    private final BigDecimal subtotal;
    private final BigDecimal descuento;
    private final BigDecimal importeBaseCf;
    private final BigDecimal creditoFiscal;
    private final String codigoControl;
    private final String tipoDocumentoId;
    private final Integer tipoSectorId;
    
    private final String modalidadId;
    
    private final String estadoCompraId;
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
    private final String ventaId;
    private final String recepcionId;
    private final Integer secuencia;
    
    private final String conDerechoCf;
    private final String tipoCompraId;
    private final String tipoObservacionId;
    private final String marcaEspecialId;
    
    private final Long usuarioRegistro;
    private final LocalDateTime fechaRegistro;
    private final Long usuarioUltimaModificacion;
    private final LocalDateTime fechaUltimaModificacion;
    private final String estadoId;

    public CompraRegistradaDomainEvent(
    		String aggregateId,
    		Long ifcProveedorNb,
    	    Long nitProveedor,
    	    String razonSocialProveedor,
    	    Long numeroFactura,
    	    String numeroDui,
    	    String codigoAutorizacion,
    	    LocalDate fechaFactura,
    	    BigDecimal importeTotalCompra,
    	    BigDecimal importeNoSujetoCf,
    	    BigDecimal subtotal,
    	    BigDecimal descuento,
    	    BigDecimal importeBaseCf,
    	    BigDecimal creditoFiscal,
    	    String codigoControl,
    	    String tipoDocumentoId,
    	    Integer tipoSectorId,
    	    String modalidadId,
    	    String estadoCompraId,
    	    String tipoDocumentoCliente,
    	    String numeroDocumentoCliente,
    	    String complementoDocumentoCliente,
    	    String nombreCliente,
    	    String origenId,
    	    String estadoUsoId,
    	    String impuestoUsoId,
    	    Integer gestionUso,
    	    Integer periodoUso,
    	    String nombreFormularioUso,
    	    String formularioId,
    	    String libroId,
    	    String ventaId,
    	    String recepcionId,
    	    Integer secuencia,
    	    String conDerechoCf,
    	    String tipoCompraId,
    	    String tipoObservacionId,
    	    String marcaEspecialId,
    	    Long usuarioRegistro,
    	    LocalDateTime fechaRegistro,
    	    Long usuarioUltimaModificacion,
    	    LocalDateTime fechaUltimaModificacion,
    	    String estadoId) {
        super(aggregateId);
        this.ifcProveedorNb = ifcProveedorNb;
        this.nitProveedor = nitProveedor;
        this.razonSocialProveedor = razonSocialProveedor;
        this.numeroFactura = numeroFactura;
        this.numeroDui = numeroDui;
        this.codigoAutorizacion = codigoAutorizacion;
        this.fechaFactura = fechaFactura;
        this.importeTotalCompra = importeTotalCompra;
        this.importeNoSujetoCf = importeNoSujetoCf;
        this.subtotal = subtotal;
        this.descuento = descuento;
        this.importeBaseCf = importeBaseCf;
        this.creditoFiscal = creditoFiscal;
        this.codigoControl = codigoControl;
        this.tipoDocumentoId = tipoDocumentoId;
        this.tipoSectorId = tipoSectorId;
        
        this.modalidadId=modalidadId;
        
        this.estadoCompraId = estadoCompraId;
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
        this.ventaId = ventaId;
        this.recepcionId = recepcionId;
        this.secuencia = secuencia;
        
        this.conDerechoCf=conDerechoCf;
        this.tipoCompraId=tipoCompraId;
        this.tipoObservacionId=tipoObservacionId;
        this.marcaEspecialId=marcaEspecialId;
        
        this.usuarioRegistro = usuarioRegistro;
        this.fechaRegistro = fechaRegistro;
        this.usuarioUltimaModificacion = usuarioUltimaModificacion;
        this.fechaUltimaModificacion = fechaUltimaModificacion;
        this.estadoId = estadoId;
    }


    public CompraRegistradaDomainEvent(){
        this.ifcProveedorNb=null;
        this.nitProveedor=null;
        this.razonSocialProveedor=null;
        this.numeroFactura=null;
        this.numeroDui=null;
        this.codigoAutorizacion=null;
        this.fechaFactura=null;
        this.importeTotalCompra=null;
        this.importeNoSujetoCf=null;
        this.subtotal=null;
        this.descuento=null;
        this.importeBaseCf=null;
        this.creditoFiscal=null;
        this.codigoControl=null;
        this.tipoDocumentoId=null;
        this.tipoSectorId=null;
        
        this.modalidadId=null;
        
        this.estadoCompraId=null;
        this.tipoDocumentoCliente=null;
        this.numeroDocumentoCliente=null;
        this.complementoDocumentoCliente=null;
        this.nombreCliente=null;
        this.origenId=null;
        this.estadoUsoId=null;
        this.impuestoUsoId=null;
        this.gestionUso=null;
        this.periodoUso=null;
        this.nombreFormularioUso=null;
        this.formularioId=null;
        this.libroId=null;
        this.ventaId=null;
        this.recepcionId=null;
        this.secuencia=null;
        
        this.conDerechoCf=null;
        this.tipoCompraId=null;
        this.tipoObservacionId=null;
        this.marcaEspecialId=null;
        
        this.usuarioRegistro=null;
        this.fechaRegistro=null;
        this.usuarioUltimaModificacion=null;
        this.fechaUltimaModificacion=null;
        this.estadoId=null;
    }


    public CompraRegistradaDomainEvent(String aggregateId, String eventId, String occurredOn, BuilderCompraRegistradaDomainEvent builder) {
        super(aggregateId, eventId, occurredOn);
        this.ifcProveedorNb = builder.ifcProveedorNb;
        this.nitProveedor = builder.nitProveedor;
        this.razonSocialProveedor = builder.razonSocialProveedor;
        this.recepcionId = builder.recepcionId;
        this.secuencia = builder.secuencia;
        this.fechaFactura = builder.fechaFactura;
        this.numeroFactura = builder.numeroFactura;
        this.numeroDui = builder.numeroDui;
        this.codigoAutorizacion = builder.codigoAutorizacion;
        this.importeTotalCompra = builder.importeTotalCompra;
        this.importeNoSujetoCf = builder.importeNoSujetoCf;
        this.subtotal = builder.subtotal;
        this.descuento = builder.descuento;
        this.importeBaseCf = builder.importeBaseCf;
        this.creditoFiscal = builder.creditoFiscal;
        this.codigoControl = builder.codigoControl;
        this.tipoDocumentoId = builder.tipoDocumentoId;
        this.tipoSectorId = builder.tipoSectorId;
        
        this.modalidadId=builder.modalidadId;
        
        this.estadoCompraId = builder.estadoCompraId;
        this.tipoDocumentoCliente = builder.tipoDocumentoCliente;
        this.numeroDocumentoCliente = builder.numeroDocumentoCliente;
        this.complementoDocumentoCliente = builder.complementoDocumentoCliente;
        this.nombreCliente = builder.nombreCliente;
        this.origenId = builder.origenId;
        this.estadoUsoId = builder.estadoUsoId;
        this.impuestoUsoId = builder.impuestoUsoId;
        this.gestionUso = builder.gestionUso;
        this.periodoUso = builder.periodoUso;
        this.nombreFormularioUso = builder.nombreFormularioUso;
        this.formularioId = builder.formularioId;
        this.libroId = builder.libroId;
        this.ventaId = builder.ventaId;
        
        this.conDerechoCf=builder.tipoCompraId;
        this.tipoCompraId=builder.tipoCompraId;
        this.tipoObservacionId=builder.tipoObservacionId;
        this.marcaEspecialId=builder.marcaEspecialId;
        		
        this.usuarioRegistro = builder.usuarioRegistro;
        this.fechaRegistro = builder.fechaRegistro;
        this.usuarioUltimaModificacion = builder.usuarioUltimaModificacion;
        this.fechaUltimaModificacion = builder.fechaUltimaModificacion;
        this.estadoId = builder.estadoId;
    }



    private CompraRegistradaDomainEvent(BuilderCompraRegistradaDomainEvent builder) {
        super(builder.id);
        this.ifcProveedorNb = builder.ifcProveedorNb;
        this.nitProveedor = builder.nitProveedor;
        this.razonSocialProveedor = builder.razonSocialProveedor;
        this.recepcionId = builder.recepcionId;
        this.secuencia = builder.secuencia;
        this.fechaFactura = builder.fechaFactura;
        this.numeroFactura = builder.numeroFactura;
        this.numeroDui = builder.numeroDui;
        this.codigoAutorizacion = builder.codigoAutorizacion;
        this.importeTotalCompra = builder.importeTotalCompra;
        this.importeNoSujetoCf = builder.importeNoSujetoCf;
        this.subtotal = builder.subtotal;
        this.descuento = builder.descuento;
        this.importeBaseCf = builder.importeBaseCf;
        this.creditoFiscal = builder.creditoFiscal;
        this.codigoControl = builder.codigoControl;
        this.tipoDocumentoId = builder.tipoDocumentoId;
        this.tipoSectorId = builder.tipoSectorId;
        
        this.modalidadId=builder.modalidadId;
        
        this.estadoCompraId = builder.estadoCompraId;
        this.tipoDocumentoCliente = builder.tipoDocumentoCliente;
        this.numeroDocumentoCliente = builder.numeroDocumentoCliente;
        this.complementoDocumentoCliente = builder.complementoDocumentoCliente;
        this.nombreCliente = builder.nombreCliente;
        this.origenId = builder.origenId;
        this.estadoUsoId = builder.estadoUsoId;
        this.impuestoUsoId = builder.impuestoUsoId;
        this.gestionUso = builder.gestionUso;
        this.periodoUso = builder.periodoUso;
        this.nombreFormularioUso = builder.nombreFormularioUso;
        this.formularioId = builder.formularioId;
        this.libroId = builder.libroId;
        this.ventaId = builder.ventaId;
        
        this.conDerechoCf=builder.tipoCompraId;
        this.tipoCompraId=builder.tipoCompraId;
        this.tipoObservacionId=builder.tipoObservacionId;
        this.marcaEspecialId=builder.marcaEspecialId;
        		
        this.usuarioRegistro = builder.usuarioRegistro;
        this.fechaRegistro = builder.fechaRegistro;
        this.usuarioUltimaModificacion = builder.usuarioUltimaModificacion;
        this.fechaUltimaModificacion = builder.fechaUltimaModificacion;
        this.estadoId = builder.estadoId;

    }

    public static BuilderCompraRegistradaDomainEvent CompraRegistradaDomainEvent() {
        return new BuilderCompraRegistradaDomainEvent();
    }

    @Override
    public String eventName() {
        return "compra.registrada";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<>() {{
            put("ifcProveedorNb",ifcProveedorNb);
            put("nitProveedor",nitProveedor);
            put("razonSocialProveedor",razonSocialProveedor);
            put("numeroFactura",numeroFactura);
            put("numeroDui",numeroDui);
            put("codigoAutorizacion",codigoAutorizacion);
            put("fechaFactura",Utils.localDateToString(fechaFactura));
            put("importeTotalCompra",importeTotalCompra);
            put("importeNoSujetoCf",importeNoSujetoCf);
            put("subtotal",subtotal);
            put("descuento",descuento);
            put("importeBaseCf",importeBaseCf);
            put("creditoFiscal",creditoFiscal);
            put("codigoControl",codigoControl);
            put("tipoDocumentoId",tipoDocumentoId);
            put("tipoSectorId",tipoSectorId);
            
            put("modalidadId",modalidadId);
            
            put("estadoCompraId",estadoCompraId);
            put("tipoDocumentoCliente",tipoDocumentoCliente);
            put("numeroDocumentoCliente",numeroDocumentoCliente);
            put("complementoDocumentoCliente",complementoDocumentoCliente);
            put("nombreCliente",nombreCliente);
            put("origenId",origenId);
            put("estadoUsoId",estadoUsoId);
            put("impuestoUsoId",impuestoUsoId);
            put("gestionUso",gestionUso);
            put("periodoUso",periodoUso);
            put("nombreFormularioUso",nombreFormularioUso);
            put("formularioId",formularioId);
            put("libroId",libroId);
            put("ventaId",ventaId);
            put("recepcionId",recepcionId);
            put("secuencia",secuencia);
            
            put("conDerechoCf",conDerechoCf);
            put("tipoCompraId",tipoCompraId);
            put("tipoObservacionId",tipoObservacionId);
            put("marcaEspecialId",marcaEspecialId);
            
            put("usuarioRegistro",usuarioRegistro);
            put("fechaRegistro",Utils.localDateTimeToString(fechaRegistro));
            put("usuarioUltimaModificacion",usuarioUltimaModificacion);
            put("fechaUltimaModificacion",Utils.localDateTimeToString(fechaUltimaModificacion));
            put("estadoId",estadoId);
        }};
    }

    @Override
    public DomainEvent fromPrimitives(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        BuilderCompraRegistradaDomainEvent builder = new BuilderCompraRegistradaDomainEvent()
                .ifcProveedorNb(body.get("ifcProveedorNb") != null ? Long.parseLong( body.get("ifcProveedorNb").toString()) : null)
                .nitProveedor(body.get("nitProveedor") != null ? Long.parseLong( body.get("nitProveedor").toString()) : null)
                .razonSocialProveedor(body.get("razonSocialProveedor") != null ? (String) body.get("razonSocialProveedor") : null)
                .numeroFactura(body.get("numeroFactura") != null ? Long.parseLong( body.get("numeroFactura").toString()) : null)
                .numeroDui(body.get("numeroDui") != null ? (String) body.get("numeroDui") : null)
                .codigoAutorizacion(body.get("codigoAutorizacion") != null ? (String) body.get("codigoAutorizacion") : null)
                .fechaFactura(body.get("fechaFactura") != null ? Utils.stringToLocalDate(body.get("fechaFactura").toString()) : null)
                .importeTotalCompra(body.get("importeTotalCompra") != null ? new BigDecimal( body.get("importeTotalCompra").toString()) : null)
                .importeNoSujetoCf(body.get("importeNoSujetoCf") != null ? new BigDecimal( body.get("importeNoSujetoCf").toString()) : null)
                .subtotal(body.get("subtotal") != null ? new BigDecimal( body.get("subtotal").toString()) : null)
                .descuento(body.get("descuento") != null ? new BigDecimal( body.get("descuento").toString()) : null)
                .importeBaseCf(body.get("importeBaseCf") != null ? new BigDecimal( body.get("importeBaseCf").toString()) : null)
                .creditoFiscal(body.get("creditoFiscal") != null ? new BigDecimal( body.get("creditoFiscal").toString()) : null)
                .codigoControl(body.get("codigoControl") != null ? (String) body.get("codigoControl") : null)
                .tipoDocumentoId(body.get("tipoDocumentoId") != null ? (String) body.get("tipoDocumentoId") : null)
                .tipoSectorId(body.get("tipoSectorId") != null ? (Integer) body.get("tipoSectorId") : null)
                .modalidadId(body.get("modalidadId") != null ? (String) body.get("modalidadId") : null)
                .estadoCompraId(body.get("estadoCompraId") != null ? (String) body.get("estadoCompraId") : null)
                .tipoDocumentoCliente(body.get("tipoDocumentoCliente") != null ? (String) body.get("tipoDocumentoCliente") : null)
                .numeroDocumentoCliente(body.get("numeroDocumentoCliente") != null ? (String) body.get("numeroDocumentoCliente") : null)
                .complementoDocumentoCliente(body.get("complementoDocumentoCliente") != null ? (String) body.get("complementoDocumentoCliente") : null)
                .nombreCliente(body.get("nombreCliente") != null ? (String) body.get("nombreCliente") : null)
                .origenId(body.get("origenId") != null ? (String) body.get("origenId") : null)
                .estadoUsoId(body.get("estadoUsoId") != null ? (String) body.get("estadoUsoId") : null)
                .impuestoUsoId(body.get("impuestoUsoId") != null ? (String) body.get("impuestoUsoId") : null)
                .gestionUso(body.get("gestionUso") != null ? (Integer) body.get("gestionUso") : null)
                .periodoUso(body.get("periodoUso") != null ? (Integer) body.get("periodoUso") : null)
                .nombreFormularioUso(body.get("nombreFormularioUso") != null ? (String) body.get("nombreFormularioUso") : null)
                .formularioId(body.get("formularioId") != null ? (String) body.get("formularioId") : null)
                .libroId(body.get("libroId") != null ? (String) body.get("libroId") : null)
                .ventaId(body.get("ventaId") != null ? (String) body.get("ventaId") : null)
                .recepcionId(body.get("recepcionId") != null ? (String) body.get("recepcionId") : null)
                .secuencia(body.get("secuencia") != null ? (Integer) ( body.get("secuencia")) : null)
                .conDerechoCf(body.get("conDerechoCf") != null ? (String) body.get("conDerechoCf") : null)
                .tipoCompraId(body.get("tipoCompraId") != null ? (String) body.get("tipoCompraId") : null)
                .tipoObservacionId(body.get("tipoObservacionId") != null ? (String) body.get("tipoObservacionId") : null)
                .marcaEspecialId(body.get("marcaEspecialId") != null ? (String) body.get("marcaEspecialId") : null)
                .usuarioRegistro(body.get("usuarioRegistro") != null ? Long.parseLong( body.get("usuarioRegistro").toString()) : null)
                .fechaRegistro(body.get("fechaRegistro") != null ? Utils.stringToLocalDateTime(body.get("fechaRegistro").toString()) : null)
                .usuarioUltimaModificacion(body.get("usuarioUltimaModificacion") != null ? Long.parseLong( body.get("usuarioUltimaModificacion").toString()) : null)
                .fechaUltimaModificacion(body.get("fechaUltimaModificacion") != null ? Utils.stringToLocalDateTime(body.get("fechaUltimaModificacion").toString()) : null)
                .estadoId(body.get("estadoId") != null ? (String) body.get("estadoId") : null);
        
        return new CompraRegistradaDomainEvent(
                aggregateId,
                eventId,
                occurredOn,
                builder
        );
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

    public String getRecepcionId() {
        return recepcionId;
    }

    public Integer getsecuencia() {
        return secuencia;
    }

    public LocalDate getFechaFactura() {
        return fechaFactura;
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

    public BigDecimal getimporteNoSujetoCf() {
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

    public String getTipoDocumentoId() {
        return tipoDocumentoId;
    }

    public Integer getTipoSectorId() {
        return tipoSectorId;
    }

    public String getEstadoCompraId() {
        return estadoCompraId;
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

    public String getModalidadId() {
		return modalidadId;
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


	public String getMarcaEspecialId() {
		return marcaEspecialId;
	}



	public static final class BuilderCompraRegistradaDomainEvent {
        private String id;
        private Long ifcProveedorNb;
        private Long nitProveedor;
        private String razonSocialProveedor;
        private Long numeroFactura;
        private String numeroDui;
        private String codigoAutorizacion;
        private LocalDate fechaFactura;
        private BigDecimal importeTotalCompra;
        private BigDecimal importeNoSujetoCf;
        private BigDecimal subtotal;
        private BigDecimal descuento;
        private BigDecimal importeBaseCf;
        private BigDecimal creditoFiscal;
        private String codigoControl;
        private String tipoDocumentoId;
        private Integer tipoSectorId;
        
        private String modalidadId;
        
        private String estadoCompraId;
        private String tipoDocumentoCliente;
        private String numeroDocumentoCliente;
        private String complementoDocumentoCliente;
        private String nombreCliente;
        private String origenId;
        private String estadoUsoId;
        private String impuestoUsoId;
        private Integer gestionUso;
        private Integer periodoUso;
        private String nombreFormularioUso;
        private String formularioId;
        private String libroId;
        private String ventaId;
        private String recepcionId;
        private Integer secuencia;
        
        private String conDerechoCf;
        private String tipoCompraId;
        private String tipoObservacionId;
        private String marcaEspecialId;
        
        private Long usuarioRegistro;
        private LocalDateTime fechaRegistro;
        private Long usuarioUltimaModificacion;
        private LocalDateTime fechaUltimaModificacion;
        private String estadoId;

        private BuilderCompraRegistradaDomainEvent() {
        }

        public CompraRegistradaDomainEvent build() {
            return new CompraRegistradaDomainEvent(this);
        }
        public BuilderCompraRegistradaDomainEvent id(String id) {
            this.id = id;
            return this;
        }

        public BuilderCompraRegistradaDomainEvent ifcProveedorNb(Long ifcProveedorNb) {
            this.ifcProveedorNb = ifcProveedorNb;
            return this;
        }

        public BuilderCompraRegistradaDomainEvent nitProveedor(Long nitProveedor) {
            this.nitProveedor = nitProveedor;
            return this;
        }

        public BuilderCompraRegistradaDomainEvent razonSocialProveedor(String razonSocialProveedor) {
            this.razonSocialProveedor = razonSocialProveedor;
            return this;
        }

        public BuilderCompraRegistradaDomainEvent numeroFactura(Long numeroFactura) {
            this.numeroFactura = numeroFactura;
            return this;
        }

        public BuilderCompraRegistradaDomainEvent numeroDui(String numeroDui) {
            this.numeroDui = numeroDui;
            return this;
        }

        public BuilderCompraRegistradaDomainEvent codigoAutorizacion(String codigoAutorizacion) {
            this.codigoAutorizacion = codigoAutorizacion;
            return this;
        }

        public BuilderCompraRegistradaDomainEvent fechaFactura(LocalDate fechaFactura) {
            this.fechaFactura = fechaFactura;
            return this;
        }
        
        public BuilderCompraRegistradaDomainEvent importeTotalCompra(BigDecimal importeTotalCompra) {
            this.importeTotalCompra = importeTotalCompra;
            return this;
        }

        public BuilderCompraRegistradaDomainEvent importeNoSujetoCf(BigDecimal importeNoSujetoCf) {
            this.importeNoSujetoCf = importeNoSujetoCf;
            return this;
        }

        public BuilderCompraRegistradaDomainEvent subtotal(BigDecimal subtotal) {
            this.subtotal = subtotal;
            return this;
        }

        public BuilderCompraRegistradaDomainEvent descuento(BigDecimal descuento) {
            this.descuento = descuento;
            return this;
        }

        public BuilderCompraRegistradaDomainEvent importeBaseCf(BigDecimal importeBaseCf) {
            this.importeBaseCf = importeBaseCf;
            return this;
        }

        public BuilderCompraRegistradaDomainEvent creditoFiscal(BigDecimal creditoFiscal) {
            this.creditoFiscal = creditoFiscal;
            return this;
        }

        public BuilderCompraRegistradaDomainEvent codigoControl(String codigoControl) {
            this.codigoControl = codigoControl;
            return this;
        }

        public BuilderCompraRegistradaDomainEvent tipoDocumentoId(String tipoDocumentoId) {
            this.tipoDocumentoId = tipoDocumentoId;
            return this;
        }

        public BuilderCompraRegistradaDomainEvent tipoSectorId(Integer tipoSectorId) {
            this.tipoSectorId = tipoSectorId;
            return this;
        }

        
        public BuilderCompraRegistradaDomainEvent modalidadId(String modalidadId) {
            this.modalidadId = modalidadId;
            return this;
        }
       
        public BuilderCompraRegistradaDomainEvent estadoCompraId(String estadoCompraId) {
            this.estadoCompraId = estadoCompraId;
            return this;
        }

        public BuilderCompraRegistradaDomainEvent tipoDocumentoCliente(String tipoDocumentoCliente) {
            this.tipoDocumentoCliente = tipoDocumentoCliente;
            return this;
        }

        public BuilderCompraRegistradaDomainEvent numeroDocumentoCliente(String numeroDocumentoCliente) {
            this.numeroDocumentoCliente = numeroDocumentoCliente;
            return this;
        }

        public BuilderCompraRegistradaDomainEvent complementoDocumentoCliente(String complementoDocumentoCliente) {
            this.complementoDocumentoCliente = complementoDocumentoCliente;
            return this;
        }

        public BuilderCompraRegistradaDomainEvent nombreCliente(String nombreCliente) {
            this.nombreCliente = nombreCliente;
            return this;
        }

        public BuilderCompraRegistradaDomainEvent origenId(String origenId) {
            this.origenId = origenId;
            return this;
        }

        public BuilderCompraRegistradaDomainEvent estadoUsoId(String estadoUsoId) {
            this.estadoUsoId = estadoUsoId;
            return this;
        }

        public BuilderCompraRegistradaDomainEvent impuestoUsoId(String impuestoUsoId) {
            this.impuestoUsoId = impuestoUsoId;
            return this;
        }

        public BuilderCompraRegistradaDomainEvent gestionUso(Integer gestionUso) {
            this.gestionUso = gestionUso;
            return this;
        }

        public BuilderCompraRegistradaDomainEvent periodoUso(Integer periodoUso) {
            this.periodoUso = periodoUso;
            return this;
        }

        public BuilderCompraRegistradaDomainEvent nombreFormularioUso(String nombreFormularioUso) {
            this.nombreFormularioUso = nombreFormularioUso;
            return this;
        }

        public BuilderCompraRegistradaDomainEvent formularioId(String formularioId) {
            this.formularioId = formularioId;
            return this;
        }

        public BuilderCompraRegistradaDomainEvent libroId(String libroId) {
            this.libroId = libroId;
            return this;
        }

        public BuilderCompraRegistradaDomainEvent ventaId(String ventaId) {
            this.ventaId = ventaId;
            return this;
        }

        public BuilderCompraRegistradaDomainEvent recepcionId(String recepcionId) {
            this.recepcionId = recepcionId;
            return this;
        }

        public BuilderCompraRegistradaDomainEvent secuencia(Integer secuencia) {
            this.secuencia = secuencia;
            return this;
        }
        
		public BuilderCompraRegistradaDomainEvent conDerechoCf(String conDerechoCf) {
			this.conDerechoCf = conDerechoCf;
			return this;
		}

		public BuilderCompraRegistradaDomainEvent tipoCompraId(String tipoCompraId) {
			this.tipoCompraId = tipoCompraId;
			return this;
		}

		public BuilderCompraRegistradaDomainEvent tipoObservacionId(String tipoObservacionId) {
			this.tipoObservacionId = tipoObservacionId;
			return this;
		}

		public BuilderCompraRegistradaDomainEvent marcaEspecialId(String marcaEspecialId) {
			this.marcaEspecialId = marcaEspecialId;
			return this;
		}
        
        public BuilderCompraRegistradaDomainEvent usuarioRegistro(Long usuarioRegistro) {
            this.usuarioRegistro = usuarioRegistro;
            return this;
        }

        public BuilderCompraRegistradaDomainEvent fechaRegistro(LocalDateTime fechaRegistro) {
            this.fechaRegistro = fechaRegistro;
            return this;
        }

        public BuilderCompraRegistradaDomainEvent usuarioUltimaModificacion(Long usuarioUltimaModificacion) {
            this.usuarioUltimaModificacion = usuarioUltimaModificacion;
            return this;
        }

        public BuilderCompraRegistradaDomainEvent fechaUltimaModificacion(LocalDateTime fechaUltimaModificacion) {
            this.fechaUltimaModificacion = fechaUltimaModificacion;
            return this;
        }

        public BuilderCompraRegistradaDomainEvent estadoId(String estadoId) {
            this.estadoId = estadoId;
            return this;
        }
    }
}
