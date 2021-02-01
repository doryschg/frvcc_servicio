package bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.contribuyentes;



import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.contribuyentes.ContribuyenteResponse;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandler;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.contribuyentes.IBuscarContribuyentePorNit;

@Service
public final class BuscarContribuyenteQueryDtoHandler implements QueryHandler<BuscarContribuyentePorNitQueryDto, ContribuyenteResponse> {
    private final IBuscarContribuyentePorNit buscarContribuyentePorNit;

    public BuscarContribuyenteQueryDtoHandler(IBuscarContribuyentePorNit buscarContribuyentePorNit) {
        this.buscarContribuyentePorNit = buscarContribuyentePorNit;
    }


    @Override
    public ContribuyenteResponse handle(BuscarContribuyentePorNitQueryDto query){
        ContribuyenteResponse result = buscarContribuyentePorNit.buscar(query);
        return  result;
    }
}
