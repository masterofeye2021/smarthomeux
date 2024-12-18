package de.smarthome.smartux.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;

@Configuration
public class SpringTemplateEngineConfiguration {

    @Bean
    public LayoutDialect layoutDialect() {
      return new LayoutDialect();
    }

}
