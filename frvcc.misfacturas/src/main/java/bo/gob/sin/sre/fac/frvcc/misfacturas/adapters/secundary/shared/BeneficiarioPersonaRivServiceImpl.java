package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.secundary.shared;

import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.shared.BeneficiarioPersonaRivDto;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.shared.IBeneficiarioPersonaRivService;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.ResultadoGenericoDto;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.str.caut.security.jwt.model.JwtUserDetails;
import bo.gob.sin.str.cexc.LogExcepcion;
import bo.gob.sin.str.cexc.MethodSign;
import bo.gob.sin.str.constantes.swagger.ConstSwagger;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Optional;

@Service
public class BeneficiarioPersonaRivServiceImpl implements IBeneficiarioPersonaRivService {
    private final RestTemplate restTemplate;
    private final Environment env;
    private static final String API_V1_0 = ConstSwagger.API_HEADER_VERSION + "1.0" + ConstSwagger.API_HEADER_JSON;

    public BeneficiarioPersonaRivServiceImpl(RestTemplate restTemplate, Environment env) {
        this.restTemplate = restTemplate;
        this.env = env;
    }

    @Override
    public Optional<BeneficiarioPersonaRivDto> getBeneficiarioPersona(Long idPersona) {

        ResultadoGenericoDto<BeneficiarioPersonaRivDto> vRespuesta = null;
        String token = ((JwtUserDetails) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal()).getToken();

        HttpHeaders headers = new HttpHeaders();
        String vUrlServicio = env.getRequiredProperty("sre.sfe.gpri.query") + "/rest/consultaBeneficiario/obtenerBeneficiarioPersonaPorPersonaId/"+idPersona.toString();
        try {
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.add(HttpHeaders.AUTHORIZATION, "Token " + token);
            HttpEntity httpEntity = new HttpEntity(headers);


            ResponseEntity<ResultadoGenericoDto<BeneficiarioPersonaRivDto>> vResponse = restTemplate.exchange(vUrlServicio,
                    HttpMethod.GET, httpEntity,
                    new ParameterizedTypeReference<ResultadoGenericoDto<BeneficiarioPersonaRivDto>>() {
                    });


        if (vResponse.getBody().isOk())
        {
           return Optional.of(vResponse.getBody().getResultadoObjeto());
        }
    }
        catch (HttpClientErrorException | HttpServerErrorException e){
        return Optional.empty();

    }
        return Optional.empty();

    }
}
