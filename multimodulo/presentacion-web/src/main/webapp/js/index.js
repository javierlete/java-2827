'use strict';

const url = 'http://www.multimodulo.com/api/productos/'

let form;
let ul;

const formatoEuro = new Intl.NumberFormat('es-ES', {
	style: 'currency',
	currency: 'EUR',
	useGrouping: true,
});

window.addEventListener('DOMContentLoaded', async () => {
	form = document.querySelector('form');
	ul = document.querySelector('ul');

	listado();
});

async function editar(id) {
	mostrar(form);

	const respuesta = await fetch(url + id);
	const producto = await respuesta.json();

	form.nombre.value = producto.nombre;
	form.precio.value = producto.precio;
	form.descripcion.value = producto.descripcion;
}

async function listado() {
	const respuesta = await fetch(url);
	const productos = await respuesta.json();

	mostrar(ul);

	ul.innerHTML = '';

	productos.forEach(p => {
		const li = document.createElement('li');
		li.innerHTML = `
				${p.nombre}: ${formatoEuro.format(p.precio)}
				<a href="javascript:editar(${p.id})">[Editar]</a>
			`;

		ul.appendChild(li);
	});
}

function mostrar(capa) {
	const capas = document.querySelectorAll('body > *');

	capas.forEach(e => e.style.display = 'none');

	capa.style.display = null;
}