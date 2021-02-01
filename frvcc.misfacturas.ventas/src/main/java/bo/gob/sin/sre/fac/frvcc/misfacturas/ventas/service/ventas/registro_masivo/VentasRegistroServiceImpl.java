package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.service.ventas.registro_masivo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.compras.VerificaCodigoAutorizacionRepository;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.primary.recepcion.registro_errores.RegistrarErroresCommand;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.primary.ventas.registro_masivo.RegistroVentasCommand;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.secundary.ventas.validadores.VentaValidador;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.Venta;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaCodigoAutorizacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaCodigoControl;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaConDerechoDf;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaDebitoFiscal;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaDescuento;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaFechaFactura;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaIfcProveedor;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaImporteBase;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaImporteExento;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaImporteIceIehdTasas;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaImporteNoSujetoDf;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaImporteTasaCero;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaImporteTotal;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaListaErrores;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaMarcaEspecialId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaNitProveedor;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaNombreCliente;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaNumeroDocumentoCliente;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaNumeroFactura;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaOrigenId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaRazonSocialProveedor;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaRecepcionId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaSubTotal;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaUsuarioRegistro;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.shared.adapters.secondary.sql2o.RepositoryConfig;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.use.ports.primary.ventas.registro_masivo.IVentasRegistro;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.use.ports.secundary.venta.IVentaRepository;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.EnumFacFrvccMensajesShared;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.contribuyentes.ContribuyenteResponse;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.contribuyentes.BuscarContribuyentePorNitQueryDto;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ValidationResponse;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandNotRegisteredError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryNotRegisteredError;

@Service
public class VentasRegistroServiceImpl implements IVentasRegistro {
	private static final Logger LOG = LoggerFactory.getLogger(VentasRegistroServiceImpl.class);
	private final QueryBus queryBus;
	private final CommandBus commandBus;
	private final VentaValidador validador;
	private final Environment env;

	public VentasRegistroServiceImpl(IVentaRepository pRepository, CommandBus commandBus, QueryBus queryBus,
			VentaValidador pValidador, VerificaCodigoAutorizacionRepository verificaCodigoAutorizacionRepository,
			Environment env) {
		this.queryBus = queryBus;
		this.validador = pValidador;
		this.env = env;
		this.commandBus = commandBus;
	}

