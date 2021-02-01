package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.modificar;


import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.*;
import bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras.modificar.CompraModificadorServiceImpl;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandHandler;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryNotRegisteredError;


@Service
public class ModificarCompraCommandHandler implements CommandHandler<ModificarCompraCommand> {
    private final CompraModificadorServiceImpl modificador;

    public ModificarCompraCommandHandler(CompraModificadorServiceImpl modificador) {
        this.modificador = modificador;
    }


    @Override
    public void handle(ModificarCompraCommand command) {

        try {
            modificador.modificar(
               new CompraId(command.getId()),
               new CompraFechaFactura(command.getFechaFactura()),
               new CompraNitProveedor(command.getNitProveedor()),
               new CompraNumeroFactura(command.getNumeroFactura()),
               new CompraCodigoAutorizacion(command.getCodigoAutorizacion()),
               new CompraImporteTotalCompra(command.getImporteTotalCompra()),
               new CompraImporteBaseCf(command.getImporteBaseCf()),
               new CompraCodigoControl(command.getCodigoControl()),
               new CompraUsuarioUltimaModificacion(command.getUsuarioUltimaModificacion()),
               new CompraOrigenId(command.getOrigenId())
            );
        } catch (QueryNotRegisteredError | QueryHandlerExecutionError queryNotRegisteredError) {
            queryNotRegisteredError.printStackTrace();
        }

    }
}
