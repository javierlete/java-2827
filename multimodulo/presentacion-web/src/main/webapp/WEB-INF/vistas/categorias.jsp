<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp" %>

<ul>
	<c:forEach items="${categorias}" var="c">
		<li><a href="categoria?id=${c.id}">${c.nombre}</a></li>
	</c:forEach>
</ul>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp" %>