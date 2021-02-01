package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.rest.backend.controller.config;



import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.spring.ApiExceptionMiddleware;

import bo.gob.sin.str.cmsj.mapl.ports.MensajeAplicacionPort;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;




@Configuration
public class MisFacturasLibrosBackendServerConfiguration {
    private final RequestMappingHandlerMapping mapping;
    private final MensajeAplicacionPort mensajeAplicacionPort;

    public MisFacturasLibrosBackendServerConfiguration(RequestMappingHandlerMapping mapping, MensajeAplicacionPort mensajeAplicacionPort) {
        this.mapping = mapping;
        this.mensajeAplicacionPort = mensajeAplicacionPort;
    }

    @Bean
    public FilterRegistrationBean<ApiExceptionMiddleware> basicHttpAuthMiddleware() {
        FilterRegistrationBean<ApiExceptionMiddleware> registrationBean = new FilterRegistrationBean<>();



        registrationBean.setFilter(new ApiExceptionMiddleware(mapping,mensajeAplicacionPort));

        return registrationBean;
    }


}
