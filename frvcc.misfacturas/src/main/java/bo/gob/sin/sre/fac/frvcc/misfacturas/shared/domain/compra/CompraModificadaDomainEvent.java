package bo.gob.sin.sre.fac.frvcc.misfacturas.shared.domain.compra;

import bo.gob.sin.sre.fac.frvcc.shared.model.Utils;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.DomainEvent;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;

public final class CompraModificadaDomainEvent extends DomainEvent {
    private final Long ifcProveedorNb;
    private final Long nitProveedor;
    private final String razonSocialProveedor;
    private final Long numeroFactura;
    private final String codigoAutorizacion;
    private final LocalDate fechaFactura;
    private final BigDecimal importeTotalCompra;
    private final BigDecimal importeBaseCf;
    private final BigDecimal creditoFiscal;
    private final String codigoControl;
    private final String origenId;
    private final String modalidadId;
    private final String marcaEspecialId;
    private final Long usuarioUltimaModificacion;
    private final LocalDateTime fechaUltimaModificacion;
    private final String estadoId;

    public CompraModificadaDomainEvent(
    		String aggregateId,
    	    Long ifcProveedorNb,
    	    Long nitProveedor,
    	    String razonSocialProveedor,
    	    Long numeroFactura,
    	    String codigoAutorizacion,
    	    LocalDate fechaFactura,
    	    BigDecimal importeTotalCompra,
    	    BigDecimal importeBaseCf,
    	    BigDecimal creditoFiscal,
    	    String codigoControl,
    	    String modalidadId,
    	    String marcaEspecialId,
    	    String origenId,
    	    Long usuarioUltimaModificacion,
    	    LocalDateTime fechaUltimaModificacion,
    	    String estadoId) {
        super(aggregateId);
        this.fechaFactura = fechaFactura;
		this.nitProveedor = nitProveedor;
		this.ifcProveedorNb = ifcProveedorNb;
		this.razonSocialProveedor = razonSocialProveedor;
		this.numeroFactura = numeroFactura;
		this.codigoAutorizacion = codigoAutorizacion;
		this.importeTotalCompra = importeTotalCompra;
		this.importeBaseCf = importeBaseCf;
		this.codigoControl = codigoControl;
		this.origenId = origenId;
		this.usuarioUltimaModificacion = usuarioUltimaModificacion;
		this.fechaUltimaModificacion=fechaUltimaModificacion;
		this.modalidadId = modalidadId;
		this.creditoFiscal = creditoFiscal;
		this.marcaEspecialId = marcaEspecialId;
		this.estadoId=estadoId;
    }


    public CompraModificadaDomainEvent(){
        this.ifcProveedorNb=null;
        this.nitProveedor=null;
        this.razonSocialProveedor=null;
        this.numeroFactura=null;
        this.codigoAutorizacion=null;
        this.fechaFactura=null;
        this.importeTotalCompra=null;
        this.importeBaseCf=null;
        this.creditoFiscal=null;
        this.codigoControl=null;
        this.modalidadId=null;
        this.origenId=null;
        this.marcaEspecialId=null;
        this.usuarioUltimaModificacion=null;
        this.fechaUltimaModificacion=null;
        this.estadoId=null;
    }


    public CompraModificadaDomainEvent(String aggregateId, String eventId, String occurredOn, BuilderCompraRegistradaDomainEvent builder) {
        super(aggregateId, eventId, occurredOn);
        this.ifcProveedorNb = builder.ifcProveedorNb;
        this.nitProveedor = builder.nitProveedor;
        this.razonSocialProveedor = builder.razonSocialProveedor;
        this.fechaFactura = builder.fechaFactura;
        this.numeroFactura = builder.numeroFactura;
        this.codigoAutorizacion = builder.codigoAutorizacion;
        this.importeTotalCompra = builder.importeTotalCompra;
        this.importeBaseCf = builder.importeBaseCf;
        this.creditoFiscal = builder.creditoFiscal;
        this.codigoControl = builder.codigoControl;
        this.modalidadId=builder.modalidadId;
        this.origenId = builder.origenId;
        this.marcaEspecialId=builder.marcaEspecialId;
        this.usuarioUltimaModificacion = builder.usuarioUltimaModificacion;
        this.fechaUltimaModificacion = builder.fechaUltimaModificacion;
        this.estadoId = builder.estadoId;
    }



