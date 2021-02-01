package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.use.ports.primary.ventas.registro_masivo;

import bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.primary.ventas.registro_masivo.RegistroVentasCommand;

public interface IVentasRegistro {
	void registrar(RegistroVentasCommand pCommands);
}
