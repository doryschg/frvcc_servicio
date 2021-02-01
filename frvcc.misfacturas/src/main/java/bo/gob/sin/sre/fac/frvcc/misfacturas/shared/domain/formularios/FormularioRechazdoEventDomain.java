package bo.gob.sin.sre.fac.frvcc.misfacturas.shared.domain.formularios;


import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.DatosEspecificos;
import bo.gob.sin.sre.fac.frvcc.shared.model.Utils;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.DomainEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;


public final class FormularioRechazdoEventDomain extends DomainEvent {


    private final String estadoFormularioId;
    private final LocalDateTime fechaUltimaModificacion;
    private final Long usuarioUltimaModificacion;
    private final Long usuarioUltimaModificacionActual;
    private final String loginUsuarioReceptor;
    private final String nombreReceptor;
    private final Long usuarioReceptor;
    private final DatosEspecificos datosEspecificos;


    public FormularioRechazdoEventDomain() {

        this.estadoFormularioId = null;
        this.fechaUltimaModificacion = null;
        this.usuarioUltimaModificacion = null;
        this.usuarioUltimaModificacionActual = null;
        this.loginUsuarioReceptor = null;
        this.nombreReceptor = null;
        this.usuarioReceptor = null;
        this.datosEspecificos=null;


    }

    public FormularioRechazdoEventDomain(String aggregateId,

                                         String estadoFormularioId,

                                         LocalDateTime fechaUltimaModificacion,
                                         Long usuarioUltimaModificacion,
                                         Long usuarioUltimaModificacionActual,
                                         String loginUsuarioReceptor,
                                         String nombreReceptor,
                                         Long usuarioReceptor,
                                         DatosEspecificos datosEspecificos) {
        super(aggregateId);

        this.estadoFormularioId = estadoFormularioId;
        this.fechaUltimaModificacion = fechaUltimaModificacion;
        this.usuarioUltimaModificacion = usuarioUltimaModificacion;
        this.usuarioUltimaModificacionActual = usuarioUltimaModificacionActual;
        this.loginUsuarioReceptor = loginUsuarioReceptor;
        this.nombreReceptor = nombreReceptor;
        this.usuarioReceptor = usuarioReceptor;
        this.datosEspecificos=datosEspecificos;
    }

    public FormularioRechazdoEventDomain(String aggregateId, String eventId, String occurredOn,
                                         String estadoFormularioId,
                                         LocalDateTime fechaUltimaModificacion,
                                         Long usuarioUltimaModificacion,
                                         Long usuarioUltimaModificacionActual,
                                         String loginUsuarioReceptor,
                                         String nombreReceptor,
                                         Long usuarioReceptor,
                                         DatosEspecificos datosEspecificos
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
        this.datosEspecificos=datosEspecificos;
    }

    @Override
    public String eventName() {
        return "formularios.rechazado";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        String vDatosEspecificos = null;
        try {
            vDatosEspecificos =  (new ObjectMapper()).writeValueAsString(getDatosEspecificos());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        String finalVDatosEspecificos = vDatosEspecificos;
        return new HashMap<>() {{
            put("estadoFormularioId", getEstadoFormularioId());
            put("fechaUltimaModificacion", Utils.localDateTimeToString(getFechaUltimaModificacion()));
            put("usuarioUltimaModificacion", getUsuarioUltimaModificacion());
            put("usuarioUltimaModificacionActual", getUsuarioUltimaModificacionActual());
            put("loginUsuarioReceptor", getLoginUsuarioReceptor());
            put("nombreReceptor", getNombreReceptor());
            put("usuarioReceptor", getUsuarioReceptor());
            put("datosEspecificos", finalVDatosEspecificos);


        }};
    }

    @Override
    public DomainEvent fromPrimitives(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        ObjectMapper mapper= new ObjectMapper();
        DatosEspecificos vDatosEspecificos = null;
        try {
            vDatosEspecificos = mapper.readValue(body.get("datosEspecificos").toString(), DatosEspecificos.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new FormularioRechazdoEventDomain(
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
                vDatosEspecificos
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

    public DatosEspecificos getDatosEspecificos() {
        return datosEspecificos;
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
}
