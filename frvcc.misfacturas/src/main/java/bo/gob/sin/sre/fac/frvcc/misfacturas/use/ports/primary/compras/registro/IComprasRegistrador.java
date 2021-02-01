package bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.compras.registro;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.registro.registro_masivo.RegistroComprasCommand;

public interface IComprasRegistrador {
    void registrar(RegistroComprasCommand pCommand);
}
