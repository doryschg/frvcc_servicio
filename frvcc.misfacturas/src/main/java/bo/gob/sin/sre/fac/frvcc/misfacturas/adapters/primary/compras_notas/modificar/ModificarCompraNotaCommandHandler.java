package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras_notas.modificar;


import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.*;
import bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras_notas.modificar.CompraNotaModificadorServiceImpl;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandHandler;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryNotRegisteredError;


@Service
public class ModificarCompraNotaCommandHandler implements CommandHandler<ModificarCompraNotaCommand> {
    private final CompraNotaModificadorServiceImpl modificador;

    public ModificarCompraNotaCommandHandler(CompraNotaModificadorServiceImpl modificador) {
        this.modificador = modificador;
    }


    @Override
    public void handle(ModificarCompraNotaCommand command) {

        try {
            modificador.modificar(
               new CompraNotaId(command.getId()),
               new CompraNotaNitProveedor(command.getNitProveedor()),
               new CompraNotaNumeroNota(command.getNumeroNota()),
               new CompraNotaCodigoAutorizacion(command.getCodigoAutorizacion()),
               new CompraNotaFechaNota(command.getFechaNota()),
               new CompraNotaImporteTotalNota(command.getImporteTotalNota()),
               new CompraNotaCodigoControlNota(command.getCodigoControlNota()),
               new CompraNotaOrigenId(command.getOrigenId()),
               new CompraNotaUsuarioUltimaModificacion(command.getUsuarioUltimaModificacion())
               
            );
        } catch (QueryNotRegisteredError | QueryHandlerExecutionError queryNotRegisteredError) {
            queryNotRegisteredError.printStackTrace();
        }

    }
}
