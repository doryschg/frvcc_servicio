package bo.gob.sin.sre.fac.frvcc.misfacturas.shared.domain.formularios;


import bo.gob.sin.sre.fac.frvcc.shared.model.Utils;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.DomainEvent;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

public class FormularioDeclaradoEventDomain extends DomainEvent {

    private final Long numeroOrden;
    private final String estadoFormularioId;
    private final LocalDateTime fechaUltimaModificacion;
    private final Long usuarioUltimaModificacion;
    private final Integer numeroEnvio;
    private final BigInteger totalComprasCfRed;
    private final BigInteger totalComprasCfIpnRed;
    private final BigInteger totalComprasCfOtrasRed;
    private final BigInteger totalComprasSdCfRed;
    private final BigInteger determinacionPagoCfRed;
    private final BigInteger determinacionPagoCfIpnRed;
    private final BigInteger determinacionPagoCfOtrasRed;
    private final BigInteger determinacionPagoSdCfRed;
    private final Long usuarioUltimaModificacionActual;

    public FormularioDeclaradoEventDomain() {

        this.estadoFormularioId = null;

        this.fechaUltimaModificacion = null;
        this.usuarioUltimaModificacion = null;
        this.numeroOrden = null;

        this.numeroEnvio = null;
        totalComprasCfRed=null;
        this.totalComprasCfIpnRed = null;
        this.totalComprasCfOtrasRed = null;
        this.totalComprasSdCfRed = null;
        this.determinacionPagoCfRed = null;
        this.determinacionPagoCfIpnRed = null;
        this.determinacionPagoCfOtrasRed = null;
        this.determinacionPagoSdCfRed = null;

        this.usuarioUltimaModificacionActual = null;

    }

    public FormularioDeclaradoEventDomain(String aggregateId,
                                          Long numeroOrden,
                                          String estadoFormularioId,
                                          LocalDateTime fechaUltimaModificacion,
                                          Long usuarioUltimaModificacion,
                                          Integer numeroEnvio,
                                          BigInteger totalComprasCfRed,
                                          BigInteger totalComprasCfIpnRed,
                                          BigInteger totalComprasCfOtrasRed,
                                          BigInteger totalComprasSdCfRed,
                                          BigInteger determinacionPagoCfRed,
                                          BigInteger determinacionPagoCfIpnRed,
                                          BigInteger determinacionPagoCfOtrasRed,
                                          BigInteger determinacionPagoSdCfRed,
                                          Long usuarioUltimaModificacionActual
    ) {
        super(aggregateId);
        this.numeroOrden = numeroOrden;
        this.estadoFormularioId = estadoFormularioId;
        this.fechaUltimaModificacion = fechaUltimaModificacion;
        this.usuarioUltimaModificacion = usuarioUltimaModificacion;
        this.numeroEnvio = numeroEnvio;
        this.totalComprasCfRed = totalComprasCfRed;
        this.totalComprasCfIpnRed = totalComprasCfIpnRed;
        this.totalComprasCfOtrasRed = totalComprasCfOtrasRed;
        this.totalComprasSdCfRed = totalComprasSdCfRed;
        this.determinacionPagoCfRed = determinacionPagoCfRed;
        this.determinacionPagoCfIpnRed = determinacionPagoCfIpnRed;
        this.determinacionPagoCfOtrasRed = determinacionPagoCfOtrasRed;
        this.determinacionPagoSdCfRed = determinacionPagoSdCfRed;
        this.usuarioUltimaModificacionActual = usuarioUltimaModificacionActual;
    }

    public FormularioDeclaradoEventDomain(String aggregateId, String eventId, String occurredOn,
                                          Long numeroOrden,
                                          String estadoFormularioId,

                                          LocalDateTime fechaUltimaModificacion,
                                          Long usuarioUltimaModificacion,

                                          Integer numeroEnvio,
                                          BigInteger totalComprasCfRed,
                                          BigInteger totalComprasCfIpnRed,
                                          BigInteger totalComprasCfOtrasRed,
                                          BigInteger totalComprasSdCfRed,
                                          BigInteger determinacionPagoCfRed,
                                          BigInteger determinacionPagoCfIpnRed,
                                          BigInteger determinacionPagoCfOtrasRed,
                                          BigInteger determinacionPagoSdCfRed,
                                          Long usuarioUltimaModificacionActual

    ) {
        super(aggregateId, eventId, occurredOn);
        this.numeroOrden = numeroOrden;
        this.estadoFormularioId = estadoFormularioId;

        this.fechaUltimaModificacion = fechaUltimaModificacion;
        this.usuarioUltimaModificacion = usuarioUltimaModificacion;

        this.numeroEnvio = numeroEnvio;
        this.totalComprasCfRed = totalComprasCfRed;
        this.totalComprasCfIpnRed = totalComprasCfIpnRed;
        this.totalComprasCfOtrasRed = totalComprasCfOtrasRed;
        this.totalComprasSdCfRed = totalComprasSdCfRed;
        this.determinacionPagoCfRed = determinacionPagoCfRed;
        this.determinacionPagoCfIpnRed = determinacionPagoCfIpnRed;
        this.determinacionPagoCfOtrasRed = determinacionPagoCfOtrasRed;
        this.determinacionPagoSdCfRed = determinacionPagoSdCfRed;
        this.usuarioUltimaModificacionActual = usuarioUltimaModificacionActual;

    }


