package com.ipartek.formacion.multimodulo.presentacionweb.controladores;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recoger información de la petición
		HttpSession session = request.getSession();
		
		// Convertir la información recibida
		// Empaquetar en modelos
		// Ejecutar lógica de negocio
		session.invalidate();
		
		// Preparar modelo para la siguiente vista
		// Saltar a la siguiente vista
		try {
			response.sendRedirect(request.getContextPath() + "/login");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
