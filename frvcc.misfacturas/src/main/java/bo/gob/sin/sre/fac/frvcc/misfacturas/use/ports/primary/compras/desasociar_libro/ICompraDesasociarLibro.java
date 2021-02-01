package bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.compras.desasociar_libro;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraLibroId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraUsuarioUltimaModificacion;

public interface ICompraDesasociarLibro {
	
	  void desAsociarLibro(CompraId pId,
              CompraLibroId pLibroId,
              CompraUsuarioUltimaModificacion pUsuarioUltimaModificacion);

}
