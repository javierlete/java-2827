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

	private static final String CORS_ORIGIN_CLAVE = "Access-Control-Allow-Origin";
	private static final String CORS_ORIGIN_VALOR = "*";
	
	private static final String CORS_METHODS_CLAVE = "Access-Control-Allow-Methods";
	private static final String CORS_METHODS_VALOR = "GET, POST, PUT, DELETE, OPTIONS";

	private static final String CORS_HEADERS_CLAVE = "Access-Control-Allow-Headers";
	private static final String CORS_HEADERS_VALOR = "Content-type";

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
		
		cors(response);

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
		
		cors(response);

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
		
		cors(response);

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
		
		cors(response);

		AdminNegocio negocio = new AdminNegocioImpl();

		negocio.borrarProducto(id);

		response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	}
	
	@Override
	protected void doOptions(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		cors(response);
		response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	}

	private Long pedirId(HttpServletRequest request) {
		String rutaAsterisco = request.getPathInfo();

		Long id = rutaAsterisco == null || rutaAsterisco.length() < 2 ? null : Long.parseLong(rutaAsterisco.substring(1)); // NOSONAR
		return id;
	}

	private void cors(HttpServletResponse response) {
		response.addHeader(CORS_ORIGIN_CLAVE, CORS_ORIGIN_VALOR);
		response.addHeader(CORS_METHODS_CLAVE, CORS_METHODS_VALOR);
		response.addHeader(CORS_HEADERS_CLAVE, CORS_HEADERS_VALOR);
	}
}
