<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Listado</title>
</head>
<body>
	<ul>
		<c:forEach items="${productos}" var="p">
			<li>${p.nombre}</li>
		</c:forEach>
	</ul>
</body>
</html>