package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.registro_libro.registro_masivo;

import java.util.List;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.registro_libro_compras.CompraRegistroLibroCommand;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.Command;

public final class ComprasRegistroLibroCommandImpl implements Command {
    public ComprasRegistroLibroCommandImpl(List<CompraRegistroLibroCommand> pRegistroCompras) {
        this.registroCompras = pRegistroCompras;
    }

    private final List<CompraRegistroLibroCommand> registroCompras ;

    public List<CompraRegistroLibroCommand> getRegistroCompras() {
        return registroCompras;
    }
}