	@Override
	public void registrar(RegistroVentasCommand pCommands) {
		ForkJoinPool vPoolVentas = new ForkJoinPool(4);
		long start = System.currentTimeMillis();

		ConcurrentHashMap<Long, String[]> vBolsaAux = new ConcurrentHashMap<>();
		ConcurrentHashMap<String, Boolean> vBolsaFacturasVerificadasConcurrentHashMap = new ConcurrentHashMap<>();
		HashMap<String, ValidationResponse> vResutaldosValidacion = (HashMap<String, ValidationResponse>) vPoolVentas
				.submit(() -> pCommands.getRegistroVentas().parallelStream().map(command -> {
					var object = new Object() {
						public final String id = command.getId();
						public final ValidationResponse validationResponse = validador.validarVenta(new HashMap<>() {
							{
								put("id", command.getId());
								put("fechaFactura",
										command.getFechaFactura() != null ? command.getFechaFactura().toString() : "");
								put("nitProveedor",
										command.getNitProveedor() != null ? command.getNitProveedor().toString() : "");
								put("numeroFactura",
										command.getNumeroFactura() != null ? command.getNumeroFactura().toString()
												: "");
								put("codigoAutorizacion",
										command.getCodigoAutorizacion() != null ? command.getCodigoAutorizacion() : "");
								put("importeTotalVenta",
										command.getImporteTotalVenta() != null
												? command.getImporteTotalVenta().toString()
												: "");
								put("codigoControl",
										command.getCodigoControl() != null ? command.getCodigoControl() : "");
								put("origenId", command.getOrigenId() != null ? command.getOrigenId() : "");
							}
						});
					};
					return object;
				}).filter(object -> object.validationResponse.hasErrors())
						.collect(Collectors.toMap(object -> object.id, object -> object.validationResponse)))
				.join();
		if (vResutaldosValidacion.size() > 0) {
			guardarErrores(pCommands, vResutaldosValidacion);
		} else {

			List<Venta> vVentas = (List<Venta>) vPoolVentas
					.submit(() -> pCommands.getRegistroVentas().parallelStream().map(command -> {
						VentaIfcProveedor vIfcProveedorNb = new VentaIfcProveedor(0L);
						VentaRazonSocialProveedor vRazonSocialProveedor = new VentaRazonSocialProveedor(null);

						if (!vBolsaAux.containsKey(command.getNitProveedor())) {
							ContribuyenteResponse vContribuyenteResponse = null;
							try {
								vContribuyenteResponse = (ContribuyenteResponse) Optional
										.ofNullable(queryBus
												.ask(new BuscarContribuyentePorNitQueryDto(command.getNitProveedor())))
										.orElse(null);
								if (vContribuyenteResponse != null) {
									vIfcProveedorNb = new VentaIfcProveedor(vContribuyenteResponse.ifc());
									vRazonSocialProveedor = new VentaRazonSocialProveedor(
											vContribuyenteResponse.razonSocial());
									vBolsaAux.putIfAbsent(command.getNitProveedor(), new String[] {
											vIfcProveedorNb.value().toString(), vRazonSocialProveedor.value() });
								}
							} catch (QueryNotRegisteredError queryHandlerExecutionError) {
								queryHandlerExecutionError.printStackTrace();
								// return null;
							} catch (QueryHandlerExecutionError queryHandlerExecutionError) {
								queryHandlerExecutionError.printStackTrace();
								// return null;
							} catch (Exception e) {
								e.printStackTrace();
							}
						} else {
							vIfcProveedorNb = new VentaIfcProveedor(
									Long.parseLong(vBolsaAux.get(command.getNitProveedor())[0].toString()));
							vRazonSocialProveedor = new VentaRazonSocialProveedor(
									vBolsaAux.get(command.getNitProveedor())[1].toString());
						}

						/*
						 * VentaModalidadId vModalidadId = new VentaModalidadId(
						 * vResultadoVerificadorNumeroAutorizacion.getModalidad());
						 * 
						 * VentaImporteBase vImporteBaseCf = VentaImporteBase.importeBaseCreditoFiscal(
						 * command.getImporteTotalVenta(), command.getImporteBase(),
						 * vResultadoVerificadorNumeroAutorizacion.getMarcaEspecial(),
						 * vResultadoVerificadorNumeroAutorizacion.getCreditoFiscal());
						 * VentaMarcaEspecialId vMarcaEspecialId = new VentaMarcaEspecialId(
						 * vResultadoVerificadorNumeroAutorizacion.getMarcaEspecial());
						 * VentaConDerechoDf vConDerechoCf = new VentaConDerechoDf(
						 * vResultadoVerificadorNumeroAutorizacion.getConDerechoCf());
						 */

						Venta vVenta = Venta.registro(new VentaId(command.getId()),
								new VentaRecepcionId(command.getRecepcionId()), vIfcProveedorNb,
								new VentaNitProveedor(command.getNitProveedor()), vRazonSocialProveedor,
								new VentaNumeroDocumentoCliente(command.getNumeroDocumentoCliente()),
								new VentaNombreCliente(command.getNombreCliente()),
								new VentaNumeroFactura(command.getNumeroFactura()),
								new VentaCodigoAutorizacion(command.getCodigoAutorizacion()),
								new VentaFechaFactura(command.getFechaFactura()),
								new VentaImporteTotal(command.getImporteTotalVenta()),
								new VentaCodigoControl(command.getCodigoControl()),
								new VentaImporteBase(command.getImporteBase()),
								new VentaOrigenId(command.getOrigenId()),
								new VentaUsuarioRegistro(command.getUsuarioRegistro()),
								new VentaConDerechoDf(command.getConDerechoDf()),
								new VentaMarcaEspecialId(command.getMarcaEspecialId()),
								new VentaDescuento(command.getDescuento()),
								new VentaDebitoFiscal(command.getDebitoFiscal()),
								new VentaImporteIceIehdTasas(command.getImporteIceIehdTasas()),
								new VentaImporteTasaCero(command.getImporteTasaCero()),
								new VentaImporteNoSujetoDf(command.getImporteNoSujetoDf()),
								new VentaImporteExento(command.getImporteExento()),
								// new VentaModalidadId(vModalidadId),
								// new CompraImporteBaseCf(vImporteBaseCf.value()),
								// new VentaConDerechoDf(vConDerechoCf.value()),
								new VentaSubTotal(command.getSubTotal()));

						String vLlaveFactura = vVenta.codigoAutorizacion().value()
								+ vVenta.numeroFactura().value().toString() + vVenta.nitProveedor().value().toString()
								+ vVenta.numeroDocumentoCliente().value();

						if (vBolsaFacturasVerificadasConcurrentHashMap.containsKey(vLlaveFactura)) {
							vResutaldosValidacion.put(command.getId(), crearValidacionVentaExistente());
							return null;
						} else {
//						Venta vVentaExistente = repository.buscarVentaExistente(vVenta).get();
//						if (vVentaExistente != null) {
//							vBolsaFacturasVerificadasConcurrentHashMap.putIfAbsent(vLlaveFactura, true);
//							vResutaldosValidacion.put(command.getId(), crearValidacionVentaExistente());
//							vVentaExistente
//									.anularVenta(new VentaUsuarioUltimaModificacion(command.getUsuarioRegistro()));
//							return vVentaExistente;
//						}

							vBolsaFacturasVerificadasConcurrentHashMap.putIfAbsent(vLlaveFactura, true);
						}

						return (vVenta);
					}).filter(Objects::nonNull).collect(Collectors.toList())).join();

//		if (vResutaldosValidacion.size() > 0) {
//			guardarErrores(pCommands, vResutaldosValidacion);
//		}

			try {
				if (vVentas != null && vVentas.size() > 0) {
					// repository.guardarTodo(vVentas);

					String insertSql = new StringBuilder().append(
							"INSERT INTO sfe_facturacion.tsfe_cv_ventas	(seq_venta_vc, ifc_proveedor_nb, nit_proveedor_nb, razon_social_proveedor_vc,"
									+ "nro_factura_nb, cod_autorizacion_vc, fecha_factura_dt, importe_total_venta_nb, importe_ice_iehd_tasas_nb, importe_exento_nb, "
									+ "importe_tasa_cero_nb, importe_no_sujeto_df_nb, subtotal_nb, descuento_nb, importe_base_df_nb, debito_fiscal_nb, "
									+ "codigo_control_vc, modalidad_id_vc, estado_venta_id_vc, nro_doc_cliente_vc, nombre_cliente_vc, origen_id_vc, estado_uso_id_vc, "
									+ "impuesto_uso_id_vc, gestion_uso_nb, periodo_uso_nb, nombre_formulario_uso_vc, seq_formulario_vc,"
									+ "seq_recepcion_vc, secuencia_nb, con_derecho_df_vc, marca_especial_id_vc,usuario_registro_nb, fecha_registro_ts, "
									+ "usuario_ultima_modificacion_nb, fecha_ultima_modificacion_ts, estado_id_vc) "
									+ "VALUES(:seq_venta_vc, :ifc_proveedor_nb, :nit_proveedor_nb, :razon_social_proveedor_vc, :nro_factura_nb,"
									+ ":cod_autorizacion_vc, :fecha_factura_dt, :importe_total_venta_nb, :importe_ice_iehd_tasas_nb, :importe_exento_nb, "
									+ ":importe_tasa_cero_nb, :importe_no_sujeto_df_nb, :subtotal_nb, "
									+ ":descuento_nb, :importe_base_df_nb, :debito_fiscal_nb, :codigo_control_vc, "
									+ ":modalidad_id_vc, :estado_venta_id_vc, :nro_doc_cliente_vc, :nombre_cliente_vc, "
									+ ":origen_id_vc, :estado_uso_id_vc, :impuesto_uso_id_vc, :gestion_uso_nb,"
									+ " :periodo_uso_nb, :nombre_formulario_uso_vc, :seq_formulario_vc,"
									+ ":seq_recepcion_vc, :secuencia_nb, :con_derecho_df_vc,:marca_especial_id_vc,"
									+ ":usuario_registro_nb, :fecha_registro_ts, :usuario_ultima_modificacion_nb, "
									+ ":fecha_ultima_modificacion_ts, :estado_id_vc)")
							.toString();

					int[] respuesta;
					Sql2o sql2o = RepositoryConfig.getSql2o(env.getRequiredProperty("datasource.driver"),
							env.getRequiredProperty("datasource.url"), env.getRequiredProperty("datasource.username"),
							env.getRequiredProperty("datasource.password"));
					try (Connection vConnection = sql2o.open()) {
						Query query = vConnection.createQuery(insertSql);
						for (Venta pModel : vVentas) {
							// super.insert(pModel);
							query.addParameter("seq_venta_vc", pModel.id().value())
									.addParameter("nit_proveedor_nb", pModel.nitProveedor().value())
									.addParameter("ifc_proveedor_nb", pModel.ifcProveedor().value())
									.addParameter("razon_social_proveedor_vc", pModel.razonSocialProveedor().value())
									.addParameter("nro_factura_nb", pModel.numeroFactura().value())
									.addParameter("cod_autorizacion_vc", pModel.codigoAutorizacion().value())
									.addParameter("fecha_factura_dt", pModel.fechaFactura().value())
									.addParameter("importe_total_venta_nb", pModel.importeTotal().value())
									.addParameter("importe_ice_iehd_tasas_nb", pModel.importeIceIehdTasas().value())
									.addParameter("importe_exento_nb", pModel.importeExento().value())
									.addParameter("importe_tasa_cero_nb", pModel.importeTasaCero().value())
									.addParameter("importe_no_sujeto_df_nb", pModel.importeBase().value())
									.addParameter("subtotal_nb", pModel.importeBase().value())
									.addParameter("descuento_nb", pModel.importeBase().value())
									.addParameter("importe_base_df_nb", pModel.importeBase().value())
									.addParameter("debito_fiscal_nb", pModel.debitoFiscal().value())
									.addParameter("codigo_control_vc", pModel.codigoControl().value())
									.addParameter("modalidad_id_vc", pModel.modalidadId().value())
									.addParameter("estado_venta_id_vc", pModel.estadoVentaId().value())
									.addParameter("nro_doc_cliente_vc", pModel.numeroDocumentoCliente().value())
									.addParameter("nombre_cliente_vc", pModel.nombreCliente().value())
									.addParameter("origen_id_vc", pModel.origenId().value())
									.addParameter("estado_uso_id_vc", pModel.estadoUsoId().value())
									.addParameter("impuesto_uso_id_vc", pModel.impuestoUsoId().value())
									.addParameter("gestion_uso_nb", pModel.gestionUso().value())
									.addParameter("periodo_uso_nb", pModel.periodoUso().value())
									.addParameter("nombre_formulario_uso_vc", pModel.nombreArchivoUso().value())
									.addParameter("seq_formulario_vc", pModel.formularioId().value())
									// .addParameter("seq_libro_vc", pModel.libroId.value())
									.addParameter("seq_recepcion_vc", pModel.recepcionId().value())
									.addParameter("secuencia_nb", pModel.secuencia().value())
									.addParameter("con_derecho_df_vc", "S").addParameter("marca_especial_id_vc", "SM")
									.addParameter("usuario_registro_nb", pModel.usuarioRegistro().value())
									.addParameter("fecha_registro_ts", pModel.fechaRegistro().value())
									.addParameter("usuario_ultima_modificacion_nb",
											pModel.usuarioUltimaModificacion().value())
									.addParameter("fecha_ultima_modificacion_ts",
											pModel.fechaUltimaModificacion().value())
									.addParameter("estado_id_vc", pModel.estadoId().value());
							query.addToBatch();
						}

						respuesta = query.executeBatch().getBatchResult();
					}

					System.out.println("Se proceso la recepcion " + vVentas.get(0).recepcionId() + " un total de "
							+ vVentas.size() + " ventas en " + (System.currentTimeMillis() - start) + " milisegundos");

					// return respuesta;

				}
			} catch (Exception e) {
				throw new VentaListaErrores(new VentaId(""), validador.getValidacionException());
			}
		}
	}

