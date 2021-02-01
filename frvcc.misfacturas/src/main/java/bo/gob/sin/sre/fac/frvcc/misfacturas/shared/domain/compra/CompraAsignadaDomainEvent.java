package bo.gob.sin.sre.fac.frvcc.misfacturas.shared.domain.compra;

import bo.gob.sin.sre.fac.frvcc.shared.model.Utils;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.DomainEvent;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;

public final class CompraAsignadaDomainEvent extends DomainEvent {
    private final String formularioId;
    private final String estadoUsoId;
    private final Integer periodoUso;
    private final Integer gestionUso;
    private final String impuestoUsoId;
    private final Long usuarioUltimaModificacion;
    private final LocalDateTime fechaUltimaModificacion;
    private final String nombreFormularioUso;
    private final BigDecimal importeBaseCf;
    private final BigDecimal creditoFiscal;
    private final BigDecimal importeTotalCompra;
    private final String marcaEspecialId;
    private final String modalidadId;

    public CompraAsignadaDomainEvent(String aggregateId,
                                     String formularioId,
                                     String estadoUsoId,
                                     Integer periodoUso,
                                     Integer gestionUso,
                                     String impuestoUsoId,
                                     Long usuarioUltimaModificacion,
                                     LocalDateTime fechaUltimaModificacion,
                                     String nombreFormularioUso,
                                     BigDecimal importeBaseCf,
                                     BigDecimal creditoFiscal,
                                     BigDecimal importeTotalCompra,
                                     String marcaEspecialId,
                                     String modalidadId) {
        super(aggregateId);
        this.formularioId = formularioId;
        this.estadoUsoId = estadoUsoId;
        this.periodoUso = periodoUso;
        this.gestionUso = gestionUso;
        this.impuestoUsoId = impuestoUsoId;
        this.usuarioUltimaModificacion = usuarioUltimaModificacion;
        this.fechaUltimaModificacion = fechaUltimaModificacion;
        this.nombreFormularioUso = nombreFormularioUso;
        this.importeBaseCf = importeBaseCf;
        this.creditoFiscal=creditoFiscal;
        this.importeTotalCompra=importeTotalCompra;
        this.marcaEspecialId=marcaEspecialId;
        this.modalidadId=modalidadId;
    }

    public CompraAsignadaDomainEvent(String aggregateId, String eventId, String occurredOn, String formularioId, String estadoUsoId, Integer periodoUso, Integer gestionUso, String impuestoUsoId, Long usuarioUltimaModificacion, LocalDateTime fechaUltimaModificacion, String nombreFormularioUso, BigDecimal importeBaseCf, BigDecimal creditoFiscal
    		,BigDecimal importeTotalCompra,String marcaEspecialId,String modalidadId) {
        super(aggregateId, eventId, occurredOn);
        this.formularioId = formularioId;
        this.estadoUsoId = estadoUsoId;
        this.periodoUso = periodoUso;
        this.gestionUso = gestionUso;
        this.impuestoUsoId = impuestoUsoId;
        this.usuarioUltimaModificacion = usuarioUltimaModificacion;
        this.fechaUltimaModificacion = fechaUltimaModificacion;
        this.nombreFormularioUso = nombreFormularioUso;
        this.importeBaseCf = importeBaseCf;
        this.creditoFiscal=creditoFiscal;
        this.importeTotalCompra=importeTotalCompra;
        this.marcaEspecialId=marcaEspecialId;
        this.modalidadId=modalidadId;
    }

    public CompraAsignadaDomainEvent() {
        this.formularioId = null;
        this.estadoUsoId = null;
        this.periodoUso = null;
        this.gestionUso = null;
        this.impuestoUsoId = null;
        this.usuarioUltimaModificacion = null;
        this.fechaUltimaModificacion = null;
        this.nombreFormularioUso = null;
        this.importeBaseCf = null;
        this.creditoFiscal=null;
        this.importeTotalCompra=null;
        this.marcaEspecialId=null;
        this.modalidadId=null;
        
    }

    @Override
    public String eventName() {
        return "compra.asignada";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<String, Serializable>(){{
            put("formularioId", formularioId);
            put("estadoUsoId", estadoUsoId);
            put("periodoUso", periodoUso);
            put("gestionUso",gestionUso);
            put("impuestoUsoId", impuestoUsoId);
            put("usuarioUltimaModificacion", usuarioUltimaModificacion);
            put("fechaUltimaModificacion",  Utils.localDateTimeToString(fechaUltimaModificacion));
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
        return new CompraAsignadaDomainEvent(
                aggregateId,
                eventId,
                occurredOn,
                (String) body.get("formularioId"),
                (String)body.get("estadoUsoId"),
                (Integer) body.get("periodoUso"),
                (Integer) body.get("gestionUso"),
                (String)(body.get("impuestoUsoId")),
                Long.parseLong(body.get("usuarioUltimaModificacion").toString()),
              Utils.stringToLocalDateTime(body.get("fechaUltimaModificacion").toString()),
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

    public String getNombreFormularioUso() {
        return nombreFormularioUso;
    }

    public String getFormularioId() {
        return formularioId;
    }

    public String getEstadoUsoId() {
        return estadoUsoId;
    }

    public Integer getPeriodoUso() {
        return periodoUso;
    }

    public Integer getGestionUso() {
        return gestionUso;
    }

    public String getImpuestoUsoId() {
        return impuestoUsoId;
    }

    public Long getUsuarioUltimaModificacion() {
        return usuarioUltimaModificacion;
    }

    public LocalDateTime getFechaUltimaModificacion() {
        return fechaUltimaModificacion;
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
    
}
