package bo.gob.sin.sre.fac.frvcc.misfacturas.shared.domain.formularios;

import bo.gob.sin.sre.fac.frvcc.shared.model.Utils;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.DomainEvent;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

public class FormularioActulizarImporteCompraSelecionadaDomainEvent extends DomainEvent {

    private final BigDecimal totalCompras;
    private final Integer cantidadCompras;
    private final Long usuarioUltimaModificacion;
    private final Integer periodoMes;
    private final Integer periodoAnio;
    private final String nombreformulario;
    private final String tipoFormularioId;
    private final LocalDateTime fechaUltimaModificacion;
    private final BigDecimal determinacionPago;
    private final BigDecimal determinacionPagoCf;
    private final BigDecimal totalComprasCfIpn;
    private final Integer cantidadComprasCfIpn;
    private final BigDecimal determinacionPagoCfIpn;
    private final BigDecimal totalComprasCfElec;
    private final Integer cantidadComprasCfElec;
    private final BigDecimal totalComprasSdCf;
    private final Integer cantidadComprasSdCf;
    private final BigDecimal determinacionPagoSdCf;
    private final BigDecimal totalComprasCfOtras;
    private final Integer cantidadComprasCfOtras;
    private final BigDecimal determinacionPagoCfOtras;
    private final String compraId;
    private final BigDecimal importeTotalCompraMoficada;
    private final BigDecimal importeBaseCfompraMoficada;
    private final BigDecimal creditoFiscalCompraMoficada;
    private final LocalDate FechaFacturaCompraMoficada;
    private final String codigoControlCompraMoficada;


    public FormularioActulizarImporteCompraSelecionadaDomainEvent() {
        this.totalCompras = null;
        this.cantidadCompras = null;
        this.usuarioUltimaModificacion = null;
        this.periodoMes = null;
        this.periodoAnio = null;
        this.nombreformulario = null;
        this.tipoFormularioId = null;
        this.compraId = null;
        this.fechaUltimaModificacion = null;
        this.determinacionPago = null;
        this.determinacionPagoCf = null;
        this.totalComprasCfIpn = null;
        this.cantidadComprasCfIpn = null;
        this.determinacionPagoCfIpn = null;
        this.totalComprasCfElec = null;
        this.cantidadComprasCfElec = null;
        this.totalComprasSdCf = null;
        this.cantidadComprasSdCf = null;
        this.determinacionPagoSdCf = null;
        this.totalComprasCfOtras = null;
        this.cantidadComprasCfOtras = null;
        this.determinacionPagoCfOtras = null;
        this.importeTotalCompraMoficada = null;
        this.importeBaseCfompraMoficada = null;
        this.creditoFiscalCompraMoficada = null;
        this.FechaFacturaCompraMoficada = null;
        this.codigoControlCompraMoficada = null;


    }

