package bo.gob.sin.sre.fac.frvcc.shared.domain.libros;


import bo.gob.sin.sre.fac.frvcc.shared.model.Utils;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.DomainEvent;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

public final class LibroDeclaradoEventDomain extends DomainEvent {

    private final Long numeroOrden;
    private final LocalDateTime fechaPresentacion;
    private final String estadoLibroId;
    private final LocalDateTime fechaUltimaModificacion;
    private final Long usuarioUltimaModificacion;
    private final List<String> comprasId;

    public LibroDeclaradoEventDomain() {
        this.comprasId = null;
        this.fechaPresentacion = null;
        this.estadoLibroId=null;
        this.fechaUltimaModificacion = null;
        this.usuarioUltimaModificacion = null;
        this.numeroOrden= null;
    }

    public LibroDeclaradoEventDomain(String aggregateId,
                                          Long numeroOrden,
                                          LocalDateTime fechaPresentacion,
                                          String estadoLibroId,
                                          LocalDateTime fechaUltimaModificacion,
                                          Long usuarioUltimaModificacion, List<String> comprasId) {
        super(aggregateId);
        this.numeroOrden = numeroOrden;
        this.fechaPresentacion = fechaPresentacion;
        this.estadoLibroId=estadoLibroId;
        this.fechaUltimaModificacion = fechaUltimaModificacion;
        this.usuarioUltimaModificacion = usuarioUltimaModificacion;
        this.comprasId = comprasId;
    }

    public LibroDeclaradoEventDomain(String aggregateId, String eventId, String occurredOn,
                                          Long numeroOrden,
                                          LocalDateTime fechaPresentacion,
                                          String estadoLibroId,
                                          LocalDateTime fechaUltimaModificacion,
                                          Long usuarioUltimaModificacion,  List<String> comprasId) {
        super(aggregateId, eventId, occurredOn);
        this.numeroOrden = numeroOrden;
        this.fechaPresentacion = fechaPresentacion;
        this.estadoLibroId = estadoLibroId;
        this.fechaUltimaModificacion = fechaUltimaModificacion;
        this.usuarioUltimaModificacion = usuarioUltimaModificacion;
        this.comprasId = comprasId;
    }

    @Override
    public String eventName() {
        return "libros.declarado";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<String, Serializable>() {{
            put("numeroOrden", numeroOrden());
            put("fechaPresentacion", Utils.localDateTimeToString(fechaPresentacion()));
            put("estadoLibroId", estadoLibroId());
            put("fechaUltimaModificacion", Utils.localDateTimeToString(fechaUltimaModificacion()));
            put("usuarioUltimaModificacion", usuarioUltimaModificacion());
            put("comprasId", comprasId().toArray());
        }};
    }

    @Override
    public DomainEvent fromPrimitives(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return new LibroDeclaradoEventDomain(
                aggregateId,
                eventId,
                occurredOn,
                Long.parseLong(body.get("numeroOrden").toString()),
                Utils.stringToLocalDateTime((String) body.get("fechaPresentacion")),
                (String) body.get("estadoLibroId"),
                Utils.stringToLocalDateTime((String)(body.get("fechaUltimaModificacion"))),
                Long.parseLong(body.get("usuarioUltimaModificacion").toString()),
                (List<String>) body.get("comprasId")
                );
    }

    public List<String> comprasId() {
        return comprasId;
    }

    public Long numeroOrden() {
        return numeroOrden;
    }

    public String estadoLibroId() {
        return estadoLibroId;
    }

    public LocalDateTime fechaPresentacion() {
        return fechaPresentacion;
    }

  
    public LocalDateTime fechaUltimaModificacion() {
        return fechaUltimaModificacion;
    }

    public Long usuarioUltimaModificacion() {
        return usuarioUltimaModificacion;
    }
}
