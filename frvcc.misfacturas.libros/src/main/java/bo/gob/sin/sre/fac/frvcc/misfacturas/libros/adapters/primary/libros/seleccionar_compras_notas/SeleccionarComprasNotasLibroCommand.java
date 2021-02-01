package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.adapters.primary.libros.seleccionar_compras_notas;

import java.util.List;

import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.Command;

public class SeleccionarComprasNotasLibroCommand implements Command {
    private final String id;
    private final Long usuarioUltimaModificacionId;
    private final List<String> listaIdsCompras;
    

    public SeleccionarComprasNotasLibroCommand(String id,
    		Long usuarioUltimaModificacionId,List<String> listaIdscompras) {
        this.id = id;
        
        this.usuarioUltimaModificacionId=usuarioUltimaModificacionId;
        this.listaIdsCompras=listaIdscompras;
        
    }

    public String id() {
        return id;
    }

    public Long usuarioUltimaModificacionId()
    {
    	return usuarioUltimaModificacionId;
    }
    public List<String> listaIdsCompras()
    {
    	return listaIdsCompras;
    }
}

