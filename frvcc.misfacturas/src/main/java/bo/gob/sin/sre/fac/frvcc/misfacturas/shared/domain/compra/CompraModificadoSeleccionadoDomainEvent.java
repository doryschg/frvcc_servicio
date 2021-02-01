package bo.gob.sin.sre.fac.frvcc.misfacturas.shared.domain.compra;

import bo.gob.sin.sre.fac.frvcc.shared.model.Utils;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.DomainEvent;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;

public class CompraModificadoSeleccionadoDomainEvent extends DomainEvent {


           private final LocalDate fechaFactura;
    private final BigDecimal importeTotalCompra;
    private final BigDecimal importeBaseCf;
    private final BigDecimal         creditoFiscal;
    private final String         codigoControl;
    private final Long usuarioUltimaModificacion;

    private final LocalDateTime fechaUltimaModificacion;
    private final String origenId;

    public CompraModificadoSeleccionadoDomainEvent(String aggregateId,
                                                   LocalDate fechaFactura,
                                                   BigDecimal importeTotalCompra,
                                                   BigDecimal creditoFiscal,
                                                   BigDecimal importeBaseCf,
                                                   String codigoControl,
                                                   Long usuarioUltimaModificacion,
                                                   LocalDateTime fechaUltimaModificacion,
                                                   String origenId) {
        super(aggregateId);
        this.fechaFactura = fechaFactura;
        this.importeTotalCompra = importeTotalCompra;
        this.importeBaseCf = importeBaseCf;
        this.creditoFiscal = creditoFiscal;
        this.codigoControl = codigoControl;
        this.usuarioUltimaModificacion = usuarioUltimaModificacion;

        this.fechaUltimaModificacion = fechaUltimaModificacion;
        this.origenId = origenId;
    }

    public CompraModificadoSeleccionadoDomainEvent(String aggregateId,
                                                   String eventId,
                                                   String occurredOn,
                                                   LocalDate fechaFactura,
                                                   BigDecimal importeTotalCompra,
                                                   BigDecimal importeBaseCf,
                                                   BigDecimal creditoFiscal,
                                                   String codigoControl,
                                                   Long usuarioUltimaModificacion,
                                                   LocalDateTime fechaUltimaModificacion,
                                                   String origenId) {
        super(aggregateId, eventId, occurredOn);
        this.fechaFactura = fechaFactura;
        this.importeTotalCompra = importeTotalCompra;
        this.importeBaseCf = importeBaseCf;
        this.creditoFiscal = creditoFiscal;
        this.codigoControl = codigoControl;
        this.usuarioUltimaModificacion = usuarioUltimaModificacion;
        this.fechaUltimaModificacion = fechaUltimaModificacion;
        this.origenId = origenId;
    }

    public CompraModificadoSeleccionadoDomainEvent() {

        this.fechaFactura = null;
        this.importeTotalCompra = null;
        this.importeBaseCf = null;
        this.codigoControl = null;
        this.creditoFiscal = null;
        this.usuarioUltimaModificacion = null;
        this.fechaUltimaModificacion = null;
        this.origenId = null;
    }

    @Override
    public String eventName() {
        return "compra.modificacion_seleccionado";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<>(){{

            put("fechaFactura", Utils.localDateToString(getFechaFactura()));
            put("importeTotalCompra", getImporteTotalCompra().toString());
            put("importeBaseCf", getImporteBaseCf().toString());
            put("creditoFiscal", getCreditoFiscal().toString());
            put("codigoControl", getCodigoControl());
            put("usuarioUltimaModificacion", getUsuarioUltimaModificacion());

            put("fechaUltimaModificacion", Utils.localDateTimeToString(getFechaUltimaModificacion()));
            put("origenId", getOrigenId());
        }};
    }

    @Override
    public DomainEvent fromPrimitives(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) throws IOException {
        return new CompraModificadoSeleccionadoDomainEvent(
                aggregateId,
                eventId,
                occurredOn,
                Utils.stringToLocalDate(body.get("fechaFactura").toString()),
               new BigDecimal(body.get("importeTotalCompra").toString()),
                new BigDecimal(body.get("importeBaseCf").toString()),
                new BigDecimal(body.get("creditoFiscal").toString()),
                (String) body.get("codigoControl"),
                Long.parseLong(body.get("usuarioUltimaModificacion").toString()),
                Utils.stringToLocalDateTime(body.get("fechaUltimaModificacion").toString()),
                (String) body.get("origenId")
        );
    }



    public LocalDate getFechaFactura() {
        return fechaFactura;
    }

    public BigDecimal getImporteTotalCompra() {
        return importeTotalCompra;
    }

    public BigDecimal getImporteBaseCf() {
        return importeBaseCf;
    }

    public String getCodigoControl() {
        return codigoControl;
    }

    public Long getUsuarioUltimaModificacion() {
        return usuarioUltimaModificacion;
    }

    public BigDecimal getCreditoFiscal() {
        return creditoFiscal;
    }

    public String getOrigenId() {
        return origenId;
    }

    public LocalDateTime getFechaUltimaModificacion() {
        return fechaUltimaModificacion;
    }
}
