package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.use.ports.primary.libros.client;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.CompraResponse;

public interface IComprasFindRestclient {
	
	public CompraResponse obtenerCompraPorId(String pIdCompra,String pToken);

}