	private void guardarErrores(RegistroVentasCommand pCommands,
			HashMap<String, ValidationResponse> vResutaldosValidacion) {
		if (pCommands.getRegistroVentas().get(0).getOrigenId() != null
				&& pCommands.getRegistroVentas().get(0).getOrigenId().equals("SER")) {

			// TODO: Guardar Errores
			HashMap<String, List<Integer>> errores = new HashMap<>();
			vResutaldosValidacion.entrySet().forEach(registro -> {
				errores.put(
						"Fila " + pCommands.getRegistroVentas().stream()
								.filter(venta -> venta.getId() == registro.getKey()).findFirst().get().getFila()
								+ " - Errores ",
						vResutaldosValidacion.get(registro.getKey()).errors().values().stream().distinct()
								.flatMap(x -> x.stream()).collect(Collectors.toList()));
			});

			JSONObject json = new JSONObject(errores);
			try {
				commandBus.dispatch(new RegistrarErroresCommand(pCommands.getRegistroVentas().get(0).getRecepcionId(),
						json, pCommands.getRegistroVentas().get(0).getUsuarioRegistro()));
			} catch (CommandNotRegisteredError e) {
			} catch (CommandHandlerExecutionError e) {
			}

//			System.out.println(String.format(
//					"----------------------------------Se encontraron %s errores validación---------------------------",
//					errores.size()));
//			System.out.println(json.toString());
		}
		
		throw new VentaListaErrores(vResutaldosValidacion);
	}

	private ValidationResponse crearValidacionVentaExistente() {
		return new ValidationResponse(new HashMap<>() {
			{
				put("nitProveedor", Arrays.asList(EnumFacFrvccMensajesShared.COMPRA_YA_EXISTE.getId()));
			}
		});
	}
}
