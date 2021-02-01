package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.asociar_libro;

import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.Command;

public final class AsociarLibroCompraCommandImpl implements Command {
    private final String id;
    private final String libroId;
    private final String tipoCompra;
    private final Long usuarioUltimaModificacion;

    public AsociarLibroCompraCommandImpl(String pId, String pLibroId, Long pUsuarioUltimaModificacion,String pTipoCompra) {
        this.id = pId;
        this.libroId = pLibroId;
        this.usuarioUltimaModificacion = pUsuarioUltimaModificacion;
        this.tipoCompra=pTipoCompra;
    }

    public String id() {
        return id;
    }

    public String libroId() {
        return libroId;
    }

    public Long usuarioUltimaModificacion() {
        return usuarioUltimaModificacion;
    }
    public String tipoCompra()
    {
    	return tipoCompra;
    }
}
