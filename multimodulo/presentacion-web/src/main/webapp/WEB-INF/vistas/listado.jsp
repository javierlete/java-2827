<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>
<h3>Listado</h3>

<c:if test="${usuario != null}">
	<div>
		<a class="btn btn-primary" href="formulario">Añadir</a>
	</div>
</c:if>

<div class="row row-cols-1 row-cols-md-3 g-4">
	<c:forEach items="${productos}" var="p">
		<div class="col">
			<div class="card h-100">
				<img src="https://picsum.photos/400/300?${p.id}" class="card-img-top" alt="...">
				<div class="card-body">
					<h5 class="card-title">${p.nombre}</h5>
					<p class="card-text">
						<a class="btn btn-primary" href="carrito?id=${p.id}">Añadir al carrito</a>
						<c:if test="${usuario != null}">
							<a class="btn btn-outline-primary" href="admin/formulario?id=${p.id}">Editar</a>
						</c:if>
					</p>
				</div>
				<div class="card-footer">
					<small class="text-body-secondary">${p.categoria.nombre}</small>
				</div>
			</div>
		</div>
	</c:forEach>
</div>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>