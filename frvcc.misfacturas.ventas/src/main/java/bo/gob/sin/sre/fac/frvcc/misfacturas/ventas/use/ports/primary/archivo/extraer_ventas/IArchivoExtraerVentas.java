package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.use.ports.primary.archivo.extraer_ventas;

import java.io.IOException;
import java.util.List;

import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.primary.recepcion.RecepcionResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.primary.ventas.registro.RegistroVentaCommand;

public interface IArchivoExtraerVentas {
    List<RegistroVentaCommand> extraerVentas(byte[] pArchivo, RecepcionResponse pRecepcion) throws IOException;
}
