package bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.compras_notas;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNota;

import java.util.Optional;

public interface VerificaCodigoAutorizacionRepository {

	// --Optional<String> verificaCodigoAutorizacion(Long nitProveedor, Long
	// numeroFactura, Long codigoAutorizacion, Long nitCi, Long fechaFactura, String
	// codigoControl, Long importeFactura);
	Optional<String> verificaCodigoAutorizacion(CompraNota pCompraNota);
}
