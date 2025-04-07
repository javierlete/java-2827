package com.ipartek.formacion.multimodulo.presentacionweb.servlets;

import java.io.IOException;

import com.ipartek.formacion.multimodulo.logicanegocio.AnonimoNegocio;
import com.ipartek.formacion.multimodulo.logicanegocio.AnonimoNegocioImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/listado")
public class ListadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AnonimoNegocio negocio = new AnonimoNegocioImpl();
		
		StringBuilder lista = new StringBuilder();
		
		var productos = negocio.listarProductos();
		
		for(var producto: productos) {
			lista.append("<li>" + producto.getNombre() + "</li>");
		}
		
		response.getWriter().printf("""
                <!DOCTYPE html>
                <html lang="es">
                <head>
                <meta charset="UTF-8">
                <title>Hola Mundo</title>
                </head>
                <body>

                <ul>
                     %s
                </ul>
                </body>
                </html>
                """, lista);
		
	}
}
