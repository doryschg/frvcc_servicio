package bo.gob.sin.sre.fac.frvcc.misfacturas.shared.domain.hformularios;


import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.hformularios.*;
import bo.gob.sin.sre.fac.frvcc.shared.model.Utils;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.DomainEvent;

public final class HFormularioRegistradoDomainEvent extends DomainEvent {
    private final String estadoFormularioId;
    private final Long numeroOrden;
    private final Long usuarioRegistro;
    private final LocalDateTime fechaRegistro;
    private final Long usuarioUltimaModificacion;
    private final LocalDateTime fechaUltimaModificacion;
    private final String estadoId;
    private final BigDecimal totalComprasCfIpn;
    private final BigDecimal totalComprasCfOtras;
    private final BigDecimal totalComprasSdCf;
    private final List<String> compraIds;

    private final BigInteger totalComprasCfRed;
    private final BigInteger totalComprasCfIpnRed;
    private final BigInteger totalComprasCfOtrasRed;
    private final BigInteger totalComprasSdCfRed;
    private final BigInteger determinacionPagoCfRed;
    private final BigInteger determinacionPagoCfIpnRed;
    private final BigInteger determinacionPagoCfOtrasRed;
    private final BigInteger determinacionPagoSdCfRed;

    public HFormularioRegistradoDomainEvent() {
        this.estadoFormularioId = null;

        this.numeroOrden = null;
        this.usuarioRegistro = null;
        this.fechaRegistro = null;
        this.usuarioUltimaModificacion = null;
        this.fechaUltimaModificacion = null;
        this.estadoId = null;
        this.totalComprasCfIpn = null;
        this.totalComprasCfOtras = null;
        this.totalComprasSdCf = null;
        this.compraIds = null;
        this.totalComprasCfRed = null;
        this.totalComprasCfIpnRed = null;
        this.totalComprasCfOtrasRed = null;
        this.totalComprasSdCfRed = null;
        this.determinacionPagoCfRed = null;
        this.determinacionPagoCfIpnRed = null;
        this.determinacionPagoCfOtrasRed = null;
        this.determinacionPagoSdCfRed = null;
    }


    public HFormularioRegistradoDomainEvent(String aggregateId,
                                            String estadoFormularioId,
                                            Long numeroOrden,
                                            Long usuarioRegistro,
                                            LocalDateTime fechaRegistro,
                                            Long usuarioUltimaModificacion,
                                            LocalDateTime fechaUltimaModificacion,
                                            String estadoId,
                                            BigDecimal totalComprasCfIpn,
                                            BigDecimal totalComprasCfOtras,
                                            BigDecimal totalComprasSdCf,
                                            BigInteger totalComprasCfRed,
                                            BigInteger totalComprasCfIpnRed,
                                            BigInteger totalComprasCfOtrasRed,
                                            BigInteger totalComprasSdCfRed,
                                            BigInteger determinacionPagoCfRed,
                                            BigInteger determinacionPagoCfIpnRed,
                                            BigInteger determinacionPagoCfOtrasRed,
                                            BigInteger determinacionPagoSdCfRed,


                                            List<String> compraIds) {
        super(aggregateId);

        this.estadoFormularioId = estadoFormularioId;

        this.numeroOrden = numeroOrden;
        this.usuarioRegistro = usuarioRegistro;
        this.fechaRegistro = fechaRegistro;
        this.usuarioUltimaModificacion = usuarioUltimaModificacion;
        this.fechaUltimaModificacion = fechaUltimaModificacion;
        this.estadoId = estadoId;
        this.totalComprasCfIpn = totalComprasCfIpn;
        this.totalComprasCfOtras = totalComprasCfOtras;
        this.totalComprasSdCf = totalComprasSdCf;
        this.totalComprasCfRed = totalComprasCfRed;
        this.totalComprasCfIpnRed = totalComprasCfIpnRed;
        this.totalComprasCfOtrasRed = totalComprasCfOtrasRed;
        this.totalComprasSdCfRed = totalComprasSdCfRed;
        this.determinacionPagoCfRed = determinacionPagoCfRed;
        this.determinacionPagoCfIpnRed = determinacionPagoCfIpnRed;
        this.determinacionPagoCfOtrasRed = determinacionPagoCfOtrasRed;
        this.determinacionPagoSdCfRed = determinacionPagoSdCfRed;
        this.compraIds = compraIds;
    }

