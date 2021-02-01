package bo.gob.sin.sre.fac.frvcc.misfacturas.shared.domain.compra;

import bo.gob.sin.sre.fac.frvcc.shared.model.Utils;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.DomainEvent;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;

public class CompraEliminadaDomainEvent extends DomainEvent {
    private final String estadoId;
    private final Long usuarioUltimaModificacion;
    private final LocalDateTime fechaUltimaModificacion;

    public CompraEliminadaDomainEvent(String aggregateId, String estadoId, Long usuarioUltimaModificacion, LocalDateTime fechaUltimaModificacion) {
        super(aggregateId);
        this.estadoId = estadoId;
        this.usuarioUltimaModificacion = usuarioUltimaModificacion;
        this.fechaUltimaModificacion = fechaUltimaModificacion;
    }

    public CompraEliminadaDomainEvent(String aggregateId, String eventId, String occurredOn, String estadoId, Long usuarioUltimaModificacion, LocalDateTime fechaUltimaModificacion) {
        super(aggregateId, eventId, occurredOn);
        this.estadoId = estadoId;
        this.usuarioUltimaModificacion = usuarioUltimaModificacion;
        this.fechaUltimaModificacion = fechaUltimaModificacion;
    }

    public CompraEliminadaDomainEvent() {
        this.estadoId = null;
        this.usuarioUltimaModificacion = null;
        this.fechaUltimaModificacion = null;
    }

    @Override
    public String eventName() {
        return "Compra.Eliminada";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<>(){{
            put("estadoId", getEstadoId());
            put("usuarioUltimaModificacion",getUsuarioUltimaModificacion());
            put("fechaUltimaModificacion", Utils.localDateTimeToString(getFechaUltimaModificacion()));

        }};
    }

    @Override
    public DomainEvent fromPrimitives(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) throws IOException {
        return new CompraEliminadaDomainEvent(aggregateId,eventId,
                occurredOn,
                (String)body.get("estadoId"),
                Long.parseLong(body.get("usuarioUltimaModificacion").toString()),
                Utils.stringToLocalDateTime(body.get("fechaUltimaModificacion").toString())
                );
    }

    public String getEstadoId() {
        return estadoId;
    }

    public Long getUsuarioUltimaModificacion() {
        return usuarioUltimaModificacion;
    }

    public LocalDateTime getFechaUltimaModificacion() {
        return fechaUltimaModificacion;
    }
}
