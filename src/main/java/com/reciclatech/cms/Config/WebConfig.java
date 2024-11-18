package com.reciclatech.cms.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Permite CORS desde localhost:4200
        registry.addMapping("/api/**") // Aquí defines los endpoints que se verán afectados por esta configuración
                .allowedOrigins("https://halvertcode.github.io") // El origen desde donde se permite hacer las solicitudes
                .allowedOrigins("http://localhost:4200") // El origen desde donde se permite hacer las solicitudes
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Los métodos permitidos
                .allowedHeaders("*") // Permite todas las cabeceras
                .allowCredentials(true); // Permite el envío de cookies (si es necesario)
    }
}
