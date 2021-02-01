package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.rest.backend.controller.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.spring.ApiExceptionMiddleware;
import bo.gob.sin.str.cmsj.mapl.ports.MensajeAplicacionPort;

@Configuration
public class MisFacturasVentasBackendServerConfiguration {
	private final RequestMappingHandlerMapping mapping;
	private final MensajeAplicacionPort mensajeAplicacionPort;

	public MisFacturasVentasBackendServerConfiguration(RequestMappingHandlerMapping mapping,
			MensajeAplicacionPort mensajeAplicacionPort) {
		this.mapping = mapping;
		this.mensajeAplicacionPort = mensajeAplicacionPort;
	}

	@Bean
	public FilterRegistrationBean<ApiExceptionMiddleware> basicHttpAuthMiddleware() {
		FilterRegistrationBean<ApiExceptionMiddleware> registrationBean = new FilterRegistrationBean<>();

		registrationBean.setFilter(new ApiExceptionMiddleware(mapping, mensajeAplicacionPort));

		return registrationBean;
	}

}
