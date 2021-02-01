package bo.gob.sin.sre.fac.frvcc.misfacturas.shared.domain.formularios;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

import bo.gob.sin.sre.fac.frvcc.shared.model.Utils;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.DomainEvent;

public class FormularioDeclaradoCanceladoEventDomain extends DomainEvent {

    private final String estadoFormularioId;

    private final LocalDateTime fechaUltimaModificacion;
    private final Long usuarioUltimaModificacion;

    private final Long usuarioUltimaModificacionActual;


    public FormularioDeclaradoCanceladoEventDomain() {

        this.estadoFormularioId = null;

        this.fechaUltimaModificacion = null;
        this.usuarioUltimaModificacion = null;

        this.usuarioUltimaModificacionActual = null;
    }

    public FormularioDeclaradoCanceladoEventDomain(String aggregateId,
                                                   String estadoFormularioId,

                                                   LocalDateTime fechaUltimaModificacion,
                                                   Long usuarioUltimaModificacion,

                                                   Long usuarioUltimaModificacionActual) {
        super(aggregateId);

        this.estadoFormularioId = estadoFormularioId;

        this.fechaUltimaModificacion = fechaUltimaModificacion;
        this.usuarioUltimaModificacion = usuarioUltimaModificacion;

        this.usuarioUltimaModificacionActual = usuarioUltimaModificacionActual;
    }

    public FormularioDeclaradoCanceladoEventDomain(String aggregateId, String eventId, String occurredOn,
                                                   String estadoFormularioId,

                                                   LocalDateTime fechaUltimaModificacion,
                                                   Long usuarioUltimaModificacion,

                                                   Long usuarioUltimaModificacionActual) {
        super(aggregateId, eventId, occurredOn);
        this.estadoFormularioId = estadoFormularioId;
        this.fechaUltimaModificacion = fechaUltimaModificacion;
        this.usuarioUltimaModificacion = usuarioUltimaModificacion;

        this.usuarioUltimaModificacionActual = usuarioUltimaModificacionActual;
    }

    @Override
    public String eventName() {
        return "formularios.delcaracion_cancelada";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<String, Serializable>() {{
            put("estadoFormularioId", getEstadoFormularioId());
            put("fechaUltimaModificacion", Utils.localDateTimeToString(getFechaUltimaModificacion()));
            put("usuarioUltimaModificacion", getUsuarioUltimaModificacion());
            put("usuarioUltimaModificacionActual", getUsuarioUltimaModificacionActual());

        }};
    }



    @Override
    public DomainEvent fromPrimitives(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return new FormularioDeclaradoCanceladoEventDomain(
                aggregateId,
                eventId,
                occurredOn,
                (String) body.get("estadoFormularioId"),
                Utils.stringToLocalDateTime((String) (body.get("fechaUltimaModificacion"))),
                Long.parseLong(body.get("usuarioUltimaModificacion").toString()),
                Long.parseLong(body.get("usuarioUltimaModificacionActual").toString())
        );
    }




    public String getEstadoFormularioId() {
        return estadoFormularioId;
    }

    public LocalDateTime getFechaUltimaModificacion() {
        return fechaUltimaModificacion;
    }

    public Long getUsuarioUltimaModificacion() {
        return usuarioUltimaModificacion;
    }

    public Long getUsuarioUltimaModificacionActual() {
        return usuarioUltimaModificacionActual;
    }
}
