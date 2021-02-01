package bo.gob.sin.sre.fac.frvcc.misfacturas.model.hformularios;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraId;
import bo.gob.sin.sre.fac.frvcc.shared.model.AggregateRoot;
import bo.gob.sin.sre.fac.frvcc.shared.model.EnumEstadoId;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;



public final class HFormulario extends AggregateRoot {
    private final HFormularioHistoricoId id;
    private HFormularioId idFormulario;
    private HFormularioEstadoFormularioId estadoFormularioId;
    private HFormularioFechaDesde fechaDesde;
    private HFormularioFechaHasta fechaHasta;
    private HFormularioNumeroOrden numeroOrden;
    private HFormularioUsuarioRegistro usuarioRegistro;
    private HFormularioFechaRegistro fechaRegistro;
    private HFormularioUsuarioUltimaModificacion usuarioUltimaModificacion;
    private HFormularioFechaUltimaModificacion fechaUltimaModificacion;
    private HFormularioEstadoId estadoId;
    private HFormularioTotalComprasCfIpn totalComprasCfIpn;
    private HFormularioTotalComprasCfOtras totalComprasCfOtras;
    private HFormularioTotalComprasSdCf totalComprasSdCf;
    private HFormularioTotalComprasCfRed totalComprasCfRed;
    private HFormularioTotalComprasCfIpnRed totalComprasCfIpnRed;
    private HFormularioTotalComprasCfOtrasRed totalComprasCfOtrasRed;
    private HFormularioTotalComprasSdCfRed totalComprasSdCfRed;
    private HFormularioDeterminacionPagoCfRed determinacionPagoCfRed;
    private HFormularioDeterminacionPagoCfIpnRed determinacionPagoCfIpnRed;
    private HFormularioDeterminacionPagoCfOtrasRed determinacionPagoCfOtrasRed;
    private HFormularioDeterminacionPagoSdCfRed determinacionPagoSdCfRed;
    private List<CompraId> compraIds;

    public HFormulario() {

        this.id = null;
    }


    public HFormulario(HFormularioHistoricoId id,
                       HFormularioId idFormulario,
                       HFormularioEstadoFormularioId estadoFormularioId,
                       HFormularioFechaDesde fechaDesde,
                       HFormularioFechaHasta fechaHasta,
                       HFormularioNumeroOrden numeroOrden,
                       HFormularioUsuarioRegistro usuarioRegistro,
                       HFormularioFechaRegistro fechaRegistro,
                       HFormularioUsuarioUltimaModificacion usuarioUltimaModificacion,
                       HFormularioFechaUltimaModificacion fechaUltimaModificacion,
                       HFormularioEstadoId estadoId, HFormularioTotalComprasCfIpn totalComprasCfIpn,
                       HFormularioTotalComprasCfOtras totalComprasCfOtras,
                       HFormularioTotalComprasSdCf totalComprasSdCf,
                       HFormularioTotalComprasCfRed totalComprasCfRed,
                       HFormularioTotalComprasCfIpnRed totalComprasCfIpnRed,
                       HFormularioTotalComprasCfOtrasRed totalComprasCfOtrasRed,
                       HFormularioTotalComprasSdCfRed totalComprasSdCfRed,
                       HFormularioDeterminacionPagoCfRed determinacionPagoCfRed,
                       HFormularioDeterminacionPagoCfIpnRed determinacionPagoCfIpnRed,
                       HFormularioDeterminacionPagoCfOtrasRed determinacionPagoCfOtrasRed,
                       HFormularioDeterminacionPagoSdCfRed determinacionPagoSdCfRed,
                       List<CompraId> compraIds) {
        super();
        this.id = id;
        this.idFormulario = idFormulario;
        this.estadoFormularioId = estadoFormularioId;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.numeroOrden = numeroOrden;
        this.usuarioRegistro = usuarioRegistro;
        this.fechaRegistro = fechaRegistro;
        this.usuarioUltimaModificacion = usuarioUltimaModificacion;
        this.fechaUltimaModificacion = fechaUltimaModificacion;
        this.estadoId = estadoId;
        this.compraIds = compraIds;
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
    }


