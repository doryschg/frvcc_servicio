package bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.compras.generar_historial;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.ComprasResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraId;

import java.util.List;

public interface IGeneradorHistorialCompras {
    ComprasResponse generadorHistorial(CompraId id);
}
