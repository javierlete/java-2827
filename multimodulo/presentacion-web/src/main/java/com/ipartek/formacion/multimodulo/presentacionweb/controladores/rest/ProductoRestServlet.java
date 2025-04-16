package com.ipartek.formacion.multimodulo.presentacionweb.controladores.rest;

import java.io.IOException;
import java.io.PrintWriter;

import com.ipartek.formacion.multimodulo.entidades.Producto;
import com.ipartek.formacion.multimodulo.logicanegocio.AdminNegocio;
import com.ipartek.formacion.multimodulo.logicanegocio.AdminNegocioImpl;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/api/productos/*")
public class ProductoRestServlet extends HttpServlet {
	private static final String APPLICATION_JSON = "application/json";

	private static final long serialVersionUID = 1L;

	private static final Jsonb JSONB = JsonbBuilder.create();
	private static final AdminNegocio NEGOCIO = new AdminNegocioImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		response.setCharacterEncoding("utf-8"); // NOSONAR
		response.setContentType(APPLICATION_JSON);
		PrintWriter out = response.getWriter(); // NOSONAR
		Long id = pedirId(request);

		String json;

		if (id == null) {
			var productos = NEGOCIO.listarProductos();

			json = JSONB.toJson(productos); // NOSONAR
		} else {
			var producto = NEGOCIO.buscarPorId(id);

			if(producto == null) {
				response.setStatus(HttpServletResponse.SC_NOT_FOUND);
				return;
			}
			
			json = JSONB.toJson(producto); // NOSONAR
		}

		out.write(json);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		response.setCharacterEncoding("utf-8"); // NOSONAR
		response.setContentType(APPLICATION_JSON);
		PrintWriter out = response.getWriter(); // NOSONAR

		Producto producto = JSONB.fromJson(request.getReader(), Producto.class); // NOSONAR

		NEGOCIO.anyadirProducto(producto);

		response.setStatus(HttpServletResponse.SC_CREATED);
		out.write(JSONB.toJson(producto)); // NOSONAR
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		response.setCharacterEncoding("utf-8"); // NOSONAR
		response.setContentType(APPLICATION_JSON);
		PrintWriter out = response.getWriter(); // NOSONAR
		Long id = pedirId(request);

		var producto = JSONB.fromJson(request.getReader(), Producto.class); // NOSONAR

		var productoExistente = NEGOCIO.buscarPorId(id);

		if (productoExistente == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return;
		}

		if (!producto.getId().equals(id)) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}

		NEGOCIO.modificarProducto(producto);

		out.write(JSONB.toJson(producto)); // NOSONAR
	}

	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		response.setCharacterEncoding("utf-8"); // NOSONAR
		response.setContentType(APPLICATION_JSON);

		Long id = pedirId(request);

		AdminNegocio negocio = new AdminNegocioImpl();

		negocio.borrarProducto(id);

		response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	}

	private Long pedirId(HttpServletRequest request) {
		String rutaAsterisco = request.getPathInfo();

		Long id = rutaAsterisco == null ? null : Long.parseLong(rutaAsterisco.substring(1)); // NOSONAR
		return id;
	}
}
