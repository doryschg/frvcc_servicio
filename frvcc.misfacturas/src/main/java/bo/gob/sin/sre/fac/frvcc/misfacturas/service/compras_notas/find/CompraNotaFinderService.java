package bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras_notas.find;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras_notas.CompraNotaResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras_notas.CompraNotaResponseGenerico;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNota;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaNotExist;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.compras_notas.CompraNotaRepository;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;

@Service
public class CompraNotaFinderService {
    private final CompraNotaRepository repository;

    public CompraNotaFinderService(CompraNotaRepository pRepository) {
        this.repository = pRepository;
    }

    public CompraNotaResponse find(CompraNotaId pId) {
        CompraNota vCompraNota =repository.findById(pId).orElseThrow(() ->new CompraNotaNotExist(pId));
        return  new CompraNotaResponse(CompraNotaResponseGenerico.fromAggregate(vCompraNota));
    }
}