    private CompraModificadaDomainEvent(BuilderCompraRegistradaDomainEvent builder) {
        super(builder.id);
        this.ifcProveedorNb = builder.ifcProveedorNb;
        this.nitProveedor = builder.nitProveedor;
        this.razonSocialProveedor = builder.razonSocialProveedor;
        this.fechaFactura = builder.fechaFactura;
        this.numeroFactura = builder.numeroFactura;
        this.codigoAutorizacion = builder.codigoAutorizacion;
        this.importeTotalCompra = builder.importeTotalCompra;
        this.importeBaseCf = builder.importeBaseCf;
        this.creditoFiscal = builder.creditoFiscal;
        this.codigoControl = builder.codigoControl;
        this.modalidadId=builder.modalidadId;
        this.origenId = builder.origenId;
        this.marcaEspecialId=builder.marcaEspecialId;
        this.usuarioUltimaModificacion = builder.usuarioUltimaModificacion;
        this.fechaUltimaModificacion = builder.fechaUltimaModificacion;
        this.estadoId = builder.estadoId;

    }

    public static BuilderCompraRegistradaDomainEvent CompraRegistradaDomainEvent() {
        return new BuilderCompraRegistradaDomainEvent();
    }

    @Override
    public String eventName() {
        return "compra.modificada";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<>() {{
            put("ifcProveedorNb",ifcProveedorNb);
            put("nitProveedor",nitProveedor);
            put("razonSocialProveedor",razonSocialProveedor);
            put("numeroFactura",numeroFactura);
            put("codigoAutorizacion",codigoAutorizacion);
            put("fechaFactura",Utils.localDateToString(fechaFactura));
            put("importeTotalCompra",importeTotalCompra);
            put("importeBaseCf",importeBaseCf);
            put("creditoFiscal",creditoFiscal);
            put("codigoControl",codigoControl);
            put("modalidadId",modalidadId);
            put("origenId",origenId);
            put("marcaEspecialId",marcaEspecialId);
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
                .codigoAutorizacion(body.get("codigoAutorizacion") != null ? (String) body.get("codigoAutorizacion") : null)
                .fechaFactura(body.get("fechaFactura") != null ? Utils.stringToLocalDate(body.get("fechaFactura").toString()) : null)
                .importeTotalCompra(body.get("importeTotalCompra") != null ? new BigDecimal( body.get("importeTotalCompra").toString()) : null)
                .importeBaseCf(body.get("importeBaseCf") != null ? new BigDecimal( body.get("importeBaseCf").toString()) : null)
                .creditoFiscal(body.get("creditoFiscal") != null ? new BigDecimal( body.get("creditoFiscal").toString()) : null)
                .codigoControl(body.get("codigoControl") != null ? (String) body.get("codigoControl") : null)
                .modalidadId(body.get("modalidadId") != null ? (String) body.get("modalidadId") : null)
                .origenId(body.get("origenId") != null ? (String) body.get("origenId") : null)
                .marcaEspecialId(body.get("marcaEspecialId") != null ? (String) body.get("marcaEspecialId") : null)
                .usuarioUltimaModificacion(body.get("usuarioUltimaModificacion") != null ? Long.parseLong( body.get("usuarioUltimaModificacion").toString()) : null)
                .fechaUltimaModificacion(body.get("fechaUltimaModificacion") != null ? Utils.stringToLocalDateTime(body.get("fechaUltimaModificacion").toString()) : null)
                .estadoId(body.get("estadoId") != null ? (String) body.get("estadoId") : null);
        
        return new CompraModificadaDomainEvent(
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

    public LocalDate getFechaFactura() {
        return fechaFactura;
    }

    public Long getNumeroFactura() {
        return numeroFactura;
    }

    public String getCodigoAutorizacion() {
        return codigoAutorizacion;
    }

    public BigDecimal getImporteTotalCompra() {
        return importeTotalCompra;
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

    public String getOrigenId() {
        return origenId;
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

        public CompraModificadaDomainEvent build() {
            return new CompraModificadaDomainEvent(this);
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
