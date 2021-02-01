package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.rest.backend.controller.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@Configuration
@ComponentScan(value = { "bo.gob.sin.str.cps", "bo.gob.sin.str.caut", "bo.gob.sin.mapl", "bo.gob.sin.str.cmsj" })
public class AppConfig {

}
