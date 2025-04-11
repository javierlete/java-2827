package com.ipartek.formacion.multimodulo.presentacionweb.controladores;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Set;

import com.ipartek.formacion.multimodulo.entidades.Producto;
import com.ipartek.formacion.multimodulo.logicanegocio.AdminNegocio;
import com.ipartek.formacion.multimodulo.logicanegocio.AdminNegocioImpl;
import com.ipartek.formacion.multimodulo.logicanegocio.AnonimoNegocio;
import com.ipartek.formacion.multimodulo.logicanegocio.AnonimoNegocioImpl;

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
		@SuppressWarnings("unchecked")
		Set<Producto> productos = (Set<Producto>) request.getSession().getAttribute("carrito");
		
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

			productos.add(producto);
			
			// Preparar modelo para la siguiente vista
		}

		// Saltar a la siguiente vista
		try {
			request.getRequestDispatcher("/WEB-INF/vistas/carrito.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			System.err.println("Error en la petición de carrito");
			System.err.println(e.getStackTrace());
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recoger información de la petición
		String sId = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String sPrecio = request.getParameter("precio");
		String descripcion = request.getParameter("descripcion");
		
		Long id = null;
		
		try {
			id = sId.isBlank() ? null: Long.parseLong(sId);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		BigDecimal precio = new BigDecimal(sPrecio);
		
		// Empaquetar en modelos
		var producto = new Producto(id, nombre, precio, descripcion);
		
		// Ejecutar lógica de negocio
		AdminNegocio negocio = new AdminNegocioImpl();
		
		if(id == null) {
			negocio.anyadirProducto(producto);
		} else {
			negocio.modificarProducto(producto);
		}
		
		// Preparar modelo para la siguiente vista
		// Saltar a la siguiente vista
		try {
			response.sendRedirect("listado");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
