package bo.gob.sin.sre.fac.frvcc.misfacturas.service.consolidaciones.registro;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.secundary.consolidaciones.PostgreSqlConsolidacionRepository;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.secundary.consolidaciones.validadores.ConsolidacionValidador;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.secundary.formularios.validadores.FormularioValidador;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.consolidaciones.*;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.Formulario;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioListaErrores;
import bo.gob.sin.sre.fac.frvcc.misfacturas.service.formularios.registro.FormularioRegistradorServiceImpl;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.consolidaciones.registro.IConsolidacionRegistrador;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.formularios.FormularioRepository;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.EventBus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ConsolidacionregistradorServiceImpl implements IConsolidacionRegistrador {
    private static final Logger LOG = LoggerFactory.getLogger(FormularioRegistradorServiceImpl.class);
    private final PostgreSqlConsolidacionRepository repository;
    private final EventBus eventBus;
    private final ConsolidacionValidador validador;
    public ConsolidacionregistradorServiceImpl(PostgreSqlConsolidacionRepository pRepository, EventBus pEventBus,
                                            ConsolidacionValidador pValidador) {
        this.repository = pRepository;
        this.eventBus = pEventBus;
        this.validador = pValidador;
    }
    @Override
    public void registro(ConsolidacionId id, ConsolidacionIfcAgente ifcAgente, ConsolidacionNitAgente nitAgente, ConsolidacionRazonSocialAgente razonSocialAgente, ConsolidacionSucursal sucursal, ConsolidacionDireccionSucursal direccionSucursal, ConsolidacionDepartamentoSucursal departamentoSucursal, ConsolidacionAdministracion administracion, ConsolidacionGestion gestion, ConsolidacionPeriodo periodo, ConsolidacionCantidadFormularios cantidadFormularios, ConsolidacionTotalCantidadFacturas totalCantidadFacturas, ConsolidacionTotalCantidadOtrasFacturas totalCantidadOtrasFacturas, ConsolidacionTotalCantidad7rgFacturas totalCantidad7rgFacturas, ConsolidacionTotalImporteFacturas totalImporteFacturas, ConsolidacionTotalImporteOtrasFacturas totalImporteOtrasFacturas, ConsolidacionTotalImporte7rgFacturas totalImporte7rgFacturas, ConsolidacionTotalDeterminacionPagoCuenta totalDeterminacionPagoCuenta, ConsolidacionTotalPagoCuenta totalPagoCuenta, ConsolidacionUsuarioConsolidador usuarioConsolidador, ConsolidacionLoginUsuarioConsolidador loginUsuarioConsolidador, ConsolidacionNombreConsolidador nombreConsolidador, ConsolidacionUsuarioRegistro usuarioRegistro) {

//        Consolidacion vConsolidacion = Consolidacion.registro(id, ifcAgente, nitAgente, razonSocialAgente, sucursal, direccionSucursal, departamentoSucursal,
//                 administracion,  gestion,  periodo,  cantidadFormularios, totalCantidadFacturas, totalCantidadOtrasFacturas, totalCantidad7rgFacturas,
//                totalImporteFacturas, totalImporteOtrasFacturas, totalImporte7rgFacturas, totalDeterminacionPagoCuenta, totalPagoCuenta, usuarioConsolidador,
//                loginUsuarioConsolidador, nombreConsolidador, usuarioRegistro);
//        try {
//            repository.guardar(vConsolidacion);
//            eventBus.publish(vConsolidacion.pullDomainEvents());
//        } catch (Exception excepcion) {
//            LOG.error(excepcion.getCause().toString(), excepcion);
//            throw new ConsolidadorListaErrores(id, validador.crearValidacionException());
//        }
    }
}
