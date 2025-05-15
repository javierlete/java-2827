package com.ipartek.formacion.springapp.config;

import java.util.logging.Level;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ipartek.formacion.springapp.modelos.Carrito;

import lombok.extern.java.Log;

@Log
@Configuration
@ControllerAdvice
public class WebConfig implements WebMvcConfigurer {
	@Value("${rutas.imagenes.url}")
	private String urlImagenes;
	
	@Value("${rutas.imagenes.fisica}")
	private String rutaImagenes;
	
	private Carrito carrito;
	
	public WebConfig(Carrito carrito) {
		this.carrito = carrito;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler(urlImagenes + "**")
			.addResourceLocations("file:" + rutaImagenes);
	}
	
	@ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("imagenes", urlImagenes);
        model.addAttribute("carrito", carrito);
    }
	
	@ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String gestionarExcepcion(Exception ex) {
		log.log(Level.SEVERE, "Error no esperado", ex);
		
        return "errores/generico";
    }
}
