package bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.sucursal_usuario.inhabilitar;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.sucursal_usuario.SucursalUsuarioId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.sucursal_usuario.SucursalUsuarioUsuarioUltimaModificacion;

public interface ISucursalUsuarioInhabilitar {
	void inhabilitar(SucursalUsuarioId pId,
				   SucursalUsuarioUsuarioUltimaModificacion pUsuarioUltimaModificacion
				   );
}
