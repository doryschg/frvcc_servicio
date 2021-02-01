package bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;



public class EnvironmentConfig {
    Logger logger = LoggerFactory.getLogger(EnvironmentConfig.class);
    ResourceLoader resourceLoader;

    private final Environment environment;


    public EnvironmentConfig(ResourceLoader resourceLoader, Environment environment) {
        this.resourceLoader = resourceLoader;

        this.environment = environment;
    }

    @Bean
    public Dotenv dotenv() {
        Resource resource = resourceLoader.getResource("classpath:/application.properties");

        return Dotenv
            .configure()
            .directory("/")
            .filename(resource.exists() ? "application.properties" : ".env.local")
            .load();
    }
}
