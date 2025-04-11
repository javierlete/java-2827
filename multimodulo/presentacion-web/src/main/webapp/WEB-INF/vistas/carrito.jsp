<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp" %>
	<ul>
		<c:forEach items="${carrito}" var="p">
			<li>
				${p.nombre} (${p.categoria.nombre})
				
				<a href="#">Quitar del carrito</a>
			</li>
		</c:forEach>
	</ul>

	<p>
		<a href="listado">Volver</a>
	</p>
	
<%@ include file="/WEB-INF/vistas/includes/pie.jsp" %>