package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.secundary.compras.validadores;

import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.EnumFacFrvccMensajesShared;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ValidationResponse;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.Validator;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ValidatorNotExist;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.validadores.*;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.validadores.NumeroFacturaValidator;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

@Service
public final class CompraValidador {

    public static final String TIPO_FORMULARIO_110="F110";
    public static final String TIPO_FORMULARIO_110_ANEXO_F610="AF610";
    public static final String TIPO_FORMULARIO_110_ANEXO_F702="AF702";
    public static final String TIPO_FORMULARIO_110_ANEXO_F510="AF510";
    public static final String TIPO_FORMULARIO_LCV="LCV";

    private final HashMap<String, String> rules = new HashMap<>() {{
        put("id", "required|uuid");
        put("nitProveedor", "required|nit");
        put("fechaFactura", "required|fecha_emision");
        put("numeroFactura", "required|numero_factura");
        put("codigoAutorizacion", "required|codigo_autorizacion");
        put("importeTotalCompra", "required|importe_total");
        put("nombreCliente", "required");
        put("tipoDocumentoCliente", "required");
        put("numeroDocumentoCliente", "required");
        put("origenId", "origen_compra|required");
    }};


    public ValidationResponse validarCompra(HashMap<String, Serializable> request) {
        HashMap<String, FieldValidator> validators = new HashMap<>() {{
            put("nit", new NitValidator());
            put("uuid", new UuidValidator());
            put("required", new RequiredValidator());
            put("string", new StringValidator());
            put("not_empty", new NotEmptyValidator());
            put("numero_factura", new NumeroFacturaValidator());
            put("codigo_autorizacion", new CodigoAutorizacion());
            put("origen_compra", new OrigenValidator());
            put("importe_total", new ImporteTotalCompra());
            put("fecha_emision", new FechaFacturaValidator());
            put("codigo_control", new CodigoControlValidator());
        }};
        try {
            return Validator.validate(request, this.rules, validators);
        } catch (ValidatorNotExist validatorNotExist) {
            return null;
        }
    }

    public ValidationResponse crearValidacionCompraNoExiste() {
        return new ValidationResponse(new HashMap<>() {{
            put("id", Arrays.asList(EnumFacFrvccMensajesShared.COMPRA_NO_EXISTE.getId()));
        }});
    }

    public ValidationResponse getValidacionNumeroAutorizacionException(List<Integer> listaErrores) {
        return new ValidationResponse(new HashMap<>() {{
            listaErrores.stream().forEach(error -> {
                        put("pNumeroAutorizacion", Arrays.asList(error));
                    }
            );
        }});
    }

    public ValidationResponse getValidacionCompraExistente() {
        return new ValidationResponse(new HashMap<>() {{
            put("nitProveedor", Arrays.asList(EnumFacFrvccMensajesShared.COMPRA_YA_EXISTE.getId()));
        }});
    }

    public ValidationResponse getValidacionException() {
        return new ValidationResponse(new HashMap<>() {{
            put("id", Arrays.asList(EnumFacFrvccMensajesShared.ERROR_REGISTRO_FACTURAS_COMPRAS.getId()));
        }});
    }

    public boolean verificaFechaValidaEnRango(String pTipoFormularioId, LocalDate pFechaPresentacion, String pCantidadPeriodicidad,
                                              Integer pAnioPeriodo, Integer pMesPeriodo, LocalDate pFechaFactura)
    {
        boolean vRespuesta=false;
        LocalDate vfechaDesde= LocalDate.now();
        LocalDate vfechaHasta=LocalDate.now();
        switch (pTipoFormularioId) {
            case TIPO_FORMULARIO_110:
                vfechaDesde = pFechaPresentacion.plusDays(-Integer.valueOf(pCantidadPeriodicidad));
                vfechaHasta = pFechaPresentacion;
                break;
            case TIPO_FORMULARIO_110_ANEXO_F610:
                vfechaHasta=LocalDate.of(pAnioPeriodo, pMesPeriodo,
                        obtenerCantidadDiasMes(pAnioPeriodo,pMesPeriodo));
                vfechaDesde = vfechaHasta.plusDays(-Integer.valueOf(pCantidadPeriodicidad));
                break;
            case TIPO_FORMULARIO_110_ANEXO_F510:
                vfechaHasta=LocalDate.of(pAnioPeriodo, 12, 31);
                vfechaDesde=LocalDate.of(pAnioPeriodo, 1, 1);
                break;
            case TIPO_FORMULARIO_110_ANEXO_F702:
                vfechaHasta=LocalDate.of(pAnioPeriodo, pMesPeriodo,
                        obtenerCantidadDiasMes(pAnioPeriodo,pMesPeriodo));
                vfechaDesde=LocalDate.of(pAnioPeriodo, vfechaHasta.plusMonths(-2).getMonth(),
                        1);
                break;
            default:
                break;
        }
        if(pFechaFactura.isBefore(vfechaHasta) && pFechaFactura.isAfter(vfechaDesde))
        {
            vRespuesta=true;
        }

        return vRespuesta;
    }

    public int obtenerCantidadDiasMes(Integer pGestion,Integer pMes)
    {	Integer dias=0;
        if (pGestion != null && pMes != null) {
            boolean biciesto;
            if ((pGestion % 4 == 0) && ((pGestion % 100 != 0) || (pGestion % 400 == 0)))
                biciesto=false;
            else
                biciesto=true;

            switch (pMes) {
                case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                    dias = 31;
                    break;
                case 4: case 6: case 9: case 11:
                    dias = 30;
                    break;
                case 2:
                    if(biciesto)
                        dias = 29;
                    else
                        dias=28;
                    break;
            }

        }
        return dias;
    }


}


