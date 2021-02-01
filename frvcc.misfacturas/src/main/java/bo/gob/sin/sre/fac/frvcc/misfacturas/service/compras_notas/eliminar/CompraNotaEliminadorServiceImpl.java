package bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras_notas.eliminar;

import java.util.Arrays;
import java.util.HashMap;

import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.EnumFacFrvccMensajesShared;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.secundary.compras_notas.validadores.CompraNotaValidador;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.EstadoUsoId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNota;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaListaErrores;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.compras_notas.eliminar.ICompraNotaEliminar;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.compras_notas.CompraNotaRepository;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ValidationResponse;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;

@Service
public class CompraNotaEliminadorServiceImpl implements ICompraNotaEliminar {
	private static final Logger LOG = LoggerFactory.getLogger(CompraNotaEliminadorServiceImpl.class);
	private final CompraNotaRepository repository;
	public final CompraNotaValidador validador;

	public CompraNotaEliminadorServiceImpl(CompraNotaRepository pRepository, CompraNotaValidador pValidador) {
		this.repository = pRepository;
		this.validador = pValidador;
	}

	@Override
	public void eliminar(CompraNotaId pId, CompraNotaUsuarioUltimaModificacion pUsuarioUltimaModificacion) {
		CompraNota vCompraNota = repository.findById(pId)
				.orElseThrow(() -> new CompraNotaListaErrores(pId, validador.crearValidacionCompraNotaNoExiste()));
		if (vCompraNota.estadoUsoId().value().equals(EstadoUsoId.REGISTRADO.value())) {
			try {

				vCompraNota.eliminar(pUsuarioUltimaModificacion);
			} catch (Exception excepcion) {
				LOG.error(excepcion.getCause().toString(), excepcion);
				throw new CompraNotaListaErrores(pId, crearValidacionException());

			}
			repository.guardar(vCompraNota);
		}
	}

	private ValidationResponse crearValidacionException() {
		return new ValidationResponse(new HashMap<>() {
			{
				put("id", Arrays.asList(EnumFacFrvccMensajesShared.ERROR_ELIMINACION.getId()));
			}
		});
	}
}
