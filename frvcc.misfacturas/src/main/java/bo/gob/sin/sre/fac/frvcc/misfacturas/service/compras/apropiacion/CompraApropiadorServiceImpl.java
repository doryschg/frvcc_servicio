package bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras.apropiacion;


import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.Compra;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraNotExist;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.compras.apropiacion.ICompraApropiar;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.compras.CompraRepository;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.EventBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;


@Service
public  class CompraApropiadorServiceImpl implements ICompraApropiar {
    private final CompraRepository repository;
    private final EventBus eventBus;

    public CompraApropiadorServiceImpl(CompraRepository pRepository, EventBus pEventBus) {
        this.repository = pRepository;
        this.eventBus = pEventBus;
    }

    @Override
    public void apropiar(CompraId pId) {
        Compra vCompra = repository.findById(pId).orElseThrow(()->new CompraNotExist(pId));
        if (vCompra != null) {
            vCompra.propiarCompra();
            repository.guardar(vCompra);
            eventBus.publish(vCompra.pullDomainEvents());
        }
    }
}
