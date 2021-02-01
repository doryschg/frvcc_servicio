package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.service.ventas.procesar_agrupadas_masivo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Qualifier;

import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.primary.ventas.registro.RegistroVentaCommand;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.primary.ventas.registro_agrupado_masivo.RegistroVentasAgrupadosCommand;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.primary.ventas.registro_masivo.RegistroVentasCommand;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.secundary.ventas.validadores.VentaAgrupadaValidador;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.EstadoVentaId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.Venta;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaCodigoAutorizacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaEstadoId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaFechaFactura;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaFechaRegistro;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaIfcProveedor;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaImporteTotal;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaListaErrores;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaNitProveedor;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaOrigenId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaRecepcionId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaUsuarioRegistro;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.use.ports.primary.ventas.procesar_agrupadas_masivo.IProcesarVentasAgrupadasService;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ValidationResponse;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.UuidGenerator;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.EventBus;

@Service
public class ProcesarVentasAgrupadasServiceImpl implements IProcesarVentasAgrupadasService {
	private final EventBus eventBus;
	private final CommandBus commandBus;
	private final UuidGenerator uuidGenerator;
	private final VentaAgrupadaValidador validador;

	public ProcesarVentasAgrupadasServiceImpl(@Qualifier("ApachePulsarEventBus") EventBus eventBus,
			CommandBus pCommandBus, UuidGenerator pUuidGenerator, VentaAgrupadaValidador pValidador) {
		this.eventBus = eventBus;
		this.commandBus = pCommandBus;
		this.uuidGenerator = pUuidGenerator;
		this.validador = pValidador;

	}

