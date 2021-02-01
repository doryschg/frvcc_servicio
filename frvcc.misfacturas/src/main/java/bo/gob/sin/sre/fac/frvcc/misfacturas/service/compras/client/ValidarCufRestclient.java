package bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras.client;//package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.service.libros.client;

import java.util.Arrays;

import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.compras.client.IValidarCufRestclient;
import bo.gob.sin.str.caut.security.jwt.model.JwtUserDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import bo.gob.sin.str.cexc.LogExcepcion;
import bo.gob.sin.str.cexc.MethodSign;

@Service
public class ValidarCufRestclient implements IValidarCufRestclient {
	private static final Logger LOG = LoggerFactory.getLogger(ValidarCufRestclient.class);
	private ObjectMapper mapper = new ObjectMapper();


	private final RestTemplate restTemplate;

	private final Environment env;

	public ValidarCufRestclient(RestTemplate restTemplate, Environment env)
	{
		this.restTemplate = restTemplate;
		this.env = env;

	}

	@Override
	public boolean verificaCuf(String pCuf) {

		boolean vRespuesta = false;
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add(HttpHeaders.AUTHORIZATION, "Token " + getToken());

        HttpEntity entity = new HttpEntity(headers);


		String vUrlServicio = env.getRequiredProperty("sre.sfe.rec.rest") + "/rest/facturacion/configuracion/verificaCuf/" + pCuf;

		try {
		    vRespuesta = restTemplate.exchange(vUrlServicio, HttpMethod.GET, entity, Boolean.class).getBody();
	    }
		catch (HttpClientErrorException e){
			vRespuesta = false;
			LogExcepcion.registrar(e, LOG, MethodSign.build(vUrlServicio));
			LOG.info("Servicio no disponible {}", vUrlServicio);
		}
		catch (HttpServerErrorException e){
			vRespuesta = false;
			LogExcepcion.registrar(e, LOG, MethodSign.build(vUrlServicio));
			LOG.info("Servicio no disponible {}", vUrlServicio);
		}


		return vRespuesta;
	}

	public String getToken() {
		SecurityContext ctx = SecurityContextHolder.getContext();
		Authentication authorization = ctx.getAuthentication();
		JwtUserDetails detalleUsuario = (JwtUserDetails) authorization.getPrincipal();
		return detalleUsuario.getToken();
	}

}
