<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp" %>

<pre>${producto}</pre>

<form>
	<input value="${producto.nombre}" placeholder="Nombre">
	<input value="${producto.precio}" placeholder="Precio">
	<textarea placeholder="Descripción">${producto.descripcion}</textarea>
	
	<button>Guardar</button>
</form>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp" %>