package bo.gob.sin.sre.fac.frvcc.misfacturas.service.hformularios.registro_formulario_historico;


import java.util.stream.Collectors;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.*;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.hformularios.*;
import bo.gob.sin.sre.fac.frvcc.misfacturas.shared.domain.hformularios.HFormularioRegistradoDomainEvent;
import org.springframework.context.event.EventListener;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.shared.domain.formularios.FormularioConsolidadoEventDomain;
import bo.gob.sin.sre.fac.frvcc.misfacturas.shared.domain.formularios.FormularioDeclaradoCanceladoEventDomain;
import bo.gob.sin.sre.fac.frvcc.misfacturas.shared.domain.formularios.FormularioDeclaradoEventDomain;
import bo.gob.sin.sre.fac.frvcc.misfacturas.shared.domain.formularios.FormularioRechazdoEventDomain;
import bo.gob.sin.sre.fac.frvcc.misfacturas.shared.domain.formularios.FormularioRectificadoEventDomain;
import bo.gob.sin.sre.fac.frvcc.misfacturas.shared.domain.formularios.FormularioRegistradoDomainEvent;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.DomainEventSubscriber;

@Service
@DomainEventSubscriber({HFormularioRegistradoDomainEvent.class })
public final class RegistroFormularioHistoricoOnCambioEstadoFormulario {
    private final Registro_formulario_historico service;

    public RegistroFormularioHistoricoOnCambioEstadoFormulario(Registro_formulario_historico service) {
        this.service = service;
    }
    
    @EventListener
    public void on(HFormularioRegistradoDomainEvent event){

          service.registrar(
                  new HFormularioHistoricoId(event.eventId()),
                 new HFormularioId( event.aggregateId()),
                new HFormularioNumeroOrden(event.getNumeroOrden()),
                new HFormularioEstadoFormularioId(event.getEstadoFormularioId()),
                new HFormularioUsuarioRegistro(event.getUsuarioUltimaModificacion()),
                new HFormularioTotalComprasCfIpn(event.getTotalComprasCfIpn()),
                new HFormularioTotalComprasCfOtras(event.getTotalComprasCfOtras()),
                new HFormularioTotalComprasSdCf(event.getTotalComprasSdCf()),
        new HFormularioTotalComprasCfRed(event.getTotalComprasCfRed()),
        new HFormularioTotalComprasCfIpnRed(event.getTotalComprasCfIpnRed()),
        new HFormularioTotalComprasCfOtrasRed(event.getTotalComprasCfOtrasRed()),
        new HFormularioTotalComprasSdCfRed(event.getTotalComprasSdCfRed()),
        new HFormularioDeterminacionPagoCfRed(event.getDeterminacionPagoCfRed()),
        new HFormularioDeterminacionPagoCfIpnRed(event.getDeterminacionPagoCfIpnRed()),
        new HFormularioDeterminacionPagoCfOtrasRed(event.getDeterminacionPagoCfOtrasRed()),
        new HFormularioDeterminacionPagoSdCfRed (event.getDeterminacionPagoSdCfRed()),
                event.getCompraIds().stream().map(id -> new CompraId(id)).collect(Collectors.toList())
        );
    }
}
