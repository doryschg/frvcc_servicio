package bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras.des_asignar;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.EnumFacFrvccMensajesShared;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.secundary.compras.validadores.CompraValidador;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.Compra;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraFormularioId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraGestionUso;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraListaErrores;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraNombreFormularioUso;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraPeriodoUso;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.compras.desasignar.ICompraDesasignar;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.compras.CompraRepository;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ValidationResponse;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.EventBus;

@Service
public  class CompraDesAsignadorServiceImpl implements ICompraDesasignar {
	private static final Logger LOG= LoggerFactory.getLogger(CompraDesAsignadorServiceImpl.class);
    private final CompraRepository repository;
    private final EventBus eventBus;
    private final CompraValidador validador;

    public CompraDesAsignadorServiceImpl(CompraRepository pRepository, EventBus pEventBus, CompraValidador pValidador) {
        this.repository = pRepository;
        this.eventBus = pEventBus;
        this.validador=pValidador;
    }

    @Override
    public void desAsignar(List<CompraId> pIds,
                           CompraFormularioId pFormularioId,
                           CompraUsuarioUltimaModificacion pUsuarioUltimaModificacion,
                           CompraPeriodoUso pPeriodoUso,
                           CompraGestionUso pGestionUso,
                           CompraNombreFormularioUso pNombreFormulrioUso,
                           String pTipoformularioId
    		) {
        pIds.stream().forEach( id -> {
            Compra vCompra = repository.findById(id).orElseThrow(() -> new CompraListaErrores(id, validador.crearValidacionCompraNoExiste()));
            vCompra.desAsignarAFormulario(pFormularioId, pUsuarioUltimaModificacion);
            try {

                repository.guardar(vCompra);
            } catch (Exception excepcion) {
                LOG.error(excepcion.getCause().toString(), excepcion);
                throw new CompraListaErrores(id, crearValidacionException());
            }
            eventBus.publish(vCompra.pullDomainEvents());
        });

    }
    
    private ValidationResponse crearValidacionException(){
        return  new ValidationResponse(new HashMap<>() {{
            put("id", Arrays.asList(EnumFacFrvccMensajesShared.ERROR_DESASOCIACION_COMPRAS.getId()));
        }});
    }

}
