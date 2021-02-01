package bo.gob.sin.sre.fac.frvcc.misfacturas.shared.domain.formularios;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

import bo.gob.sin.sre.fac.frvcc.shared.model.Utils;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.DomainEvent;

public class FormularioAnexoRectificadoDeclaradoEventDomain extends DomainEvent {

    private final Long numeroOrden;
    private final String estadoFormularioId;
    private final LocalDate fechaPresentacion;
    private final BigDecimal determinacionPago;
    private final LocalDateTime fechaUltimaModificacion;
    private final Long usuarioUltimaModificacion;
    private final BigDecimal totalComprasCfIpn;
    private final BigDecimal totalComprasCfOtras;
    private final BigDecimal totalComprasSdCf;
    private final List<String> comprasId;
    private final String idFormularioRectificado;

    public FormularioAnexoRectificadoDeclaradoEventDomain() {
        this.comprasId = null;
        this.estadoFormularioId = null;
        this.fechaPresentacion = null;
        this.determinacionPago = null;
        this.fechaUltimaModificacion = null;
        this.usuarioUltimaModificacion = null;
        this.numeroOrden= null;
        this.totalComprasCfIpn= null;
        this.totalComprasCfOtras=null;
        this.totalComprasSdCf=null;
        this.idFormularioRectificado=null;
    }

    public FormularioAnexoRectificadoDeclaradoEventDomain(String aggregateId,
                                          Long numeroOrden,
                                          String estadoFormularioId,
                                          LocalDate fechaPresentacion,
                                          BigDecimal determinacionPago,
                                          LocalDateTime fechaUltimaModificacion,
                                          Long usuarioUltimaModificacion,   
                                          BigDecimal totalComprasCfIpn,
                                          BigDecimal totalComprasCfOtras,
                                          BigDecimal totalComprasSdCf,
                                          List<String> comprasId,String idFormularioRectificado) {
        super(aggregateId);
        this.numeroOrden = numeroOrden;
        this.estadoFormularioId = estadoFormularioId;
        this.fechaPresentacion = fechaPresentacion;
        this.determinacionPago = determinacionPago;
        this.fechaUltimaModificacion = fechaUltimaModificacion;
        this.usuarioUltimaModificacion = usuarioUltimaModificacion;
        this.totalComprasCfIpn= totalComprasCfIpn;
        this.totalComprasCfOtras=totalComprasCfOtras;
        this.totalComprasSdCf= totalComprasSdCf;
        this.comprasId = comprasId;
        this.idFormularioRectificado=idFormularioRectificado;
    }

    public FormularioAnexoRectificadoDeclaradoEventDomain(String aggregateId, String eventId, String occurredOn,
                                          Long numeroOrden,
                                          String estadoFormularioId,
                                          LocalDate fechaPresentacion,
                                          BigDecimal determinacionPago,
                                          LocalDateTime fechaUltimaModificacion,
                                          Long usuarioUltimaModificacion,  
                                          BigDecimal totalComprasCfIpn,
                                          BigDecimal totalComprasCfOtras,
                                          BigDecimal totalComprasSdCf,
                                          List<String> comprasId,
                                          String idFormularioRectificado) {
        super(aggregateId, eventId, occurredOn);
        this.numeroOrden = numeroOrden;
        this.estadoFormularioId = estadoFormularioId;
        this.fechaPresentacion = fechaPresentacion;
        this.determinacionPago = determinacionPago;
        this.fechaUltimaModificacion = fechaUltimaModificacion;
        this.usuarioUltimaModificacion = usuarioUltimaModificacion;
        this.totalComprasCfIpn= totalComprasCfIpn;
        this.totalComprasCfOtras=totalComprasCfOtras;
        this.totalComprasSdCf= totalComprasSdCf;
        this.comprasId = comprasId;
        this.idFormularioRectificado=idFormularioRectificado;
    }

    @Override
    public String eventName() {
        return "habilitacion.rectificacion.formulario.anexo";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<String, Serializable>() {{
            put("numeroOrden", getNumeroOrden());
            put("estadoFormularioId", getEstadoFormularioId());
            put("fechaPresentacion", Utils.localDateToString(getFechaPresentacion()));
            put("determinacionPago", getDeterminacionPago());
            put("fechaUltimaModificacion", Utils.localDateTimeToString(getFechaUltimaModificacion()));
            put("usuarioUltimaModificacion", getUsuarioUltimaModificacion());
            put("totalComprasCfIpn", getTotalComprasCfIpn());
            put("totalComprasCfOtras", getTotalComprasCfOtras());
            put("totalComprasSdCf", getTotalComprasSdCf());
            put("comprasId", getComprasId().toArray());
            put("idFormularioRectificado", getIdFormularioRectificado());
        }};
    }


	@Override
    public DomainEvent fromPrimitives(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return new FormularioAnexoRectificadoDeclaradoEventDomain(
                aggregateId,
                eventId,
                occurredOn,
                Long.parseLong(body.get("numeroOrden").toString()),
                (String) body.get("estadoFormularioId"),
                Utils.stringToLocalDate((String) body.get("fechaPresentacion")),
                new BigDecimal(body.get("determinacionPago").toString()),
                Utils.stringToLocalDateTime((String)(body.get("fechaUltimaModificacion"))),
                Long.parseLong(body.get("usuarioUltimaModificacion").toString()),
                (BigDecimal) body.get("totalComprasCfIpn"),
                (BigDecimal) body.get("totalComprasCfOtras"),
                (BigDecimal) body.get("totalComprasSdCf"), 
                (List<String>) body.get("comprasId"),
                (String)body.get("idFormularioRectificado")
                );
    }

    public Long getNumeroOrden() {
        return numeroOrden;
    }

    public String getEstadoFormularioId() {
        return estadoFormularioId;
    }

    public LocalDate getFechaPresentacion() {
        return fechaPresentacion;
    }

    public BigDecimal getDeterminacionPago() {
        return determinacionPago;
    }

    public LocalDateTime getFechaUltimaModificacion() {
        return fechaUltimaModificacion;
    }

    public Long getUsuarioUltimaModificacion() {
        return usuarioUltimaModificacion;
    }

    public BigDecimal getTotalComprasCfIpn() {
        return totalComprasCfIpn;
    }

    public BigDecimal getTotalComprasCfOtras() {
        return totalComprasCfOtras;
    }

    public BigDecimal getTotalComprasSdCf() {
        return totalComprasSdCf;
    }

    public List<String> getComprasId() {
        return comprasId;
    }

    public String getIdFormularioRectificado() {
        return idFormularioRectificado;
    }
}