	@Override
	public void procesar(RegistroVentasAgrupadosCommand pRegistroVentasAgrupadosCommand) {
		List<RegistroVentaCommand> ventaCommands = new ArrayList<>();

		HashMap<String, ValidationResponse> vResutaldosValidacion = (HashMap<String, ValidationResponse>) pRegistroVentasAgrupadosCommand
				.getRegistroVentasAgrupados().stream().map(command -> {
					var object = new Object() {
						public final String id = command.getId();
						public final ValidationResponse validationResponse = validador.validarVenta(new HashMap<>() {
							{
								put("id", command.getId());
								put("numeroFacturaDel",
										command.getNumeroFacturaDel() != null ? command.getNumeroFacturaDel().toString()
												: "");
								put("numeroFacturaHasta",
										command.getNumeroFacturaHasta() != null
												? command.getNumeroFacturaHasta().toString()
												: "");
								put("fechaFactura",
										command.getFechaFactura() != null ? command.getFechaFactura().toString() : "");
								put("nitProveedor",
										command.getNitProveedor() != null ? command.getNitProveedor().toString() : "");
								put("codigoAutorizacion",
										command.getCodigoAutorizacion() != null ? command.getCodigoAutorizacion() : "");
								put("importeTotalVenta",
										command.getImporteTotalVenta() != null
												? command.getImporteTotalVenta().toString()
												: "");
								put("origenId", command.getOrigenId() != null ? command.getOrigenId() : "");
							}

						});
					};
					return object;
				}).filter(object -> object.validationResponse.hasErrors())
				.collect(Collectors.toMap(object -> object.id, object -> object.validationResponse));

		if (vResutaldosValidacion.size() > 0) {
			if (pRegistroVentasAgrupadosCommand.getRegistroVentasAgrupados().get(0).getOrigenId() != null
					&& pRegistroVentasAgrupadosCommand.getRegistroVentasAgrupados().get(0).getOrigenId()
							.equals("SER")) {
				// TODO: Guardar Errores
				HashMap<String, List<Integer>> errores = new HashMap<>();
				vResutaldosValidacion.entrySet().forEach(registro -> {
					errores.put(
							"Fila " + pRegistroVentasAgrupadosCommand.getRegistroVentasAgrupados().stream()
									.filter(venta -> venta.getId() == registro.getKey()).findFirst().get().getFila()
									+ " - Errores ",
							vResutaldosValidacion.get(registro.getKey()).errors().values().stream().distinct()
									.flatMap(x -> x.stream()).collect(Collectors.toList()));
				});

				JSONObject json = new JSONObject(errores);
				System.out.println(json.toString());
			}

			throw new VentaListaErrores(vResutaldosValidacion);
		}

		String recepcionId = uuidGenerator.generate();
		pRegistroVentasAgrupadosCommand.getRegistroVentasAgrupados().forEach(registro -> {
			Venta vVenta = Venta.newVenta().id(new VentaId(uuidGenerator.generate())).build();

			vVenta.recepcionAgrupada(new VentaId(uuidGenerator.generate()), new VentaRecepcionId(recepcionId),
					new VentaIfcProveedor(registro.getIfcProveedor()), registro.getFila(),
					new VentaNitProveedor(registro.getNitProveedor()),
					new VentaFechaFactura(registro.getFechaFactura()), registro.getNumeroFacturaDel(),
					registro.getNumeroFacturaHasta(), new VentaCodigoAutorizacion(registro.getCodigoAutorizacion()),
					new VentaImporteTotal(registro.getImporteTotalVenta()),
					new VentaUsuarioRegistro(registro.getUsuarioRegistro()),
					new VentaFechaRegistro(LocalDateTime.now()), new VentaOrigenId(registro.getOrigenId()),
					new VentaEstadoId(EstadoVentaId.VIGENTE.value()));
			eventBus.publish(vVenta.pullDomainEvents());
		});

		/*
		 * VentaId pId, VentaRecepcionId pRecepcionId, VentaIfcProveedor pIfcProveedor,
		 * Long pFila, VentaNitProveedor pNitProveedor, VentaFechaFactura pFechaFactura,
		 * VentaNumeroFactura pNumeroFacturaDel, VentaNumeroFactura pNumeroFacturaHasta,
		 * VentaCodigoAutorizacion pCodigoAutorizacion, VentaImporteTotal
		 * pImporteTotalVenta, VentaUsuarioRegistro pUsuarioRegistro, VentaFechaRegistro
		 * pFechaRegistro, VentaOrigenId pOrigenId, VentaEstadoId pEstadoVenta
		 */

		/*
		 * private final Long fila; private final String id; private final String
		 * recepcionId; private final Long ifcProveedor; private final Long
		 * nitProveedor;
		 * 
		 * private final LocalDate fechaFactura; private final Long numeroFacturaDel;
		 * private final Long numeroFacturaHasta; private final String
		 * codigoAutorizacion; private final BigDecimal importeTotalVenta;
		 */

//		pRegistroVentasAgrupadosCommand.getRegistroVentasAgrupados().stream()
//				.collect(HashMap<Integer, RegistroVentasAgrupadoCommand>::new,
//						(map, registroVentasAgrupadoCommand) -> map.put(map.size(), registroVentasAgrupadoCommand),
//						(map, map2) -> {
//						})
//				.forEach((fila, command) -> {
//					for (long iteracion = command.getNumeroFacturaDel().intValue(); iteracion <= command
//							.getNumeroFacturaHasta(); iteracion++) {
//						ventaCommands.add(RegistroVentaCommand.newRegistroVentaCommand().id(uuidGenerator.generate())
//								.numeroFactura(iteracion).ifcProveedor(command.getIfcProveedor())
//								.nitProveedor(command.getNitProveedor()).origenId(command.getOrigenId())
//								.codigoAutorizacion(command.getCodigoAutorizacion()).fila(command.getFila())
//								.fechaFactura(command.getFechaFactura()).usuarioRegistro(command.getUsuarioRegistro())
//								.importeTotalVenta(command.getImporteTotalVenta()).build());
//					}
//				});

//		RegistroVentasCommand commands = new RegistroVentasCommand(ventaCommands);
//		try {
//			commandBus.dispatch(commands);
//		} catch (CommandNotRegisteredError commandNotRegisteredError) {
//			commandNotRegisteredError.printStackTrace();
//		} catch (CommandHandlerExecutionError commandHandlerExecutionError) {
//			commandHandlerExecutionError.printStackTrace();
//		}
	}
}
