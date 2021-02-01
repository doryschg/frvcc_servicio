package bo.gob.sin.sre.fac.frvcc.misfacturas.service.formularios.consolidar;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.secundary.compras.validadores.CompraValidador;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.secundary.formularios.validadores.FormularioValidador;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.*;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.consolidaciones.ConsolidacionId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.consolidaciones.ConsolidacionListaErrores;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.consolidaciones.ConsolidacionUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.*;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.hformularios.HFormularioUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras.asignar.CompraAsignadorServiceImpl;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.formularios.consolidar.IConsolidarFormularios;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.compras.CompraRepository;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.formularios.FormularioRepository;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.EventBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryBus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
@Service
public class ConsolidarFormulariosServiceImpl implements IConsolidarFormularios {
    private static final Logger LOG= LoggerFactory.getLogger(CompraAsignadorServiceImpl.class);
    private final FormularioRepository repository;
    private final EventBus eventBus;
    private final QueryBus queryBus;
    private final FormularioValidador validador;



    public ConsolidarFormulariosServiceImpl(FormularioRepository pRepository, EventBus pEventBus, QueryBus pQueryBus,FormularioValidador pValidador) {
        this.repository = pRepository;
        this.eventBus = pEventBus;
        this.queryBus = pQueryBus;
        this.validador=pValidador;
    }
    @Override
    public void consolidar( List<FormularioId> pIds,
                         ConsolidacionId pIdConsolidacion,
                            ConsolidacionUsuarioUltimaModificacion pUsuarioUltimaModificacion
                         ){


        pIds.stream().forEach( id -> {
                    LOG.info("compra id {}. pIdConsolidacion id {}. usuario {}.", id,pIdConsolidacion,pUsuarioUltimaModificacion);
                    Formulario vFormulario = repository.findById(id).orElseThrow(() -> new FormularioListaErrores(id, validador.crearValidacionFormularioNoExistente()));
                    try {

                        vFormulario.consolidarFormulario(new FormularioConsolidacionId(pIdConsolidacion.value()),
                                new FormularioUsuarioUltimaModificacion(pUsuarioUltimaModificacion.value()));
                        LOG.info("FormularioConsolidacionId {}", vFormulario.consolidacionId().value());

                        repository.save(vFormulario);
                    } catch (Exception excepcion) {
                        LOG.error(excepcion.getMessage(), excepcion);
                          //throw new FormularioListaErrores((id, validador.crearValidacionException());

                    }
                    eventBus.publish(vFormulario.pullDomainEvents());
                }

        );
    }
}
