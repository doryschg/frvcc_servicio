package bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.Compra;

import java.util.Optional;



public interface VerificaCodigoAutorizacionRepository {
	
	//--Optional<String> verificaCodigoAutorizacion(Long nitProveedor, Long numeroFactura, Long codigoAutorizacion, Long nitCi, Long fechaFactura, String codigoControl, Long importeFactura); 
	Optional<String> verificaCodigoAutorizacion(Compra pCompra);
}
