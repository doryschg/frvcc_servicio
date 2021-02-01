package bo.gob.sin.sre.fac.frvcc.misfacturas.service.formularios.seleccionar_compras;


import java.util.*;
import java.util.stream.Collectors;


import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.search_by_criteria.SearchComprasByCriteriaQuery;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.EnumMarcaEspecialId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.*;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.formularios.generar_historial.IGeneradorHistorialFormulario;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.shared.BeneficiarioPersonaRivDto;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.shared.IBeneficiarioPersonaRivService;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.EnumFacFrvccMensajesShared;
import bo.gob.sin.sre.fac.frvcc.shared.model.EnumEstadoId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.ComprasResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.search_by_criteria.SearchComprasListaIds;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.secundary.formularios.validadores.FormularioValidador;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.EstadoUsoId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.formularios.seleccionar_compras.IFormularioSeleccionarCompras;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.formularios.FormularioRepository;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ValidationResponse;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.EventBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryNotRegisteredError;

@Service
public class FormularioSeleccionarComprasServiceImpl implements IFormularioSeleccionarCompras {
    private static final Logger LOG = LoggerFactory.getLogger(FormularioSeleccionarComprasServiceImpl.class);
    private final FormularioRepository repository;
    private final EventBus eventBus;
    private final QueryBus queryBus;
    private final FormularioValidador validador;
    private final IGeneradorHistorialFormulario historialFormulario;

    public FormularioSeleccionarComprasServiceImpl(FormularioRepository pRepository,
                                                   EventBus pEventBus,
                                                   FormularioValidador pValidador,
                                                   QueryBus pQueryBus,
                                                   IGeneradorHistorialFormulario historialFormulario) {
        this.repository = pRepository;
        this.eventBus = pEventBus;
        this.validador = pValidador;
        this.queryBus = pQueryBus;
        this.historialFormulario = historialFormulario;

    }

    public void incrementarImporte(FormularioId pFormularioId,
                                   FormularioUsuarioUltimaModificacion pUsuarioUltimaModificacion, List<String> pListaIdsCompras) {


        ValidationResponse vResultadoValidacion = validador.validarFormulario(
                new HashMap<>() {{
                    put("id", pFormularioId.value() != null ? pFormularioId.value() : "");
                }});
        if (vResultadoValidacion.hasErrors()) {
            throw new FormularioListaErrores(pFormularioId, vResultadoValidacion);
        }


        Formulario vFormulario = repository.search(pFormularioId).orElseThrow(
                () -> new FormularioListaErrores(pFormularioId, validador.crearValidacionFormularioNoExistente()));



        List<String> vFiltroComprasSeleccionadas = pListaIdsCompras.stream().filter(compra -> !vFormulario.compras()
                .stream()
                .anyMatch(compraId -> compraId.value().equals(compra))).collect(Collectors.toList());

        ComprasResponse vComprasResponse = null;
        ComprasResponse vComprasTotales = null;
        try {
            vComprasResponse = queryBus.ask(new SearchComprasListaIds(vFiltroComprasSeleccionadas));
            vComprasTotales = queryBus.ask(new SearchComprasByCriteriaQuery(filtrosTotalCompras(vFormulario.id().value()),Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty()));
        } catch (QueryHandlerExecutionError | QueryNotRegisteredError error) {
            throw new FormularioListaErrores(pFormularioId, crearValidacionException());
        }
        if(vFormulario.tipoFormularioId().value().equals(EnumTipoFormularioId.FORMULARIO_111.value())){

            vFormulario.incrementoImporte(
                    vComprasResponse.getComprasResponse().stream().filter(c -> Long.parseLong(c.getNumeroDocumentoCliente()) == vFormulario.nitCi().value() &&
                            c.getEstadoUsoId().equals(EstadoUsoId.REGISTRADO.value())).filter(c -> this.filtroPorTipoFormulario(vFormulario.tipoFormularioId().value(),c.marcaEspecialId(), c.tipoSectorId())).collect(Collectors.toList()),
                    pUsuarioUltimaModificacion
           );
        }else{
            vFormulario.incrementoImporte(
                    vComprasResponse.getComprasResponse().stream().filter(c -> Long.parseLong(c.getNumeroDocumentoCliente()) == vFormulario.nitCi().value() &&
                            c.getEstadoUsoId().equals(EstadoUsoId.REGISTRADO.value())).filter(c -> this.filtroPorTipoFormulario(vFormulario.tipoFormularioId().value(),c.marcaEspecialId(), c.tipoSectorId())).collect(Collectors.toList()),
                    pUsuarioUltimaModificacion
            );
        }


        try {
            repository.save(vFormulario);
        } catch (Exception excepcion) {

            throw new FormularioListaErrores(pFormularioId, crearValidacionException());

        }
        eventBus.publish(vFormulario.pullDomainEvents());
    }

    private List<HashMap<String, String>> filtrosTotalCompras(String idFormulario) {


      return   Arrays.asList(
                new HashMap<>(){{
                    put("field", "formularioId");
                    put("operator", "=");
                    put("value", idFormulario);
                }},
                new HashMap<>(){{
                    put("field", "estadoUsoId");
                    put("operator", "=");
                    put("value", EstadoUsoId.ASOCIADO.value());
                }},
                new HashMap<>(){{
                    put("field", "estadoId");
                    put("operator", "=");
                    put("value", EnumEstadoId.ACTIVO.value());
                }}
                ) ;
    }

    private ValidationResponse crearValidacionException() {
        return new ValidationResponse(new HashMap<>() {
            {
                put("id", Arrays.asList(EnumFacFrvccMensajesShared.ERROR_DECLARAR_FORMULARIO.getId()));
            }
        });
    }

    private Boolean filtroPorTipoFormulario(String tipoFormularioId, String marcaEspecialId, Integer tipoSectorId) {
        if (tipoFormularioId.equals(EnumTipoFormularioId.FORMULARIO_111.value())) {
            if ( marcaEspecialId.equals(EnumMarcaEspecialId.SINMARCA.value()) && tipoSectorId == null){
                return Boolean.TRUE;
            }

            if (tipoSectorId.equals(0) || tipoSectorId.equals(0)
                    || tipoSectorId.equals(1) || tipoSectorId.equals(11) || tipoSectorId.equals(2) || tipoSectorId.equals(15) ||
                    tipoSectorId.equals(16) || tipoSectorId.equals(17) || tipoSectorId.equals(22) || tipoSectorId.equals(21)) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}