    public FormularioActulizarImporteCompraSelecionadaDomainEvent(String aggregateId,
                                                                  BigDecimal totalCompras,
                                                                  Integer cantidadCompras,
                                                                  BigDecimal determinacionPago,
                                                                  BigDecimal determinacionPagoCf,
                                                                  BigDecimal totalComprasCfIpn,
                                                                  Integer cantidadComprasCfIpn,
                                                                  BigDecimal determinacionPagoCfIpn,
                                                                  BigDecimal totalComprasCfElec,
                                                                  Integer cantidadComprasCfElec,
                                                                  BigDecimal totalComprasSdCf,
                                                                  Integer cantidadComprasSdCf,
                                                                  BigDecimal determinacionPagoSdCf,
                                                                  BigDecimal totalComprasCfOtras,
                                                                  Integer cantidadComprasCfOtras,
                                                                  BigDecimal determinacionPagoCfOtras,
                                                                  Long usuarioUltimaModificacion,
                                                                  Integer periodoMes,
                                                                  Integer periodoAnio,
                                                                  String nombreformulario,
                                                                  String tipoFormularioId,
                                                                  LocalDateTime fechaUltimaModificacion,
                                                                  String compraId,
                                                                  BigDecimal        importeTotalCompraMoficada,
                                                                  BigDecimal importeBaseCfompraMoficada,
                                                                  BigDecimal     creditoFiscalCompraMoficada,
                                                                  LocalDate    FechaFacturaCompraMoficada,
                                                                  String    codigoControlCompraMoficada) {
        super(aggregateId);
        this.totalCompras = totalCompras;
        this.cantidadCompras = cantidadCompras;
        this.determinacionPago = determinacionPago;
        this.determinacionPagoCf = determinacionPagoCf;
        this.totalComprasCfIpn = totalComprasCfIpn;
        this.cantidadComprasCfIpn = cantidadComprasCfIpn;
        this.determinacionPagoCfIpn = determinacionPagoCfIpn;
        this.totalComprasCfElec = totalComprasCfElec;
        this.cantidadComprasCfElec = cantidadComprasCfElec;
        this.totalComprasSdCf = totalComprasSdCf;
        this.cantidadComprasSdCf = cantidadComprasSdCf;
        this.determinacionPagoSdCf = determinacionPagoSdCf;
        this.totalComprasCfOtras = totalComprasCfOtras;
        this.cantidadComprasCfOtras = cantidadComprasCfOtras;
        this.determinacionPagoCfOtras = determinacionPagoCfOtras;

        this.usuarioUltimaModificacion = usuarioUltimaModificacion;
        this.periodoMes = periodoMes;
        this.periodoAnio = periodoAnio;
        this.nombreformulario = nombreformulario;
        this.tipoFormularioId = tipoFormularioId;
        this.fechaUltimaModificacion = fechaUltimaModificacion;
        this.compraId = compraId;
        this.importeTotalCompraMoficada = importeTotalCompraMoficada;
        this.importeBaseCfompraMoficada = importeBaseCfompraMoficada;
        this.creditoFiscalCompraMoficada = creditoFiscalCompraMoficada;
        this.FechaFacturaCompraMoficada = FechaFacturaCompraMoficada;
        this.codigoControlCompraMoficada = codigoControlCompraMoficada;

    }





    public FormularioActulizarImporteCompraSelecionadaDomainEvent(String aggregateId, String eventId,
                                                                  String occurredOn,
                                                                  BigDecimal totalCompras,
                                                                  Integer cantidadCompras,
                                                                  BigDecimal determinacionPago,
                                                                  BigDecimal determinacionPagoCf,
                                                                  BigDecimal totalComprasCfIpn,
                                                                  Integer cantidadComprasCfIpn,
                                                                  BigDecimal determinacionPagoCfIpn,
                                                                  BigDecimal totalComprasCfElec,
                                                                  Integer cantidadComprasCfElec,
                                                                  BigDecimal totalComprasSdCf,
                                                                  Integer cantidadComprasSdCf,
                                                                  BigDecimal determinacionPagoSdCf,
                                                                  BigDecimal totalComprasCfOtras,
                                                                  Integer cantidadComprasCfOtras,
                                                                  BigDecimal determinacionPagoCfOtras,
                                                                  Long usuarioUltimaModificacion,
                                                                  Integer periodoMes,
                                                                  Integer periodoAnio,
                                                                  String nombreformulario,
                                                                  String tipoFormularioId,
                                                                  LocalDateTime fechaUltimaModificacion,
                                                                  String compraId,
                                                                  BigDecimal        importeTotalCompraMoficada,
                                                                  BigDecimal importeBaseCfompraMoficada,
                                                                  BigDecimal     creditoFiscalCompraMoficada,
                                                                  LocalDate    FechaFacturaCompraMoficada,
                                                                  String    codigoControlCompraMoficada) {
        super(aggregateId, eventId, occurredOn);
        this.totalCompras = totalCompras;
        this.cantidadCompras = cantidadCompras;
        this.determinacionPago = determinacionPago;
        this.determinacionPagoCf = determinacionPagoCf;
        this.totalComprasCfIpn = totalComprasCfIpn;
        this.cantidadComprasCfIpn = cantidadComprasCfIpn;
        this.determinacionPagoCfIpn = determinacionPagoCfIpn;
        this.totalComprasCfElec = totalComprasCfElec;
        this.cantidadComprasCfElec = cantidadComprasCfElec;
        this.totalComprasSdCf = totalComprasSdCf;
        this.cantidadComprasSdCf = cantidadComprasSdCf;
        this.determinacionPagoSdCf = determinacionPagoSdCf;
        this.totalComprasCfOtras = totalComprasCfOtras;
        this.cantidadComprasCfOtras = cantidadComprasCfOtras;
        this.determinacionPagoCfOtras = determinacionPagoCfOtras;
        this.usuarioUltimaModificacion = usuarioUltimaModificacion;
        this.periodoMes = periodoMes;
        this.periodoAnio = periodoAnio;
        this.nombreformulario = nombreformulario;
        this.tipoFormularioId = tipoFormularioId;
        this.fechaUltimaModificacion = fechaUltimaModificacion;
        this.compraId = compraId;
        this.importeTotalCompraMoficada = importeTotalCompraMoficada;
        this.importeBaseCfompraMoficada = importeBaseCfompraMoficada;
        this.creditoFiscalCompraMoficada = creditoFiscalCompraMoficada;
        this.FechaFacturaCompraMoficada = FechaFacturaCompraMoficada;
        this.codigoControlCompraMoficada = codigoControlCompraMoficada;
    }

