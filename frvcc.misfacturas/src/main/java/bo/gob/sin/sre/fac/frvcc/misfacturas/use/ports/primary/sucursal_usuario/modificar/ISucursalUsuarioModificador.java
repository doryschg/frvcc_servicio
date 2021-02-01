package bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.sucursal_usuario.modificar;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.sucursal_usuario.SucursalUsuarioId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.sucursal_usuario.SucursalUsuarioUsuarioUltimaModificacion;

public interface ISucursalUsuarioModificador {
	void modificar(SucursalUsuarioId pId,
				   SucursalUsuarioUsuarioUltimaModificacion pUsuarioUltimaModificacion
				   );
}
