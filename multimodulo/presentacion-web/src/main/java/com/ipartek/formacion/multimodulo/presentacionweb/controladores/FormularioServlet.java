package com.ipartek.formacion.multimodulo.presentacionweb.controladores;

import java.io.IOException;

import com.ipartek.formacion.multimodulo.logicanegocio.AnonimoNegocio;
import com.ipartek.formacion.multimodulo.logicanegocio.AnonimoNegocioImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/formulario")
public class FormularioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recoger información de la petición
		String sId = request.getParameter("id");

		if (sId != null) {

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
			
			var producto = negocio.buscarPorId(id);

			// Preparar modelo para la siguiente vista
			request.setAttribute("producto", producto);
		}
		
		// Saltar a la siguiente vista
		try {
			request.getRequestDispatcher("/WEB-INF/vistas/formulario.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			System.err.println("Error en la petición de formulario");
			System.err.println(e.getStackTrace());
		}
	}
}
