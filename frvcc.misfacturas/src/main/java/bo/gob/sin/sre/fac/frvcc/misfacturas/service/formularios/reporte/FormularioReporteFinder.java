package bo.gob.sin.sre.fac.frvcc.misfacturas.service.formularios.reporte;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.EnumtipoBeneficiario;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.EstadoUsoId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.*;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.compras.generar_historial.IGeneradorHistorialCompras;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.shared.BeneficiarioPersonaRivDto;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.shared.IBeneficiarioPersonaRivService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.CompraResponseGenerico;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.ComprasResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.search_by_criteria.SearchComprasListaIds;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios.FormularioReporteResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.secundary.formularios.validadores.FormularioValidador;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.EnumMarcaEspecialId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.formularios.reportes.IFormularioReporte;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.formularios.FormularioRepository;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryNotRegisteredError;

@Service
public class FormularioReporteFinder {
    private static final Logger LOG = LoggerFactory.getLogger(FormularioReporteFinder.class);

    private final FormularioRepository repository;
    private final IGeneradorHistorialCompras iGeneradorHistorialCompras;
    private final IFormularioReporte iFormularioReporte;
    private final QueryBus queryBus;
    private final FormularioValidador validador;


    public FormularioReporteFinder(FormularioRepository repository, IFormularioReporte iFormularioReporte
            , QueryBus queryBus, FormularioValidador validador, IGeneradorHistorialCompras iGeneradorHistorialCompras) {
        this.repository = repository;
        this.iFormularioReporte = iFormularioReporte;
        this.queryBus = queryBus;
        this.validador = validador;
        this.iGeneradorHistorialCompras = iGeneradorHistorialCompras;

    }

    public FormularioReporteResponse reporteFormulario(
            FormularioId pFormularioId) {
        ComprasResponse comprasResponse = null;
        Formulario formulario = repository.search(pFormularioId).orElseThrow(() -> new FormularioListaErrores(pFormularioId, validador.crearValidacionFormularioNoExistente()));

        if (formulario.estadoFormularioId().value().equals(EstadoformularioId.REGISTRADO.value())) {

            return new FormularioReporteResponse("");
        }

        List<String> vListCompras = new ArrayList<>();
        for (CompraId compraId : formulario.compras()) {
            vListCompras.add(compraId.value());
        }
        if (formulario.estadoFormularioId().value().equals(EstadoformularioId.RECTIFICADO.value())) {
            comprasResponse = obtenerComprasFormRectificado(vListCompras, pFormularioId);
        } else {
            try {
                comprasResponse = queryBus.ask(new SearchComprasListaIds(vListCompras));
            } catch (QueryHandlerExecutionError queryHandlerExecutionError) {
                LOG.error(queryHandlerExecutionError.getCause().toString(), queryHandlerExecutionError);
                queryHandlerExecutionError.printStackTrace();
            } catch (QueryNotRegisteredError queryNotRegisteredError) {
                LOG.error(queryNotRegisteredError.getCause().toString(), queryNotRegisteredError);
                queryNotRegisteredError.printStackTrace();
            }
        }
        if(formulario.tipoFormularioId().value().equals(TipoFormlarioId.F111.value())){
            return new FormularioReporteResponse(generarReporteForm111(formulario, comprasResponse.getComprasResponse()));

        }else{
            return new FormularioReporteResponse(generarReporteForm110(formulario, comprasResponse.getComprasResponse()));
        }
    }

    public ComprasResponse obtenerComprasFormRectificado(List<String> pListCompras, FormularioId pFormularioId) {
        List<CompraResponseGenerico> vListaComprasRec = new ArrayList<>();
        try {
            ComprasResponse comprasResponse;

            for (String compraId : pListCompras) {
                comprasResponse = this.iGeneradorHistorialCompras.generadorHistorial(new CompraId(compraId));
                Optional<CompraResponseGenerico> vOpCompra = comprasResponse.getComprasResponse().stream().filter(c -> c.getEstadoUsoId().equals(EstadoUsoId.ASOCIADO.value()) && c.getFormularioId().equals(pFormularioId.value())).findFirst();
                if (vOpCompra.isPresent())
                    vListaComprasRec.add(vOpCompra.get());
            }
            return new ComprasResponse(vListaComprasRec, null, null);
        } catch (Exception excepcion) {
            LOG.error(excepcion.getCause().toString(), excepcion);
            excepcion.printStackTrace();
            return null;
        }
    }

