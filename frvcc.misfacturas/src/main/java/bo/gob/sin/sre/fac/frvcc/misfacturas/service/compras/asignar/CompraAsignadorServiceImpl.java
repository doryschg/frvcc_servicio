package bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras.asignar;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.*;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.EnumFacFrvccMensajesShared;
import bo.gob.sin.sre.fac.frvcc.shared.model.EnumEstadoId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.secundary.compras.validadores.CompraValidador;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.compras.asignar.ICompraAsignar;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.compras.CompraRepository;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ValidationResponse;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.EventBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryBus;

@Service
public class CompraAsignadorServiceImpl  implements ICompraAsignar {
    private static final Logger LOG = LoggerFactory.getLogger(CompraAsignadorServiceImpl.class);
    private final CompraRepository repository;
    private final EventBus eventBus;
    private final QueryBus queryBus;
    private final CompraValidador validador;


    public CompraAsignadorServiceImpl(CompraRepository pRepository, EventBus pEventBus, QueryBus pQueryBus, CompraValidador pValidador) {
        this.repository = pRepository;
        this.eventBus = pEventBus;
        this.queryBus = pQueryBus;
        this.validador = pValidador;
    }

    @Override
    public void asignar(List<CompraId> pIds,
                        CompraFormularioId pFormularioId,
                        CompraUsuarioUltimaModificacion pUsuarioUltimaModificacion,
                        CompraPeriodoUso pPeriodoUso,
                        CompraGestionUso pGestionUso,
                        CompraNombreFormularioUso pNombreFormulrioUso,
                        String pTipoformularioId) {


        pIds.stream().forEach(id -> {
            LOG.info("compra id {}. formulario id {}. usuario {}.", id, pFormularioId, pUsuarioUltimaModificacion);
            Compra vCompra = repository.findById(id).orElseThrow(() -> new CompraListaErrores(id, validador.crearValidacionCompraNoExiste()));
            try {
                LOG.info("tipoFormulario {}", pTipoformularioId);
                vCompra.asignarAFormulario(pFormularioId, pPeriodoUso, pNombreFormulrioUso,
                        pUsuarioUltimaModificacion, pGestionUso, pTipoformularioId);
                LOG.info("creditoFiscal {}", vCompra.creditoFiscal().value());
                LOG.info("importe credito fiscal {}", vCompra.importeBaseCf().value());

                repository.guardar(vCompra);
            } catch (Exception excepcion) {
                LOG.error(excepcion.getMessage(), excepcion);
                throw new CompraListaErrores(id, crearValidacionException());

            }
            eventBus.publish(vCompra.pullDomainEvents());
                }

        );
    }

    private ValidationResponse crearValidacionException() {
        return new ValidationResponse(new HashMap<>() {{
            put("id", Arrays.asList(EnumFacFrvccMensajesShared.ERROR_ASOCIACION_COMPRAS.getId()));
        }});
    }


    private List<HashMap<String, String>> filtrosTotalCompras(String idFormulario) {


        return Arrays.asList(
                new HashMap<>() {{
                    put("field", "formularioId");
                    put("operator", "=");
                    put("value", idFormulario);
                }},
                new HashMap<>() {{
                    put("field", "estadoUsoId");
                    put("operator", "=");
                    put("value", EstadoUsoId.ASOCIADO.value());
                }},
                new HashMap<>() {{
                    put("field", "estadoId");
                    put("operator", "=");
                    put("value", EnumEstadoId.ACTIVO.value());
                }}
        );
    }
}
