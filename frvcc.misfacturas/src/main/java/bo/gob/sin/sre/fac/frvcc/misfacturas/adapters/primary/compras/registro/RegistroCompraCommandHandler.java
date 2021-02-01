package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.registro;


import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.*;
import bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras.registro.CompraRegistradorServiceImpl;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandHandler;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryNotRegisteredError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;


@Service
public class RegistroCompraCommandHandler implements CommandHandler<RegistroCompraCommand> {
    private final CompraRegistradorServiceImpl registrador;

    public RegistroCompraCommandHandler(CompraRegistradorServiceImpl registrador) {
        this.registrador = registrador;
    }

    @Override
    public void handle(RegistroCompraCommand command) {
        try {
            registrador.registrar(new CompraId(command.getId()),
                    new CompraFechaFactura(command.getFechaFactura()),
                    new CompraNitProveedor(command.getNitProveedor()),
                    new CompraNumeroFactura(command.getNumeroFactura()),
                    new CompraCodigoAutorizacion(command.getCodigoAutorizacion()),
                    new CompraImporteTotalCompra(command.getImporteTotalCompra()),
                    new CompraImporteBaseCf(command.getImporteBaseCf()),
                    new CompraCodigoControl(command.getCodigoControl()),
                    new CompraUsuarioRegistro(command.getUsuarioRegistro()),
                    new CompraNombreCliente(command.getNombreCliente()),
                    new CompraTipoDocumentoCliente(command.getTipoDocumentoCliente()),
                    new CompraNumeroDocumentoCliente(command.getNumeroDocumentoCliente()),
                    new CompraComplementoDocumentoCliente(command.getComplementoDocumentoCliente()),
                    new CompraOrigenId(command.getOrigenId()));
        } catch (QueryNotRegisteredError | QueryHandlerExecutionError error ) {

        }
    }
}
