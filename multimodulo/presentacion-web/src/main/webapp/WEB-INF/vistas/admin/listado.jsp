<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp" %>

<table class="table table-striped table-hover table-bordered">
	<thead class="table-secondary">
		<tr>
			<th scope="col" class="text-end">Id</th>
			<th scope="col">Nombre</th>
			<th scope="col" class="text-end">Precio</th>
			<th scope="col">Descripción</th>
			<th scope="col">OPCIONES</th>
		</tr>
	</thead>
	
	<tbody>
		<c:forEach items="${productos}" var="p">
			<tr>
				<th scope="row" class="text-end">${p.id}</th>
				<td>${p.nombre}</td>
				<td class="text-end"><fmt:formatNumber type="currency" value="${p.precio}"/></td>
				<td>${p.descripcion}</td>
				<td>
					<a href="admin/formulario?id=${p.id}" class="btn btn-sm btn-primary"><i class="bi bi-pencil"></i></a>
					<a href="admin/borrar?id=${p.id}" class="btn btn-sm btn-danger"><i class="bi bi-x-lg"></i></a>
				</td>		
			</tr>
		</c:forEach>
	</tbody>
	
	<tfoot class="table-secondary">
		<tr>
			<td colspan="4"></td>
			<td>
				<a href="admin/formulario" class="btn btn-sm btn-primary">Añadir</a>
			</td>
		</tr>
	</tfoot>
</table>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp" %>