<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<form action="admin/formulario" method="post" novalidate class="needs-validation">
	<fieldset>
		<legend>Edición de producto</legend>
		<input type="hidden" name="id" value="${producto.id}">
		<div class="row mb-3">
			<label for="nombre" class="col-sm-2 col-form-label">Nombre</label>
			<div class="col-sm">
				<input type="text" required class="form-control ${errores.nombre != null ? 'is-invalid': '' }" id="nombre" name="nombre"
					value="${producto.nombre}">
				<div class="invalid-feedback">El nombre debe rellenarse y debe tener como máximo 45 caracteres</div>
			</div>
		</div>
		<div class="row mb-3">
			<label for="precio" class="col-sm-2 col-form-label">Precio</label>
			<div class="col-sm">
				<input type="number" required step=".01" min="0" class="form-control ${errores.precio != null ? 'is-invalid': '' }"
					id="precio" name="precio" value="${producto.precio}">
				<div class="invalid-feedback">El precio es obligatorio y debe ser mayor o igual que 0</div>
			</div>
		</div>
		<div class="row mb-3">
			<label for="descripcion" class="col-sm-2 col-form-label">Descripción</label>
			<div class="col-sm">
				<textarea maxlength="2000" class="form-control ${errores.descripcion != null ? 'is-invalid': '' }" id="descripcion" name="descripcion">${producto.descripcion}</textarea>
				<div class="invalid-feedback">La descripción no puede tener más de 2000 caracteres</div>
			</div>
		</div>
		<div class="row mb-3">
			<div class="offset-sm-2 col-sm">
				<button type="submit" class="btn btn-primary">Guardar</button>
			</div>
		</div>
	</fieldset>
</form>

<script src="js/bootstrap-validacion.js"></script>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>