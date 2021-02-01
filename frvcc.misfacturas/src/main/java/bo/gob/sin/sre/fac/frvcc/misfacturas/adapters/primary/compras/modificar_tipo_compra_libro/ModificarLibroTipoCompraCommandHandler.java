package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.modificar_tipo_compra_libro;


import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraTipoCompraId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras.modificar_tipo_compra_libro.CompraModificadorTipoCompraLibroServiceImpl;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandHandler;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryNotRegisteredError;


@Service
public class ModificarLibroTipoCompraCommandHandler implements CommandHandler<ModificarLibroTipoCompraCommand> {
    private final CompraModificadorTipoCompraLibroServiceImpl modificador;

    public ModificarLibroTipoCompraCommandHandler(CompraModificadorTipoCompraLibroServiceImpl modificador) {
        this.modificador = modificador;
    }


    @Override
    public void handle(ModificarLibroTipoCompraCommand command) {

        try {
            modificador.modificarTipoCompra(
               new CompraId(command.getId()),
               new CompraTipoCompraId(command.gettipoCompraId()),
               new CompraUsuarioUltimaModificacion(command.getUsuarioUltimaModificacion()) 
            );
        } catch (QueryNotRegisteredError | QueryHandlerExecutionError queryNotRegisteredError) {
            queryNotRegisteredError.printStackTrace();
        }

    }
}
