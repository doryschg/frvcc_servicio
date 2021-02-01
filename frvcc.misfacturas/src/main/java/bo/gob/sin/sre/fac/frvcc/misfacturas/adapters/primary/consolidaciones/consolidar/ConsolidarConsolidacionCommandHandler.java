package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.consolidaciones.consolidar;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.consolidaciones.*;
import bo.gob.sin.sre.fac.frvcc.misfacturas.service.consolidaciones.consolidar.ConsolidacionConsolidarServiceImpl;
import bo.gob.sin.sre.fac.frvcc.misfacturas.service.consolidaciones.registro.ConsolidacionregistradorServiceImpl;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandHandler;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;

@Service
public class ConsolidarConsolidacionCommandHandler implements CommandHandler<ConsolidarConsolidacionCommand> {
    private final ConsolidacionConsolidarServiceImpl service;

    public ConsolidarConsolidacionCommandHandler(ConsolidacionConsolidarServiceImpl creator) {
        this.service = creator;
    }


    @Override
    public void handle(ConsolidarConsolidacionCommand command) {

            service.consolidar(
                    new ConsolidacionId(command.getId()),
                    new ConsolidacionIfcAgente(command.getIfcAgente()),
                    new ConsolidacionNitAgente (command.getNitAgente()),
                    new ConsolidacionRazonSocialAgente(command.getRazonSocialAgente()),
                    new ConsolidacionAdministracion(command.getAdministracion()),
                    new ConsolidacionGestion(command.getGestion()),
                    new ConsolidacionPeriodo(command.getPeriodo()),
                    new ConsolidacionUsuarioConsolidador(command.getUsuarioConsolidador()),
                    new ConsolidacionLoginUsuarioConsolidador(command.getLoginUsuarioConsolidador()),
                    new ConsolidacionNombreConsolidador(command.getNombreConsolidador()),
                    new ConsolidacionUsuarioRegistro(command.getUsuarioRegistro())
            );

    }
}
