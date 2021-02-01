package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.service.recepcion.registro;

import java.util.Arrays;
import java.util.HashMap;

import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.recepcion.Recepcion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.recepcion.RecepcionId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.recepcion.RecepcionIfc;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.recepcion.RecepcionNit;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.recepcion.RecepcionTipoDocumentoId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.recepcion.RecepcionTipoRecepcionId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.model.recepcion.RecepcionUsuarioRegistro;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.use.ports.primary.recepcion.registro.IRecepcionRegistro;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.use.ports.secundary.recepcion.IRecepcionRepository;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.EnumFacFrvccMensajesShared;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ValidationResponse;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.EventBus;

@Service
public final class RecepcionRegistroServiceImpl implements IRecepcionRegistro {
	private final IRecepcionRepository repository;
	private final EventBus eventBus;

	public RecepcionRegistroServiceImpl(IRecepcionRepository pRepository, EventBus pEventBus) {
		this.repository = pRepository;
		this.eventBus = pEventBus;
	}

	@Override
	public void registrar(RecepcionId pId, RecepcionTipoRecepcionId pTipoRecepcionId,
			RecepcionTipoDocumentoId pTipoDocumentoId, RecepcionIfc pIfc, RecepcionNit pNit,
			RecepcionUsuarioRegistro pUsuarioRegistro) {
		HashMap<String, ValidationResponse> vResutaldosValidacion = new HashMap<>();
		if (!repository.findById(pId).isPresent()) {
			Recepcion recepcion = Recepcion.Registrar(pId, pTipoRecepcionId, pTipoDocumentoId, pIfc, pNit,
					pUsuarioRegistro);
			repository.guardar(recepcion);
			eventBus.publish(recepcion.pullDomainEvents());
		} else {
			vResutaldosValidacion.put(pId.value(), crearValidacionRecepcionExistente());
		}
	}

	private ValidationResponse crearValidacionRecepcionExistente() {
		return new ValidationResponse(new HashMap<>() {
			{
				put("nitProveedor", Arrays.asList(EnumFacFrvccMensajesShared.COMPRA_YA_EXISTE.getId()));
			}
		});
	}
}
