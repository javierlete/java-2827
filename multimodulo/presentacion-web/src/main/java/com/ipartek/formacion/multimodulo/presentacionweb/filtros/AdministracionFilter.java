package com.ipartek.formacion.multimodulo.presentacionweb.filtros;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter({"/formulario", "/admin/*"})
public class AdministracionFilter extends HttpFilter implements Filter {

	private static final long serialVersionUID = -4159773187847868536L;

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		String usuario = (String) request.getSession().getAttribute("usuario");
		
		if(usuario == null) {
			response.sendRedirect("login");
			return;
		}
		
		chain.doFilter(request, response);
	}
}
