package com.ipartek.formacion.multimodulo.presentacionweb.controladores;

import java.io.IOException;
import java.util.List;

import com.ipartek.formacion.multimodulo.entidades.Categoria;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/categorias")
public class CategoriasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recoger información de la petición
		// Convertir la información recibida
		// Empaquetar en modelos
		// Ejecutar lógica de negocio
		// Preparar modelo para la siguiente vista
		var categorias = List.of(
				new Categoria(1L, "Informática", ""),
				new Categoria(2L, "Electrónica", ""));
		
		request.setAttribute("categorias", categorias);
		
		// Saltar a la siguiente vista
		try {
			request.getRequestDispatcher("/WEB-INF/vistas/categorias.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			System.err.println("Error en la petición de categorías");
			System.err.println(e.getStackTrace());
		}
	}
}
