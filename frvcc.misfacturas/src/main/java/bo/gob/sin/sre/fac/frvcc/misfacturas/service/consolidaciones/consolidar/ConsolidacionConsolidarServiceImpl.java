package bo.gob.sin.sre.fac.frvcc.misfacturas.service.consolidaciones.consolidar;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios.FormularioResponseGenerico;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios.FormulariosResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios.search_by_criteria.SearchFormulariosByCriteriaQuery;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.secundary.consolidaciones.PostgreSqlConsolidacionRepository;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.secundary.consolidaciones.validadores.ConsolidacionValidador;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.consolidaciones.*;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.EnumTipoUsoId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.EstadoformularioId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.service.formularios.registro.FormularioRegistradorServiceImpl;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.consolidaciones.consolidar.IConsolidacionConsolidar;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ValidationResponse;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.EventBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryNotRegisteredError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ConsolidacionConsolidarServiceImpl implements IConsolidacionConsolidar {
    private static final Logger LOG = LoggerFactory.getLogger(FormularioRegistradorServiceImpl.class);
    private final PostgreSqlConsolidacionRepository repository;
    private final EventBus eventBus;
    private final QueryBus queryBus;
    private final ConsolidacionValidador validador;
    public ConsolidacionConsolidarServiceImpl(PostgreSqlConsolidacionRepository pRepository, EventBus pEventBus, QueryBus queryBus,
                                              ConsolidacionValidador pValidador) {
        this.repository = pRepository;
        this.eventBus = pEventBus;
        this.queryBus=queryBus;
        this.validador = pValidador;
    }

    @Override
    public void consolidar(ConsolidacionId pId, ConsolidacionIfcAgente ifcAgente, ConsolidacionNitAgente nitAgente,
                           ConsolidacionRazonSocialAgente razonSocialAgente,
                           ConsolidacionAdministracion administracion, ConsolidacionGestion gestion, ConsolidacionPeriodo periodo,
                           ConsolidacionUsuarioConsolidador usuarioConsolidador, ConsolidacionLoginUsuarioConsolidador loginUsuarioConsolidador,
                           ConsolidacionNombreConsolidador nombreConsolidador, ConsolidacionUsuarioRegistro usuarioRegistro)
    {

        ValidationResponse vResultadoValidacion = validador.validarConsolidacion(
                new HashMap<>() {{
                    put("id", pId.value() != null ? pId.value() : "");
                    put("ifcAgente", ifcAgente.value() != null ? ifcAgente.value().toString() : "");
                    put("nitAgente", nitAgente.value() != null ? nitAgente.value().toString() : "");
                    put("razonSocialAgente", razonSocialAgente.value() != null ? razonSocialAgente.value().toString() : "");
                    put("administracion", administracion.value() != null ? administracion.value() : "");
                    put("gestion", gestion.value() != null ? gestion.value().toString() : "");
                    put("periodo", periodo.value() != null ? periodo.value().toString() : "");
                    put("usuarioConsolidador", usuarioConsolidador.value() != null ? usuarioConsolidador.value() : "");
                    put("loginUsuarioConsolidador", loginUsuarioConsolidador.value() != null ? loginUsuarioConsolidador.value() : "");
                    put("nombreConsolidador", nombreConsolidador.value() != null ? nombreConsolidador.value() : "");
                    put("usuarioRegistro", usuarioRegistro.value() != null ? usuarioRegistro.value() : "");
                }});

        if (vResultadoValidacion.hasErrors()) {
            throw new ConsolidacionListaErrores(pId, vResultadoValidacion);
        }

        //TODO Descomentar las lineas en periodo febrero
//        List<HashMap<String, String>> filters0 = new ArrayList<>();
//
//        filters0.add(new HashMap<>(){{put("field", "nitEmpleador"); put("operator", "="); put("value", nitAgente.value().toString());   }});
//        filters0.add(new HashMap<>(){{put("field", "anioPeriodo");  put("operator", "="); put("value", gestion.value().toString());      }});
//        filters0.add(new HashMap<>(){{put("field", "mesPeriodo");  put("operator", "=");  put("value", periodo.value().toString());     }});
//        filters0.add(new HashMap<>(){{put("field", "estadoFormularioId");put("operator", "="); put("value", EstadoformularioId.DECLARADO.value());        }});
//        filters0.add(new HashMap<>(){{put("field", "tipoUsoId");put("operator", "="); put("value",EnumTipoUsoId.TIPO_DEPENDIENTE.value());        }});
//        SearchFormulariosByCriteriaQuery searchFormulariosByCriteriaQuery0  = new SearchFormulariosByCriteriaQuery(filters0, Optional.ofNullable(null),Optional.ofNullable(null),Optional.ofNullable(null),Optional.ofNullable(null));
//        FormulariosResponse vFormulariosResponse0  = null;
//        try {
//            vFormulariosResponse0 = queryBus.ask(searchFormulariosByCriteriaQuery0);
//        } catch (QueryHandlerExecutionError queryHandlerExecutionError) {
//            queryHandlerExecutionError.printStackTrace();
//        } catch (QueryNotRegisteredError queryNotRegisteredError) {
//            queryNotRegisteredError.printStackTrace();
//        }
//
//        if(vFormulariosResponse0.getTotalElementos()>0)
//        {
//            throw new ConsolidacionListaErrores(new ConsolidacionId(UUID.randomUUID().toString()), validador.crearValidacionFormulariosPendientes());
//        }


        List<HashMap<String, String>> filters = new ArrayList<>();

        filters.add(new HashMap<>(){{put("field", "nitEmpleador"); put("operator", "="); put("value", nitAgente.value().toString());   }});
        filters.add(new HashMap<>(){{put("field", "anioPeriodo");  put("operator", "="); put("value", gestion.value().toString());      }});
        filters.add(new HashMap<>(){{put("field", "mesPeriodo");  put("operator", "=");  put("value", periodo.value().toString());     }});
        filters.add(new HashMap<>(){{put("field", "estadoFormularioId");put("operator", "="); put("value", EstadoformularioId.ACEPTADO.value());        }});
        filters.add(new HashMap<>(){{put("field", "tipoUsoId");put("operator", "="); put("value",EnumTipoUsoId.TIPO_DEPENDIENTE.value());        }});
        SearchFormulariosByCriteriaQuery searchFormulariosByCriteriaQuery  = new SearchFormulariosByCriteriaQuery(filters, Optional.ofNullable(null),Optional.ofNullable(null),Optional.ofNullable(null),Optional.ofNullable(null));
        FormulariosResponse vFormulariosResponse  = null;
        try {
            vFormulariosResponse = queryBus.ask(searchFormulariosByCriteriaQuery);
        } catch (QueryHandlerExecutionError queryHandlerExecutionError) {
            queryHandlerExecutionError.printStackTrace();
        } catch (QueryNotRegisteredError queryNotRegisteredError) {
            queryNotRegisteredError.printStackTrace();
        }
        List<FormularioResponseGenerico> formularios=vFormulariosResponse.getFormulariosReponse();
        List<Integer> vNrosSucursales=formularios.stream().map(f->f.getNumeroSucursal()).distinct().collect(Collectors.toList());
        List<Consolidacion> vConsolidaciones=new ArrayList<>();
        vConsolidaciones.add(obtenerConsolidacionPrincipal(vFormulariosResponse,pId, ifcAgente, nitAgente,
                razonSocialAgente,
                administracion, gestion, periodo,
                usuarioConsolidador, loginUsuarioConsolidador,
                nombreConsolidador, usuarioRegistro));
        for ( Integer vNrosuc: vNrosSucursales) {
            vConsolidaciones.add(obtenerConsolidacionSucursal(vNrosuc,vFormulariosResponse,pId, ifcAgente, nitAgente,
                    razonSocialAgente,
                    administracion, gestion, periodo,
                    usuarioConsolidador, loginUsuarioConsolidador,
                    nombreConsolidador, usuarioRegistro));
        }
        if(!vConsolidaciones.isEmpty()){
        repository.BuscarConsolidacionExistente(vConsolidaciones.get(0)).ifPresentOrElse(consolidacion -> {
                    throw new ConsolidacionListaErrores(consolidacion.id(), validador.crearValidacionConsolidacionExistente());

                },
                () -> {
                    try{
                        repository.guardarTodo(vConsolidaciones);
                        vConsolidaciones.stream().forEach(consolidacion -> eventBus.publish(consolidacion.pullDomainEvents()));
                    }catch (Exception e){
                        LOG.error(e.getCause().toString(), e);
                        throw new ConsolidacionListaErrores(new ConsolidacionId(""), validador.crearValidacionException());
                    }
                });
        }

    }
    public Consolidacion obtenerConsolidacionSucursal(int pNroSucursal,FormulariosResponse pFormularios,ConsolidacionId id, ConsolidacionIfcAgente ifcAgente, ConsolidacionNitAgente nitAgente,
                                         ConsolidacionRazonSocialAgente razonSocialAgente, ConsolidacionAdministracion administracion, ConsolidacionGestion gestion, ConsolidacionPeriodo periodo,
                                         ConsolidacionUsuarioConsolidador usuarioConsolidador, ConsolidacionLoginUsuarioConsolidador loginUsuarioConsolidador,
                                         ConsolidacionNombreConsolidador nombreConsolidador, ConsolidacionUsuarioRegistro usuarioRegistro){


        List<FormularioResponseGenerico> formularios=pFormularios.getFormulariosReponse();
        Optional<FormularioResponseGenerico> vFormu=formularios.stream().filter(f->f.getNumeroSucursal()==pNroSucursal).findFirst();
        Long cantidadFormularios=formularios.stream().filter(f->f.getNumeroSucursal()==pNroSucursal).count();
        Integer totalCantidadFacturas=formularios.stream().filter(f->f.getNumeroSucursal()==pNroSucursal).mapToInt(formulario->formulario.getCantidadCompras()).sum();
        Integer totalCantidadIpnFacturas=formularios.stream().filter(f->f.getNumeroSucursal()==pNroSucursal).mapToInt(formulario->formulario.getCantidadComprasCfIpn()).sum();
        Integer totalCantidadOtrasFacturas=formularios.stream().filter(f->f.getNumeroSucursal()==pNroSucursal).mapToInt(formulario->formulario.getCantidadComprasCfOtras()).sum();
        Integer totalCantidad7rgFacturas=formularios.stream().filter(f->f.getNumeroSucursal()==pNroSucursal).mapToInt(formulario->formulario.getCantidadComprasSdCf()).sum();
        BigInteger totalImporteFacturas= formularios.stream().filter(f->f.getNumeroSucursal()==pNroSucursal).map(formulario -> formulario.getTotalComprasCfRed()).reduce(BigInteger.ZERO, BigInteger::add);
        BigInteger totalImporteIpnFacturas=formularios.stream().filter(f->f.getNumeroSucursal()==pNroSucursal).map(formulario -> formulario.getTotalComprasCfIpnRed()).reduce(BigInteger.ZERO, BigInteger::add);
        BigInteger totalImporteOtrasFacturas=formularios.stream().filter(f->f.getNumeroSucursal()==pNroSucursal).map(formulario -> formulario.getTotalComprasCfOtrasRed()).reduce(BigInteger.ZERO, BigInteger::add);
        BigInteger totalImporte7rgFacturas=formularios.stream().filter(f->f.getNumeroSucursal()==pNroSucursal).map(formulario -> formulario.getTotalComprasSdCfRed()).reduce(BigInteger.ZERO, BigInteger::add);
        BigInteger totalDeterminacionPagoCuenta=formularios.stream().filter(f->f.getNumeroSucursal()==pNroSucursal).map(formulario -> formulario.getDeterminacionPagoCfRed()).reduce(BigInteger.ZERO, BigInteger::add);
        BigInteger totalPagoCuenta=formularios.stream().filter(f->f.getNumeroSucursal()==pNroSucursal).map(formulario -> formulario.getDeterminacionPagoSdCfRed()).reduce(BigInteger.ZERO, BigInteger::add);

        Consolidacion vConsolidacion=Consolidacion.registro(
                new ConsolidacionId(UUID.randomUUID().toString()), ifcAgente, nitAgente,
                razonSocialAgente,
                new ConsolidacionSucursal(vFormu.get().getNumeroSucursal()),
                new ConsolidacionDireccionSucursal(vFormu.get().getDireccionEmpleador()),
                new ConsolidacionDepartamentoSucursal(vFormu.get().getDatosEspecificos().getDepartamentoDescripcion()),
                administracion,
                 gestion,  periodo,
                 new ConsolidacionCantidadFormularios(cantidadFormularios),
                new ConsolidacionTotalCantidadFacturas(totalCantidadFacturas),
                new ConsolidacionTotalCantidadOtrasFacturas(totalCantidadOtrasFacturas),
                new ConsolidacionTotalCantidad7rgFacturas(totalCantidad7rgFacturas),
                new ConsolidacionTotalImporteFacturas(totalImporteFacturas),
                new ConsolidacionTotalImporteOtrasFacturas(totalImporteOtrasFacturas),
                 new ConsolidacionTotalImporte7rgFacturas(totalImporte7rgFacturas),
                new ConsolidacionTotalDeterminacionPagoCuenta(totalDeterminacionPagoCuenta),
                new ConsolidacionTotalPagoCuenta(totalPagoCuenta), usuarioConsolidador,
                 loginUsuarioConsolidador,	 nombreConsolidador,
                 usuarioRegistro, new ConsolidacionTipoId("S"),
                new ConsolidacionIdConsolidacionPrincipal(id.value()),
                formularios.stream().filter(f->f.getNumeroSucursal()==pNroSucursal).map(f->new FormularioId(f.getId())).collect(Collectors.toList()),
                new ConsolidacionTotalCantidadIpnFacturas(totalCantidadIpnFacturas),
                new ConsolidacionTotalImporteIpnFacturas(totalImporteIpnFacturas)
        )
                ;

                return vConsolidacion;
    }
    public Consolidacion obtenerConsolidacionPrincipal(FormulariosResponse pFormularios,ConsolidacionId id, ConsolidacionIfcAgente ifcAgente, ConsolidacionNitAgente nitAgente,
                                                      ConsolidacionRazonSocialAgente razonSocialAgente, ConsolidacionAdministracion administracion, ConsolidacionGestion gestion, ConsolidacionPeriodo periodo,
                                                      ConsolidacionUsuarioConsolidador usuarioConsolidador, ConsolidacionLoginUsuarioConsolidador loginUsuarioConsolidador,
                                                      ConsolidacionNombreConsolidador nombreConsolidador, ConsolidacionUsuarioRegistro usuarioRegistro){


        List<FormularioResponseGenerico> formularios=pFormularios.getFormulariosReponse();
        Long cantidadFormularios=formularios.stream().count();
        Integer totalCantidadFacturas=formularios.stream().mapToInt(formulario->formulario.getCantidadCompras()).sum();
        Integer totalCantidadIpnFacturas=formularios.stream().mapToInt(formulario->formulario.getCantidadComprasCfIpn()).sum();
        Integer totalCantidadOtrasFacturas=formularios.stream().mapToInt(formulario->formulario.getCantidadComprasCfOtras()).sum();
        Integer totalCantidad7rgFacturas=formularios.stream().mapToInt(formulario->formulario.getCantidadComprasSdCf()).sum();
        BigInteger totalImporteFacturas= formularios.stream().map(formulario -> formulario.getTotalComprasCfRed()).reduce(BigInteger.ZERO, BigInteger::add);
        BigInteger totalImporteIpnFacturas=formularios.stream().map(formulario -> formulario.getTotalComprasCfIpnRed()).reduce(BigInteger.ZERO, BigInteger::add);
        BigInteger totalImporteOtrasFacturas=formularios.stream().map(formulario -> formulario.getTotalComprasCfOtrasRed()).reduce(BigInteger.ZERO, BigInteger::add);
        BigInteger totalImporte7rgFacturas=formularios.stream().map(formulario -> formulario.getTotalComprasSdCfRed()).reduce(BigInteger.ZERO, BigInteger::add);
        BigInteger totalDeterminacionPagoCuenta=formularios.stream().map(formulario -> formulario.getDeterminacionPagoCfRed()).reduce(BigInteger.ZERO, BigInteger::add);
        BigInteger totalPagoCuenta=formularios.stream().map(formulario -> formulario.getDeterminacionPagoSdCfRed()).reduce(BigInteger.ZERO, BigInteger::add);
        Consolidacion vConsolidacion=new Consolidacion();
        vConsolidacion=vConsolidacion.registroPrincipal(
                new ConsolidacionId(UUID.randomUUID().toString()), ifcAgente, nitAgente,
                razonSocialAgente,
                new ConsolidacionSucursal(0),
                new ConsolidacionDireccionSucursal(""),
                new ConsolidacionDepartamentoSucursal(""), administracion,
                gestion,  periodo,
                new ConsolidacionCantidadFormularios(cantidadFormularios),
                new ConsolidacionTotalCantidadFacturas(totalCantidadFacturas),
                new ConsolidacionTotalCantidadOtrasFacturas(totalCantidadOtrasFacturas),
                new ConsolidacionTotalCantidad7rgFacturas(totalCantidad7rgFacturas),
                new ConsolidacionTotalImporteFacturas(totalImporteFacturas),
                new ConsolidacionTotalImporteOtrasFacturas(totalImporteOtrasFacturas),
                new ConsolidacionTotalImporte7rgFacturas(totalImporte7rgFacturas),
                new ConsolidacionTotalDeterminacionPagoCuenta(totalDeterminacionPagoCuenta),
                new ConsolidacionTotalPagoCuenta(totalPagoCuenta), usuarioConsolidador,
                loginUsuarioConsolidador,	 nombreConsolidador,
                usuarioRegistro, new ConsolidacionTipoId("P"),
                new ConsolidacionIdConsolidacionPrincipal(null),
                formularios.stream().map(f->new FormularioId(f.getId())).collect(Collectors.toList()),
                new ConsolidacionTotalCantidadIpnFacturas(totalCantidadIpnFacturas),
                new ConsolidacionTotalImporteIpnFacturas(totalImporteIpnFacturas)

        );

        return vConsolidacion;
    }
}
