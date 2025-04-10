package com.ipartek.formacion.multimodulo.presentacionweb.controladores;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recoger información de la petición
		// Convertir la información recibida
		// Empaquetar en modelos
		// Ejecutar lógica de negocio
		// Preparar modelo para la siguiente vista
		// Saltar a la siguiente vista
		try {
			request.getRequestDispatcher("/WEB-INF/vistas/login.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recoger información de la petición
		HttpSession session = request.getSession();
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		// Convertir la información recibida
		// Empaquetar en modelos
		// Ejecutar lógica de negocio
		if ("javier@email.net".equals(email) && "lete".equals(password)) {
			// Preparar modelo para la siguiente vista
			session.setAttribute("usuario", email);
			
			// Saltar a la siguiente vista
			try {
				response.sendRedirect("listado");
				return;
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		// Preparar modelo para la siguiente vista
		// Saltar a la siguiente vista
		try {
			response.sendRedirect("login");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
