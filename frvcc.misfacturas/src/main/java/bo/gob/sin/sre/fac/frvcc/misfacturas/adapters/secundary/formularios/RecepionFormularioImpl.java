package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.secundary.formularios;

import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.formularios.IRecepionFormulario;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.shared.BeneficiarioPersonaRivDto;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.shared.RespuestaConciliacionDto;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.shared.SolicitudConciliacionDto;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.ResultadoGenericoDto;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.str.caut.security.jwt.model.JwtUserDetails;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class RecepionFormularioImpl implements IRecepionFormulario {
    private final RestTemplate restTemplate;
    private final Environment env;

    public RecepionFormularioImpl(RestTemplate restTemplate, Environment env) {
        this.restTemplate = restTemplate;
        this.env = env;
    }

    @Override
    public ResultadoGenericoDto<RespuestaConciliacionDto> recepcionFormulario(String formulario,
                                                                              Long codigoPersona,
                                                                              Integer periodo,
                                                                              Integer anio,
                                                                              BigDecimal montoDeterminacionPago,
                                                                              Integer cantidadFacturas,
                                                                              BigDecimal montoTotalFacturas) {

        ResultadoGenericoDto<RespuestaConciliacionDto> vRespuesta = null;
        String token = ((JwtUserDetails) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal()).getToken();

        HttpHeaders headers = new HttpHeaders();
        String vUrlServicio = env.getRequiredProperty("sre.sfe.gpri.rest") + "/rest/Conciliacion/recepionFormulario";
        try {
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.add(HttpHeaders.AUTHORIZATION, "Token " + token);


            Map<String, Object> map = new HashMap<>() {{
                put("formulario", formulario);
                put("codigoPersona", codigoPersona);
                put("periodo", periodo);
                put("anio", anio);
                put("montoDeterminacionPago", montoDeterminacionPago);
                put("cantidadFacturas", cantidadFacturas);
                put("montoTotalFacturas", montoTotalFacturas);
            }};
            HttpEntity httpEntity = new HttpEntity(map, headers);


            vRespuesta = restTemplate.exchange(vUrlServicio,
                    HttpMethod.POST, httpEntity,
                    new ParameterizedTypeReference<ResultadoGenericoDto<RespuestaConciliacionDto>>() {
                    }).getBody();

            return vRespuesta;

        } catch (HttpClientErrorException | HttpServerErrorException e) {
            vRespuesta.setOk(false);
           return vRespuesta;
        }

    }


}