    public String generarReporteForm110(Formulario pFormulario, List<CompraResponseGenerico> pListCompras) {

        try {


            List<CompraReporte> vListCompras = new ArrayList<CompraReporte>();
            DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            for (CompraResponseGenerico compra : pListCompras) {
                String fechaCadena = compra.getFechaFactura().format(formatters);
                if(compra.getMarcaEspecialId().equals(EnumMarcaEspecialId.SIETERG.value())){
                    vListCompras.add(new CompraReporte(compra.getCodigoControl(), compra.getCodigoAutorizacion(), compra.getNitProveedor(), fechaCadena, compra.getNumeroFactura(), compra.getImporteTotalCompra().setScale(0, BigDecimal.ROUND_HALF_UP), compra.getMarcaEspecialId()));
                }
                else{
                    vListCompras.add(new CompraReporte(compra.getCodigoControl(), compra.getCodigoAutorizacion(), compra.getNitProveedor(), fechaCadena, compra.getNumeroFactura(), compra.getImporteBaseCf().setScale(0, BigDecimal.ROUND_HALF_UP), compra.getMarcaEspecialId()));

                }
            }



            Map<String, Object> vParamReport = new HashMap<String, Object>();
            vParamReport.put("funcionarioDependiente",
                    pFormulario.tipoFormularioId().value().equals(TipoFormlarioId.F110.value()));
            vParamReport.put("anexo610", pFormulario.tipoFormularioId().value().equals(TipoFormlarioId.AF610.value())
            );
            vParamReport.put("anexo510",
                    pFormulario.tipoFormularioId().value().equals(TipoFormlarioId.AF510.value()));
            vParamReport.put("anexo702",
                    pFormulario.tipoFormularioId().value().equals(TipoFormlarioId.AF702.value()));
            vParamReport.put("anioPeriodo", pFormulario.anioPeriodo().value());
            vParamReport.put("nit", pFormulario.tipoFormularioId().value().equals(TipoFormlarioId.F110.value()) ? 0l
                    : pFormulario.nitCi().value());
            vParamReport.put("lugarExpedicion", pFormulario.datosEspecificos().getDescripcionLugarExpedicion() == null ? "" : pFormulario.datosEspecificos().getDescripcionLugarExpedicion());
            vParamReport.put("lugar", pFormulario.datosEspecificos().getDepartamentoDescripcion());
            vParamReport.put("dia", pFormulario.fechaPresentacion().value().getDayOfMonth());
            vParamReport.put("nombreRazonSocialEmpleador", pFormulario.nombreEmpleador() == null ? "" : pFormulario.nombreEmpleador().value());
            vParamReport.put("mesPeriodo", pFormulario.mesPeriodo() == null ? null : pFormulario.mesPeriodo().value());
            vParamReport.put("domicilioEmpleador", pFormulario.direccionEmpleador() == null ? "" : pFormulario.direccionEmpleador().value());
            vParamReport.put("numeroOrden", pFormulario.numeroOrden() == null ? null : pFormulario.numeroOrden().value().toString());
            vParamReport.put("numeroDocumentoIdentidad", pFormulario.datosEspecificos().getNumeroDocumento().concat(pFormulario.datosEspecificos().getComplementoDocumento() == null || pFormulario.datosEspecificos().getComplementoDocumento().equals("") ? "" : "-" + pFormulario.datosEspecificos().getComplementoDocumento()));
            vParamReport.put("descripcionTipoDocumento", pFormulario.datosEspecificos().getDescripcionTipoDocumento());
            vParamReport.put("tipoDocumentoIdentidad", pFormulario.datosEspecificos().getTipoDocumento() == null ? "" : pFormulario.datosEspecificos().getTipoDocumento());
            vParamReport.put("domicilio", pFormulario.direccion() == null ? null : pFormulario.direccion().value());
            vParamReport.put("anio", pFormulario.fechaPresentacion().value().getYear());
            vParamReport.put("mes", pFormulario.fechaPresentacion().value().getMonthValue());
            vParamReport.put("nitEmpleador", pFormulario.nitEmpleador() == null ? null : pFormulario.nitEmpleador().value());
            vParamReport.put("nombreApellido", pFormulario.razonSocial().value());
            vParamReport.put("totalFacturasElectronicas", pFormulario.cantidadComprasCfElec().value());
            vParamReport.put("totalProduccionNacional", pFormulario.cantidadComprasCfIpn().value());
            vParamReport.put("totalOtrasFacturas", pFormulario.cantidadComprasCfOtras().value());
            vParamReport.put("totalFacturas7G", pFormulario.cantidadComprasSdCf().value());
            vParamReport.put("sumaElectOtrasFac",
                    (pFormulario.totalComprasCfOtras().value()).setScale(0, BigDecimal.ROUND_HALF_UP));
            vParamReport.put("sumaProdNacional",
                    pFormulario.totalComprasCfIpn().value().setScale(0, BigDecimal.ROUND_HALF_UP));
            vParamReport.put("sumaFacturas7G", pFormulario.totalComprasSdCf().value().setScale(0, BigDecimal.ROUND_HALF_UP));
            vParamReport.put("detPagoOtrosProduc",
                    pFormulario.determinacionPagoCfOtras().value().setScale(0, BigDecimal.ROUND_HALF_UP));
            vParamReport.put("detPagoProducNal",
                    pFormulario.determinacionPagoCfIpn().value().setScale(0, BigDecimal.ROUND_HALF_UP));
            vParamReport.put("detTotalPago", pFormulario.determinacionPagoCf().value().setScale(0, BigDecimal.ROUND_HALF_UP));
            vParamReport.put("detPago7G", pFormulario.determinacionPagoSdCf().value().setScale(0, BigDecimal.ROUND_HALF_UP));
            List<ParametrosReporte> vListaParReport = new ArrayList<>();
            ParametrosReporte vFormulario = new ParametrosReporte();
            List<CompraReporte> vFacturasMarca7RG = vListCompras.stream()
                    .filter(c -> c.getMarcaEspecialId() != null && c.getMarcaEspecialId().equals(EnumMarcaEspecialId.SIETERG.value()))
                    .collect(Collectors.toList());
            List<CompraReporte> vOtrasFacturas = vListCompras.stream()
                    .filter(c -> c.getMarcaEspecialId().equals(EnumMarcaEspecialId.SINMARCA.value()) || c.getMarcaEspecialId().equals(EnumMarcaEspecialId.IPN.value()))
                    .collect(Collectors.toList());
            vFormulario.setFacturasConDerechoCf(vOtrasFacturas);

                vFormulario.setFacturas7g(vFacturasMarca7RG);
                vListaParReport.add(vFormulario);
                return iFormularioReporte.generarFormulario110(vParamReport, vListaParReport);
        } catch (Exception exception) {
            LOG.error(exception.toString(), exception);
            return "";
        }

    }
    public String generarReporteForm111(Formulario pFormulario, List<CompraResponseGenerico> pListCompras) {

        try {
            List<CompraReporte> vListCompras = new ArrayList<CompraReporte>();
            DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            for (CompraResponseGenerico compra : pListCompras) {
                String fechaCadena = compra.getFechaFactura().format(formatters);
                CompraReporte compraR = new CompraReporte(compra.getCodigoControl(), compra.getCodigoAutorizacion(), compra.getNitProveedor(), fechaCadena, compra.getNumeroFactura(), compra.getImporteBaseCf(), compra.getMarcaEspecialId());
                vListCompras.add(compraR);
            }
            Map<String, Object> vParamReport = new HashMap<String, Object>();
            vParamReport.put("anioPeriodo", pFormulario.anioPeriodo().value());
            vParamReport.put("nit", pFormulario.tipoFormularioId().value().equals(TipoFormlarioId.F110.value()) ? 0l
                    : pFormulario.nitCi().value());
            vParamReport.put("lugarExpedicion", pFormulario.datosEspecificos().getDescripcionLugarExpedicion() == null ? "" : pFormulario.datosEspecificos().getDescripcionLugarExpedicion());
            vParamReport.put("lugar", pFormulario.datosEspecificos().getDepartamentoDescripcion());
            vParamReport.put("dia", pFormulario.fechaPresentacion().value().getDayOfMonth());
            vParamReport.put("mesPeriodo", pFormulario.mesPeriodo() == null ? null : pFormulario.mesPeriodo().value());
            vParamReport.put("numeroOrden", pFormulario.numeroOrden() == null ? null : pFormulario.numeroOrden().value().toString());
            vParamReport.put("numeroDocumentoIdentidad", pFormulario.datosEspecificos().getNumeroDocumento().concat(pFormulario.datosEspecificos().getComplementoDocumento() == null || pFormulario.datosEspecificos().getComplementoDocumento().equals("") ? "" : "-" + pFormulario.datosEspecificos().getComplementoDocumento()));
            vParamReport.put("descripcionTipoDocumento", pFormulario.datosEspecificos().getDescripcionTipoDocumento());
            vParamReport.put("tipoDocumentoIdentidad", pFormulario.datosEspecificos().getTipoDocumento() == null ? "" : pFormulario.datosEspecificos().getTipoDocumento());
            vParamReport.put("domicilio", pFormulario.direccion() == null ? null : pFormulario.direccion().value().toUpperCase());
            vParamReport.put("anio", pFormulario.fechaPresentacion().value().getYear());
            vParamReport.put("mes", pFormulario.fechaPresentacion().value().getMonthValue());
            vParamReport.put("nombreApellido", pFormulario.razonSocial().value());
            List<ParametrosReporte> vListaParReport = new ArrayList<>();
            ParametrosReporte vFormulario = new ParametrosReporte();
            List<CompraReporte> vOtrasFacturas = vListCompras.stream()
                    .filter(c -> c.getMarcaEspecialId().equals(EnumMarcaEspecialId.SINMARCA.value()) || c.getMarcaEspecialId().equals(EnumMarcaEspecialId.IPN.value()))
                    .collect(Collectors.toList());
            vFormulario.setFacturasConDerechoCf(vOtrasFacturas);
                vParamReport.put("lugarExpedicion", pFormulario.datosEspecificos().getDescripcionLugarExpedicion());
                vParamReport.put("totalFacturas", pFormulario.cantidadCompras().value());
                vParamReport.put("sumaTotalFacturas", pFormulario.totalCompras().value());
                vParamReport.put("devolucionPagoCuenta", pFormulario.determinacionPagoCf().value());
                vParamReport.put("totalDevolucion", pFormulario.determinacionPagoCfOtras().value());
                vParamReport.put("entidadFinanciera", pFormulario.datosEspecificos().getDescripcionBanco());
                vParamReport.put("nroCuenta", pFormulario.datosEspecificos().getNumeroCuenta());
                vParamReport.put("tipoCuenta", pFormulario.datosEspecificos().getTipoCuentaBancariaDescripcion());
                vParamReport.put("montoSujetoADevolucion", pFormulario.datosEspecificos().getPromedioIngreso().compareTo(pFormulario.totalCompras().value()) < 0 ? pFormulario.datosEspecificos().getPromedioIngreso() : pFormulario.totalCompras().value() );
                vParamReport.put("jubilado", pFormulario.tipoUsoId().value().equals(EnumtipoBeneficiario.JUBILADO.value()));
                vParamReport.put("funcionarioDependiente", pFormulario.tipoUsoId().value().equals(EnumtipoBeneficiario.DEPENDIENTE.value()));
                vParamReport.put("funcionarioIndependiente", pFormulario.tipoUsoId().value().equals(EnumtipoBeneficiario.INDEPENDIENTE.value()));
                vListaParReport.add(vFormulario);
                return iFormularioReporte.generarFormulario111(vParamReport, vListaParReport);
        } catch (Exception exception) {
            LOG.error(exception.toString(), exception);
            return "";
        }

    }

}