    // Create Formulario
    public static HFormulario registro(HFormularioHistoricoId id,
                                       HFormularioId idFormulario,
                                       HFormularioEstadoFormularioId estadoFormularioId,
                                       HFormularioNumeroOrden numeroOrden,
                                       HFormularioUsuarioRegistro usuarioRegistro,
                                       HFormularioTotalComprasCfIpn totalComprasCfIpn,
                                       HFormularioTotalComprasCfOtras totalComprasCfOtras,
                                       HFormularioTotalComprasSdCf totalComprasSdCf,
                                       List<CompraId> compraIds,
                                       HFormularioTotalComprasCfRed totalComprasCfRed,
                                       HFormularioTotalComprasCfIpnRed totalComprasCfIpnRed,
                                       HFormularioTotalComprasCfOtrasRed totalComprasCfOtrasRed,
                                       HFormularioTotalComprasSdCfRed totalComprasSdCfRed,
                                       HFormularioDeterminacionPagoCfRed determinacionPagoCfRed,
                                       HFormularioDeterminacionPagoCfIpnRed determinacionPagoCfIpnRed,
                                       HFormularioDeterminacionPagoCfOtrasRed determinacionPagoCfOtrasRed,
                                       HFormularioDeterminacionPagoSdCfRed determinacionPagoSdCfRed
    ) {
        HFormularioFechaDesde fechaDesde = new HFormularioFechaDesde(LocalDate.now());
        HFormularioFechaHasta fechaHasta = new HFormularioFechaHasta(null);
        HFormularioFechaRegistro fechaRegistro = new HFormularioFechaRegistro(LocalDateTime.now());
        HFormularioFechaUltimaModificacion fechaUltimaModificacion = new HFormularioFechaUltimaModificacion(LocalDateTime.now());
        HFormularioUsuarioUltimaModificacion usuarioUltimaModificacion = new HFormularioUsuarioUltimaModificacion(usuarioRegistro.value());
        HFormularioEstadoId estadoId = new HFormularioEstadoId(EnumEstadoId.ACTIVO.value());

        HFormulario formulario = new HFormulario(
                id,
                idFormulario,
                estadoFormularioId,
                fechaDesde,
                fechaHasta,
                numeroOrden,
                usuarioRegistro,
                fechaRegistro,
                usuarioUltimaModificacion,
                fechaUltimaModificacion,
                estadoId,
                totalComprasCfIpn,
                totalComprasCfOtras,
                totalComprasSdCf,
                totalComprasCfRed,
                totalComprasCfIpnRed,
                totalComprasCfOtrasRed,
                totalComprasSdCfRed,
                determinacionPagoCfRed,
                determinacionPagoCfIpnRed,
                determinacionPagoCfOtrasRed,
                determinacionPagoSdCfRed,
                compraIds
        );

        return formulario;
    }


    public HFormularioHistoricoId id() {
        return id;
    }

    public HFormularioId idFormulario() {
        return idFormulario;
    }

    public HFormularioEstadoFormularioId estadoFormularioId() {
        return estadoFormularioId;
    }

    public HFormularioFechaDesde fechaDesde() {
        return fechaDesde;
    }

    public HFormularioFechaHasta fechaHasta() {
        return fechaHasta;
    }

    public HFormularioNumeroOrden numeroOrden() {
        return numeroOrden;
    }

    public HFormularioUsuarioRegistro usuarioRegistro() {
        return usuarioRegistro;
    }

    public HFormularioFechaRegistro fechaRegistro() {
        return fechaRegistro;
    }

    public HFormularioUsuarioUltimaModificacion usuarioUltimaModificacion() {
        return usuarioUltimaModificacion;
    }

    public HFormularioFechaUltimaModificacion fechaUltimaModificacion() {
        return fechaUltimaModificacion;
    }

    public HFormularioEstadoId estadoId() {
        return estadoId;
    }

    public HFormularioTotalComprasCfIpn totalComprasCfIpn() {
        return totalComprasCfIpn;
    }

    public HFormularioTotalComprasCfOtras totalComprasCfOtras() {
        return totalComprasCfOtras;
    }

    public HFormularioTotalComprasSdCf totalComprasSdCf() {
        return totalComprasSdCf;
    }

    public HFormularioTotalComprasCfRed totalComprasCfRed() {
        return totalComprasCfRed;
    }

    public HFormularioTotalComprasCfIpnRed totalComprasCfIpnRed() {
        return totalComprasCfIpnRed;
    }

    public HFormularioTotalComprasCfOtrasRed totalComprasCfOtrasRed() {
        return totalComprasCfOtrasRed;
    }

    public HFormularioTotalComprasSdCfRed totalComprasSdCfRed() {
        return totalComprasSdCfRed;
    }

    public HFormularioDeterminacionPagoCfRed determinacionPagoCfRed() {
        return determinacionPagoCfRed;
    }

    public HFormularioDeterminacionPagoCfIpnRed determinacionPagoCfIpnRed() {
        return determinacionPagoCfIpnRed;
    }

    public HFormularioDeterminacionPagoCfOtrasRed determinacionPagoCfOtrasRed() {
        return determinacionPagoCfOtrasRed;
    }

    public HFormularioDeterminacionPagoSdCfRed determinacionPagoSdCfRed() {
        return determinacionPagoSdCfRed;
    }

    public List<CompraId> compraIds() {
        return compraIds;
    }
}
