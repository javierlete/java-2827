package com.ipartek.formacion.multimodulo.presentacionweb.controladores;

import java.io.IOException;

import com.ipartek.formacion.multimodulo.logicanegocio.AnonimoNegocio;
import com.ipartek.formacion.multimodulo.logicanegocio.AnonimoNegocioImpl;
import com.ipartek.formacion.multimodulo.presentacion.modelos.Carrito;
import com.ipartek.formacion.multimodulo.presentacion.modelos.Carrito.LineaCarrito;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/carrito")
public class CarritoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recoger información de la petición
		Carrito carrito = (Carrito) request.getSession().getAttribute("carrito");

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

			LineaCarrito linea = carrito.getLineaPorId(id);

			if (linea != null) {
				linea.setCantidad(linea.getCantidad() + 1);
			} else {
				carrito.ponerLinea(new LineaCarrito(producto, 1));
			}

			// Preparar modelo para la siguiente vista
			// Saltar a la siguiente vista
			try {
				response.sendRedirect("carrito");
				return;
			} catch (IOException e) {
				System.err.println("Error en la petición de carrito");
				System.err.println(e.getStackTrace());
			}
		}

		// Saltar a la siguiente vista
		try {
			request.getRequestDispatcher("/WEB-INF/vistas/carrito.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			System.err.println("Error en la petición de carrito");
			System.err.println(e.getStackTrace());
		}
	}
}
