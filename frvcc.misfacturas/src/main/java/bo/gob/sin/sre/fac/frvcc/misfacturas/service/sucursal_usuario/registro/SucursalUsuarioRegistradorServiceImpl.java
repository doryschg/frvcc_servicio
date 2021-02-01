package bo.gob.sin.sre.fac.frvcc.misfacturas.service.sucursal_usuario.registro;


import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.secundary.compras.validadores.CompraValidador;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.secundary.sucursal_usuario.validadores.SucursalUsuarioValidador;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.*;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.sucursal_usuario.*;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.compras.registro.ICompraRegistrador;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.sucursal_usuario.registro.ISucursalUsuarioRegistrador;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.compras.CompraRepository;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.compras.VerificaCodigoAutorizacionRepository;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.compras.VerificadorNumeroAutoriacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.sucursal_usuario.ISucursalUsuarioRepository;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.contribuyentes.ContribuyenteResponse;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.contribuyentes.BuscarContribuyentePorNitQueryDto;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ValidationResponse;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.EventBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryNotRegisteredError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Optional;

@Service
public class SucursalUsuarioRegistradorServiceImpl implements ISucursalUsuarioRegistrador {
    private static final Logger LOG = LoggerFactory.getLogger(SucursalUsuarioRegistradorServiceImpl.class);
    private final ISucursalUsuarioRepository repository;
    private final EventBus eventBus;
    private final QueryBus queryBus;
    private final SucursalUsuarioValidador validador;

    public SucursalUsuarioRegistradorServiceImpl(ISucursalUsuarioRepository pRepository, EventBus pEventBus, QueryBus pQueryBus, SucursalUsuarioValidador pValidador) {
        this.repository = pRepository;
        this.eventBus = pEventBus;
        this.queryBus = pQueryBus;
        this.validador = pValidador;
    }

    public void registrar(SucursalUsuarioId id, SucursalUsuarioIfcAgente ifcAgente, SucursalUsuarioNitAgente nitAgente,
                          SucursalUsuarioNumeroSucursal nroSucursal, SucursalUsuarioUsuarioReceptor usuarioReceptor,
                          SucursalUsuarioLoginUsuarioReceptor loginUsuarioReceptor, SucursalUsuarioNombreReceptor nombreUsuarioReceptor,
                          SucursalUsuarioUsuarioRegistro usuarioRegistro,
                          SucursalUsuarioUsuarioUltimaModificacion usuarioUltimaModificacion)
            throws QueryNotRegisteredError, QueryHandlerExecutionError {

//TODO VALORES NULOS
        ValidationResponse vResultadoValidacion = validador.validarSucursalUsuario(
                new HashMap<>() {{
                    put("id", id.value() != null ? id.value() : "");
                    put("ifcAgente", ifcAgente.value() != null ? ifcAgente.value().toString() : "");
                    put("nitAgente", nitAgente.value() != null ? nitAgente.value().toString() : "");
                    put("nroSucursal", nroSucursal.value() != null ? nroSucursal.value().toString() : "");
                    put("usuarioReceptor", usuarioReceptor.value() != null ? usuarioReceptor.value() : "");
                    put("loginUsuarioReceptor", loginUsuarioReceptor.value() != null ? loginUsuarioReceptor.value().toString() : "");
                    put("nombreUsuarioReceptor", nombreUsuarioReceptor.value() != null ? nombreUsuarioReceptor.value().toString() : "");
                    put("nombreCliente", usuarioRegistro.value() != null ? usuarioRegistro.value() : "");
                    put("usuarioUltimaModificacion", usuarioUltimaModificacion.value() != null ? usuarioUltimaModificacion.value() : "");
                }});

        if (vResultadoValidacion.hasErrors()) {
            throw new SucursalUsuarioListaErrores(id, vResultadoValidacion);
        }

        SucursalUsuario vSucursalUsuario = SucursalUsuario.registro( id,  ifcAgente,  nitAgente,
                 nroSucursal,  usuarioReceptor,
                 loginUsuarioReceptor,  nombreUsuarioReceptor,
                 usuarioRegistro,
                 usuarioUltimaModificacion);
        repository.BuscarSucursalUsuarioExistente(vSucursalUsuario).ifPresentOrElse(su -> {
                    throw new SucursalUsuarioListaErrores(su.id(), validador.getValidacionExistente());
                    
                },
                () -> {
                    try {
                        repository.save(vSucursalUsuario);
                        eventBus.publish(vSucursalUsuario.pullDomainEvents());
                    } catch (Exception excepcion) {
                        LOG.error(excepcion.getCause().toString(), excepcion);
                        throw new SucursalUsuarioListaErrores(id, validador.getValidacionException());

                    }
                });
        
        
        

    }


}


