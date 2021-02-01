package bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras.modificar_selecionado;


import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.*;
import bo.gob.sin.sre.fac.frvcc.misfacturas.shared.domain.formularios.FormularioActulizarImporteCompraSelecionadaDomainEvent;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.compras.modificar_selecionado.ICompraModificarSeleccionado;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.DomainEventSubscriber;
import org.springframework.context.event.EventListener;

@Service
@DomainEventSubscriber({FormularioActulizarImporteCompraSelecionadaDomainEvent.class})
public final class ModifcarOnCompraSeleccionado {
    private final ICompraModificarSeleccionado service;

    public ModifcarOnCompraSeleccionado(ICompraModificarSeleccionado service) {
        this.service = service;
    }
    @EventListener
    public void on(FormularioActulizarImporteCompraSelecionadaDomainEvent event){

            service.modificar(
                    new CompraId(event.getCompraId()),
                    new CompraFechaFactura(event.getFechaFacturaCompraMoficada()),
                    new CompraImporteTotalCompra(event.getImporteTotalCompraMoficada()),
                    new CompraImporteBaseCf(event.getImporteBaseCfompraMoficada()),
                    new CompraCreditoFiscal(event.getCreditoFiscalCompraMoficada()),
                    new CompraCodigoControl(event.getCodigoControlCompraMoficada()),
                    new CompraUsuarioUltimaModificacion(event.getUsuarioUltimaModificacion()),
                    new CompraOrigenId(EnumOrigenId.MOBIL.value())
            );


    }
}
