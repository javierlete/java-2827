<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt"%>
<fmt:setLocale value="es-ES"/>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Multimódulo</title>
</head>
<body>
	<h1>Multimódulo</h1>

	<c:if test="${usuario != null}">
		<p>Estás logueado con ${usuario}</p>
	</c:if>

	<nav>
		<ul>
			<li><a href="listado">Listado</a></li>
			<li><a href="carrito">Carrito</a></li>

			<c:choose>
				<c:when test="${usuario == null}">
					<li><a href="login">Inicio sesión</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="logout">Cerrar sesión</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</nav>

	<aside>
		<h3>Carrito</h3>
		<ul>
			<c:forEach items="${carrito.lineas}" var="l">
				<li>${l.producto.nombre} (${l.producto.categoria.nombre})</li>
			</c:forEach>
		</ul>
	</aside>