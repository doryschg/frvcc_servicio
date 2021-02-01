package bo.gob.sin.sre.fac.frvcc.misfacturas.shared.domain.compra;

import bo.gob.sin.sre.fac.frvcc.shared.model.Utils;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.DomainEvent;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;

public final class CompraDesAsociadaLibroDomainEvent extends DomainEvent {
	private final String libroId;
    private final Long usuarioUltimaModificacion;
    private final LocalDateTime fechaUltimaModificacion;
    
    private final String estadoUsoId;
    private final Integer periodoUso;
    private final Integer gestionUso;
    private final String impuestoUsoId;
    private final String nombreFormularioUso;
    
    private final BigDecimal importeBaseCf;
    private final BigDecimal creditoFiscal;
    private final BigDecimal importeTotalCompra;
    private final String marcaEspecialId;
    private final String modalidadId;

    public CompraDesAsociadaLibroDomainEvent(String aggregateId, String libroId, Long usuarioUltimaModificacion, LocalDateTime fechaUltimaModificacion,
   		 String estadoUsoId, Integer periodoUso, Integer gestionUso, String impuestoUsoId,String nombreFormularioUso,
   		BigDecimal importeBaseCf, BigDecimal creditoFiscal
   		,BigDecimal importeTotalCompra,String marcaEspecialId,String modalidadId) {
       super(aggregateId);
       this.libroId = libroId;
       this.usuarioUltimaModificacion = usuarioUltimaModificacion;
       this.fechaUltimaModificacion = fechaUltimaModificacion;
       this.importeBaseCf = importeBaseCf;
       this.creditoFiscal=creditoFiscal;
       this.importeTotalCompra=importeTotalCompra;
       this.marcaEspecialId=marcaEspecialId;
       this.modalidadId=modalidadId;
       this.estadoUsoId = estadoUsoId;
       this.periodoUso = periodoUso;
       this.gestionUso = gestionUso;
       this.impuestoUsoId = impuestoUsoId;
       this.nombreFormularioUso = nombreFormularioUso;
    }

    public CompraDesAsociadaLibroDomainEvent(String aggregateId, String eventId, String occurredOn, String libroId, Long usuarioUltimaModificacion, LocalDateTime fechaUltimaModificacion,
    		String estadoUsoId, Integer periodoUso, Integer gestionUso, String impuestoUsoId,String nombreFormularioUso,
    		BigDecimal importeBaseCf, BigDecimal creditoFiscal,BigDecimal importeTotalCompra,String marcaEspecialId,String modalidadId) {
        super(aggregateId, eventId, occurredOn);
        this.libroId = libroId;
        this.usuarioUltimaModificacion = usuarioUltimaModificacion;
        this.fechaUltimaModificacion = fechaUltimaModificacion;
        this.importeBaseCf = importeBaseCf;
        this.creditoFiscal=creditoFiscal;
        this.importeTotalCompra=importeTotalCompra;
        this.marcaEspecialId=marcaEspecialId;
        this.modalidadId=modalidadId;
        this.estadoUsoId = estadoUsoId;
        this.periodoUso = periodoUso;
        this.gestionUso = gestionUso;
        this.impuestoUsoId = impuestoUsoId;
        this.nombreFormularioUso = nombreFormularioUso;
    }

    public CompraDesAsociadaLibroDomainEvent() {
    	this.libroId = null;
        this.usuarioUltimaModificacion = null;
        this.fechaUltimaModificacion = null;
        this.importeBaseCf = null;
        this.creditoFiscal=null;
        this.importeTotalCompra=null;
        this.marcaEspecialId=null;
        this.modalidadId=null;
        this.estadoUsoId = null;
        this.periodoUso = null;
        this.gestionUso = null;
        this.impuestoUsoId = null;
        this.nombreFormularioUso = null;
    }

    @Override
    public String eventName() {
        return "compra.desasociada.libro";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<>(){{
        	put("libroId", libroId);
            put("usuarioUltimaModificacion", usuarioUltimaModificacion);
            put("fechaUltimaModificacion",  Utils.localDateTimeToString(fechaUltimaModificacion));
            put("estadoUsoId", estadoUsoId);
            put("periodoUso", periodoUso);
            put("gestionUso",gestionUso);
            put("impuestoUsoId", impuestoUsoId);
            put("nombreFormularioUso",nombreFormularioUso);
            put("importeBaseCf",importeBaseCf);
            put("creditoFiscal",creditoFiscal);
            put("importeTotalCompra",importeTotalCompra);
            put("marcaEspecialId",marcaEspecialId);
            put("modalidadId",modalidadId);


        }} ;
    }

    @Override
    public DomainEvent fromPrimitives(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return new CompraDesAsociadaLibroDomainEvent(
        		aggregateId,
                eventId,
                occurredOn,
                (String) body.get("libroId"),
                Long.parseLong(body.get("usuarioUltimaModificacion").toString()),
                Utils.stringToLocalDateTime(body.get("fechaUltimaModificacion").toString()),
                (String)body.get("estadoUsoId"),
                (Integer) body.get("periodoUso"),
                (Integer) body.get("gestionUso"),
                (String)(body.get("impuestoUsoId")),
                (String) (body.get("nombreFormularioUso")),
                 new BigDecimal(body.get("importeBaseCf").toString()),
                 new BigDecimal(body.get("creditoFiscal").toString()),
        		new BigDecimal(body.get("importeTotalCompra").toString()),
        		(String) body.get("marcaEspecialId"),
        		(String)body.get("modalidadId"));

    }

    
    public BigDecimal getCreditoFiscal() {
		return creditoFiscal;
	}

	public BigDecimal getImporteBaseCf() {
        return importeBaseCf;
    }
	
	
  

    public BigDecimal getImporteTotalCompra() {
		return importeTotalCompra;
	}

	public String getMarcaEspecialId() {
		return marcaEspecialId;
	}

	public String getModalidadId() {
		return modalidadId;
	}

	public String getLibroId() {
        return libroId;
    }

    public Long getUsuarioUltimaModificacion() {
        return usuarioUltimaModificacion;
    }

    public LocalDateTime getFechaUltimaModificacion() {
        return fechaUltimaModificacion;
    }
}
