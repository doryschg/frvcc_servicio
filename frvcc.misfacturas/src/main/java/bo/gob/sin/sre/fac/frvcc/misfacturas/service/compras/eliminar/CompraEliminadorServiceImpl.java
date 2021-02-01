package bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras.eliminar;

import java.util.Arrays;
import java.util.HashMap;

import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.EnumFacFrvccMensajesShared;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.secundary.compras.validadores.CompraValidador;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.Compra;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraListaErrores;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.EstadoUsoId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.compras.eliminar.ICompraEliminar;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.compras.CompraRepository;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ValidationResponse;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;

@Service
public class CompraEliminadorServiceImpl implements ICompraEliminar {
	private static final Logger LOG = LoggerFactory.getLogger(CompraEliminadorServiceImpl.class);
	private final CompraRepository repository;
	private final CompraValidador validador;

	public CompraEliminadorServiceImpl(CompraRepository pRepository, CompraValidador pValidador) {
		this.repository = pRepository;
		this.validador = pValidador;
	}

	@Override
	public void eliminar(CompraId pId, CompraUsuarioUltimaModificacion pUsuarioUltimaModificacion) {
		Compra vCompra = repository.findById(pId)
				.orElseThrow(() -> new CompraListaErrores(pId, validador.crearValidacionCompraNoExiste()));
		if (vCompra.estadoUsoId().value().equals(EstadoUsoId.REGISTRADO.value()) && vCompra.ventaId() == null) {
			try {

				vCompra.eliminar(pUsuarioUltimaModificacion);
			} catch (Exception excepcion) {
				LOG.error(excepcion.getCause().toString(), excepcion);
				throw new CompraListaErrores(pId, crearValidacionException());

			}
			repository.guardar(vCompra);
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
