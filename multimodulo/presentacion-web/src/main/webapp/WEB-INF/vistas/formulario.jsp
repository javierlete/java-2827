<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<form action="formulario" method="post">
	<input type="hidden" name="id" value="${producto.id}">
	<div class="row mb-3">
		<label for="nombre" class="col-sm-2 col-form-label">Nombre</label>
		<div class="col-sm">
			<input type="text" class="form-control" id="nombre" name="nombre" value="${producto.nombre}">
		</div>
	</div>
	<div class="row mb-3">
		<label for="precio" class="col-sm-2 col-form-label">Precio</label>
		<div class="col-sm">
			<input type="number" step=".01" min="0" class="form-control" id="precio" name="precio" value="${producto.precio}">
		</div>
	</div>
	<div class="row mb-3">
		<label for="descripcion" class="col-sm-2 col-form-label">Descripción</label>
		<div class="col-sm">
			<textarea class="form-control" id="descripcion" name="descripcion">${producto.descripcion}</textarea>
		</div>
	</div>
	<div class="row mb-3">
		<div class="offset-sm-2 col-sm">
			<button type="submit" class="btn btn-primary">Guardar</button>
		</div>
	</div>
</form>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>