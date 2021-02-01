package bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.shared;

import java.util.Optional;

public interface IBeneficiarioPersonaRivService {
    Optional<BeneficiarioPersonaRivDto> getBeneficiarioPersona(Long idPersona);
}
