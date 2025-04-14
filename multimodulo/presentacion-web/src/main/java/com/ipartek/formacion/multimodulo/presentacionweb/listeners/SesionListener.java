package com.ipartek.formacion.multimodulo.presentacionweb.listeners;

import com.ipartek.formacion.multimodulo.presentacion.modelos.Carrito;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class SesionListener implements HttpSessionListener {
	@Override
    public void sessionCreated(HttpSessionEvent se)  { 
    	se.getSession().setAttribute("carrito", new Carrito());
    }
}
