package bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.contribuyentes;


import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.contribuyentes.ContribuyenteResponse;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.contribuyentes.BuscarContribuyentePorNitQueryDto;

import java.util.Optional;

public  interface IBuscarContribuyentePorNit {
   ContribuyenteResponse buscar(BuscarContribuyentePorNitQueryDto query);
}
