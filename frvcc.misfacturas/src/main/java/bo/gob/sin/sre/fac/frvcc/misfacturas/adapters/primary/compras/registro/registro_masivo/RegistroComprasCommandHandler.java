package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.registro.registro_masivo;


import bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras.registro.ComprasRegistradorServiceImpl;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandHandler;



@Service
public class RegistroComprasCommandHandler implements CommandHandler<RegistroComprasCommand> {
    private final ComprasRegistradorServiceImpl registrador;

    public RegistroComprasCommandHandler(ComprasRegistradorServiceImpl registrador) {
        this.registrador = registrador;
    }


    @Override
    public void handle(RegistroComprasCommand command) {
            registrador.registrar(command);

    }


}
