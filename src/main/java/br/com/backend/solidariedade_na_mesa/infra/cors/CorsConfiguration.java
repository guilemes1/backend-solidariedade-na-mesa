package br.com.backend.solidariedade_na_mesa.infra.cors;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:5501", "http://127.0.0.1:5501")
                .allowedMethods("*")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