    @Override
    public String eventName() {
        return "formulario.decrementado_importe";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap() {{
            put("totalCompras", getTotalCompras());
            put("cantidadCompras", getCantidadCompras());
            put("determinacionPago", getDeterminacionPago());
            put("determinacionPagoCf", getDeterminacionPagoCf());
            put("totalComprasCfIpn", getTotalComprasCfIpn());
            put("cantidadComprasCfIpn", getCantidadComprasCfIpn());
            put("determinacionPagoCfIpn", getDeterminacionPagoCfIpn());
            put("totalComprasCfElec", getTotalComprasCfElec());
            put("cantidadComprasCfElec", getCantidadComprasCfElec());
            put("totalComprasSdCf", getTotalComprasSdCf());
            put("cantidadComprasSdCf", getCantidadComprasSdCf());
            put("determinacionPagoSdCf", getDeterminacionPagoSdCf());
            put("totalComprasCfOtras", getTotalComprasCfOtras());
            put("cantidadComprasCfOtras", getCantidadComprasCfOtras());
            put("determinacionPagoCfOtras", getDeterminacionPagoCfOtras());
            put("usuarioUltimaModificacion", getUsuarioUltimaModificacion());
            put("periodoMes", getPeriodoMes());
            put("periodoAnio", getPeriodoAnio());
            put("nombreformulario", getNombreformulario());
            put("tipoFormularioId", getTipoFormularioId());
            put("fechaUltimaModificacion", Utils.localDateTimeToString(getFechaUltimaModificacion()));
            put("compraId", getCompraId());
            put("importeTotalCompraMoficada", getImporteTotalCompraMoficada());
            put("importeBaseCfompraMoficada", getImporteBaseCfompraMoficada());
            put("creditoFiscalCompraMoficada", getCreditoFiscalCompraMoficada());
            put("FechaFacturaCompraMoficada", Utils.localDateToString(getFechaFacturaCompraMoficada()));
            put("codigoControlCompraMoficada", getCodigoControlCompraMoficada());


        }};
    }

