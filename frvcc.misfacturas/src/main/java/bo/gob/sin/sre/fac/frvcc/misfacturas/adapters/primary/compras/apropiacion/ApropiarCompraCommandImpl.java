package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.apropiacion;



import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.Command;

public final class ApropiarCompraCommandImpl implements Command {
    private final String id;

    public ApropiarCompraCommandImpl(String pId) {
        this.id = pId;
    }

    public String id() {
        return id;
    }

}
