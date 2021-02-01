package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.secundary.ventas.validadores;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.EnumFacFrvccMensajesShared;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ValidationResponse;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.Validator;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ValidatorNotExist;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.validadores.CodigoAutorizacion;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.validadores.FieldValidator;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.validadores.ImporteTotalCompra;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.validadores.NitValidator;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.validadores.NotEmptyValidator;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.validadores.NumeroFacturaValidator;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.validadores.RequiredValidator;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.validadores.StringValidator;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.validadores.UuidValidator;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;

@Service
public class VentaAgrupadaValidador {
	public static final String TIPO_FORMULARIO_LCV = "LCV";

	private final HashMap<String, String> rules = new HashMap<>() {
		{
			put("id", "required|uuid");
			put("fechaFactura", "required|fecha_emision");
			put("numeroFacturaDel", "required|numero_factura_del");
			put("numeroFacturaHasta", "required|numero_factura_hasta");
			put("codigoAutorizacion", "required|codigo_autorizacion");
			put("importeTotalVenta", "required|importe_total");
			put("origenId", "origen_venta|required");
		}
	};

	public ValidationResponse validarVenta(HashMap<String, Serializable> request) {
		HashMap<String, FieldValidator> validators = new HashMap<>() {
			{
				put("nit", new NitValidator());
				put("uuid", new UuidValidator());
				put("required", new RequiredValidator());
				put("string", new StringValidator());
				put("not_empty", new NotEmptyValidator());
				put("numero_factura_del", new NumeroFacturaValidator());
				put("numero_factura_hasta", new NumeroFacturaValidator());
				put("codigo_autorizacion", new CodigoAutorizacion());
				put("importe_total", new ImporteTotalCompra());
				put("fecha_emision", new FechaFacturaValidator());
				put("codigo_control", new CodigoControlValidator());
				put("origen_venta", new OrigenValidator());
			}
		};
		try {
			return Validator.validate(request, this.rules, validators);
		} catch (ValidatorNotExist validatorNotExist) {
			return null;
		}
	}

	public ValidationResponse crearValidacionVentaNoExiste() {
		return new ValidationResponse(new HashMap<>() {
			{
				// TODO: ASIGNAR MENSAJE VENTA NO EXISTE
				put("id", Arrays.asList(EnumFacFrvccMensajesShared.COMPRA_NO_EXISTE.getId()));
			}
		});
	}

	public ValidationResponse getValidacionNumeroAutorizacionException(List<Integer> listaErrores) {
		return new ValidationResponse(new HashMap<>() {
			{
				listaErrores.stream().forEach(error -> {
					put("pNumeroAutorizacion", Arrays.asList(error));
				});
			}
		});
	}

	public ValidationResponse getValidacionVentaExistente() {
		return new ValidationResponse(new HashMap<>() {
			{
				put("nitProveedor", Arrays.asList(EnumFacFrvccMensajesShared.COMPRA_YA_EXISTE.getId()));
			}
		});
	}

	public ValidationResponse getValidacionException() {
		return new ValidationResponse(new HashMap<>() {
			{
				put("id", Arrays.asList(EnumFacFrvccMensajesShared.ERROR_REGISTRO_FACTURAS_COMPRAS.getId()));
			}
		});
	}

	public boolean verificaFechaValidaEnRango(String pTipoFormularioId, LocalDate pFechaPresentacion,
			String pCantidadPeriodicidad, Integer pAnioPeriodo, Integer pMesPeriodo, LocalDate pFechaFactura) {
		boolean vRespuesta = false;
		LocalDate vfechaDesde = LocalDate.now();
		LocalDate vfechaHasta = LocalDate.now();

		if (pFechaFactura.isBefore(vfechaHasta) && pFechaFactura.isAfter(vfechaDesde)) {
			vRespuesta = true;
		}

		return vRespuesta;
	}

	public int obtenerCantidadDiasMes(Integer pGestion, Integer pMes) {
		Integer dias = 0;
		if (pGestion != null && pMes != null) {
			boolean biciesto;
			if ((pGestion % 4 == 0) && ((pGestion % 100 != 0) || (pGestion % 400 == 0)))
				biciesto = false;
			else
				biciesto = true;

			switch (pMes) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				dias = 31;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				dias = 30;
				break;
			case 2:
				if (biciesto)
					dias = 29;
				else
					dias = 28;
				break;
			}

		}
		return dias;
	}

}
