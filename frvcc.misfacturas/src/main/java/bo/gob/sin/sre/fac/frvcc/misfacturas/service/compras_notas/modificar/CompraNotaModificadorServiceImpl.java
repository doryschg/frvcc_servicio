package bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras_notas.modificar;

import java.util.Arrays;
import java.util.HashMap;

import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.EnumFacFrvccMensajesShared;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.secundary.compras_notas.validadores.CompraNotaValidador;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNota;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaCodigoAutorizacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaCodigoControlNota;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaFechaNota;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaIfcProveedor;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaImporteTotalNota;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaListaErrores;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaNitProveedor;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaNumeroNota;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaOrigenId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaRazonSocialProveedor;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.compras_notas.modificar.ICompraNotaModificar;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.compras_notas.CompraNotaRepository;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.contribuyentes.ContribuyenteResponse;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.contribuyentes.BuscarContribuyentePorNitQueryDto;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ValidationResponse;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.EventBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryNotRegisteredError;

@Service
public class CompraNotaModificadorServiceImpl implements ICompraNotaModificar {
	private static final Logger LOG = LoggerFactory.getLogger(CompraNotaModificadorServiceImpl.class);
	private final CompraNotaRepository repository;
	private final EventBus eventBus;
	private final QueryBus queryBus;
	public final CompraNotaValidador validador;

	public CompraNotaModificadorServiceImpl(CompraNotaRepository pRepository, EventBus pEventBus, QueryBus pQueryBus,
			CompraNotaValidador pValidador) {
		this.repository = pRepository;
		this.eventBus = pEventBus;
		this.queryBus = pQueryBus;
		this.validador = pValidador;
	}

	@Override
	public void modificar(CompraNotaId pId, CompraNotaNitProveedor pNitProveedor, CompraNotaNumeroNota pNumeroNota,
			CompraNotaCodigoAutorizacion pCodigoAutorizacion, CompraNotaFechaNota pFechaNota,
			CompraNotaImporteTotalNota pImporteTotalNota, CompraNotaCodigoControlNota pCodigoControlNota,
			CompraNotaOrigenId pOrigenId, CompraNotaUsuarioUltimaModificacion pUsuarioUltimaModificacion)
			throws QueryNotRegisteredError, QueryHandlerExecutionError {
		CompraNota vCompraNota = repository.findById(pId)
				.orElseThrow(() -> new CompraNotaListaErrores(pId, validador.crearValidacionCompraNotaNoExiste()));
		CompraNotaIfcProveedor vIfcProveedor = null;
		CompraNotaRazonSocialProveedor vRazonSocialProveedor = null;
		if (!vCompraNota.nitProveedor().value().equals(pNitProveedor.value())) {
			ContribuyenteResponse vContribuyenteResponse = queryBus
					.ask(new BuscarContribuyentePorNitQueryDto(pNitProveedor.value()));
			vIfcProveedor = new CompraNotaIfcProveedor(vContribuyenteResponse.ifc());
			vRazonSocialProveedor = new CompraNotaRazonSocialProveedor(vContribuyenteResponse.razonSocial());
		}

		vCompraNota.modificar(pNitProveedor, vIfcProveedor, vRazonSocialProveedor, pNumeroNota, pCodigoAutorizacion,
				pFechaNota, pImporteTotalNota, pCodigoControlNota, pOrigenId, pUsuarioUltimaModificacion);
		try {

			repository.guardar(vCompraNota);
		} catch (Exception excepcion) {
			LOG.error(excepcion.getCause().toString(), excepcion);
			throw new CompraNotaListaErrores(pId, crearValidacionException());

		}
		eventBus.publish(vCompraNota.pullDomainEvents());
	}

	private ValidationResponse crearValidacionException() {
		return new ValidationResponse(new HashMap<>() {
			{
				put("id", Arrays.asList(EnumFacFrvccMensajesShared.ERROR_EDICION.getId()));
			}
		});
	}
}
