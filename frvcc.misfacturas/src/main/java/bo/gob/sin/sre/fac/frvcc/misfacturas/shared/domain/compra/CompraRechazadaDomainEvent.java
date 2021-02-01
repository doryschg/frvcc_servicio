package bo.gob.sin.sre.fac.frvcc.misfacturas.shared.domain.compra;

import bo.gob.sin.sre.fac.frvcc.shared.model.Utils;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.DomainEvent;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;

public class CompraRechazadaDomainEvent extends DomainEvent {

    private final String estadoUsoId;
    private final Long usuarioUltimaModificacion;
    private final LocalDateTime fechaUltimaModificacion;

    public CompraRechazadaDomainEvent(){
        this.estadoUsoId= null;
        this.usuarioUltimaModificacion= null;
        this.fechaUltimaModificacion= null;
    }
    public CompraRechazadaDomainEvent(String aggregateId, String estadoUsoId,
                                      Long usuarioUltimaModificacion,
                                      LocalDateTime fechaUltimaModificacion) {
        super(aggregateId);
        this.estadoUsoId = estadoUsoId;
        this.usuarioUltimaModificacion= usuarioUltimaModificacion;
        this.fechaUltimaModificacion= fechaUltimaModificacion;

    }

    public CompraRechazadaDomainEvent(String aggregateId, String eventId, String occurredOn, String estadoUsoId,
                                      Long usuarioUltimaModificacion,
                                      LocalDateTime fechaUltimaModificacion) {
        super(aggregateId,eventId,occurredOn);
        this.estadoUsoId = estadoUsoId;
        this.usuarioUltimaModificacion= usuarioUltimaModificacion;
        this.fechaUltimaModificacion= fechaUltimaModificacion;

    }


    @Override
    public String eventName() {
        return "compra.rechazada";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap(){{
            put("estadoUsoId",getEstadoUsoId());
            put("usuarioUltimaModificacion",getUsuarioUltimaModificacion());
            put("fechaUltimaModificacion",Utils.localDateTimeToString(getFechaUltimaModificacion()));
        }} ;
    }

    public String getEstadoUsoId() {
        return estadoUsoId;
    }

    public Long getUsuarioUltimaModificacion() {
        return usuarioUltimaModificacion;
    }

    public LocalDateTime getFechaUltimaModificacion() {
        return fechaUltimaModificacion;
    }

    @Override
    public DomainEvent fromPrimitives(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return new CompraRechazadaDomainEvent(
                aggregateId,
                eventId,
                occurredOn,
                (String) body.get("estadoUsoId"),
                Long.parseLong(body.get("usuarioUltimaModificacion").toString()),
                Utils.stringToLocalDateTime(body.get("fechaUltimaModificacion").toString())
        );

    }
}
