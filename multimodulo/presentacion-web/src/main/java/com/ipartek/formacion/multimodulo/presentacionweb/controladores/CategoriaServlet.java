package com.ipartek.formacion.multimodulo.presentacionweb.controladores;

import java.io.IOException;

import com.ipartek.formacion.multimodulo.logicanegocio.AnonimoNegocio;
import com.ipartek.formacion.multimodulo.logicanegocio.AnonimoNegocioImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/categoria")
public class CategoriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recoger información de la petición
		String sId = request.getParameter("id");
		
		// Convertir la información recibida
		Long id = null;
		
		try {
			id = Long.parseLong(sId);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		// Empaquetar en modelos
		// Ejecutar lógica de negocio
		AnonimoNegocio negocio = new AnonimoNegocioImpl();
		
		var categoria = negocio.detalleCategoria(id);
		var productos = negocio.productosDeCategoria(id);
		
		// Preparar modelo para la siguiente vista
		request.setAttribute("categoria", categoria);
		request.setAttribute("productos", productos);
		
		// Saltar a la siguiente vista
		try {
			request.getRequestDispatcher("/WEB-INF/vistas/categoria.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			System.err.println("Error en la petición de categorías");
			System.err.println(e.getStackTrace());
		}
	}
}