    @Override
    public DomainEvent fromPrimitives(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return new FormularioActulizarImporteCompraSelecionadaDomainEvent(aggregateId, eventId, occurredOn,
                new BigDecimal(body.get("totalCompras").toString()),
                (Integer) body.get("cantidadCompras"),
                new BigDecimal(body.get("determinacionPago").toString()),
                new BigDecimal(body.get("determinacionPagoCf").toString()),
                new BigDecimal(body.get("totalComprasCfIpn").toString()),
                (Integer) body.get("cantidadComprasCfIpn"),
                new BigDecimal(body.get("determinacionPagoCfIpn").toString()),
                new BigDecimal(body.get("totalComprasCfElec").toString()),
                (Integer) body.get("cantidadComprasCfElec"),
                new BigDecimal(body.get("totalComprasSdCf").toString()),
                (Integer) body.get("cantidadComprasSdCf"),
                new BigDecimal(body.get("determinacionPagoSdCf").toString()),
                new BigDecimal(body.get("totalComprasCfOtras").toString()),
                (Integer) body.get("cantidadComprasCfOtras"),
                new BigDecimal(body.get("determinacionPagoCfOtras").toString()),
                Long.parseLong(body.get("usuarioUltimaModificacion").toString()),
                (Integer) body.get("periodoMes"),
                (Integer) body.get("periodoAnio"),
                (String) body.get("nombreformulario"),
                (String) body.get("tipoFormularioId"),
                Utils.stringToLocalDateTime(body.get("fechaUltimaModificacion").toString()),
                (String) body.get("compraId"),
                new BigDecimal(body.get("importeTotalCompraMoficada").toString()),
                new BigDecimal(body.get("importeBaseCfompraMoficada").toString()),
                new BigDecimal(body.get("creditoFiscalCompraMoficada").toString()),
                Utils.stringToLocalDate(body.get("FechaFacturaCompraMoficada").toString()),
                (String) body.get("codigoControlCompraMoficada")
                );
    }

    public BigDecimal getTotalCompras() {
        return totalCompras;
    }

    public Integer getCantidadCompras() {
        return cantidadCompras;
    }

    public Long getUsuarioUltimaModificacion() {
        return usuarioUltimaModificacion;
    }

    public Integer getPeriodoMes() {
        return periodoMes;
    }

    public Integer getPeriodoAnio() {
        return periodoAnio;
    }

    public String getNombreformulario() {
        return nombreformulario;
    }

    public String getTipoFormularioId() {
        return tipoFormularioId;
    }

    public LocalDateTime getFechaUltimaModificacion() {
        return fechaUltimaModificacion;
    }

    public BigDecimal getDeterminacionPago() {
        return determinacionPago;
    }

    public BigDecimal getDeterminacionPagoCf() {
        return determinacionPagoCf;
    }

    public BigDecimal getTotalComprasCfIpn() {
        return totalComprasCfIpn;
    }

    public Integer getCantidadComprasCfIpn() {
        return cantidadComprasCfIpn;
    }

    public BigDecimal getDeterminacionPagoCfIpn() {
        return determinacionPagoCfIpn;
    }

    public BigDecimal getTotalComprasCfElec() {
        return totalComprasCfElec;
    }

    public Integer getCantidadComprasCfElec() {
        return cantidadComprasCfElec;
    }

    public BigDecimal getTotalComprasSdCf() {
        return totalComprasSdCf;
    }

    public Integer getCantidadComprasSdCf() {
        return cantidadComprasSdCf;
    }

    public BigDecimal getDeterminacionPagoSdCf() {
        return determinacionPagoSdCf;
    }

    public BigDecimal getTotalComprasCfOtras() {
        return totalComprasCfOtras;
    }

    public Integer getCantidadComprasCfOtras() {
        return cantidadComprasCfOtras;
    }

    public BigDecimal getDeterminacionPagoCfOtras() {
        return determinacionPagoCfOtras;
    }


    public String getCompraId() {
        return compraId;
    }

    public BigDecimal getImporteTotalCompraMoficada() {
        return importeTotalCompraMoficada;
    }

    public BigDecimal getImporteBaseCfompraMoficada() {
        return importeBaseCfompraMoficada;
    }

    public BigDecimal getCreditoFiscalCompraMoficada() {
        return creditoFiscalCompraMoficada;
    }

    public LocalDate getFechaFacturaCompraMoficada() {
        return FechaFacturaCompraMoficada;
    }

    public String getCodigoControlCompraMoficada() {
        return codigoControlCompraMoficada;
    }
}
