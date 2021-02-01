package bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras.find;


import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.CompraResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.CompraResponseGenerico;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.secundary.compras.validadores.CompraValidador;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.Compra;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraListaErrores;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.compras.CompraRepository;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;

@Service
public class CompraBuscadorService {
    private final CompraRepository repository;
    private final CompraValidador validador;
    public CompraBuscadorService(CompraRepository pRepository, CompraValidador pValidador) {
        this.repository = pRepository;
        this.validador=pValidador;
        
    }

    public CompraResponse find(CompraId pId) {
        Compra vCompra =repository.findById(pId).orElseThrow(() ->new CompraListaErrores(pId, validador.crearValidacionCompraNoExiste()));
        return  new CompraResponse(CompraResponseGenerico.fromAggregate(vCompra));
    }
}
