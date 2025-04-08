package com.ipartek.formacion.multimodulo.presentacionweb.controladores;

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recoger información de la petición
		// Convertir la información recibida
		// Empaquetar en modelos
		// Ejecutar lógica de negocio
		AnonimoNegocio negocio = new AnonimoNegocioImpl();

		var productos = negocio.listarProductos();

		// Preparar modelo para la siguiente vista
		request.setAttribute("productos", productos);

		// Saltar a la siguiente vista
		try {
			request.getRequestDispatcher("/WEB-INF/vistas/listado.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			System.err.println("Error en la petición de listado");
			System.err.println(e.getStackTrace());
		}
	}
}
