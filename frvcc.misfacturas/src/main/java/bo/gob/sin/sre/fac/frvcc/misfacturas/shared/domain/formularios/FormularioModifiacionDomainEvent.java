package bo.gob.sin.sre.fac.frvcc.misfacturas.shared.domain.formularios;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.DatosEspecificos;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioFechaPresentacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioId;
import bo.gob.sin.sre.fac.frvcc.shared.model.Utils;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.DomainEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.DataInput;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;

public final class FormularioModifiacionDomainEvent extends DomainEvent {
    private final String direccion;
    private final String direccionEmpleador;
    private final Long usuarioUltimaModificacion;
    private final Integer lugarDepartamento;
    private final LocalDate fechaPresentacion;
    private final LocalDateTime fechaUltimaModificacion;
    private final DatosEspecificos datosEspecificos;
    private final LocalDate fechaActualPresentacion;
    private final Integer numeroSucursal;

    public FormularioModifiacionDomainEvent() {
        this.direccion = null;
        this.direccionEmpleador = null;
        this.usuarioUltimaModificacion = null;
        this.lugarDepartamento = null;
        this.fechaPresentacion = null;
        this.fechaUltimaModificacion = null;
        this.datosEspecificos = null;
        this.fechaActualPresentacion = null;
        this.numeroSucursal=null;
    }

    public FormularioModifiacionDomainEvent(String aggregateId, String direccion, String direccionEmpleador, Long usuarioUltimaModificacion, Integer lugarDepartamento, LocalDate fechaPresentacion, LocalDateTime fechaUltimaModificacion, DatosEspecificos datosEspecificos, LocalDate fechaActualPresentacion, Integer numeroSucursal) {
        super(aggregateId);
        this.direccion = direccion;
        this.direccionEmpleador = direccionEmpleador;
        this.usuarioUltimaModificacion = usuarioUltimaModificacion;
        this.lugarDepartamento = lugarDepartamento;
        this.fechaPresentacion = fechaPresentacion;
        this.fechaUltimaModificacion = fechaUltimaModificacion;
        this.datosEspecificos = datosEspecificos;
        this.fechaActualPresentacion = fechaActualPresentacion;
        this.numeroSucursal=numeroSucursal;
    }

    public FormularioModifiacionDomainEvent(String aggregateId, String eventId, String occurredOn, String direccion, String direccionEmpleador, Long usuarioUltimaModificacion, Integer lugarDepartamento, LocalDate fechaPresentacion, LocalDateTime fechaUltimaModificacion, DatosEspecificos datosEspecificos, LocalDate fechaActualPresentacion, Integer numeroSucursal) {
        super(aggregateId, eventId,
                occurredOn);
        this.direccion = direccion;
        this.direccionEmpleador = direccionEmpleador;
        this.usuarioUltimaModificacion = usuarioUltimaModificacion;
        this.lugarDepartamento = lugarDepartamento;
        this.fechaPresentacion = fechaPresentacion;
        this.fechaUltimaModificacion = fechaUltimaModificacion;
        this.datosEspecificos = datosEspecificos;
        this.fechaActualPresentacion = fechaActualPresentacion;
        this.numeroSucursal=numeroSucursal;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getDireccionEmpleador() {
        return direccionEmpleador;
    }

    public Long getUsuarioUltimaModificacion() {
        return usuarioUltimaModificacion;
    }

    public Integer getLugarDepartamento() {
        return lugarDepartamento;
    }

    public LocalDate getFechaPresentacion() {
        return fechaPresentacion;
    }

    public LocalDateTime getFechaUltimaModificacion() {
        return fechaUltimaModificacion;
    }

    public DatosEspecificos getDatosEspecificos() {
        return datosEspecificos;
    }

    public LocalDate getFechaActualPresentacion() {
        return fechaActualPresentacion;
    }
    public Integer getNumeroSucursal() {
        return numeroSucursal;
    }

    @Override
    public String eventName() {
        return "Formulario.modificacion";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives()  {
        String vDatosEspecificos = null;
        try {
             vDatosEspecificos =  (new ObjectMapper()).writeValueAsString(getDatosEspecificos());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        String finalVDatosEspecificos = vDatosEspecificos;
        return new HashMap<>() {{
            put("direccion", getDireccion());
            put("direccionEmpleador", getDireccionEmpleador());
            put("usuarioUltimaModificacion", getUsuarioUltimaModificacion());
            put("lugarDepartamento", getLugarDepartamento());
            put("fechaPresentacion", Utils.localDateToString(getFechaPresentacion()));
            put("fechaUltimaModificacion", Utils.localDateTimeToString(getFechaUltimaModificacion()));
            put("datosEspecificos", finalVDatosEspecificos);
            put("fechaActualPresentacion", Utils.localDateToString(getFechaActualPresentacion()));
            put("numeroSucursal", getNumeroSucursal());
        }};

    }

    @Override
    public FormularioModifiacionDomainEvent fromPrimitives(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn)  {
        ObjectMapper mapper= new ObjectMapper();
        DatosEspecificos vDatosEspecificos = null;
        try {
            vDatosEspecificos = mapper.readValue(body.get("datosEspecificos").toString(), DatosEspecificos.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new FormularioModifiacionDomainEvent(aggregateId,
                eventId,
                occurredOn,
                (String) body.get("direccion"),
                (String)  body.get("direccionEmpleador"),
                Long.parseLong(body.get("usuarioUltimaModificacion").toString()),
                (Integer) body.get("lugarDepartamento"),
                Utils.stringToLocalDate(body.get("fechaPresentacion").toString()),
                Utils.stringToLocalDateTime(body.get("fechaUltimaModificacion").toString()),
                vDatosEspecificos,
                Utils.stringToLocalDate(body.get("fechaActualPresentacion").toString()),
                (Integer) body.get("numeroSucursal")
                );
    }
}
