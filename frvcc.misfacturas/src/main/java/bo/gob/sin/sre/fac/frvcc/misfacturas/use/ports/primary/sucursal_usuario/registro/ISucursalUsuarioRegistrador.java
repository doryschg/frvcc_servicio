package bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.sucursal_usuario.registro;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.sucursal_usuario.*;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ValidatorNotExist;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryNotRegisteredError;

public interface ISucursalUsuarioRegistrador {
    void registrar(SucursalUsuarioId id, SucursalUsuarioIfcAgente ifcAgente, SucursalUsuarioNitAgente nitAgente,
                   SucursalUsuarioNumeroSucursal nroSucursal, SucursalUsuarioUsuarioReceptor usuarioReceptor,
                   SucursalUsuarioLoginUsuarioReceptor loginUsuarioReceptor, SucursalUsuarioNombreReceptor nombreUsuarioReceptor,
                   SucursalUsuarioUsuarioRegistro usuarioRegistro,
                   SucursalUsuarioUsuarioUltimaModificacion usuarioUltimaModificacion) throws QueryNotRegisteredError, QueryHandlerExecutionError, ValidatorNotExist;
}
