<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp" %>
	<ul>
		<c:forEach items="${productos}" var="p">
			<li>
				${p.nombre} (${p.categoria.nombre})
				
				<a href="formulario?id=${p.id}">Editar</a>
			</li>
		</c:forEach>
	</ul>
	
	<div>
		<a href="formulario">Añadir</a>
	</div>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp" %>