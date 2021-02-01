package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.registro_libro_compras;


import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.*;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.compras.registro_libro_compras.ICompraRegistradorLibro;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandHandler;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryNotRegisteredError;


@Service
public class CompraRegistroLibroCommandHandler implements CommandHandler<CompraRegistroLibroCommand> {
    private final ICompraRegistradorLibro registrador;

    public CompraRegistroLibroCommandHandler(ICompraRegistradorLibro registrador) {
        this.registrador = registrador;
    }


    @Override
    public void handle(CompraRegistroLibroCommand command) {
        try {
            registrador.registrar(
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
                    new CompraTipoDocumentoCliente(command.getTipoDocumentoCliente()),
                    new CompraNumeroDocumentoCliente(command.getNumeroDocumentoCliente()),
                    new CompraComplementoDocumentoCliente(command.getComplementoDocumentoCliente()),
                    new CompraNombreCliente(command.getNombreCliente()),
                    new CompraOrigenId(command.getOrigenId()),
                    new CompraUsuarioRegistro(command.getUsuarioRegistro())
            );
        } catch (QueryNotRegisteredError | QueryHandlerExecutionError error ) {


        }
    }
}
