package bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.contribuyentes;


import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.contribuyentes.ContribuyenteResponse;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.model.contribuyentes.Contribuyente;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.contribuyentes.IBuscarContribuyentePorNit;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.contribuyentes.IContribuyenteRepository;


@Service
public final class BuscarContribuyentePorNitImpl implements IBuscarContribuyentePorNit {
    private final IContribuyenteRepository repository;

    public BuscarContribuyentePorNitImpl(IContribuyenteRepository repository) {
        this.repository = repository;
    }

    public ContribuyenteResponse buscar(BuscarContribuyentePorNitQueryDto query) {
        return ContribuyenteResponse.fromContribuyente(repository.buscarPorNIt(query.nit()).orElseGet(Contribuyente::new));
    }
}
