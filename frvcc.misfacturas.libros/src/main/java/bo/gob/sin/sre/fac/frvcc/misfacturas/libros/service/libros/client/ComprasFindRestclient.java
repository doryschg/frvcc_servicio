//package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.service.libros.client;
//
//import java.util.Arrays;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.HttpClientErrorException;
//import org.springframework.web.client.HttpServerErrorException;
//import org.springframework.web.client.RestTemplate;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.CompraResponse;
//import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.use.ports.primary.libros.client.IComprasFindRestclient;
//import bo.gob.sin.str.cexc.LogExcepcion;
//import bo.gob.sin.str.cexc.MethodSign;
//
//@Service
//public class ComprasFindRestclient implements IComprasFindRestclient {
//	private static final Logger LOG = LoggerFactory.getLogger(ComprasFindRestclient.class);
//	private ObjectMapper mapper = new ObjectMapper();
//	
//	@Value("${sre.fac.frvcc.mfc.rest}")
//	private String restClientCompras;
//	private RestTemplate restTemplate;
//	
//	public ComprasFindRestclient()
//	{
//		restTemplate = new RestTemplate();
//	}
//	
//	@Override
//	public CompraResponse obtenerCompraPorId(String pIdCompra,String pToken) {
//		ResponseEntity<CompraResponse> vRespuesta = null;
//		HttpHeaders headers = new HttpHeaders();
//		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.add(HttpHeaders.AUTHORIZATION, "Token " + pToken);
//        
//        HttpEntity entity = new HttpEntity(headers);
//		String vUrlServicio = restClientCompras + "/rest/misfacturas/compra/" + pIdCompra;
//        
//		try { 
//		    vRespuesta = restTemplate.exchange(vUrlServicio, HttpMethod.GET, entity, CompraResponse.class );
//	    }
//		catch (HttpClientErrorException e){
//			vRespuesta = null;
//			LogExcepcion.registrar(e, LOG, MethodSign.build(vUrlServicio));
//			LOG.info("Servicio no disponible {}", vUrlServicio);
//		}
//		catch (HttpServerErrorException e){
//			vRespuesta = null;
//			LogExcepcion.registrar(e, LOG, MethodSign.build(vUrlServicio));
//			LOG.info("Servicio no disponible {}", vUrlServicio);
//		}
//		
//        
//		return vRespuesta.getBody();
//	}
//	
//}
