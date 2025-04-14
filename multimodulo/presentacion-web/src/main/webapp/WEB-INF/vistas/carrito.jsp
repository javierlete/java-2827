<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<table border="1">
	<thead>
		<tr>
			<th scope="col">Nombre</th>
			<th scope="col">Precio</th>
			<th scope="col">Cantidad</th>
			<th scope="col">Total</th>
			<th scope="col">Opciones</th>
		</tr>
	</thead>

	<tbody>
		<c:forEach items="${carrito.lineas}" var="l">
			<tr>
				<td>${l.producto.nombre}</td>
				<td><fmt:formatNumber type="currency" value="${l.producto.precio}"/></td>
				<td>${l.cantidad}</td>
				<td><fmt:formatNumber type="currency" value="${l.total}"/></td>
				<td><a href="carrito-quitar?id=${l.producto.id}">Quitar del carrito</a></td>
			</tr>
		</c:forEach>
	</tbody>
	
	<tfoot>
		<tr>
			<td colspan="3"></td>
			<td><fmt:formatNumber type="currency" value="${carrito.total}"/></td>
			<td></td>
		</tr>
	</tfoot>
</table>

<p>
	<a href="listado">Volver</a>
</p>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>