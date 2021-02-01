package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.consolidaciones.registro;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.sucursal_usuario.registro.RegistroSucursalUsuarioCommand;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.consolidaciones.*;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.sucursal_usuario.*;
import bo.gob.sin.sre.fac.frvcc.misfacturas.service.consolidaciones.registro.ConsolidacionregistradorServiceImpl;
import bo.gob.sin.sre.fac.frvcc.misfacturas.service.sucursal_usuario.registro.SucursalUsuarioRegistradorServiceImpl;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandHandler;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryNotRegisteredError;

@Service
public class RegistroConsolidacionCommandHandler implements CommandHandler<RegistroConsolidacionCommand> {
    private final ConsolidacionregistradorServiceImpl creator;

    public RegistroConsolidacionCommandHandler(ConsolidacionregistradorServiceImpl creator) {
        this.creator = creator;
    }


    @Override
    public void handle(RegistroConsolidacionCommand command) {
        try {
            creator.registro(
                    new ConsolidacionId(command.getId()),
                    new ConsolidacionIfcAgente(command.getIfcAgente()),
                    new ConsolidacionNitAgente (command.getNitAgente()),
                    new ConsolidacionRazonSocialAgente(command.getRazonSocialAgente()),
                    new ConsolidacionSucursal(command.getSucursal()),
                    new ConsolidacionDireccionSucursal(command.getDireccionSucursal()),
                    new ConsolidacionDepartamentoSucursal(command.getDepartamentoSucursal()),
                    new ConsolidacionAdministracion(command.getAdministracion()),
                    new ConsolidacionGestion(command.getGestion()),
                    new ConsolidacionPeriodo(command.getPeriodo()),
                    new ConsolidacionCantidadFormularios(command.getCantidadFormularios()),
                    new ConsolidacionTotalCantidadFacturas(command.getTotalCantidadFacturas()),
                    new ConsolidacionTotalCantidadOtrasFacturas(command.getTotalCantidadOtrasFacturas()),
                    new ConsolidacionTotalCantidad7rgFacturas(command.getTotalCantidad7rgFacturas()),
                    new ConsolidacionTotalImporteFacturas(command.getTotalImporteFacturas()),
                    new ConsolidacionTotalImporteOtrasFacturas(command.getTotalImporteOtrasFacturas()),
                    new ConsolidacionTotalImporte7rgFacturas(command.getTotalImporte7rgFacturas()),
                    new ConsolidacionTotalDeterminacionPagoCuenta(command.getTotalDeterminacionPagoCuenta()),
                    new ConsolidacionTotalPagoCuenta(command.getTotalPagoCuenta()),
                    new ConsolidacionUsuarioConsolidador(command.getUsuarioConsolidador()),
                    new ConsolidacionLoginUsuarioConsolidador(command.getLoginUsuarioConsolidador()),
                    new ConsolidacionNombreConsolidador(command.getNombreConsolidador()),
                    new ConsolidacionUsuarioRegistro(command.getUsuarioRegistro())
            );
        } catch (Exception e)
        {

        }
    }
}