    @Override
    public String eventName() {
        return "formularios.declarado";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<String, Serializable>() {{
            put("numeroOrden", getNumeroOrden());
            put("estadoFormularioId", getEstadoFormularioId());
            put("fechaUltimaModificacion", Utils.localDateTimeToString(getFechaUltimaModificacion()));
            put("usuarioUltimaModificacion", getUsuarioUltimaModificacion());
            put("totalComprasCfRed", getTotalComprasCfRed());
            put("totalComprasCfIpnRed", getTotalComprasCfIpnRed());
            put("totalComprasCfOtrasRed", getTotalComprasCfOtrasRed());
            put("totalComprasSdCfRed", getTotalComprasSdCfRed());
            put("determinacionPagoCfRed", getDeterminacionPagoCfRed());
            put("determinacionPagoCfIpnRed", getDeterminacionPagoCfIpnRed());
            put("determinacionPagoCfOtrasRed", getDeterminacionPagoCfOtrasRed());
            put("determinacionPagoSdCfRed", getDeterminacionPagoSdCfRed());


            put("usuarioUltimaModificacionActual", getUsuarioUltimaModificacionActual());
        }};
    }

    @Override
    public DomainEvent fromPrimitives(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return new FormularioDeclaradoEventDomain(
                aggregateId,
                eventId,
                occurredOn,
                body.get("numeroOrden") != null ? Long.parseLong(body.get("numeroOrden").toString()) : null,
                (String) body.get("estadoFormularioId"),
                Utils.stringToLocalDateTime(body.get("fechaUltimaModificacion").toString()),
                Long.parseLong(body.get("usuarioUltimaModificacion").toString()),
                (Integer) (body.get("numeroEnvio")),
                new BigInteger(body.get("totalComprasCfRed").toString()),
                new BigInteger(body.get("totalComprasCfIpnRed").toString()),
                new BigInteger(body.get("totalComprasCfOtrasRed").toString()),
                new BigInteger(body.get("totalComprasSdCfRed").toString()),
                new BigInteger(body.get("determinacionPagoCfRed").toString()),
                new BigInteger(body.get("determinacionPagoCfIpnRed").toString()),
                new BigInteger(body.get("determinacionPagoCfOtrasRed").toString()),
                new BigInteger(body.get("determinacionPagoSdCfRed").toString()),
                body.get(" usuarioUltimaModificacionActual") != null ? Long.parseLong(body.get(" usuarioUltimaModificacionActual").toString()) : null
        );
    }


    public Long getNumeroOrden() {
        return numeroOrden;
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


    public Integer getNumeroEnvio() {
        return numeroEnvio;
    }


    public Long getUsuarioUltimaModificacionActual() {
        return usuarioUltimaModificacionActual;
    }

    public BigInteger getTotalComprasCfRed() {
        return totalComprasCfRed;
    }

    public BigInteger getTotalComprasCfIpnRed() {
        return totalComprasCfIpnRed;
    }

    public BigInteger getTotalComprasCfOtrasRed() {
        return totalComprasCfOtrasRed;
    }

    public BigInteger getTotalComprasSdCfRed() {
        return totalComprasSdCfRed;
    }

    public BigInteger getDeterminacionPagoCfRed() {
        return determinacionPagoCfRed;
    }

    public BigInteger getDeterminacionPagoCfIpnRed() {
        return determinacionPagoCfIpnRed;
    }

    public BigInteger getDeterminacionPagoCfOtrasRed() {
        return determinacionPagoCfOtrasRed;
    }

    public BigInteger getDeterminacionPagoSdCfRed() {
        return determinacionPagoSdCfRed;
    }
}
