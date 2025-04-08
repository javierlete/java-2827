<%@page import="com.ipartek.formacion.multimodulo.entidades.Producto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
@SuppressWarnings("unchecked")
Iterable<Producto> productos = (Iterable<Producto>)request.getAttribute("productos");
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