package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.rest.backend.controller.config;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfig {

	@Value("${client.connect.timeout}")
	private long connectTimeout;
	
	@Value("${client.read.timeout}")
	private long readTimeout;
	
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder){
        return restTemplateBuilder
                .setConnectTimeout(Duration.ofSeconds(connectTimeout))
                .setReadTimeout(Duration.ofSeconds(readTimeout))
                .build();
    }

}
