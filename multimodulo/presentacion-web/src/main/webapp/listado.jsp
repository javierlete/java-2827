<%@page
	import="com.ipartek.formacion.multimodulo.logicanegocio.AnonimoNegocioImpl"%>
<%@page
	import="com.ipartek.formacion.multimodulo.logicanegocio.AnonimoNegocio"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
AnonimoNegocio negocio = new AnonimoNegocioImpl();

var productos = negocio.listarProductos();
%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Listado</title>
</head>
<body>
	<ul>	
	<% for (var producto : productos) { %>
		<li><%=producto.getNombre()%></li>		
	<% } %>
	</ul>
</body>
</html>