package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras_notas.registro;


import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.*;
import bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras_notas.registro.CompraNotaRegistradorServiceImpl;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandHandler;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryNotRegisteredError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;


@Service
public class RegistroCompraNotaCommandHandler implements CommandHandler<RegistroCompraNotaCommand> {
	
 private final CompraNotaRegistradorServiceImpl registrador;

    public RegistroCompraNotaCommandHandler(CompraNotaRegistradorServiceImpl registrador) {
        this.registrador = registrador;
    }


    @Override
    public void handle(RegistroCompraNotaCommand command) {
        try {
            registrador.registrar(new CompraNotaId(command.id()),
            		new CompraNotaNitProveedor(command.nitProveedor()),
            		new CompraNotaNumeroNota(command.numeroNota()),
            		new CompraNotaCodigoAutorizacion(command.codigoAutorizacion()),
                    new CompraNotaFechaNota(command.fechaNota()),
                    new CompraNotaImporteTotalNota(command.importeTotalNota()),
                    new CompraNotaCodigoControlNota(command.codigoControlNota()), 
                    new CompraNotaCompraId(command.compraId()),
                    new CompraNotaTipoDocumentoCliente(command.tipoDocumentoCliente()),
                    new CompraNotaNumeroDocumentoCliente(command.numeroDocumentoCliente()),
                    new CompraNotaComplementoDocumentoCliente(command.complementoDocumentoCliente()),
                    new CompraNotaNombreCliente(command.nombreCliente()),
                    new CompraNotaOrigenId(command.origenId()),
                    new CompraNotaUsuarioRegistro(command.usuarioRegistro()) );
        } catch (QueryNotRegisteredError | QueryHandlerExecutionError error ) {

        }
    }
}