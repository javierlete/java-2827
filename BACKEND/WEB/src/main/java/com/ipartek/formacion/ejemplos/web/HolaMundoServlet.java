package com.ipartek.formacion.ejemplos.web;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/hola")
public class HolaMundoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		try  {
			response.setContentType("text/html");
			
			PrintWriter out = response.getWriter();
			
			String nombre = request.getParameter("nombre");
			
			out.printf("""
                       <!DOCTYPE html>
                       <html lang="es">
                       <head>
                       <meta charset="UTF-8">
                       <title>Hola Mundo</title>
                       </head>
                       <body>

                       <form action="hola">
                            <input name="nombre" placeholder="Nombre">
                            <button>Saludar</button>
                       </form>
                       <p>
                            Hola %s
                       </p>
                       </body>
                       </html>
                       """, nombre);
		} catch(IOException e) {
			System.out.println("Error en la salida de datos");
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		try  {
			doGet(request, response);
		} catch(ServletException e) {
			System.out.println("Error en la servlet");
		}
	}
}
