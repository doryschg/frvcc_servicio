package bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.contribuyentes;

import bo.gob.sin.sre.fac.frvcc.shared.model.contribuyentes.Contribuyente;

import java.util.Optional;

public interface IContribuyenteRepository {
    Optional<Contribuyente> buscarPorNIt(Long nit);
}
