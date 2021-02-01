package bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.CompraResponseGenerico;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.*;
import bo.gob.sin.sre.fac.frvcc.misfacturas.shared.domain.formularios.*;
import bo.gob.sin.sre.fac.frvcc.misfacturas.shared.domain.formularios.FormularioDeclaradoCanceladoEventDomain;
import bo.gob.sin.sre.fac.frvcc.misfacturas.shared.domain.formularios.FormularioDeclaradoEventDomain;
import bo.gob.sin.sre.fac.frvcc.misfacturas.shared.domain.formularios.FormularioDecrementadoImporteDomainEvent;
import bo.gob.sin.sre.fac.frvcc.misfacturas.shared.domain.formularios.FormularioIncrementadoImporteDomainEvent;
import bo.gob.sin.sre.fac.frvcc.misfacturas.shared.domain.formularios.FormularioRegistradoDomainEvent;
import bo.gob.sin.sre.fac.frvcc.misfacturas.shared.domain.hformularios.HFormularioRegistradoDomainEvent;
import bo.gob.sin.sre.fac.frvcc.shared.model.AggregateRoot;
import bo.gob.sin.sre.fac.frvcc.shared.model.Identifier;
import bo.gob.sin.sre.fac.frvcc.shared.model.Utils;
import bo.gob.sin.str.constantes.estado.ConstEstado;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public final class Formulario extends AggregateRoot {

    private final FormularioId id;
    private FormularioTipoFormularioId tipoFormularioId;
    private FormularioNitCi nitCi;
    private FormularioIfc ifc;
    private FormularioCodigoDependiente codigoDependiente;
    private FormularioRazonSocial razonSocial;
    private FormularioExpedicionCi expedicionCi;
    private FormularioMesPeriodo mesPeriodo;
    private FormularioAnioPeriodo anioPeriodo;
    private FormularioNombreFormulario nombreFormulario;
    private FormularioCantidadComprasCf cantidadCompras;
    private FormularioTotalComprasCf totalCompras;

    private FormularioCantidadComprasCfElec cantidadComprasCfElec;
    private FormularioCantidadComprasCfIpn cantidadComprasCfIpn;
    private FormularioCantidadComprasCfOtras cantidadComprasCfOtras;
    private FormularioCantidadComprasSdCf cantidadComprasSdCf;
    private FormularioTotalComprasCfElec totalComprasCfElec;
    private FormularioTotalComprasCfIpn totalComprasCfIpn;
    private FormularioTotalComprasCfOtras totalComprasCfOtras;
    private FormularioTotalComprasSdCf totalComprasSdCf;
    private FormularioDeterminacionPagoCf determinacionPagoCf;
    private FormularioDeterminacionPagoCfIpn determinacionPagoCfIpn;
    private FormularioDeterminacionPagoCfOtras determinacionPagoCfOtras;
    private FormularioDeterminacionPagoSdCf determinacionPagoSdCf;

    private FormularioDeterminacionPago determinacionPago;
    private FormularioLugarDepartamento lugarDepartamento;
    private FormularioTipoPresentacionId tipoPresentacionId;
    private FormularioDireccion direccion;
    private FormularioNitEmpleador nitEmpleador;
    private FormularioNombreEmpleador nombreEmpleador;
    private FormularioDireccionEmpleador direccionEmpleador;
    private FormularioFechaPresentacion fechaPresentacion;
    private FormularioPeriodicidadId periodicidadId;
    private FormularioCantidadPeriodicidad cantidadPeriodicidad;
    private FormularioNumeroOrden numeroOrden;
    private FormularioEstadoFormularioId estadoFormularioId;
    private FormularioFechaEstado fechaEstado;
    private FormularioNumeroEnvio numeroEnvio;
    private FormularioUsuarioRegistro usuarioRegistro;
    private FormularioFechaRegistro fechaRegistro;
    private FormularioUsuarioUltimaModificacion usuarioUltimaModificacion;
    private FormularioFechaUltimaModificacion fechaUltimaModificacion;
    private FormularioEstadoId estadoId;
    private FormularioNumeroSucursal numeroSucursal;
    private FormularioUsuarioReceptor usuarioReceptor;
    private FormularioLoginUsuarioReceptor loginUsuarioReceptor;
    private FormularioNombreReceptor nombreReceptor;
    private FormularioConsolidacionId consolidacionId;
    private FormularioTotalComprasCfRed totalComprasCfRed;
    private FormularioTotalComprasCfIpnRed totalComprasCfIpnRed;
    private FormularioTotalComprasCfOtrasRed totalComprasCfOtrasRed;
    private FormularioTotalComprasSdCfRed totalComprasSdCfRed;
    private FormularioDeterminacionPagoCfRed determinacionPagoCfRed;
    private FormularioDeterminacionPagoCfIpnRed determinacionPagoCfIpnRed;
    private FormularioDeterminacionPagoCfOtrasRed determinacionPagoCfOtrasRed;
    private FormularioDeterminacionPagoSdCfRed determinacionPagoSdCfRed;
    private FormularioTipoUsoId tipoUsoId;
    private List<CompraId> compras;
    private DatosEspecificos datosEspecificos;

    public Formulario() {

        this.id = null;
    }


    public Formulario(FormularioId id, FormularioTipoFormularioId tipoFormularioId, FormularioNitCi nitCi,
                      FormularioIfc ifc, FormularioCodigoDependiente codigoDependiente, FormularioRazonSocial razonSocial,
                      FormularioExpedicionCi expedicionCi, FormularioMesPeriodo mesPeriodo, FormularioAnioPeriodo anioPeriodo,
                      FormularioNombreFormulario nombreFormulario, FormularioCantidadComprasCf cantidadCompras,
                      FormularioTotalComprasCf totalCompras, FormularioCantidadComprasCfElec cantidadComprasCfElec,
                      FormularioCantidadComprasCfIpn cantidadComprasCfIpn,
                      FormularioCantidadComprasCfOtras cantidadComprasCfOtras, FormularioCantidadComprasSdCf cantidadComprasSdCf,
                      FormularioTotalComprasCfElec totalComprasCfElec, FormularioTotalComprasCfIpn totalComprasCfIpn,
                      FormularioTotalComprasCfOtras totalComprasCfOtras, FormularioTotalComprasSdCf totalComprasSdCf,
                      FormularioDeterminacionPagoCf determinacionPagoCf, FormularioDeterminacionPagoCfIpn determinacionPagoCfIpn,
                      FormularioDeterminacionPagoCfOtras determinacionPagoCfOtras,
                      FormularioDeterminacionPagoSdCf determinacionPagoSdCf, FormularioDeterminacionPago determinacionPago,
                      FormularioLugarDepartamento lugarDepartamento, FormularioTipoPresentacionId tipoPresentacionId,
                      FormularioDireccion direccion, FormularioNitEmpleador nitEmpleador,
                      FormularioNombreEmpleador nombreEmpleador, FormularioDireccionEmpleador direccionEmpleador,
                      FormularioFechaPresentacion fechaPresentacion, FormularioPeriodicidadId periodicidadId,
                      FormularioCantidadPeriodicidad cantidadPeriodicidad, FormularioNumeroOrden numeroOrden,
                      FormularioEstadoFormularioId estadoFormularioId, FormularioFechaEstado fechaEstado,
                      FormularioNumeroEnvio numeroEnvio, FormularioUsuarioRegistro usuarioRegistro,
                      FormularioFechaRegistro fechaRegistro, FormularioUsuarioUltimaModificacion usuarioUltimaModificacion,
                      FormularioFechaUltimaModificacion fechaUltimaModificacion, FormularioEstadoId estadoId,
                      FormularioNumeroSucursal numeroSucursal, FormularioUsuarioReceptor usuarioReceptor,
                      FormularioLoginUsuarioReceptor loginUsuarioReceptor,
                      FormularioNombreReceptor nombreReceptor,
                      FormularioTotalComprasCfRed totalComprasCfRed,
                      FormularioTotalComprasCfIpnRed totalComprasCfIpnRed,
                      FormularioTotalComprasCfOtrasRed totalComprasCfOtrasRed,
                      FormularioTotalComprasSdCfRed totalComprasSdCfRed,
                      FormularioDeterminacionPagoCfRed determinacionPagoCfRed,
                      FormularioDeterminacionPagoCfIpnRed determinacionPagoCfIpnRed,
                      FormularioDeterminacionPagoCfOtrasRed determinacionPagoCfOtrasRed,
                      FormularioDeterminacionPagoSdCfRed determinacionPagoSdCfRed,
                      FormularioConsolidacionId consolidacionId,
                      FormularioTipoUsoId tipoUsoId,
                      List<CompraId> compras, DatosEspecificos datosEspecificos) {
        super();
        this.id = id;
        this.tipoFormularioId = tipoFormularioId;
        this.nitCi = nitCi;
        this.ifc = ifc;
        this.codigoDependiente = codigoDependiente;
        this.razonSocial = razonSocial;
        this.expedicionCi = expedicionCi;
        this.mesPeriodo = mesPeriodo;
        this.anioPeriodo = anioPeriodo;
        this.nombreFormulario = nombreFormulario;
        this.cantidadCompras = cantidadCompras;
        this.totalCompras = totalCompras;
        this.cantidadComprasCfElec = cantidadComprasCfElec;
        this.cantidadComprasCfIpn = cantidadComprasCfIpn;
        this.cantidadComprasCfOtras = cantidadComprasCfOtras;
        this.cantidadComprasSdCf = cantidadComprasSdCf;
        this.totalComprasCfElec = totalComprasCfElec;
        this.totalComprasCfIpn = totalComprasCfIpn;
        this.totalComprasCfOtras = totalComprasCfOtras;
        this.totalComprasSdCf = totalComprasSdCf;
        this.determinacionPagoCf = determinacionPagoCf;
        this.determinacionPagoCfIpn = determinacionPagoCfIpn;
        this.determinacionPagoCfOtras = determinacionPagoCfOtras;
        this.determinacionPagoSdCf = determinacionPagoSdCf;
        this.determinacionPago = determinacionPago;
        this.lugarDepartamento = lugarDepartamento;
        this.tipoPresentacionId = tipoPresentacionId;
        this.direccion = direccion;
        this.nitEmpleador = nitEmpleador;
        this.nombreEmpleador = nombreEmpleador;
        this.direccionEmpleador = direccionEmpleador;
        this.fechaPresentacion = fechaPresentacion;
        this.periodicidadId = periodicidadId;
        this.cantidadPeriodicidad = cantidadPeriodicidad;
        this.numeroOrden = numeroOrden;
        this.estadoFormularioId = estadoFormularioId;
        this.fechaEstado = fechaEstado;
        this.numeroEnvio = numeroEnvio;
        this.usuarioRegistro = usuarioRegistro;
        this.fechaRegistro = fechaRegistro;
        this.usuarioUltimaModificacion = usuarioUltimaModificacion;
        this.fechaUltimaModificacion = fechaUltimaModificacion;
        this.estadoId = estadoId;
        this.numeroSucursal = numeroSucursal;
        this.usuarioReceptor = usuarioReceptor;
        this.loginUsuarioReceptor = loginUsuarioReceptor;
        this.nombreReceptor = nombreReceptor;
        this.totalComprasCfRed = totalComprasCfRed;
        this.totalComprasCfIpnRed = totalComprasCfIpnRed;
        this.totalComprasCfOtrasRed = totalComprasCfOtrasRed;
        this.totalComprasSdCfRed = totalComprasSdCfRed;
        this.determinacionPagoCfRed = determinacionPagoCfRed;
        this.determinacionPagoCfIpnRed = determinacionPagoCfIpnRed;
        this.determinacionPagoCfOtrasRed = determinacionPagoCfOtrasRed;
        this.determinacionPagoSdCfRed = determinacionPagoSdCfRed;
        this.consolidacionId = consolidacionId;
        this.tipoUsoId = tipoUsoId;
        this.compras = compras;
        this.datosEspecificos = datosEspecificos;
    }


    // Create Formulario
    public static Formulario registro(FormularioId id, FormularioTipoFormularioId tipoFormularioId,
                                      FormularioNombreFormulario nombreFormulario, FormularioMesPeriodo mesPeriodo,
                                      FormularioAnioPeriodo anioPeriodo, FormularioFechaPresentacion fechaPresentacion,
                                      FormularioPeriodicidadId periodicidadId, FormularioCantidadPeriodicidad cantidadPeriodicidad,
                                      FormularioTipoPresentacionId tipoPresentacionId, FormularioLugarDepartamento lugarDepartamento,
                                      FormularioNitCi nitCi, FormularioExpedicionCi expedicionCi, FormularioIfc ifc,
                                      FormularioRazonSocial razonSocial, FormularioDireccion direccion,
                                      FormularioCodigoDependiente codigoDependiente, FormularioNitEmpleador nitEmpleador,
                                      FormularioNombreEmpleador nombreEmpleador, FormularioDireccionEmpleador direccionEmpleador,
                                      FormularioUsuarioRegistro usuarioRegistro, DatosEspecificos datosEspecificos, FormularioNumeroSucursal numeroSucursal,
                                      FormularioTipoUsoId tipoUsoId) {
        FormularioTotalComprasCf totalCompras = new FormularioTotalComprasCf(BigDecimal.ZERO);
        FormularioCantidadComprasCf cantidadCompras = new FormularioCantidadComprasCf(Integer.valueOf(0));

        FormularioCantidadComprasCfElec cantidadComprasCfElec = new FormularioCantidadComprasCfElec(Integer.valueOf(0));
        FormularioCantidadComprasCfIpn cantidadComprasCfIpn = new FormularioCantidadComprasCfIpn(Integer.valueOf(0));
        FormularioCantidadComprasCfOtras cantidadComprasCfOtras = new FormularioCantidadComprasCfOtras(Integer.valueOf(0));
        FormularioCantidadComprasSdCf cantidadComprasSdCf = new FormularioCantidadComprasSdCf(Integer.valueOf(0));
        FormularioTotalComprasCfElec totalComprasCfElec = new FormularioTotalComprasCfElec(BigDecimal.ZERO);
        FormularioTotalComprasCfIpn totalComprasCfIpn = new FormularioTotalComprasCfIpn(BigDecimal.ZERO);
        FormularioTotalComprasCfOtras totalComprasCfOtras = new FormularioTotalComprasCfOtras(BigDecimal.ZERO);
        FormularioTotalComprasSdCf totalComprasSdCf = new FormularioTotalComprasSdCf(BigDecimal.ZERO);
        FormularioDeterminacionPagoCf determinacionPagoCf = new FormularioDeterminacionPagoCf(BigDecimal.ZERO);
        FormularioDeterminacionPagoCfIpn determinacionPagoCfIpn = new FormularioDeterminacionPagoCfIpn(BigDecimal.ZERO);
        FormularioDeterminacionPagoCfOtras determinacionPagoCfOtras = new FormularioDeterminacionPagoCfOtras(BigDecimal.ZERO);
        FormularioDeterminacionPagoSdCf determinacionPagoSdCf = new FormularioDeterminacionPagoSdCf(BigDecimal.ZERO);


        FormularioDeterminacionPago determinacionPago = new FormularioDeterminacionPago(BigDecimal.ZERO);
        FormularioEstadoFormularioId estadoFormularioId = new FormularioEstadoFormularioId(
                FormularioEstado.REGISTRADO.value());
        FormularioFechaRegistro fechaRegistro = new FormularioFechaRegistro(LocalDateTime.now());
        FormularioUsuarioUltimaModificacion usuarioUltimaModificacion = new FormularioUsuarioUltimaModificacion(
                usuarioRegistro.value());

        FormularioNumeroOrden numeroOrden = new FormularioNumeroOrden(null);
        FormularioFechaUltimaModificacion fechaUltimaModificacion = new FormularioFechaUltimaModificacion(
                LocalDateTime.now());
        FormularioEstadoId estadoId = new FormularioEstadoId("AC");
        FormularioFechaEstado fechaEstado = new FormularioFechaEstado(LocalDate.now());
        FormularioNumeroEnvio numeroEnvio = new FormularioNumeroEnvio(Integer.valueOf(0));
        FormularioUsuarioReceptor usuarioReceptor = new FormularioUsuarioReceptor(null);
        FormularioLoginUsuarioReceptor loginUsuarioReceptor = new FormularioLoginUsuarioReceptor("");
        FormularioNombreReceptor nombreReceptor = new FormularioNombreReceptor("");
        FormularioTotalComprasCfRed totalComprasCfRed = new FormularioTotalComprasCfRed(BigInteger.ZERO);
        FormularioTotalComprasCfIpnRed totalComprasCfIpnRed = new FormularioTotalComprasCfIpnRed(BigInteger.ZERO);
        FormularioTotalComprasCfOtrasRed totalComprasCfOtrasRed = new FormularioTotalComprasCfOtrasRed(BigInteger.ZERO);
        FormularioTotalComprasSdCfRed totalComprasSdCfRed = new FormularioTotalComprasSdCfRed(BigInteger.ZERO);
        FormularioDeterminacionPagoCfRed determinacionPagoCfRed = new FormularioDeterminacionPagoCfRed(BigInteger.ZERO);
        FormularioDeterminacionPagoCfIpnRed determinacionPagoCfIpnRed = new FormularioDeterminacionPagoCfIpnRed(BigInteger.ZERO);
        FormularioDeterminacionPagoCfOtrasRed determinacionPagoCfOtrasRed = new FormularioDeterminacionPagoCfOtrasRed(BigInteger.ZERO);
        FormularioDeterminacionPagoSdCfRed determinacionPagoSdCfRed = new FormularioDeterminacionPagoSdCfRed(BigInteger.ZERO);
        FormularioConsolidacionId consolidacionId = new FormularioConsolidacionId(null);


        List<CompraId> compras = new ArrayList<>();

        if (datosEspecificos.getComplementoDocumento() != null) {
            datosEspecificos.setComplementoDocumento(datosEspecificos.getComplementoDocumento().toUpperCase());
        }

        Formulario formulario = new Formulario(id, tipoFormularioId, nitCi, ifc, codigoDependiente, razonSocial,
                expedicionCi, mesPeriodo, anioPeriodo, nombreFormulario, cantidadCompras, totalCompras,
                cantidadComprasCfElec, cantidadComprasCfIpn, cantidadComprasCfOtras,
                cantidadComprasSdCf, totalComprasCfElec, totalComprasCfIpn,
                totalComprasCfOtras, totalComprasSdCf, determinacionPagoCf,
                determinacionPagoCfIpn, determinacionPagoCfOtras, determinacionPagoSdCf,
                determinacionPago, lugarDepartamento, tipoPresentacionId, direccion, nitEmpleador, nombreEmpleador,
                direccionEmpleador, fechaPresentacion, periodicidadId, cantidadPeriodicidad, numeroOrden,
                estadoFormularioId, fechaEstado, numeroEnvio, usuarioRegistro, fechaRegistro, usuarioUltimaModificacion,
                fechaUltimaModificacion, estadoId, numeroSucursal, usuarioReceptor, loginUsuarioReceptor, nombreReceptor,
                totalComprasCfRed,
                totalComprasCfIpnRed,
                totalComprasCfOtrasRed,
                totalComprasSdCfRed,
                determinacionPagoCfRed,
                determinacionPagoCfIpnRed,
                determinacionPagoCfOtrasRed,
                determinacionPagoSdCfRed,
                consolidacionId,
                tipoUsoId,
                compras, datosEspecificos);

        formulario.compras = new ArrayList<>();

        formulario.record(new HFormularioRegistradoDomainEvent(
                formulario.id().value(),
                formulario.estadoFormularioId().value(),
                formulario.numeroOrden().value(),
                formulario.usuarioRegistro().value(),
                formulario.fechaRegistro().value(),
                formulario.usuarioUltimaModificacion().value(),
                formulario.fechaUltimaModificacion().value(),
                formulario.estadoId().value(),
                formulario.totalComprasCfIpn().value(),
                formulario.totalComprasCfOtras().value(),
                formulario.totalComprasSdCf().value(),
                formulario.totalComprasCfRed().value(),
                formulario.totalComprasCfIpnRed().value(),
                formulario.totalComprasCfOtrasRed().value(),
                formulario.totalComprasSdCfRed().value(),
                formulario.determinacionPagoCfRed().value(),
                formulario.determinacionPagoCfIpnRed().value(),
                formulario.determinacionPagoCfOtrasRed().value(),
                formulario.determinacionPagoSdCfRed().value(),
                formulario.compras().stream().map(Identifier::value).collect(Collectors.toList())
        ));
        return formulario;
    }

    public void modificar(FormularioDireccion direccion,
                          FormularioDireccionEmpleador direccionEmpleador,
                          FormularioUsuarioUltimaModificacion usuarioUltimaModificacion,
                          FormularioLugarDepartamento lugarDepartamento,
                          FormularioFechaPresentacion fechaPresentacion,
                          FormularioNumeroSucursal numeroSucursal,
                          DatosEspecificos datosEspecificos, FormularioTipoUsoId tipoUsoId) {
        this.record(new FormularioModifiacionDomainEvent(this.id.value(), this.direccion.value(),
                this.direccionEmpleador == null ? null : this.direccionEmpleador.value(),
                this.usuarioUltimaModificacion.value(),
                this.lugarDepartamento.value(),
                this.fechaPresentacion.value(),
                this.fechaUltimaModificacion.value(),
                this.datosEspecificos,
                fechaPresentacion.value(),
                this.numeroSucursal.value()));
        this.direccion = direccion;
        this.direccionEmpleador = direccionEmpleador;
        this.usuarioUltimaModificacion = usuarioUltimaModificacion;
        this.lugarDepartamento = lugarDepartamento;
        this.fechaPresentacion = fechaPresentacion;
        this.fechaUltimaModificacion = new FormularioFechaUltimaModificacion(LocalDateTime.now());
        this.numeroSucursal = numeroSucursal;
        this.tipoUsoId = tipoUsoId;
        if (datosEspecificos.getComplementoDocumento() != null) {
            datosEspecificos.setComplementoDocumento(datosEspecificos.getComplementoDocumento().toUpperCase());
        }
        this.datosEspecificos = datosEspecificos;


        crearHistorico();
    }

    public void incrementoImporte(BigDecimal ImporteBaseCf,
                                  BigDecimal creditoFiscal,
                                  FormularioUsuarioUltimaModificacion usuarioUltimaModificacion,
                                  CompraId compraId,
                                  BigDecimal importeTotalCompra,
                                  CompraMarcaEspecialId marcaEspecialId, String modalidadId) {
        this.record(new FormularioIncrementadoImporteDomainEvent(id.value(),
                this.totalCompras.value(),
                this.cantidadCompras.value(),
                this.determinacionPago.value(),
                this.determinacionPagoCf.value(),
                this.totalComprasCfIpn.value(),
                this.cantidadComprasCfIpn.value(),
                this.determinacionPagoCfIpn.value(),
                this.totalComprasCfElec.value(),
                this.cantidadComprasCfElec.value(),
                this.totalComprasSdCf.value(),
                this.cantidadComprasSdCf.value(),
                this.determinacionPagoSdCf.value(),
                this.totalComprasCfOtras.value(),
                this.cantidadComprasCfOtras.value(),
                this.determinacionPagoCfOtras.value(),
                this.usuarioUltimaModificacion.value(),
                this.mesPeriodo.value(),
                this.anioPeriodo.value(),
                this.nombreFormulario.value(),
                this.tipoFormularioId.value(),
                this.fechaUltimaModificacion.value(),
                this.compras().stream().map(x -> x.value()).collect(Collectors.toList()),
                this.compras().stream().map(x -> x.value()).collect(Collectors.toList())
        ));

        if (!this.tipoFormularioId.value().equals("AF702")) {
            actualizaTotales(ImporteBaseCf, creditoFiscal,
                    usuarioUltimaModificacion, compraId,
                    importeTotalCompra, marcaEspecialId, modalidadId);
        } else {
            actualizaTotalesF702(ImporteBaseCf, creditoFiscal,
                    usuarioUltimaModificacion, compraId,
                    importeTotalCompra, marcaEspecialId, modalidadId);
        }

        this.usuarioUltimaModificacion = usuarioUltimaModificacion;
        this.compras = this.compras == null ? new ArrayList<>() : this.compras;
        this.compras.add(compraId);
        this.fechaUltimaModificacion = new FormularioFechaUltimaModificacion(LocalDateTime.now());
        crearHistorico();
    }

    private void crearHistorico() {
        this.record(new HFormularioRegistradoDomainEvent(
                this.id() != null ? this.id().value() : null,
                this.estadoFormularioId() != null ? this.estadoFormularioId().value() : null,
                this.numeroOrden() != null ? this.numeroOrden().value() : null,
                this.usuarioRegistro() != null ? this.usuarioRegistro().value() : null,
                this.fechaRegistro() != null ? this.fechaRegistro().value() : null,
                this.usuarioUltimaModificacion() != null ? this.usuarioUltimaModificacion().value() : null,
                this.fechaUltimaModificacion() != null ? this.fechaUltimaModificacion().value() : null,
                this.estadoId() != null ? this.estadoId().value() : null,
                this.totalComprasCfIpn() != null ? this.totalComprasCfIpn().value() : null,
                this.totalComprasCfOtras() != null ? this.totalComprasCfOtras().value() : null,
                this.totalComprasSdCf() != null ? this.totalComprasSdCf().value() : null,
                this.totalComprasCfRed() != null ? this.totalComprasCfRed().value() : null,
                this.totalComprasCfIpnRed() != null ? this.totalComprasCfIpnRed().value() : null,
                this.totalComprasCfOtrasRed() != null ? this.totalComprasCfOtrasRed().value() : null,
                this.totalComprasSdCfRed() != null ? this.totalComprasSdCfRed().value() : null,
                this.determinacionPagoCfRed() != null ? this.determinacionPagoCfRed().value() : null,
                this.determinacionPagoCfIpnRed() != null ? this.determinacionPagoCfIpnRed().value() : null,
                this.determinacionPagoCfOtrasRed() != null ? this.determinacionPagoCfOtrasRed().value() : null,
                this.determinacionPagoSdCfRed() != null ? this.determinacionPagoSdCfRed().value() : null,
                this.compras().stream().map(Identifier::value).collect(Collectors.toList())
        ));
    }


    public void decrementoImporte(BigDecimal pImporteBaseCf,
                                  BigDecimal creditoFiscal,
                                  FormularioUsuarioUltimaModificacion usuarioUltimaModificacion,
                                  CompraId compraId,
                                  BigDecimal importeTotalCompra,
                                  CompraMarcaEspecialId marcaEspecialId,
                                  String modalidadId) {
        this.record(new FormularioDecrementadoImporteDomainEvent(id.value(),
                this.totalCompras.value(),
                this.cantidadCompras.value(),
                this.determinacionPago.value(),
                this.determinacionPagoCf.value(),
                this.totalComprasCfIpn.value(),
                this.cantidadComprasCfIpn.value(),
                this.determinacionPagoCfIpn.value(),
                this.totalComprasCfElec.value(),
                this.cantidadComprasCfElec.value(),
                this.totalComprasSdCf.value(),
                this.cantidadComprasSdCf.value(),
                this.determinacionPagoSdCf.value(),
                this.totalComprasCfOtras.value(),
                this.cantidadComprasCfOtras.value(),
                this.determinacionPagoCfOtras.value(),
                this.usuarioUltimaModificacion.value(),
                this.mesPeriodo.value(),
                this.anioPeriodo.value(),
                this.nombreFormulario.value(),
                this.tipoFormularioId.value(),
                this.fechaUltimaModificacion.value(),
                this.compras().stream().map(x -> x.value()).collect(Collectors.toList()),
                this.compras().stream().map(x -> x.value()).collect(Collectors.toList())
        ));


        decrementarTotales(pImporteBaseCf, creditoFiscal,
                usuarioUltimaModificacion, compraId,
                importeTotalCompra, marcaEspecialId, modalidadId);
        this.usuarioUltimaModificacion = usuarioUltimaModificacion;
        this.fechaUltimaModificacion = new FormularioFechaUltimaModificacion(LocalDateTime.now());

        this.compras = this.compras == null ? new ArrayList<>() : this.compras;

        List<CompraId> compraIds = this.compras.stream().filter(x -> !x.value().equals(compraId.value()))
                .collect(Collectors.toList());
        this.compras = compraIds;

        crearHistorico();
    }

    public void actulizarImporteCompraSelecionada(
            CompraId compraId,
            BigDecimal pImporteBaseCfAnterior,
            BigDecimal pCreditoFiscalAnterior,
            BigDecimal pImporteTotalCompraAnterior,

            BigDecimal pImporteBaseCfActual,
            BigDecimal pCreditoFiscalActual,
            BigDecimal pImporteTotalCompraActual,
            String modalidadId,
            LocalDate pFechaFacturaActual,
            String pCodigoControlCompraActual,
            CompraMarcaEspecialId marcaEspecialId,
            FormularioUsuarioUltimaModificacion usuarioUltimaModificacion) {

        this.record(new FormularioActulizarImporteCompraSelecionadaDomainEvent(id.value(),
                this.totalCompras.value(),
                this.cantidadCompras.value(),
                this.determinacionPago.value(),
                this.determinacionPagoCf.value(),
                this.totalComprasCfIpn.value(),
                this.cantidadComprasCfIpn.value(),
                this.determinacionPagoCfIpn.value(),
                this.totalComprasCfElec.value(),
                this.cantidadComprasCfElec.value(),
                this.totalComprasSdCf.value(),
                this.cantidadComprasSdCf.value(),
                this.determinacionPagoSdCf.value(),
                this.totalComprasCfOtras.value(),
                this.cantidadComprasCfOtras.value(),
                this.determinacionPagoCfOtras.value(),
                this.usuarioUltimaModificacion.value(),
                this.mesPeriodo.value(),
                this.anioPeriodo.value(),
                this.nombreFormulario.value(),
                this.tipoFormularioId.value(),
                this.fechaUltimaModificacion.value(),
                compraId.value(),
                pImporteTotalCompraActual,
                pImporteBaseCfActual,
                pCreditoFiscalActual,
                pFechaFacturaActual,
                pCodigoControlCompraActual

        ));
        decrementarTotales(pImporteBaseCfAnterior, pCreditoFiscalAnterior,
                usuarioUltimaModificacion, compraId,
                pImporteTotalCompraAnterior, marcaEspecialId, modalidadId);


        if (!this.tipoFormularioId.value().equals("AF702")) {
            actualizaTotales(pImporteBaseCfActual, pCreditoFiscalActual,
                    usuarioUltimaModificacion, compraId,
                    pImporteTotalCompraActual, marcaEspecialId, modalidadId);
        } else {
            actualizaTotalesF702(pImporteBaseCfActual, pCreditoFiscalActual,
                    usuarioUltimaModificacion, compraId,
                    pImporteTotalCompraActual, marcaEspecialId, modalidadId);
        }

        this.usuarioUltimaModificacion = usuarioUltimaModificacion;
        this.compras = this.compras == null ? new ArrayList<>() : this.compras;
        this.compras.add(compraId);
        this.fechaUltimaModificacion = new FormularioFechaUltimaModificacion(LocalDateTime.now());
        this.usuarioUltimaModificacion = usuarioUltimaModificacion;
        this.fechaUltimaModificacion = new FormularioFechaUltimaModificacion(LocalDateTime.now());
        crearHistorico();

    }


    public FormularioId id() {
        return id;
    }

    public FormularioTipoFormularioId tipoFormularioId() {
        return tipoFormularioId;
    }

    public FormularioIfc ifc() {
        return ifc;
    }

    public FormularioNitCi nitCi() {
        return nitCi;
    }

    public FormularioMesPeriodo mesPeriodo() {
        return mesPeriodo;
    }

    public FormularioAnioPeriodo anioPeriodo() {
        return anioPeriodo;
    }

    public FormularioTotalComprasCf totalCompras() {
        return totalCompras;
    }

    public FormularioCantidadComprasCf cantidadCompras() {
        return cantidadCompras;
    }

    public FormularioCantidadComprasCfElec cantidadComprasCfElec() {
        return cantidadComprasCfElec;
    }

    public FormularioCantidadComprasCfIpn cantidadComprasCfIpn() {
        return cantidadComprasCfIpn;
    }

    public FormularioCantidadComprasCfOtras cantidadComprasCfOtras() {
        return cantidadComprasCfOtras;
    }

    public FormularioCantidadComprasSdCf cantidadComprasSdCf() {
        return cantidadComprasSdCf;
    }

    public FormularioTotalComprasCfElec totalComprasCfElec() {
        return totalComprasCfElec;
    }

    public FormularioTotalComprasCfIpn totalComprasCfIpn() {
        return totalComprasCfIpn;
    }

    public FormularioTotalComprasCfOtras totalComprasCfOtras() {
        return totalComprasCfOtras;
    }

    public FormularioTotalComprasSdCf totalComprasSdCf() {
        return totalComprasSdCf;
    }

    public FormularioDeterminacionPagoCf determinacionPagoCf() {
        return determinacionPagoCf;
    }

    public FormularioDeterminacionPagoCfIpn determinacionPagoCfIpn() {
        return determinacionPagoCfIpn;
    }

    public FormularioDeterminacionPagoCfOtras determinacionPagoCfOtras() {
        return determinacionPagoCfOtras;
    }

    public FormularioDeterminacionPagoSdCf determinacionPagoSdCf() {
        return determinacionPagoSdCf;
    }

    public FormularioTipoPresentacionId tipoPresentacionId() {
        return tipoPresentacionId;
    }

    public FormularioDireccion direccion() {
        return direccion;
    }

    public FormularioNitEmpleador nitEmpleador() {
        return nitEmpleador;
    }

    public FormularioDireccionEmpleador direccionEmpleador() {
        return direccionEmpleador;
    }

    public FormularioEstadoFormularioId estadoFormularioId() {
        return estadoFormularioId;
    }

    public FormularioNumeroEnvio numeroEnvio() {
        return numeroEnvio;
    }

    public FormularioUsuarioRegistro usuarioRegistro() {
        return usuarioRegistro;
    }

    public FormularioFechaRegistro fechaRegistro() {
        return fechaRegistro;
    }

    public FormularioUsuarioUltimaModificacion usuarioUltimaModificacion() {
        return usuarioUltimaModificacion;
    }

    public FormularioFechaUltimaModificacion fechaUltimaModificacion() {
        return fechaUltimaModificacion;
    }

    public FormularioEstadoId estadoId() {
        return estadoId;
    }

    public FormularioRazonSocial razonSocial() {
        return razonSocial;
    }

    public FormularioLugarDepartamento lugarDepartamento() {
        return lugarDepartamento;
    }

    public FormularioNombreEmpleador nombreEmpleador() {
        return nombreEmpleador;
    }

    public FormularioCodigoDependiente codigoDependiente() {
        return this.codigoDependiente;
    }

    public FormularioDeterminacionPago determinacionPago() {
        return this.determinacionPago;
    }

    public FormularioFechaPresentacion fechaPresentacion() {
        return this.fechaPresentacion;
    }

    public FormularioPeriodicidadId periodicidadId() {
        return this.periodicidadId;
    }

    public FormularioCantidadPeriodicidad cantidadPeriodicidad() {
        return this.cantidadPeriodicidad;
    }

    public FormularioNumeroOrden numeroOrden() {
        return this.numeroOrden;
    }

    public FormularioExpedicionCi expedicionCi() {
        return expedicionCi;
    }

    public FormularioNombreFormulario nombreFormulario() {
        return nombreFormulario;
    }

    public FormularioFechaEstado fechaEstado() {
        return fechaEstado;
    }

    public DatosEspecificos datosEspecificos() {
        return datosEspecificos;
    }

    public List<CompraId> compras() {
        return compras;
    }

    public FormularioNumeroSucursal numeroSucursal() {
        return numeroSucursal;
    }

    public FormularioUsuarioReceptor usuarioReceptor() {
        return usuarioReceptor;
    }

    public FormularioLoginUsuarioReceptor loginUsuarioReceptor() {
        return loginUsuarioReceptor;
    }

    public FormularioNombreReceptor nombreReceptor() {
        return nombreReceptor;
    }

    public FormularioConsolidacionId consolidacionId() {
        return consolidacionId;
    }

    public FormularioTotalComprasCfRed totalComprasCfRed() {
        return totalComprasCfRed;
    }

    public FormularioTotalComprasCfIpnRed totalComprasCfIpnRed() {
        return totalComprasCfIpnRed;
    }

    public FormularioTotalComprasCfOtrasRed totalComprasCfOtrasRed() {
        return totalComprasCfOtrasRed;
    }

    public FormularioTotalComprasSdCfRed totalComprasSdCfRed() {
        return totalComprasSdCfRed;
    }

    public FormularioDeterminacionPagoCfRed determinacionPagoCfRed() {
        return determinacionPagoCfRed;
    }

    public FormularioDeterminacionPagoCfIpnRed determinacionPagoCfIpnRed() {
        return determinacionPagoCfIpnRed;
    }

    public FormularioDeterminacionPagoCfOtrasRed determinacionPagoCfOtrasRed() {
        return determinacionPagoCfOtrasRed;
    }

    public FormularioDeterminacionPagoSdCfRed determinacionPagoSdCfRed() {
        return determinacionPagoSdCfRed;
    }

    public FormularioTipoUsoId tipoUsoId() {
        return tipoUsoId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tipoFormularioId, ifc, nitCi, mesPeriodo, anioPeriodo, totalCompras, cantidadCompras,
                tipoPresentacionId, direccion, nitEmpleador, direccionEmpleador, estadoFormularioId, numeroEnvio,
                usuarioRegistro, fechaRegistro, usuarioUltimaModificacion, fechaUltimaModificacion, estadoId);
    }

    public void RechazarFormulario(FormularioUsuarioUltimaModificacion pUsuarioUltimaModificacion,
                                   FormularioNombreReceptor pNombreReceptor,
                                   FormularioLoginUsuarioReceptor pLoginReceptor) {
        if (this.estadoFormularioId.value().equals(EstadoformularioId.DECLARADO.value())) {
            this.record(new FormularioRechazdoEventDomain(
                    this.id.value(),
                    this.estadoFormularioId.value(),
                    this.fechaUltimaModificacion.value(),
                    this.usuarioUltimaModificacion.value(),
                    pUsuarioUltimaModificacion.value(),
                    this.loginUsuarioReceptor == null ? null : this.loginUsuarioReceptor.value(),
                    this.nombreReceptor == null ? null : this.nombreReceptor.value(),
                    this.usuarioReceptor == null ? null : this.usuarioReceptor.value(),
                    this.datosEspecificos
            ));
            this.estadoFormularioId = new FormularioEstadoFormularioId(EstadoformularioId.RECHAZADO.value());
            this.fechaEstado = new FormularioFechaEstado(LocalDate.now());
            this.fechaUltimaModificacion = new FormularioFechaUltimaModificacion(LocalDateTime.now());
            this.usuarioUltimaModificacion = pUsuarioUltimaModificacion;
            this.nombreReceptor = pNombreReceptor;
            this.loginUsuarioReceptor = pLoginReceptor;
            this.usuarioReceptor = new FormularioUsuarioReceptor(pUsuarioUltimaModificacion.value());
            if (this.datosEspecificos.getMontoIpnFormRech() == null && this.datosEspecificos.getMontoOtrosFormRech() == null
                    && this.datosEspecificos.getMontoSieteRgFormRech() == null) {
                this.datosEspecificos.setMontoIpnFormRech(this.totalComprasCfIpn.value());
                this.datosEspecificos.setMontoOtrosFormRech(this.totalComprasCfOtras.value());
                this.datosEspecificos.setMontoSieteRgFormRech(this.totalComprasSdCf.value());
                this.datosEspecificos.setCantidadFacIpnFormRech(this.cantidadComprasCfIpn.value());
                this.datosEspecificos.setCantidadFacOtrasFormRech(this.cantidadComprasCfOtras.value());
                this.datosEspecificos.setCantidadFacSrgFormRech(this.cantidadComprasSdCf.value());
            }
            crearHistorico();
        }
    }

    public void aceptarFormulario(FormularioUsuarioUltimaModificacion pUsuarioUltimaModificacion,
                                  FormularioNombreReceptor pNombreReceptor,
                                  FormularioLoginUsuarioReceptor pLoginReceptor, FormularioTipoUsoId tipoUsoId) {
        if (this.estadoFormularioId.value().equals(EstadoformularioId.DECLARADO.value())) {

            this.record(new FormularioAceptadoEventDomain(
                    this.id.value(),
                    this.estadoFormularioId.value(),
                    this.fechaUltimaModificacion.value(),
                    this.usuarioUltimaModificacion.value(),
                    pUsuarioUltimaModificacion.value(),
                    this.loginUsuarioReceptor == null ? null : this.loginUsuarioReceptor.value(),
                    this.nombreReceptor == null ? null : this.nombreReceptor.value(),
                    this.usuarioReceptor == null ? null : this.usuarioReceptor.value(),
                    this.tipoUsoId.value()
            ));
            this.estadoFormularioId = new FormularioEstadoFormularioId(EstadoformularioId.ACEPTADO.value());
            this.fechaEstado = new FormularioFechaEstado(LocalDate.now());
            this.fechaUltimaModificacion = new FormularioFechaUltimaModificacion(LocalDateTime.now());
            this.usuarioUltimaModificacion = pUsuarioUltimaModificacion;
            this.loginUsuarioReceptor = pLoginReceptor;
            this.nombreReceptor = pNombreReceptor;
            this.usuarioReceptor = new FormularioUsuarioReceptor(pUsuarioUltimaModificacion.value());
            //this.esExDependiente=esExDependiente;
            crearHistorico();
        }
    }

    public void declararFormulario(FormularioNumeroOrden numeroOrden,
                                   FormularioUsuarioUltimaModificacion pUsuarioUltimaModificacion) {


        if (this.estadoFormularioId.value().equals(EstadoformularioId.REGISTRADO.value()) || this.estadoFormularioId.value().equals(EstadoformularioId.RECHAZADO.value())) {
            this.record(new FormularioDeclaradoEventDomain(
                    this.id.value(),
                    this.numeroOrden() == null ? null : this.numeroOrden().value(),
                    this.estadoFormularioId.value(),
                    this.fechaUltimaModificacion.value(),
                    this.usuarioUltimaModificacion.value(),
                    this.numeroEnvio != null ? this.numeroEnvio.value() : null,
                    this.totalComprasCfRed.value(),
                    this.totalComprasCfIpnRed.value(),
                    this.totalComprasCfOtrasRed.value(),
                    this.totalComprasSdCfRed.value(),
                    this.determinacionPagoCfRed.value(),
                    this.determinacionPagoCfIpnRed.value(),
                    this.determinacionPagoCfOtrasRed.value(),
                    this.determinacionPagoSdCfRed.value(),
                    pUsuarioUltimaModificacion.value()));
            this.estadoFormularioId = new FormularioEstadoFormularioId(EstadoformularioId.DECLARADO.value());
            this.fechaEstado = new FormularioFechaEstado(LocalDate.now());
            this.numeroOrden = numeroOrden;
            if (!this.tipoFormularioId.value().equals(EnumTipoFormularioId.FORMULARIO_110.value()) &&  !this.tipoFormularioId.value().equals(EnumTipoFormularioId.FORMULARIO_111.value())){
                this.fechaPresentacion = new FormularioFechaPresentacion(LocalDate.now());
            }

            this.fechaUltimaModificacion = new FormularioFechaUltimaModificacion(LocalDateTime.now());
            this.usuarioUltimaModificacion = pUsuarioUltimaModificacion;
            this.numeroEnvio = new FormularioNumeroEnvio(this.numeroEnvio.value() + 1);
            this.totalComprasCfRed = totalComprasCfRed.redondeo(this.totalCompras.value());
            this.totalComprasCfIpnRed = totalComprasCfIpnRed.redondeo(this.totalComprasCfIpn.value());
            this.totalComprasCfOtrasRed = totalComprasCfOtrasRed.redondeo(this.totalComprasCfOtras.value());
            this.totalComprasSdCfRed = totalComprasSdCfRed.redondeo(this.totalComprasSdCf.value());
            this.determinacionPagoCfRed = determinacionPagoCfRed.redondeo(this.determinacionPagoCf.value());
            this.determinacionPagoCfIpnRed = determinacionPagoCfIpnRed.redondeo(this.determinacionPagoCfIpn.value());
            this.determinacionPagoCfOtrasRed = determinacionPagoCfOtrasRed.redondeo(this.determinacionPagoCfOtras.value());
            this.determinacionPagoSdCfRed = determinacionPagoSdCfRed.redondeo(this.determinacionPagoSdCf.value());
            crearHistorico();

        }
    }

    public void cancelarDeclaracionFormulario(FormularioUsuarioUltimaModificacion pUsuarioUltimaModificacion) {
        if (this.estadoFormularioId.value().equals(EstadoformularioId.DECLARADO.value())) {
            this.record(new FormularioDeclaradoCanceladoEventDomain(
                    this.id.value(),
                    this.estadoFormularioId.value(),
                    this.fechaUltimaModificacion.value(),
                    this.usuarioUltimaModificacion.value(),
                    pUsuarioUltimaModificacion.value()));
            if (this.datosEspecificos.getMontoOtrosFormRech() == null) {
                this.estadoFormularioId = new FormularioEstadoFormularioId(EstadoformularioId.REGISTRADO.value());
            } else {
                this.estadoFormularioId = new FormularioEstadoFormularioId(EstadoformularioId.RECHAZADO.value());
            }
            this.fechaEstado = new FormularioFechaEstado(LocalDate.now());
            this.fechaUltimaModificacion = new FormularioFechaUltimaModificacion(LocalDateTime.now());
            this.usuarioUltimaModificacion = pUsuarioUltimaModificacion;
            crearHistorico();
        }
    }

    public void rectificarFormulario(FormularioNumeroOrden numeroOrden,
                                     FormularioUsuarioUltimaModificacion pUsuarioUltimaModificacion) {
        if (this.estadoFormularioId.value().equals(EstadoformularioId.RECHAZADO.value())) {
            this.record(new FormularioDeclaradoEventDomain(this.id.value(),
                    this.numeroOrden().value(),
                    this.estadoFormularioId.value(),
                    this.fechaUltimaModificacion.value(),
                    this.usuarioUltimaModificacion.value(),
                    this.numeroEnvio.value(),
                    this.totalComprasCfRed.value(),
                    this.totalComprasCfIpnRed.value(),
                    this.totalComprasCfOtrasRed.value(),
                    this.totalComprasSdCfRed.value(),
                    this.determinacionPagoCfRed.value(),
                    this.determinacionPagoCfIpnRed.value(),
                    this.determinacionPagoCfOtrasRed.value(),
                    this.determinacionPagoSdCfRed.value(),
                    pUsuarioUltimaModificacion.value()));
            this.estadoFormularioId = new FormularioEstadoFormularioId(EstadoformularioId.DECLARADO.value());
            this.fechaEstado = new FormularioFechaEstado(LocalDate.now());
            this.numeroOrden = numeroOrden;
            this.fechaUltimaModificacion = new FormularioFechaUltimaModificacion(LocalDateTime.now());
            this.usuarioUltimaModificacion = pUsuarioUltimaModificacion;
            this.totalComprasCfRed = totalComprasCfRed.redondeo(this.totalCompras.value());
            this.totalComprasCfIpnRed = totalComprasCfIpnRed.redondeo(this.totalComprasCfIpn.value());
            this.totalComprasCfOtrasRed = totalComprasCfOtrasRed.redondeo(this.totalComprasCfOtras.value());
            this.totalComprasSdCfRed = totalComprasSdCfRed.redondeo(this.totalComprasSdCf.value());
            this.determinacionPagoCfRed = determinacionPagoCfRed.redondeo(this.determinacionPagoCf.value());
            this.determinacionPagoCfIpnRed = determinacionPagoCfIpnRed.redondeo(this.determinacionPagoCfIpn.value());
            this.determinacionPagoCfOtrasRed = determinacionPagoCfOtrasRed.redondeo(this.determinacionPagoCfOtras.value());
            this.determinacionPagoSdCfRed = determinacionPagoSdCfRed.redondeo(this.determinacionPagoSdCf.value());
            crearHistorico();
        }
    }

    public void consolidarFormulario(FormularioConsolidacionId pIdConsolidacion, FormularioUsuarioUltimaModificacion pUsuarioUltimaModificacion) {
        if (this.estadoFormularioId.value().equals(EstadoformularioId.ACEPTADO.value())) {
            this.usuarioUltimaModificacion = pUsuarioUltimaModificacion;
            this.consolidacionId = pIdConsolidacion;
            crearHistorico();
        }
    }

    public void modificarFechaPresentacion(FormularioFechaPresentacion fechaPresentacion,
                                           FormularioUsuarioUltimaModificacion pUsuarioUltimaModificacion) {
        this.fechaPresentacion = fechaPresentacion;
        this.fechaUltimaModificacion = new FormularioFechaUltimaModificacion(LocalDateTime.now());
        this.usuarioUltimaModificacion = pUsuarioUltimaModificacion;
        crearHistorico();
    }

    // Create Formulario
    public static Formulario habilitarRectificatorio(Formulario pFormularioRectificar, FormularioUsuarioUltimaModificacion usuarioUltimaModificacion, String pIdNuevoformulario) {

        FormularioId id = new FormularioId(pIdNuevoformulario);
        FormularioTipoFormularioId tipoFormularioId = pFormularioRectificar.tipoFormularioId;
        FormularioNitCi nitCi = pFormularioRectificar.nitCi;
        FormularioIfc ifc = pFormularioRectificar.ifc;
        FormularioCodigoDependiente codigoDependiente = new FormularioCodigoDependiente();
        FormularioRazonSocial razonSocial = new FormularioRazonSocial(pFormularioRectificar.razonSocial.value());
        FormularioExpedicionCi expedicionCi = new FormularioExpedicionCi();
        FormularioMesPeriodo mesPeriodo = pFormularioRectificar.mesPeriodo;
        FormularioAnioPeriodo anioPeriodo = pFormularioRectificar.anioPeriodo;
        FormularioNombreFormulario nombreFormulario = pFormularioRectificar.nombreFormulario;
        FormularioCantidadComprasCf cantidadCompras = pFormularioRectificar.cantidadCompras;
        FormularioTotalComprasCf totalCompras = pFormularioRectificar.totalCompras;

        FormularioCantidadComprasCfElec cantidadComprasCfElec = pFormularioRectificar.cantidadComprasCfElec;
        FormularioCantidadComprasCfIpn cantidadComprasCfIpn = pFormularioRectificar.cantidadComprasCfIpn;
        FormularioCantidadComprasCfOtras cantidadComprasCfOtras = pFormularioRectificar.cantidadComprasCfOtras;
        FormularioCantidadComprasSdCf cantidadComprasSdCf = pFormularioRectificar.cantidadComprasSdCf;
        FormularioTotalComprasCfElec totalComprasCfElec = pFormularioRectificar.totalComprasCfElec;
        FormularioTotalComprasCfIpn totalComprasCfIpn = pFormularioRectificar.totalComprasCfIpn;
        FormularioTotalComprasCfOtras totalComprasCfOtras = pFormularioRectificar.totalComprasCfOtras;
        FormularioTotalComprasSdCf totalComprasSdCf = pFormularioRectificar.totalComprasSdCf;
        FormularioDeterminacionPagoCf determinacionPagoCf = pFormularioRectificar.determinacionPagoCf;
        FormularioDeterminacionPagoCfIpn determinacionPagoCfIpn = pFormularioRectificar.determinacionPagoCfIpn;
        FormularioDeterminacionPagoCfOtras determinacionPagoCfOtras = pFormularioRectificar.determinacionPagoCfOtras;
        FormularioDeterminacionPagoSdCf determinacionPagoSdCf = pFormularioRectificar.determinacionPagoSdCf;

        FormularioDeterminacionPago determinacionPago = pFormularioRectificar.determinacionPago;
        FormularioLugarDepartamento lugarDepartamento = pFormularioRectificar.lugarDepartamento;
        FormularioTipoPresentacionId tipoPresentacionId = new FormularioTipoPresentacionId("REC");
        FormularioDireccion direccion = pFormularioRectificar.direccion;
        FormularioNitEmpleador nitEmpleador = pFormularioRectificar.nitEmpleador != null ? pFormularioRectificar.nitEmpleador : new FormularioNitEmpleador();
        FormularioNombreEmpleador nombreEmpleador = pFormularioRectificar.nombreEmpleador != null ? pFormularioRectificar.nombreEmpleador : new FormularioNombreEmpleador();
        FormularioDireccionEmpleador direccionEmpleador = pFormularioRectificar.direccionEmpleador != null ? pFormularioRectificar.direccionEmpleador : new FormularioDireccionEmpleador();
        FormularioFechaPresentacion fechaPresentacion = pFormularioRectificar.fechaPresentacion;
        FormularioPeriodicidadId periodicidadId = pFormularioRectificar.periodicidadId;
        FormularioCantidadPeriodicidad cantidadPeriodicidad = pFormularioRectificar.cantidadPeriodicidad;
        FormularioNumeroOrden numeroOrden = pFormularioRectificar.numeroOrden;
        FormularioEstadoFormularioId estadoFormularioId = new FormularioEstadoFormularioId("REG");
        FormularioFechaEstado fechaEstado = pFormularioRectificar.fechaEstado;
        FormularioNumeroEnvio numeroEnvio = pFormularioRectificar.numeroEnvio;
        FormularioUsuarioRegistro usuarioRegistro = new FormularioUsuarioRegistro(usuarioUltimaModificacion.value());
        FormularioFechaRegistro fechaRegistro = new FormularioFechaRegistro(LocalDateTime.now());
        FormularioFechaUltimaModificacion fechaUltimaModificacion = new FormularioFechaUltimaModificacion(LocalDateTime.now());
        FormularioEstadoId estadoId = pFormularioRectificar.estadoId;
        FormularioNumeroSucursal numeroSucursal = pFormularioRectificar.numeroSucursal;
        FormularioUsuarioReceptor usuarioReceptor = pFormularioRectificar.usuarioReceptor;
        FormularioLoginUsuarioReceptor loginUsuarioReceptor = pFormularioRectificar.loginUsuarioReceptor;
        FormularioNombreReceptor nombreReceptor = pFormularioRectificar.nombreReceptor;
        FormularioTotalComprasCfRed totalComprasCfRed = pFormularioRectificar.totalComprasCfRed;
        FormularioTotalComprasCfIpnRed totalComprasCfIpnRed = pFormularioRectificar.totalComprasCfIpnRed;
        FormularioTotalComprasCfOtrasRed totalComprasCfOtrasRed = pFormularioRectificar.totalComprasCfOtrasRed;
        FormularioTotalComprasSdCfRed totalComprasSdCfRed = pFormularioRectificar.totalComprasSdCfRed;
        FormularioDeterminacionPagoCfRed determinacionPagoCfRed = pFormularioRectificar.determinacionPagoCfRed;
        FormularioDeterminacionPagoCfIpnRed determinacionPagoCfIpnRed = pFormularioRectificar.determinacionPagoCfIpnRed;
        FormularioDeterminacionPagoCfOtrasRed determinacionPagoCfOtrasRed = pFormularioRectificar.determinacionPagoCfOtrasRed;
        FormularioDeterminacionPagoSdCfRed determinacionPagoSdCfRed = pFormularioRectificar.determinacionPagoSdCfRed;
        FormularioConsolidacionId consolidacionId = new FormularioConsolidacionId(null);
        FormularioTipoUsoId tipoUsoId = new FormularioTipoUsoId("D");

        List<CompraId> compras = pFormularioRectificar.compras;
        DatosEspecificos datosEspecificos = new DatosEspecificos();
        datosEspecificos.setIdFormularioRectificado(pFormularioRectificar.id.value().toString());
        datosEspecificos.setTipoDocumento(pFormularioRectificar.datosEspecificos.getTipoDocumento());
        datosEspecificos.setDescripcionTipoDocumento(pFormularioRectificar.datosEspecificos.getDescripcionTipoDocumento());
        datosEspecificos.setNumeroDocumento(pFormularioRectificar.datosEspecificos.getNumeroDocumento());
        datosEspecificos.setComplementoDocumento(pFormularioRectificar.datosEspecificos.getComplementoDocumento());
        datosEspecificos.setLugarExpedicion(pFormularioRectificar.datosEspecificos.getLugarExpedicion());
        datosEspecificos.setDescripcionLugarExpedicion(pFormularioRectificar.datosEspecificos.getDescripcionLugarExpedicion());

        Formulario formulario = new Formulario(id, tipoFormularioId, nitCi, ifc, codigoDependiente, razonSocial,
                expedicionCi, mesPeriodo, anioPeriodo, nombreFormulario, cantidadCompras, totalCompras,
                cantidadComprasCfElec, cantidadComprasCfIpn, cantidadComprasCfOtras,
                cantidadComprasSdCf, totalComprasCfElec, totalComprasCfIpn,
                totalComprasCfOtras, totalComprasSdCf, determinacionPagoCf,
                determinacionPagoCfIpn, determinacionPagoCfOtras, determinacionPagoSdCf,
                determinacionPago, lugarDepartamento, tipoPresentacionId, direccion, nitEmpleador, nombreEmpleador,
                direccionEmpleador, fechaPresentacion, periodicidadId, cantidadPeriodicidad, numeroOrden,
                estadoFormularioId, fechaEstado, numeroEnvio, usuarioRegistro, fechaRegistro, usuarioUltimaModificacion,
                fechaUltimaModificacion, estadoId, numeroSucursal, usuarioReceptor, loginUsuarioReceptor, nombreReceptor,
                totalComprasCfRed,
                totalComprasCfIpnRed,
                totalComprasCfOtrasRed,
                totalComprasSdCfRed,
                determinacionPagoCfRed,
                determinacionPagoCfIpnRed,
                determinacionPagoCfOtrasRed,
                determinacionPagoSdCfRed,
                consolidacionId,
                tipoUsoId,
                compras, datosEspecificos);

        formulario.record(FormularioRegistradoDomainEvent.FormularioRegistradoDomainEvent().id(id.value())
                .tipoFormularioId(tipoFormularioId.value()).ifc(ifc.value()).nitCi(nitCi.value())
                .codigoDependiente(codigoDependiente.value()).razonSocial(razonSocial.value())
                .expedicionCi(expedicionCi.value()).mesPeriodo(mesPeriodo.value()).anioPeriodo(anioPeriodo.value())
                .nombreFormulario(nombreFormulario.value()).cantidadCompras(cantidadCompras.value())
                .totalCompras(totalCompras.value()).determinacionPago(determinacionPago.value())
                .lugarDepartamento(lugarDepartamento.value()).tipoPresentacionId(tipoPresentacionId.value())
                .direccion(direccion.value()).nitEmpleador(nitEmpleador.value())
                .nombreEmpleador(nombreEmpleador.value()).direccionEmpleador(direccionEmpleador.value())
                .fechaPresentacion(fechaPresentacion.value()).periodicidadId(periodicidadId.value())
                .cantidadPeriodicidad(cantidadPeriodicidad.value()).numeroOrden(numeroOrden.value())
                .fechaEstado(fechaEstado.value()).estadoFormularioId(estadoFormularioId.value())
                .numeroEnvio(numeroEnvio.value()).usuarioRegistro(usuarioRegistro.value())
                .fechaRegistro(fechaRegistro.value()).usuarioUltimaModificacion(usuarioUltimaModificacion.value())
                .fechaUltimaModificacion(fechaUltimaModificacion.value())
                .totalComprasCfIpn(totalComprasCfIpn.value())
                .totalComprasCfOtras(totalComprasCfOtras.value())
                .totalComprasSdCf(totalComprasSdCf.value())
                .estadoId(estadoId.value())
                .comprasId(compras.stream().map(compraId -> compraId.value()).collect(Collectors.toList())).datosEspecificos(datosEspecificos).build());
        formulario.compras = compras;
        return formulario;
    }

    public void inhabilitaFormulario(FormularioUsuarioUltimaModificacion pUsuarioUltimaModificacion, String pIdFormularioRectificado) {

        this.estadoFormularioId = new FormularioEstadoFormularioId("REC");
        this.fechaUltimaModificacion = new FormularioFechaUltimaModificacion(LocalDateTime.now());
        this.usuarioUltimaModificacion = pUsuarioUltimaModificacion;
        this.record(new FormularioAnexoRectificadoDeclaradoEventDomain(this.id.value(), this.numeroOrden().value(),
                this.estadoFormularioId.value(), this.fechaPresentacion.value(), this.determinacionPago.value(),
                this.fechaUltimaModificacion.value(), this.usuarioUltimaModificacion.value(),
                this.totalComprasCfIpn.value(),
                this.totalComprasCfOtras.value(), this.totalComprasSdCf.value(),
                this.compras().stream().map(x -> x.value()).collect(Collectors.toList()), pIdFormularioRectificado));
    }

    public void actualizaTotales(BigDecimal ImporteBaseCf, BigDecimal creditoFiscal,
                                 FormularioUsuarioUltimaModificacion usuarioUltimaModificacion, CompraId compraId,
                                 BigDecimal importeTotalCompra, CompraMarcaEspecialId marcaEspecialId, String modalidadId) {
        if (marcaEspecialId.value() != null &&
                marcaEspecialId.value().equals(EnumMarcaEspecialId.IPN.value())) {
            this.totalCompras = this.totalCompras.adicion(ImporteBaseCf);
            this.cantidadCompras = this.cantidadCompras.incrementar();
            this.determinacionPagoCf = this.determinacionPagoCf.adicion(creditoFiscal);
            this.totalComprasCfIpn = this.totalComprasCfIpn.adicion(ImporteBaseCf);
            this.cantidadComprasCfIpn = this.cantidadComprasCfIpn.incrementar();
            this.determinacionPagoCfIpn = this.determinacionPagoCfIpn.adicion(creditoFiscal);
            this.determinacionPago = this.determinacionPago.adicion(creditoFiscal);

            if (modalidadId.equals(EnumModalidadId.ELECTRONICA_CICLOS.value()) ||
                    modalidadId.equals(EnumModalidadId.FACTURA_PORTAL_WB.value()) ||
                    modalidadId.equals(EnumModalidadId.FACTURA_ELECTRONICA_LINEA.value()) ||
                    modalidadId.equals(EnumModalidadId.FACTURA_COMPUTARIZADA_LINEA.value()) ||
                    modalidadId.equals(EnumModalidadId.ELECTRONICA.value())) {
                this.cantidadComprasCfElec = this.cantidadComprasCfElec.incrementar();
                this.totalComprasCfElec = this.totalComprasCfElec.adicion(ImporteBaseCf);
            }
        } else if (marcaEspecialId.value() != null && marcaEspecialId.value().equals(EnumMarcaEspecialId.SIETERG.value())) {
            this.totalComprasSdCf = this.totalComprasSdCf.adicion(importeTotalCompra);
            this.cantidadComprasSdCf = this.cantidadComprasSdCf.incrementar();
            this.determinacionPagoSdCf = this.determinacionPagoSdCf.adicion(creditoFiscal);
            this.determinacionPago = this.determinacionPago.adicion(creditoFiscal);
            if (modalidadId.equals(EnumModalidadId.ELECTRONICA_CICLOS.value()) ||
                    modalidadId.equals(EnumModalidadId.FACTURA_PORTAL_WB.value()) ||
                    modalidadId.equals(EnumModalidadId.FACTURA_ELECTRONICA_LINEA.value()) ||
                    modalidadId.equals(EnumModalidadId.FACTURA_COMPUTARIZADA_LINEA.value()) ||
                    modalidadId.equals(EnumModalidadId.ELECTRONICA.value())) {
                this.cantidadComprasCfElec = this.cantidadComprasCfElec.incrementar();
                this.totalComprasCfElec = this.totalComprasCfElec.adicion(importeTotalCompra);
            }
        } else {
            this.totalCompras = this.totalCompras.adicion(ImporteBaseCf);
            this.cantidadCompras = this.cantidadCompras.incrementar();
            this.determinacionPagoCf = this.determinacionPagoCf.adicion(creditoFiscal);
            this.totalComprasCfOtras = this.totalComprasCfOtras.adicion(ImporteBaseCf);
            this.cantidadComprasCfOtras = this.cantidadComprasCfOtras.incrementar();
            this.determinacionPagoCfOtras = this.determinacionPagoCfOtras.adicion(creditoFiscal);
            this.determinacionPago = this.determinacionPago.adicion(creditoFiscal);
            if (modalidadId.equals(EnumModalidadId.ELECTRONICA_CICLOS.value()) ||
                    modalidadId.equals(EnumModalidadId.FACTURA_PORTAL_WB.value()) ||
                    modalidadId.equals(EnumModalidadId.FACTURA_ELECTRONICA_LINEA.value()) ||
                    modalidadId.equals(EnumModalidadId.FACTURA_COMPUTARIZADA_LINEA.value()) ||
                    modalidadId.equals(EnumModalidadId.ELECTRONICA.value())) {
                this.cantidadComprasCfElec = this.cantidadComprasCfElec.incrementar();
                this.totalComprasCfElec = this.totalComprasCfElec.adicion(ImporteBaseCf);
            }
        }
    }

    public void actualizaTotalesF702(BigDecimal ImporteBaseCf,
                                     BigDecimal creditoFiscal,
                                     FormularioUsuarioUltimaModificacion usuarioUltimaModificacion,
                                     CompraId compraId,
                                     BigDecimal importeTotalCompra,
                                     CompraMarcaEspecialId marcaEspecialId,
                                     String modalidadId) {
        if (marcaEspecialId.value() != null && marcaEspecialId.value().equals(EnumMarcaEspecialId.IPN.value())) {
            this.totalCompras = this.totalCompras.adicion(ImporteBaseCf);
            this.cantidadCompras = this.cantidadCompras.incrementar();
            this.determinacionPagoCf = this.determinacionPagoCf.adicion(
                    ImporteBaseCf.multiply(new BigDecimal(Utils.IMPUESTO_IPN_STI)));
            this.totalComprasCfIpn = this.totalComprasCfIpn.adicion(ImporteBaseCf);
            this.cantidadComprasCfIpn = this.cantidadComprasCfIpn.incrementar();
            this.determinacionPagoCfIpn = this.determinacionPagoCfIpn.adicion(
                    ImporteBaseCf.multiply(new BigDecimal(Utils.IMPUESTO_IPN_STI)));
            this.determinacionPago = this.determinacionPago.adicion(
                    ImporteBaseCf.multiply(new BigDecimal(Utils.IMPUESTO_IPN_STI)));


            if (modalidadId.equals(EnumModalidadId.ELECTRONICA_CICLOS.value()) ||
                    modalidadId.equals(EnumModalidadId.FACTURA_PORTAL_WB.value()) ||
                    modalidadId.equals(EnumModalidadId.FACTURA_ELECTRONICA_LINEA.value()) ||
                    modalidadId.equals(EnumModalidadId.FACTURA_COMPUTARIZADA_LINEA.value()) ||
                    modalidadId.equals(EnumModalidadId.ELECTRONICA.value())) {
                this.cantidadComprasCfElec = this.cantidadComprasCfElec.incrementar();
                this.totalComprasCfElec = this.totalComprasCfElec.adicion(ImporteBaseCf);
            }
        } else if (marcaEspecialId.value() != null && marcaEspecialId.value().equals(EnumMarcaEspecialId.SIETERG.value())) {
            this.totalComprasSdCf = this.totalComprasSdCf.adicion(importeTotalCompra);
            this.cantidadComprasSdCf = this.cantidadComprasSdCf.incrementar();
            this.determinacionPagoSdCf = this.determinacionPagoSdCf.adicion(
                    importeTotalCompra.multiply(new BigDecimal(Utils.IMPUESTO_7RG)));
            this.determinacionPago = this.determinacionPago.adicion(
                    importeTotalCompra.multiply(new BigDecimal(Utils.IMPUESTO_7RG)));
            if (modalidadId.equals(EnumModalidadId.ELECTRONICA_CICLOS.value()) ||
                    modalidadId.equals(EnumModalidadId.FACTURA_PORTAL_WB.value()) ||
                    modalidadId.equals(EnumModalidadId.FACTURA_ELECTRONICA_LINEA.value()) ||
                    modalidadId.equals(EnumModalidadId.FACTURA_COMPUTARIZADA_LINEA.value()) ||
                    modalidadId.equals(EnumModalidadId.ELECTRONICA.value())) {
                this.cantidadComprasCfElec = this.cantidadComprasCfElec.incrementar();
                this.totalComprasCfElec = this.totalComprasCfElec.adicion(importeTotalCompra);
            }
        } else {
            this.totalCompras = this.totalCompras.adicion(ImporteBaseCf);
            this.cantidadCompras = this.cantidadCompras.incrementar();
            this.determinacionPagoCf = this.determinacionPagoCf.adicion(
                    ImporteBaseCf.multiply(new BigDecimal(Utils.IMPUESTO_STI)));
            this.totalComprasCfOtras = this.totalComprasCfOtras.adicion(ImporteBaseCf);
            this.cantidadComprasCfOtras = this.cantidadComprasCfOtras.incrementar();
            this.determinacionPagoCfOtras = this.determinacionPagoCfOtras.adicion(
                    ImporteBaseCf.multiply(new BigDecimal(Utils.IMPUESTO_STI)));
            this.determinacionPago = this.determinacionPago.adicion(
                    ImporteBaseCf.multiply(new BigDecimal(Utils.IMPUESTO_STI)));
            if (modalidadId.equals(EnumModalidadId.ELECTRONICA_CICLOS.value()) ||
                    modalidadId.equals(EnumModalidadId.FACTURA_PORTAL_WB.value()) ||
                    modalidadId.equals(EnumModalidadId.FACTURA_ELECTRONICA_LINEA.value()) ||
                    modalidadId.equals(EnumModalidadId.FACTURA_COMPUTARIZADA_LINEA.value()) ||
                    modalidadId.equals(EnumModalidadId.ELECTRONICA.value())) {
                this.cantidadComprasCfElec = this.cantidadComprasCfElec.incrementar();
                this.totalComprasCfElec = this.totalComprasCfElec.adicion(ImporteBaseCf);
            }
        }
    }

    public void actualizaTotalesF111(BigDecimal ImporteBaseCf
    ) {
        this.totalCompras = this.totalCompras.adicion(ImporteBaseCf);
        this.cantidadCompras = this.cantidadCompras.incrementar();
        this.determinacionPagoCf = this.determinacionPagoCf.adicion(creditoReIva(ImporteBaseCf));
        this.totalComprasCfOtras = this.totalComprasCfOtras.adicion(ImporteBaseCf);
        this.cantidadComprasCfOtras = this.cantidadComprasCfOtras.incrementar();
        this.determinacionPagoCfOtras = this.determinacionPagoCfOtras.adicion(creditoReIva(ImporteBaseCf));
        this.determinacionPago = this.determinacionPago.adicion(creditoReIva(ImporteBaseCf));
    }

    private BigDecimal creditoReIva(BigDecimal ImporteBaseCf) {
        return ImporteBaseCf.multiply(new BigDecimal(Utils.IMPUESTO_RRIVA));
    }

    public void decrementarTotales(BigDecimal pImporteBaseCf, BigDecimal creditoFiscal,
                                   FormularioUsuarioUltimaModificacion usuarioUltimaModificacion, CompraId compraId,
                                   BigDecimal importeTotalCompra, CompraMarcaEspecialId marcaEspecialId, String modalidadId) {
        if (marcaEspecialId.value() != null && marcaEspecialId.value().equals(EnumMarcaEspecialId.IPN.value())) {
            this.totalCompras = this.totalCompras.substracion(pImporteBaseCf);
            this.cantidadCompras = this.cantidadCompras.decrementar();
            this.determinacionPagoCf = this.determinacionPagoCf.substracion(creditoFiscal);
            this.totalComprasCfIpn = this.totalComprasCfIpn.substracion(pImporteBaseCf);
            this.cantidadComprasCfIpn = this.cantidadComprasCfIpn.decrementar();
            this.determinacionPagoCfIpn = this.determinacionPagoCfIpn.substracion(creditoFiscal);
            this.determinacionPago = this.determinacionPago.substracion(creditoFiscal);


            if (modalidadId.equals(EnumModalidadId.ELECTRONICA_CICLOS.value()) ||
                    modalidadId.equals(EnumModalidadId.FACTURA_PORTAL_WB.value()) ||
                    modalidadId.equals(EnumModalidadId.FACTURA_ELECTRONICA_LINEA.value()) ||
                    modalidadId.equals(EnumModalidadId.FACTURA_COMPUTARIZADA_LINEA.value()) ||
                    modalidadId.equals(EnumModalidadId.ELECTRONICA.value())) {
                this.cantidadComprasCfElec = this.cantidadComprasCfElec.decrementar();
                this.totalComprasCfElec = this.totalComprasCfElec.substracion(pImporteBaseCf);
            }
        } else if (marcaEspecialId.value() != null && marcaEspecialId.value().equals(EnumMarcaEspecialId.SIETERG.value())) {
            this.totalComprasSdCf = this.totalComprasSdCf.substracion(importeTotalCompra);
            this.cantidadComprasSdCf = this.cantidadComprasSdCf.decrementar();
            this.determinacionPagoSdCf = this.determinacionPagoSdCf.substracion(creditoFiscal);
            this.determinacionPago = this.determinacionPago.substracion(creditoFiscal);
            if (modalidadId.equals(EnumModalidadId.ELECTRONICA_CICLOS.value()) ||
                    modalidadId.equals(EnumModalidadId.FACTURA_PORTAL_WB.value()) ||
                    modalidadId.equals(EnumModalidadId.FACTURA_ELECTRONICA_LINEA.value()) ||
                    modalidadId.equals(EnumModalidadId.FACTURA_COMPUTARIZADA_LINEA.value()) ||
                    modalidadId.equals(EnumModalidadId.ELECTRONICA.value())) {
                this.cantidadComprasCfElec = this.cantidadComprasCfElec.decrementar();
                this.totalComprasCfElec = this.totalComprasCfElec.substracion(pImporteBaseCf);
            }
        } else {
            this.totalCompras = this.totalCompras.substracion(pImporteBaseCf);
            this.cantidadCompras = this.cantidadCompras.decrementar();
            this.determinacionPagoCf = this.determinacionPagoCf.substracion(creditoFiscal);
            this.totalComprasCfOtras = this.totalComprasCfOtras.substracion(pImporteBaseCf);
            this.cantidadComprasCfOtras = this.cantidadComprasCfOtras.decrementar();
            this.determinacionPagoCfOtras = this.determinacionPagoCfOtras.substracion(creditoFiscal);
            this.determinacionPago = this.determinacionPago.substracion(creditoFiscal);
            if (modalidadId.equals(EnumModalidadId.ELECTRONICA_CICLOS.value()) ||
                    modalidadId.equals(EnumModalidadId.FACTURA_PORTAL_WB.value()) ||
                    modalidadId.equals(EnumModalidadId.FACTURA_ELECTRONICA_LINEA.value()) ||
                    modalidadId.equals(EnumModalidadId.FACTURA_COMPUTARIZADA_LINEA.value()) ||
                    modalidadId.equals(EnumModalidadId.ELECTRONICA.value())) {
                this.cantidadComprasCfElec = this.cantidadComprasCfElec.decrementar();
                this.totalComprasCfElec = this.totalComprasCfElec.substracion(pImporteBaseCf);
            }
        }

    }

    public void eliminar(FormularioUsuarioUltimaModificacion usuarioUltimaModificacion) {
        this.usuarioUltimaModificacion = usuarioUltimaModificacion;
        this.estadoId = new FormularioEstadoId(ConstEstado.ESTADO_ANULADO);
        this.fechaUltimaModificacion = new FormularioFechaUltimaModificacion(LocalDateTime.now());
        this.record(new FormularioEliminadoEventDomain(this.id.value(),
                this.fechaUltimaModificacion.value(), this.usuarioUltimaModificacion.value(),
                this.totalComprasCfIpn.value(),
                this.totalComprasCfOtras.value(), this.totalComprasSdCf.value(),
                this.compras().stream().map(x -> x.value()).collect(Collectors.toList())));
        crearHistorico();
    }




    private void crearFormularioIncImpDomainEvent(List<CompraResponseGenerico> pComprasResponse) {
        this.record(new FormularioIncrementadoImporteDomainEvent(id.value(),
                this.totalCompras.value(),
                this.cantidadCompras.value(),
                this.determinacionPago.value(),
                this.determinacionPagoCf.value(),
                this.totalComprasCfIpn.value(),
                this.cantidadComprasCfIpn.value(),
                this.determinacionPagoCfIpn.value(),
                this.totalComprasCfElec.value(),
                this.cantidadComprasCfElec.value(),
                this.totalComprasSdCf.value(),
                this.cantidadComprasSdCf.value(),
                this.determinacionPagoSdCf.value(),
                this.totalComprasCfOtras.value(),
                this.cantidadComprasCfOtras.value(),
                this.determinacionPagoCfOtras.value(),
                this.usuarioUltimaModificacion.value(),
                this.mesPeriodo.value(),
                this.anioPeriodo.value(),
                this.nombreFormulario.value(),
                this.tipoFormularioId.value(),
                this.fechaUltimaModificacion.value(),
                this.compras().stream().map(x -> x.value()).collect(Collectors.toList()),
                pComprasResponse.stream().map(CompraResponseGenerico::getId).collect(Collectors.toList()))
        );
    }


    public void incrementoImporte(List<CompraResponseGenerico> pComprasResponse, FormularioUsuarioUltimaModificacion pUsuarioUltimaModificacion) {
        if (pComprasResponse.size() < 1) {
            return;
        }



        if (this.estadoFormularioId.value().equals(EstadoformularioId.RECHAZADO.value()) || this.estadoFormularioId.value().equals(EstadoformularioId.REGISTRADO.value())) {

            crearFormularioIncImpDomainEvent(pComprasResponse);
            pComprasResponse.stream().forEach(compraResponseGenerico -> {
                        if (this.tipoFormularioId.value().equals(EnumTipoFormularioId.FORMULARIO_110.value())
                                || this.tipoFormularioId.value().equals(EnumTipoFormularioId.FORMULARIO_110_AF510.value())
                                || this.tipoFormularioId.value().equals(EnumTipoFormularioId.FORMULARIO_110_AF610.value())

                        ) {
                            actualizaTotales(compraResponseGenerico.importeBaseCf(),
                                    compraResponseGenerico.creditoFiscal(),
                                    pUsuarioUltimaModificacion,
                                    new CompraId(compraResponseGenerico.id()),
                                    compraResponseGenerico.importeTotalCompra(),
                                    new CompraMarcaEspecialId(compraResponseGenerico.marcaEspecialId()),
                                    compraResponseGenerico.modalidadId());
                        }
                        if (this.tipoFormularioId.value().equals(EnumTipoFormularioId.FORMULARIO_111.value())) {
                            actualizaTotalesF111(compraResponseGenerico.importeBaseCf());
                        }
                        if (this.tipoFormularioId.value().equals(EnumTipoFormularioId.FORMULARIO_110_AF702.value())) {

                            actualizaTotalesF702(compraResponseGenerico.importeBaseCf(),
                                    compraResponseGenerico.creditoFiscal(),
                                    pUsuarioUltimaModificacion, new CompraId(compraResponseGenerico.id()),
                                    compraResponseGenerico.importeTotalCompra(), new CompraMarcaEspecialId(compraResponseGenerico.marcaEspecialId()),
                                    compraResponseGenerico.modalidadId());
                        }
                        this.usuarioUltimaModificacion = pUsuarioUltimaModificacion;
                        this.compras = this.compras == null ? new ArrayList<>() : this.compras;
                        this.compras.add(new CompraId(compraResponseGenerico.id()));
                        this.fechaUltimaModificacion = new FormularioFechaUltimaModificacion(LocalDateTime.now());
                    }
            );
            if(this.tipoFormularioId.value().equals(EnumTipoFormularioId.FORMULARIO_111.value())){



                this.actulizarDeterminacionPagoFormulario111();


            }
            crearHistorico();
        }


    }

    private void actulizarDeterminacionPagoFormulario111(){

        if (this.datosEspecificos.getPromedioIngreso().compareTo(this.totalCompras.value()) < 0){
            this.determinacionPago = new FormularioDeterminacionPago(this.datosEspecificos.getPromedioIngreso().multiply(new BigDecimal(Utils.IMPUESTO_RRIVA)));
            this.determinacionPagoCf = new FormularioDeterminacionPagoCf(this.datosEspecificos.getPromedioIngreso().multiply(new BigDecimal(Utils.IMPUESTO_RRIVA)));
            this.determinacionPagoCfOtras = new FormularioDeterminacionPagoCfOtras(this.datosEspecificos.getPromedioIngreso().multiply(new BigDecimal(Utils.IMPUESTO_RRIVA)));
        } else {
            this.determinacionPago = new FormularioDeterminacionPago(this.totalCompras.value().multiply(new BigDecimal(Utils.IMPUESTO_RRIVA)));
            this.determinacionPagoCf = new FormularioDeterminacionPagoCf(this.totalCompras.value().multiply(new BigDecimal(Utils.IMPUESTO_RRIVA)));
            this.determinacionPagoCfOtras = new FormularioDeterminacionPagoCfOtras(this.totalCompras.value().multiply(new BigDecimal(Utils.IMPUESTO_RRIVA)));
        }
    }

    public void desmarcarImporte(List<CompraResponseGenerico> resultado, FormularioUsuarioUltimaModificacion pUsuarioUltimaModificacion) {
        if (this.estadoFormularioId.value().equals(EstadoformularioId.RECHAZADO.value()) || this.estadoFormularioId.value().equals(EstadoformularioId.REGISTRADO.value())) {
            this.record(new FormularioDecrementadoImporteDomainEvent(id.value(),
                    this.totalCompras.value(),
                    this.cantidadCompras.value(),
                    this.determinacionPago.value(),
                    this.determinacionPagoCf.value(),
                    this.totalComprasCfIpn.value(),
                    this.cantidadComprasCfIpn.value(),
                    this.determinacionPagoCfIpn.value(),
                    this.totalComprasCfElec.value(),
                    this.cantidadComprasCfElec.value(),
                    this.totalComprasSdCf.value(),
                    this.cantidadComprasSdCf.value(),
                    this.determinacionPagoSdCf.value(),
                    this.totalComprasCfOtras.value(),
                    this.cantidadComprasCfOtras.value(),
                    this.determinacionPagoCfOtras.value(),
                    this.usuarioUltimaModificacion.value(),
                    this.mesPeriodo.value(),
                    this.anioPeriodo.value(),
                    this.nombreFormulario.value(),
                    this.tipoFormularioId.value(),
                    this.fechaUltimaModificacion.value(),
                    this.compras().stream().map(x -> x.value()).collect(Collectors.toList()),
                    resultado.stream().map(compra -> compra.getId()).collect(Collectors.toList())
            ));
            resultado.stream().forEach(compraResponse -> {
                decrementarTotales(compraResponse.importeBaseCf(), compraResponse.getCreditoFiscal(),
                        usuarioUltimaModificacion, new CompraId(compraResponse.id()),
                        compraResponse.getImporteTotalCompra(), new CompraMarcaEspecialId(compraResponse.getMarcaEspecialId()), compraResponse.getModalidadId());
            });


            this.usuarioUltimaModificacion = pUsuarioUltimaModificacion;
            this.fechaUltimaModificacion = new FormularioFechaUltimaModificacion(LocalDateTime.now());

            this.compras = this.compras == null ? new ArrayList<>() : this.compras;

            List<CompraId> compraIds = resultado.stream().map(compraResponseGenerico -> new CompraId(compraResponseGenerico.getId())).collect(Collectors.toList());
            this.compras = this.compras.stream().filter(compraId -> !compraIds.stream().filter(compraId1 -> compraId1.value().equals(compraId.value())).findFirst().isPresent()).collect(Collectors.toList());
            if(this.tipoFormularioId.value().equals(EnumTipoFormularioId.FORMULARIO_111.value())){
                this.actulizarDeterminacionPagoFormulario111();
            }
            crearHistorico();
        }
    }

}
