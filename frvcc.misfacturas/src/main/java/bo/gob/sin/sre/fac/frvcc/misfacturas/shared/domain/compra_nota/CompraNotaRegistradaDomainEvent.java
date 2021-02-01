package bo.gob.sin.sre.fac.frvcc.misfacturas.shared.domain.compra_nota;

import bo.gob.sin.sre.fac.frvcc.shared.model.Utils;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.DomainEvent;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;

public final class CompraNotaRegistradaDomainEvent extends DomainEvent {
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

    public CompraNotaRegistradaDomainEvent(
    		String aggregateId,
    		Long ifcProveedor,
    	    Long nitProveedor,
    	    String razonSocialProveedor,
    	    Long numeroNota,
    	    String codigoAutorizacion,
    	    LocalDate fechaNota,
    	    BigDecimal importeTotalNota,
    	    BigDecimal creditoFiscalNota,
    	    String codigoControlNota,
    	    String compraId,
    	    String estadoNotaId,
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
    	    String ventaNotaId,
    	    String recepcionId,
    	    Integer secuencia,
    	    String tipoObservacionId,
    	    Long usuarioRegistro,
    	    LocalDateTime fechaRegistro,
    	    Long usuarioUltimaModificacion,
    	    LocalDateTime fechaUltimaModificacion,
    	    String estadoId) {
        super(aggregateId);
        this.ifcProveedor = ifcProveedor;
        this.nitProveedor = nitProveedor;
        this.razonSocialProveedor = razonSocialProveedor;
        this.numeroNota = numeroNota;
        this.codigoAutorizacion = codigoAutorizacion;
        this.fechaNota = fechaNota;
        this.importeTotalNota = importeTotalNota;
        this.creditoFiscalNota = creditoFiscalNota;
        this.codigoControlNota = codigoControlNota;
        this.compraId = compraId;
       
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


    public CompraNotaRegistradaDomainEvent(){
        this.ifcProveedor=null;
        this.nitProveedor=null;
        this.razonSocialProveedor=null;
        this.numeroNota=null;
        this.codigoAutorizacion=null;
        this.fechaNota=null;
        this.importeTotalNota=null;
        this.creditoFiscalNota=null;
        this.codigoControlNota=null;
        this.compraId=null;
        
        this.estadoNotaId=null;
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
        this.ventaNotaId=null;
        this.recepcionId=null;
        this.secuencia=null;
        this.tipoObservacionId=null;
        this.usuarioRegistro=null;
        this.fechaRegistro=null;
        this.usuarioUltimaModificacion=null;
        this.fechaUltimaModificacion=null;
        this.estadoId=null;
    }


    public CompraNotaRegistradaDomainEvent(String aggregateId, String eventId, String occurredOn, BuilderCompraNotaRegistradaDomainEvent builder) {
        super(aggregateId, eventId, occurredOn);
        this.ifcProveedor = builder.ifcProveedor;
        this.nitProveedor = builder.nitProveedor;
        this.razonSocialProveedor = builder.razonSocialProveedor;
        this.numeroNota = builder.numeroNota;
        this.codigoAutorizacion = builder.codigoAutorizacion;
        this.fechaNota = builder.fechaNota;  
        this.importeTotalNota = builder.importeTotalNota;
        this.creditoFiscalNota = builder.creditoFiscalNota;
        this.codigoControlNota = builder.codigoControlNota;
        this.compraId = builder.compraId;
        
        this.estadoNotaId = builder.estadoNotaId;
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
        this.ventaNotaId = builder.ventaNotaId;
        this.recepcionId = builder.recepcionId;
        this.secuencia = builder.secuencia;
        this.tipoObservacionId=builder.tipoObservacionId;	
        this.usuarioRegistro = builder.usuarioRegistro;
        this.fechaRegistro = builder.fechaRegistro;
        this.usuarioUltimaModificacion = builder.usuarioUltimaModificacion;
        this.fechaUltimaModificacion = builder.fechaUltimaModificacion;
        this.estadoId = builder.estadoId;
    }

    private CompraNotaRegistradaDomainEvent(BuilderCompraNotaRegistradaDomainEvent builder) {
        super(builder.id);
        this.ifcProveedor = builder.ifcProveedor;
        this.nitProveedor = builder.nitProveedor;
        this.razonSocialProveedor = builder.razonSocialProveedor;
        this.numeroNota = builder.numeroNota;
        this.codigoAutorizacion = builder.codigoAutorizacion;
        this.fechaNota = builder.fechaNota;
        this.importeTotalNota = builder.importeTotalNota;
        this.creditoFiscalNota = builder.creditoFiscalNota;
        this.codigoControlNota = builder.codigoControlNota;
        this.compraId = builder.compraId;
        
        this.estadoNotaId = builder.estadoNotaId;
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
        this.ventaNotaId = builder.ventaNotaId;
        this.recepcionId = builder.recepcionId;
        this.secuencia = builder.secuencia;
        this.tipoObservacionId=builder.tipoObservacionId;	
        this.usuarioRegistro = builder.usuarioRegistro;
        this.fechaRegistro = builder.fechaRegistro;
        this.usuarioUltimaModificacion = builder.usuarioUltimaModificacion;
        this.fechaUltimaModificacion = builder.fechaUltimaModificacion;
        this.estadoId = builder.estadoId;
    }

    public static BuilderCompraNotaRegistradaDomainEvent CompraNotaRegistradaDomainEvent() {
        return new BuilderCompraNotaRegistradaDomainEvent();
    }

    @Override
    public String eventName() {
        return "compra_nota.registrada";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<>() {{
            put("ifcProveedor",ifcProveedor);
            put("nitProveedor",nitProveedor);
            put("razonSocialProveedor",razonSocialProveedor);
            put("numeroNota",numeroNota);
            put("codigoAutorizacion",codigoAutorizacion);
            put("fechaNota",Utils.localDateToString(fechaNota));
            put("importeTotalNota",importeTotalNota);
            put("creditoFiscalNota",creditoFiscalNota);
            put("codigoControlNota",codigoControlNota);
            put("compraId",compraId);
            
            put("estadoNotaId",estadoNotaId);
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
            put("ventaNotaId",ventaNotaId);
            put("recepcionId",recepcionId);
            put("secuencia",secuencia);
            put("tipoObservacionId",tipoObservacionId);
            put("usuarioRegistro",usuarioRegistro);
            put("fechaRegistro",Utils.localDateTimeToString(fechaRegistro));
            put("usuarioUltimaModificacion",usuarioUltimaModificacion);
            put("fechaUltimaModificacion",Utils.localDateTimeToString(fechaUltimaModificacion));
            put("estadoId",estadoId);
        }};
    }

    @Override
    public DomainEvent fromPrimitives(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        BuilderCompraNotaRegistradaDomainEvent builder = new BuilderCompraNotaRegistradaDomainEvent()
                .ifcProveedor(body.get("ifcProveedor") != null ? Long.parseLong( body.get("ifcProveedor").toString()) : null)
                .nitProveedor(body.get("nitProveedor") != null ? Long.parseLong( body.get("nitProveedor").toString()) : null)
                .razonSocialProveedor(body.get("razonSocialProveedor") != null ? (String) body.get("razonSocialProveedor") : null)
                .numeroNota(body.get("numeroNota") != null ? Long.parseLong( body.get("numeroNota").toString()) : null)
                .codigoAutorizacion(body.get("codigoAutorizacion") != null ? (String) body.get("codigoAutorizacion") : null)
                .fechaNota(body.get("fechaNota") != null ? Utils.stringToLocalDate(body.get("fechaNota").toString()) : null)
                .importeTotalNota(body.get("importeTotalNota") != null ? new BigDecimal( body.get("importeTotalNota").toString()) : null)
                .creditoFiscalNota(body.get("creditoFiscalNota") != null ? new BigDecimal( body.get("creditoFiscalNota").toString()) : null)
                .codigoControlNota(body.get("codigoControlNota") != null ? (String) body.get("codigoControlNota") : null)
                .compraId(body.get("compraId") != null ? (String) body.get("compraId") : null)
                
                .estadoNotaId(body.get("estadoNotaId") != null ? (String) body.get("estadoNotaId") : null)
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
                .ventaNotaId(body.get("ventaNotaId") != null ? (String) body.get("ventaNotaId") : null)
                .recepcionId(body.get("recepcionId") != null ? (String) body.get("recepcionId") : null)
                .secuencia(body.get("secuencia") != null ? (Integer) ( body.get("secuencia")) : null)
                .tipoObservacionId(body.get("tipoObservacionId") != null ? (String) body.get("tipoObservacionId") : null)
                .usuarioRegistro(body.get("usuarioRegistro") != null ? Long.parseLong( body.get("usuarioRegistro").toString()) : null)
                .fechaRegistro(body.get("fechaRegistro") != null ? Utils.stringToLocalDateTime(body.get("fechaRegistro").toString()) : null)
                .usuarioUltimaModificacion(body.get("usuarioUltimaModificacion") != null ? Long.parseLong( body.get("usuarioUltimaModificacion").toString()) : null)
                .fechaUltimaModificacion(body.get("fechaUltimaModificacion") != null ? Utils.stringToLocalDateTime(body.get("fechaUltimaModificacion").toString()) : null)
                .estadoId(body.get("estadoId") != null ? (String) body.get("estadoId") : null);
        
        return new CompraNotaRegistradaDomainEvent(
                aggregateId,
                eventId,
                occurredOn,
                builder
        );
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





	public static final class BuilderCompraNotaRegistradaDomainEvent {
        private String id;
        private Long ifcProveedor;
        private Long nitProveedor;
        private String razonSocialProveedor;
        private Long numeroNota;
        private String codigoAutorizacion;
        private LocalDate fechaNota;
        private BigDecimal importeTotalNota;
        private BigDecimal creditoFiscalNota;
        private String codigoControlNota;
        private String compraId;
        
        private String estadoNotaId;
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
        private String ventaNotaId;
        private String recepcionId;
        private Integer secuencia;
        private String tipoObservacionId;
        private Long usuarioRegistro;
        private LocalDateTime fechaRegistro;
        private Long usuarioUltimaModificacion;
        private LocalDateTime fechaUltimaModificacion;
        private String estadoId;

        private BuilderCompraNotaRegistradaDomainEvent() {
        }

        public CompraNotaRegistradaDomainEvent build() {
            return new CompraNotaRegistradaDomainEvent(this);
        }
        
		public BuilderCompraNotaRegistradaDomainEvent id(String id) {
			this.id = id;
			return this;
		}

		public BuilderCompraNotaRegistradaDomainEvent ifcProveedor(Long ifcProveedor) {
			this.ifcProveedor = ifcProveedor;
			return this;
		}

		public BuilderCompraNotaRegistradaDomainEvent nitProveedor(Long nitProveedor) {
			this.nitProveedor = nitProveedor;
			return this;
		}

		public BuilderCompraNotaRegistradaDomainEvent razonSocialProveedor(String razonSocialProveedor) {
			this.razonSocialProveedor = razonSocialProveedor;
			return this;
		}

		public BuilderCompraNotaRegistradaDomainEvent numeroNota(Long numeroNota) {
			this.numeroNota = numeroNota;
			return this;
		}

		public BuilderCompraNotaRegistradaDomainEvent codigoAutorizacion(String codigoAutorizacion) {
			this.codigoAutorizacion = codigoAutorizacion;
			return this;
		}

		public BuilderCompraNotaRegistradaDomainEvent fechaNota(LocalDate fechaNota) {
			this.fechaNota = fechaNota;
			return this;
		}

		public BuilderCompraNotaRegistradaDomainEvent importeTotalNota(BigDecimal importeTotalNota) {
			this.importeTotalNota = importeTotalNota;
			return this;
		}

		public BuilderCompraNotaRegistradaDomainEvent creditoFiscalNota(BigDecimal creditoFiscalNota) {
			this.creditoFiscalNota = creditoFiscalNota;
			return this;
		}

		public BuilderCompraNotaRegistradaDomainEvent codigoControlNota(String codigoControlNota) {
			this.codigoControlNota = codigoControlNota;
			return this;
		}
		
		public BuilderCompraNotaRegistradaDomainEvent compraId(String compraId) {
			this.compraId = compraId;
			return this;
		}
		public BuilderCompraNotaRegistradaDomainEvent estadoNotaId(String estadoNotaId) {
			this.estadoNotaId = estadoNotaId;
			return this;
		}

		public BuilderCompraNotaRegistradaDomainEvent tipoDocumentoCliente(String tipoDocumentoCliente) {
			this.tipoDocumentoCliente = tipoDocumentoCliente;
			return this;
		}

		public BuilderCompraNotaRegistradaDomainEvent numeroDocumentoCliente(String numeroDocumentoCliente) {
			this.numeroDocumentoCliente = numeroDocumentoCliente;
			return this;
		}

		public BuilderCompraNotaRegistradaDomainEvent complementoDocumentoCliente(String complementoDocumentoCliente) {
			this.complementoDocumentoCliente = complementoDocumentoCliente;
			return this;
		}

		public BuilderCompraNotaRegistradaDomainEvent nombreCliente(String nombreCliente) {
			this.nombreCliente = nombreCliente;
			return this;
		}

		public BuilderCompraNotaRegistradaDomainEvent origenId(String origenId) {
			this.origenId = origenId;
			return this;
		}

		public BuilderCompraNotaRegistradaDomainEvent estadoUsoId(String estadoUsoId) {
			this.estadoUsoId = estadoUsoId;
			return this;
		}

		public BuilderCompraNotaRegistradaDomainEvent impuestoUsoId(String impuestoUsoId) {
			this.impuestoUsoId = impuestoUsoId;
			return this;
		}

		public BuilderCompraNotaRegistradaDomainEvent gestionUso(Integer gestionUso) {
			this.gestionUso = gestionUso;
			return this;
		}

		public BuilderCompraNotaRegistradaDomainEvent periodoUso(Integer periodoUso) {
			this.periodoUso = periodoUso;
			return this;
		}

		public BuilderCompraNotaRegistradaDomainEvent nombreFormularioUso(String nombreFormularioUso) {
			this.nombreFormularioUso = nombreFormularioUso;
			return this;
		}

		public BuilderCompraNotaRegistradaDomainEvent formularioId(String formularioId) {
			this.formularioId = formularioId;
			return this;
		}

		public BuilderCompraNotaRegistradaDomainEvent libroId(String libroId) {
			this.libroId = libroId;
			return this;
		}

		public BuilderCompraNotaRegistradaDomainEvent ventaNotaId(String ventaNotaId) {
			this.ventaNotaId = ventaNotaId;
			return this;
		}

		public BuilderCompraNotaRegistradaDomainEvent recepcionId(String recepcionId) {
			this.recepcionId = recepcionId;
			return this;
		}

		public BuilderCompraNotaRegistradaDomainEvent secuencia(Integer secuencia) {
			this.secuencia = secuencia;
			return this;
		}

		public BuilderCompraNotaRegistradaDomainEvent tipoObservacionId(String tipoObservacionId) {
			this.tipoObservacionId = tipoObservacionId;
			return this;
		}

		public BuilderCompraNotaRegistradaDomainEvent usuarioRegistro(Long usuarioRegistro) {
			this.usuarioRegistro = usuarioRegistro;
			return this;
		}

		public BuilderCompraNotaRegistradaDomainEvent fechaRegistro(LocalDateTime fechaRegistro) {
			this.fechaRegistro = fechaRegistro;
			return this;
		}

		public BuilderCompraNotaRegistradaDomainEvent usuarioUltimaModificacion(Long usuarioUltimaModificacion) {
			this.usuarioUltimaModificacion = usuarioUltimaModificacion;
			return this;
		}

		public BuilderCompraNotaRegistradaDomainEvent fechaUltimaModificacion(LocalDateTime fechaUltimaModificacion) {
			this.fechaUltimaModificacion = fechaUltimaModificacion;
			return this;
		}

		public BuilderCompraNotaRegistradaDomainEvent estadoId(String estadoId) {
			this.estadoId = estadoId;
			return this;
		}
  
    }
}
