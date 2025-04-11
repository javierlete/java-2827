<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp" %>
	<h3>Listado</h3>
	
	<ul>
		<c:forEach items="${productos}" var="p">
			<li>
				${p.nombre} (${p.categoria.nombre})
				
				<a href="carrito?id=${p.id}">Añadir al carrito</a>
				
				<c:if test="${usuario != null}">
					<a href="formulario?id=${p.id}">Editar</a>
				</c:if>
			</li>
		</c:forEach>
	</ul>
	
	<c:if test="${usuario != null}">
		<div>
			<a href="formulario">Añadir</a>
		</div>
	</c:if>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp" %>