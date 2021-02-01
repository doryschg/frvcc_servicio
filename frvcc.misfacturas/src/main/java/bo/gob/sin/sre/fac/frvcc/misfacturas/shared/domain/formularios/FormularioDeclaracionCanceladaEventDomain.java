package bo.gob.sin.sre.fac.frvcc.misfacturas.shared.domain.formularios;


import bo.gob.sin.sre.fac.frvcc.shared.model.Utils;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.DomainEvent;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

public  class FormularioDeclaracionCanceladaEventDomain extends DomainEvent {

    private final Long numeroOrden;
    private final String estadoFormularioId;
    private final LocalDate fechaPresentacion;
    private final BigDecimal determinacionPago;
    private final LocalDateTime fechaUltimaModificacion;
    private final Long usuarioUltimaModificacion;
    private final List<String> comprasId;

    public FormularioDeclaracionCanceladaEventDomain() {
        this.comprasId = null;
        this.estadoFormularioId = null;
        this.fechaPresentacion = null;
        this.determinacionPago = null;
        this.fechaUltimaModificacion = null;
        this.usuarioUltimaModificacion = null;
        this.numeroOrden= null;
    }

    public FormularioDeclaracionCanceladaEventDomain(String aggregateId,
                                                     Long numeroOrden,
                                                     String estadoFormularioId,
                                                     LocalDate fechaPresentacion,
                                                     BigDecimal determinacionPago,
                                                     LocalDateTime fechaUltimaModificacion,
                                                     Long usuarioUltimaModificacion, List<String> comprasId) {
        super(aggregateId);
        this.numeroOrden = numeroOrden;
        this.estadoFormularioId = estadoFormularioId;
        this.fechaPresentacion = fechaPresentacion;
        this.determinacionPago = determinacionPago;
        this.fechaUltimaModificacion = fechaUltimaModificacion;
        this.usuarioUltimaModificacion = usuarioUltimaModificacion;
        this.comprasId = comprasId;
    }

    public FormularioDeclaracionCanceladaEventDomain(String aggregateId, String eventId, String occurredOn,
                                                     Long numeroOrden,
                                                     String estadoFormularioId,
                                                     LocalDate fechaPresentacion,
                                                     BigDecimal determinacionPago,
                                                     LocalDateTime fechaUltimaModificacion,
                                                     Long usuarioUltimaModificacion, List<String> comprasId) {
        super(aggregateId, eventId, occurredOn);
        this.numeroOrden = numeroOrden;
        this.estadoFormularioId = estadoFormularioId;
        this.fechaPresentacion = fechaPresentacion;
        this.determinacionPago = determinacionPago;
        this.fechaUltimaModificacion = fechaUltimaModificacion;
        this.usuarioUltimaModificacion = usuarioUltimaModificacion;
        this.comprasId = comprasId;
    }

    @Override
    public String eventName() {
        return "formularios.declaracion_cancelada";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<String, Serializable>() {{
            put("numeroOrden", numeroOrden());
            put("estadoFormularioId", estadoFormularioId());
            put("fechaPresentacion", Utils.localDateToString(fechaPresentacion()));
            put("determinacionPago", determinacionPago());
            put("fechaUltimaModificacion", Utils.localDateTimeToString(fechaUltimaModificacion()));
            put("usuarioUltimaModificacion", usuarioUltimaModificacion());
            put("comprasId", comprasId().toArray());
        }};
    }

    @Override
    public DomainEvent fromPrimitives(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return new FormularioDeclaracionCanceladaEventDomain(
                aggregateId,
                eventId,
                occurredOn,
                (Long) body.get("numeroOrden"),
                (String) body.get("estadoFormularioId"),
                Utils.stringToLocalDate((String) body.get("fechaPresentacion")),
                new BigDecimal(body.get("determinacionPago").toString()),
                Utils.stringToLocalDateTime((String)(body.get("fechaUltimaModificacion"))),
                Long.parseLong(body.get("usuarioUltimaModificacion").toString()),
                (List<String>) body.get(comprasId)
                );
    }

    public List<String> comprasId() {
        return comprasId;
    }

    public Long numeroOrden() {
        return numeroOrden;
    }

    public String estadoFormularioId() {
        return estadoFormularioId;
    }

    public LocalDate fechaPresentacion() {
        return fechaPresentacion;
    }

    public BigDecimal determinacionPago() {
        return determinacionPago;
    }

    public LocalDateTime fechaUltimaModificacion() {
        return fechaUltimaModificacion;
    }

    public Long usuarioUltimaModificacion() {
        return usuarioUltimaModificacion;
    }
}
