package bo.gob.sin.sre.fac.frvcc.misfacturas.shared.domain.formularios;


import bo.gob.sin.sre.fac.frvcc.shared.model.Utils;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.DomainEvent;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;


public final class FormularioAceptadoEventDomain extends DomainEvent {


    private final String estadoFormularioId;
    private final LocalDateTime fechaUltimaModificacion;
    private final Long usuarioUltimaModificacion;
    private final Long usuarioUltimaModificacionActual;
    private final String loginUsuarioReceptor;
    private final String nombreReceptor;
    private final Long usuarioReceptor;
    private final String esExDependiente;


    public FormularioAceptadoEventDomain() {

        this.estadoFormularioId = null;
        this.fechaUltimaModificacion = null;
        this.usuarioUltimaModificacion = null;
        this.usuarioUltimaModificacionActual = null;
        this.loginUsuarioReceptor = null;
        this.nombreReceptor = null;
        this.usuarioReceptor = null;
        this.esExDependiente=null;


    }

    public FormularioAceptadoEventDomain(String aggregateId,
                                         String estadoFormularioId,
                                         LocalDateTime fechaUltimaModificacion,
                                         Long usuarioUltimaModificacion,
                                         Long usuarioUltimaModificacionActual,
                                         String loginUsuarioReceptor,
                                         String nombreReceptor,
                                         Long usuarioReceptor,
                                         String esExDependiente
                                         ) {
        super(aggregateId);

        this.estadoFormularioId = estadoFormularioId;
        this.fechaUltimaModificacion = fechaUltimaModificacion;
        this.usuarioUltimaModificacion = usuarioUltimaModificacion;
        this.usuarioUltimaModificacionActual = usuarioUltimaModificacionActual;
        this.loginUsuarioReceptor = loginUsuarioReceptor;
        this.nombreReceptor = nombreReceptor;
        this.usuarioReceptor = usuarioReceptor;
        this.esExDependiente=esExDependiente;

    }

    public FormularioAceptadoEventDomain(String aggregateId, String eventId, String occurredOn,
                                         String estadoFormularioId,
                                         LocalDateTime fechaUltimaModificacion,
                                         Long usuarioUltimaModificacion,
                                         Long usuarioUltimaModificacionActual,
                                         String loginUsuarioReceptor,
                                         String nombreReceptor,
                                         Long usuarioReceptor,
                                         String esExDependiente
                                         ) {
        super(aggregateId, eventId, occurredOn);
      ;
        this.estadoFormularioId = estadoFormularioId;

        this.fechaUltimaModificacion = fechaUltimaModificacion;
        this.usuarioUltimaModificacion = usuarioUltimaModificacion;
        this.usuarioUltimaModificacionActual = usuarioUltimaModificacionActual;
        this.loginUsuarioReceptor = loginUsuarioReceptor;
        this.nombreReceptor = nombreReceptor;
        this.usuarioReceptor = usuarioReceptor;
        this.esExDependiente=esExDependiente;
    }

    @Override
    public String eventName() {
        return "formularios.aceptado";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<>() {{

            put("estadoFormularioId", estadoFormularioId());
            put("fechaUltimaModificacion", Utils.localDateTimeToString(fechaUltimaModificacion()));
            put("usuarioUltimaModificacion", usuarioUltimaModificacion());
            put("usuarioUltimaModificacionActual", usuarioUltimaModificacionActual());
            put("loginUsuarioReceptor", getLoginUsuarioReceptor());
            put("nombreReceptor", getNombreReceptor());
            put("usuarioReceptor", getUsuarioReceptor());
            put("esExDependiente", getEsExDependiente());
        }};
    }

    @Override
    public DomainEvent fromPrimitives(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return new FormularioAceptadoEventDomain(
                aggregateId,
                eventId,
                occurredOn,
                (String) body.get("estadoFormularioId"),
                Utils.stringToLocalDateTime((String)(body.get("fechaUltimaModificacion"))),
                Long.parseLong(body.get("usuarioUltimaModificacion").toString()),
                Long.parseLong(body.get("usuarioUltimaModificacionActual").toString()),
                (String) body.get("loginUsuarioReceptor"),
                (String) body.get("nombreReceptor"),
                (Long) body.get("usuarioReceptor"),
                (String) body.get("esExDependiente")
                );
    }

    public String estadoFormularioId() {
        return estadoFormularioId;
    }



    public LocalDateTime fechaUltimaModificacion() {
        return fechaUltimaModificacion;
    }

    public Long usuarioUltimaModificacion() {
        return usuarioUltimaModificacion;
    }


    public Long usuarioUltimaModificacionActual() {
        return usuarioUltimaModificacionActual;
    }

    public String getLoginUsuarioReceptor() {
        return loginUsuarioReceptor;
    }

    public String getNombreReceptor() {
        return nombreReceptor;
    }

    public Long getUsuarioReceptor() {
        return usuarioReceptor;
    }

    public String getEsExDependiente() {
        return esExDependiente;
    }
}
