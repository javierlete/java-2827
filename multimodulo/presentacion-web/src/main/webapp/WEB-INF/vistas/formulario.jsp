<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp" %>

<pre>${producto}</pre>

<form action="formulario" method="post">
	<input type="hidden" name="id" value="${producto.id}">
	<input name="nombre" value="${producto.nombre}" placeholder="Nombre">
	<input name="precio" value="${producto.precio}" placeholder="Precio">
	<textarea name="descripcion" placeholder="Descripción">${producto.descripcion}</textarea>
	
	<button>Guardar</button>
</form>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp" %>