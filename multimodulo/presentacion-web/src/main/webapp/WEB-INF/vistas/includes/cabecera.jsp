<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt"%>
<fmt:setLocale value="es-ES" />
<!DOCTYPE html>
<html lang="es" class="h-100">
<head>
<meta charset="UTF-8">
<title>Multimódulo</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-SgOJa3DmI69IUzQ2PVdRZhwQ+dy64/BUtbMJw1MZ8t5HZApcHrRKUc4W0kG879m7"
	crossorigin="anonymous">
<script defer
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-k6d4wzSIapyDyv1kpU366/PK5hCdSbCRGRCMv+eplOQJWyd1fbcAu9OCUj5zNLiq"
	crossorigin="anonymous"></script>
<script defer src="js/password-ojo.js"></script>
</head>
<body class="h-100 d-flex flex-column justify-content-between">
	<nav class="navbar navbar-expand-lg bg-dark sticky-top"
		data-bs-theme="dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Multimódulo</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link" href="listado">Listado</a></li>
				</ul>
				<ul class="navbar-nav mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link" href="#carrito"
						data-bs-toggle="offcanvas"><i class="bi bi-cart"></i></a></li>

					<c:if test="${usuario != null}">
						<li class="navbar-text">${usuario}</li>
					</c:if>

					<c:choose>
						<c:when test="${usuario == null}">
							<li class="nav-item"><a class="nav-link" href="login">Inicio
									sesión</a></li>
						</c:when>
						<c:otherwise>
							<li class="nav-item"><a class="nav-link" href="logout">Cerrar
									sesión</a></li>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
		</div>
	</nav>

	<h1 class="d-none">Multimódulo</h1>

	<aside id="carrito" class="offcanvas offcanvas-end">
		<div class="offcanvas-header">
			<h5 class="offcanvas-title" id="offcanvasRightLabel">
				<a href="carrito">Carrito</a>
			</h5>
			<button type="button" class="btn-close" data-bs-dismiss="offcanvas"
				aria-label="Close"></button>
		</div>
		<ul class="nav flex-column offcanvas-body">
			<c:forEach items="${carrito.lineas}" var="l">
				<li class="nav-item">${l.producto.nombre}(${l.producto.categoria.nombre})</li>
			</c:forEach>
		</ul>
	</aside>

	<%="<main class='container mt-3 mb-5'>"%>