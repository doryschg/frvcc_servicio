package bo.gob.sin.sre.fac.frvcc.misfacturas.shared.domain.compra_nota;

import bo.gob.sin.sre.fac.frvcc.shared.model.Utils;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.DomainEvent;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;

public final class CompraNotaDesAsociadaLibroDomainEvent extends DomainEvent {
    private final String libroId;
    private final Long usuarioUltimaModificacion;
    private final LocalDateTime fechaUltimaModificacion;
    private final BigDecimal importeTotalNota;
    private final BigDecimal creditoFiscalNota;

    public CompraNotaDesAsociadaLibroDomainEvent(String aggregateId, String libroId, Long usuarioUltimaModificacion, LocalDateTime fechaUltimaModificacion, BigDecimal importeTotalNota, BigDecimal creditoFiscalNota) {
        super(aggregateId);
        this.libroId = libroId;
        this.usuarioUltimaModificacion = usuarioUltimaModificacion;
        this.fechaUltimaModificacion = fechaUltimaModificacion;
        this.importeTotalNota = importeTotalNota;
        this.creditoFiscalNota=creditoFiscalNota;
    }

    public CompraNotaDesAsociadaLibroDomainEvent(String aggregateId, String eventId, String occurredOn, String libroId, Long usuarioUltimaModificacion, LocalDateTime fechaUltimaModificacion,  BigDecimal importeTotalNota, BigDecimal creditoFiscalNota) {
        super(aggregateId, eventId, occurredOn);
        this.libroId = libroId;
        this.usuarioUltimaModificacion = usuarioUltimaModificacion;
        this.fechaUltimaModificacion = fechaUltimaModificacion;
        this.importeTotalNota = importeTotalNota;
        this.creditoFiscalNota=creditoFiscalNota;
    }

    public CompraNotaDesAsociadaLibroDomainEvent() {
        this.libroId = null;
        this.usuarioUltimaModificacion = null;
        this.fechaUltimaModificacion = null;
        this.importeTotalNota = null;
        this.creditoFiscalNota=null;
    }

    @Override
    public String eventName() {
        return "compra.nota.desasociada.libro";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<>(){{
            put("libroId", libroId);
            put("usuarioUltimaModificacion", usuarioUltimaModificacion);
            put("fechaUltimaModificacion",  Utils.localDateTimeToString(fechaUltimaModificacion));
            put("importeTotalNota",importeTotalNota);
            put("creditoFiscalNota",creditoFiscalNota);


        }} ;
    }

    @Override
    public DomainEvent fromPrimitives(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return new CompraNotaDesAsociadaLibroDomainEvent(
                aggregateId,
                eventId,
                occurredOn,
                (String) body.get("libroId"),
                Long.parseLong(body.get("usuarioUltimaModificacion").toString()),
                Utils.stringToLocalDateTime(body.get("fechaUltimaModificacion").toString()),
                new BigDecimal(body.get("importeTotalNota").toString()),
                new BigDecimal(body.get("creditoFiscalNota").toString()));

    }

    
    public String getLibroId()
    {
    	return libroId;
    }
    public BigDecimal getCreditoFiscalNota() {
		return creditoFiscalNota;
	}

	public BigDecimal getImporteTotalNota() {
        return importeTotalNota;
    }

    public Long getUsuarioUltimaModificacion() {
        return usuarioUltimaModificacion;
    }

    public LocalDateTime getFechaUltimaModificacion() {
        return fechaUltimaModificacion;
    }
}
