package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.service.ventas.procesar_archivo;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.json.JSONObject;

import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.primary.archivo.ArchivoResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.primary.archivo.buscar.ArchivoBuscadorQuery;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.primary.recepcion.RecepcionResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.primary.recepcion.buscar.RecepcionBuscadorQuery;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.primary.recepcion.registro_errores.RegistrarErroresCommand;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.primary.ventas.registro.RegistroVentaCommand;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.primary.ventas.registro_masivo.RegistroVentasCommand;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.archivo.ArchivoId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.archivo.ArchivoTipoRecepcionId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.ventas.VentaErrorLecturaExcel;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.service.archivo.extraer_ventas.ArchivoExtraerVentasServiceImpl;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.use.ports.primary.ventas.procesar_archivo.IVentaRegistradorDeArchivo;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.use.ports.secundary.venta.IVentaRepository;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandNotRegisteredError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryNotRegisteredError;

@Service
public final class VentaRegistroDeArchivoService implements IVentaRegistradorDeArchivo {
	private final IVentaRepository repository;
	private final QueryBus queryBus;
	private final CommandBus commandBus;
	private final ArchivoExtraerVentasServiceImpl extraerVentas;

	public VentaRegistroDeArchivoService(IVentaRepository repository, QueryBus queryBus, CommandBus pCommandBus,
			ArchivoExtraerVentasServiceImpl pExtraerVentas) {
		this.repository = repository;
		this.queryBus = queryBus;
		this.commandBus = pCommandBus;
		this.extraerVentas = pExtraerVentas;
	}

	@Override
	public void registrarArchivo(ArchivoId pArchivoId, ArchivoTipoRecepcionId pTipoRecepcionId)
			throws QueryNotRegisteredError, QueryHandlerExecutionError, IOException {
		ArchivoResponse vArchivo = queryBus.ask(new ArchivoBuscadorQuery(pArchivoId.value()));

		RecepcionResponse recepcionResponse = null;
		try {
			recepcionResponse = queryBus.ask(new RecepcionBuscadorQuery(pTipoRecepcionId.value()));

			List<RegistroVentaCommand> ventaCommands = null;
			ventaCommands = this.extraerVentas.extraerVentas(vArchivo.archivoByte(), recepcionResponse);
			RegistroVentasCommand commands = new RegistroVentasCommand(ventaCommands);
			try {
				commandBus.dispatch(commands);
			} catch (CommandNotRegisteredError commandNotRegisteredError) {
				commandNotRegisteredError.printStackTrace();
			} catch (CommandHandlerExecutionError commandHandlerExecutionError) {
				commandHandlerExecutionError.printStackTrace();
			}
		} catch (QueryHandlerExecutionError queryHandlerExecutionError) {
			queryHandlerExecutionError.printStackTrace();
		} catch (QueryNotRegisteredError queryNotRegisteredError) {
			queryNotRegisteredError.printStackTrace();
		} catch (VentaErrorLecturaExcel e) {
			HashMap<String, List<Integer>> errores = new HashMap<>();
			e.getListaErrores().entrySet().forEach(registro -> {
				errores.put("Errores Excel", e.getListaErrores().get(registro.getKey()).errors().values().stream()
						.distinct().flatMap(x -> x.stream()).collect(Collectors.toList()));
			});

			JSONObject json = new JSONObject(errores);
			System.out.println(json.toString());
			try {
				commandBus.dispatch(new RegistrarErroresCommand(pTipoRecepcionId.value(), json, 1000L));
			} catch (CommandNotRegisteredError e1) {
				e1.printStackTrace();
			} catch (CommandHandlerExecutionError e1) {
				e1.printStackTrace();
			}

		}
	}
}
