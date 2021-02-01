package bo.gob.sin.sre.fac.frvcc.misfacturas.service.shared;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.secundary.compras.PostgreSqlCompraRepository;
import bo.gob.sin.sre.fac.frvcc.misfacturas.shared.domain.compra.CompraContribuyente;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.shared.ICompraContribuyenteCache;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;

import java.util.HashMap;

@Service
public class CompraContribuyenteCacheServiceImpl implements ICompraContribuyenteCache {
    public HashMap<Long, CompraContribuyente> contribuyentesCache ;
    public final PostgreSqlCompraRepository repository;

    public CompraContribuyenteCacheServiceImpl(PostgreSqlCompraRepository repository) {
        this.repository = repository;
    }


    @Override
    public Long getIfcContribuyenteCache(Long nit) {
        return contribuyentesCache.get(nit).getIfc();
    }

    @Override
    public String getRazonSocialContribuyenteCache(Long nit) {
        return contribuyentesCache.get(nit).getRazonSocial();
    }

    @Override
    public Boolean isPresent(Long nit) {
        if(contribuyentesCache == null){
            contribuyentesCache = repository.proveedoresRecurrentes();
        }
        return contribuyentesCache.containsKey(nit);
    }
}
