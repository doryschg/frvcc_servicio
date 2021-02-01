package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.registro.registro_masivo;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.registro.RegistroCompraCommand;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.Command;

import java.util.List;

public final class RegistroComprasCommand implements Command {
    public RegistroComprasCommand(List<RegistroCompraCommand> registroCompras) {
        this.registroCompras = registroCompras;
    }

    private final List<RegistroCompraCommand> registroCompras ;

    public List<RegistroCompraCommand> getRegistroCompras() {
        return registroCompras;
    }
}