    public HFormularioRegistradoDomainEvent(String aggregateId, String eventId, String occurredOn,
                                            String estadoFormularioId,

                                            Long numeroOrden,
                                            Long usuarioRegistro,
                                            LocalDateTime fechaRegistro,
                                            Long usuarioUltimaModificacion,
                                            LocalDateTime fechaUltimaModificacion,
                                            String estadoId,
                                            BigDecimal totalComprasCfIpn,
                                            BigDecimal totalComprasCfOtras,
                                            BigDecimal totalComprasSdCf,
                                            BigInteger totalComprasCfRed,
                                            BigInteger totalComprasCfIpnRed,
                                            BigInteger totalComprasCfOtrasRed,
                                            BigInteger totalComprasSdCfRed,
                                            BigInteger determinacionPagoCfRed,
                                            BigInteger determinacionPagoCfIpnRed,
                                            BigInteger determinacionPagoCfOtrasRed,
                                            BigInteger determinacionPagoSdCfRed,
                                            List<String> compraIds) {
        super(aggregateId, eventId, occurredOn);
        this.estadoFormularioId = estadoFormularioId;
        this.numeroOrden = numeroOrden;
        this.usuarioRegistro = usuarioRegistro;
        this.fechaRegistro = fechaRegistro;
        this.usuarioUltimaModificacion = usuarioUltimaModificacion;
        this.fechaUltimaModificacion = fechaUltimaModificacion;
        this.estadoId = estadoId;
        this.totalComprasCfIpn = totalComprasCfIpn;
        this.totalComprasCfOtras = totalComprasCfOtras;
        this.totalComprasSdCf = totalComprasSdCf;
        this.totalComprasCfRed = totalComprasCfRed;
        this.totalComprasCfIpnRed = totalComprasCfIpnRed;
        this.totalComprasCfOtrasRed = totalComprasCfOtrasRed;
        this.totalComprasSdCfRed = totalComprasSdCfRed;
        this.determinacionPagoCfRed = determinacionPagoCfRed;
        this.determinacionPagoCfIpnRed = determinacionPagoCfIpnRed;
        this.determinacionPagoCfOtrasRed = determinacionPagoCfOtrasRed;
        this.determinacionPagoSdCfRed = determinacionPagoSdCfRed;
        this.compraIds = compraIds;

    }


    @Override
    public String eventName() {
        return "hformulario.registrado";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap() {{
            put("estadoFormularioId", getEstadoFormularioId());
            put("numeroOrden", getNumeroOrden());
            put("usuarioRegistro", getUsuarioRegistro());
            put("fechaRegistro", Utils.localDateTimeToString(getFechaRegistro()));
            put("usuarioUltimaModificacion", getUsuarioUltimaModificacion());
            put("fechaUltimaModificacion", Utils.localDateTimeToString(getFechaUltimaModificacion()));
            put("estadoId", getEstadoId());
            put("totalComprasCfIpn", getTotalComprasCfIpn());
            put("totalComprasCfOtras", getTotalComprasCfOtras());
            put("totalComprasSdCf", getTotalComprasSdCf());
            put("totalComprasCfRed", getTotalComprasCfRed());
            put("totalComprasCfIpnRed", getTotalComprasCfIpnRed());
            put("totalComprasCfOtrasRed", getTotalComprasCfOtrasRed());
            put("totalComprasSdCfRed", getTotalComprasSdCfRed());
            put("determinacionPagoCfRed", getDeterminacionPagoCfRed());
            put("determinacionPagoCfIpnRed", getDeterminacionPagoCfIpnRed());
            put("determinacionPagoCfOtrasRed", getDeterminacionPagoCfOtrasRed());
            put("determinacionPagoSdCfRed", getDeterminacionPagoSdCfRed());

            put("compraIds", getCompraIds());
        }};
    }

    @Override
    public DomainEvent fromPrimitives(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return new HFormularioRegistradoDomainEvent(aggregateId, eventId, occurredOn,
                (String) body.get("estadoFormularioId"),
                Long.parseLong(body.get("numeroOrden").toString()),
                Long.parseLong(body.get("usuarioRegistro").toString()),
                Utils.stringToLocalDateTime((String) (body.get("fechaRegistro"))),
                Long.parseLong(body.get("usuarioUltimaModificacion").toString()),
                Utils.stringToLocalDateTime((String) (body.get("fechaUltimaModificacion"))),
                (String) body.get("estadoId"),
                new BigDecimal(body.get("totalComprasCfIpn").toString()),
                new BigDecimal(body.get("totalComprasCfOtras").toString()),
                new BigDecimal(body.get("totalComprasSdCf").toString()),
                new BigInteger(body.get("totalComprasCfRed").toString()),
                new BigInteger(body.get("totalComprasCfIpnRed").toString()),
                new BigInteger(body.get("totalComprasCfOtrasRed").toString()),
                new BigInteger(body.get("totalComprasSdCfRed").toString()),
                new BigInteger(body.get("determinacionPagoCfRed").toString()),
                new BigInteger(body.get("determinacionPagoCfIpnRed").toString()),
                new BigInteger(body.get("determinacionPagoCfOtrasRed").toString()),
                new BigInteger(body.get("determinacionPagoSdCfRed").toString()),
                (List<String>) body.get("compraIds"));
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

    public String getEstadoFormularioId() {
        return estadoFormularioId;
    }


    public Long getNumeroOrden() {
        return numeroOrden;
    }

    public Long getUsuarioRegistro() {
        return usuarioRegistro;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public Long getUsuarioUltimaModificacion() {
        return usuarioUltimaModificacion;
    }

    public LocalDateTime getFechaUltimaModificacion() {
        return fechaUltimaModificacion;
    }

    public String getEstadoId() {
        return estadoId;
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

    public List<String> getCompraIds() {
        return compraIds;
    }
}
