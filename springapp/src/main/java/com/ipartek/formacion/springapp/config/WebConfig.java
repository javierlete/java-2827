package com.ipartek.formacion.springapp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Value("${rutas.imagenes.url}")
	private String urlImagenes;
	
	@Value("${rutas.imagenes.fisica}")
	private String rutaImagenes;
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler(urlImagenes + "**")
			.addResourceLocations("file:" + rutaImagenes);
	}
	
}
