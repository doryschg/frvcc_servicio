package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.use.ports.primary.ventas.procesar_agrupadas_masivo;

import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.primary.ventas.registro_agrupado_masivo.RegistroVentasAgrupadosCommand;

public interface IProcesarVentasAgrupadasService {
	void procesar(RegistroVentasAgrupadosCommand pRegistroVentasAgrupadosCommand);
}
