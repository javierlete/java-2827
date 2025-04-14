<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<table class="table table-bordered table-hover table-striped">
	<thead class="table-secondary">
		<tr>
			<th scope="col">Nombre</th>
			<th scope="col" class="text-end">Precio</th>
			<th scope="col" class="text-end">Cantidad</th>
			<th scope="col" class="text-end">Total</th>
			<th scope="col" class="text-center">Opciones</th>
		</tr>
	</thead>

	<tbody>
		<c:forEach items="${carrito.lineas}" var="l">
			<tr>
				<td>${l.producto.nombre}</td>
				<td class="text-end"><fmt:formatNumber type="currency" value="${l.producto.precio}"/></td>
				<td class="text-end">${l.cantidad}</td>
				<td class="text-end"><fmt:formatNumber type="currency" value="${l.total}"/></td>
				<td class="text-center"><a class="btn btn-sm btn-danger" href="carrito-quitar?id=${l.producto.id}"><i class="bi bi-x-lg"></i></a></td>
			</tr>
		</c:forEach>
	</tbody>
	
	<tfoot class="table-secondary">
		<tr>
			<td class="text-end fw-bold" colspan="3">Total</td>
			<td class="text-end fw-bold"><fmt:formatNumber type="currency" value="${carrito.total}"/></td>
			<td></td>
		</tr>
	</tfoot>
</table>

<p>
	<a class="btn btn-primary" href="listado">Volver</a>
</p>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>