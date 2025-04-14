package com.ipartek.formacion.multimodulo.presentacionweb.controladores;

import java.io.IOException;

import com.ipartek.formacion.multimodulo.presentacion.modelos.Carrito;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/carrito-quitar")
public class CarritoQuitar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recoger información de la petición
		Carrito carrito = (Carrito) request.getSession().getAttribute("carrito");

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
		carrito.quitarLinea(id);

		// Preparar modelo para la siguiente vista

		// Saltar a la siguiente vista
		try {
			response.sendRedirect("carrito");
		} catch (IOException e) {
			System.err.println("Error en la petición de carrito");
			System.err.println(e.getStackTrace());
		}
	}
}
