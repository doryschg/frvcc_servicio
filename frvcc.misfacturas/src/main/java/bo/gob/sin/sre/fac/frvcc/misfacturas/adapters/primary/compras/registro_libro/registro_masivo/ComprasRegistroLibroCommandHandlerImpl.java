package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.registro_libro.registro_masivo;


import bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras.registro_libro_compras.ComprasRegistradorLibroServiceImpl;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandHandler;



@Service
public class ComprasRegistroLibroCommandHandlerImpl implements CommandHandler<ComprasRegistroLibroCommandImpl> {
    private final ComprasRegistradorLibroServiceImpl registrador;

    public ComprasRegistroLibroCommandHandlerImpl(ComprasRegistradorLibroServiceImpl pRegistrador) {
        this.registrador = pRegistrador;
    }


    @Override
    public void handle(ComprasRegistroLibroCommandImpl pCommand) {
            registrador.registrar(pCommand);

    }


}
