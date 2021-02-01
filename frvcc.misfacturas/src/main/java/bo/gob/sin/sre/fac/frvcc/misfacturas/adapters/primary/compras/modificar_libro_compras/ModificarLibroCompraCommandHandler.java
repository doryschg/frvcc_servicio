package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.modificar_libro_compras;


import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.*;
import bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras.modificar_libro_compras.LibroCompraModificadorServiceImpl;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandHandler;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryNotRegisteredError;


@Service
public class ModificarLibroCompraCommandHandler implements CommandHandler<ModificarLibroCompraCommand> {
    private final LibroCompraModificadorServiceImpl modificador;

    public ModificarLibroCompraCommandHandler(LibroCompraModificadorServiceImpl modificador) {
        this.modificador = modificador;
    }


    @Override
    public void handle(ModificarLibroCompraCommand command) {

        try {
            modificador.modificar(
               new CompraId(command.getId()),
               new CompraNitProveedor(command.getNitProveedor()),
               new CompraNumeroFactura(command.getNumeroFactura()),
               new CompraNumeroDui(command.getNumeroDui()),
               new CompraCodigoAutorizacion(command.getCodigoAutorizacion()),
               new CompraFechaFactura(command.getFechaFactura()),
               new CompraImporteTotalCompra(command.getImporteTotalCompra()),
               new CompraImporteNoSujetoCf(command.getimporteNoSujetoCf()),
               new CompraDescuento(command.getDescuento()),
               new CompraImporteBaseCf(command.getImporteBaseCf()),
               new CompraCodigoControl(command.getCodigoControl()),
               new CompraNumeroDocumentoCliente(command.getNumeroDocumentoCliente()),
               new CompraOrigenId(command.getOrigenId()),
               new CompraTipoCompraId(command.gettipoCompraId()),
               new CompraUsuarioUltimaModificacion(command.getUsuarioUltimaModificacion()) 
            );
        } catch (QueryNotRegisteredError | QueryHandlerExecutionError queryNotRegisteredError) {
            queryNotRegisteredError.printStackTrace();
        }

    }
}
