package bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.compras.registro_libro_compras;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.registro_libro.registro_masivo.ComprasRegistroLibroCommandImpl;

public interface IComprasRegistradorLibro {
    void registrar(ComprasRegistroLibroCommandImpl pCommand);
}
