import { Servicios } from './servicios.js';

let form;
let ul;

const formatoEuro = new Intl.NumberFormat('es-ES', {
	style: 'currency',
	currency: 'EUR',
	useGrouping: true,
});

const servicioProductos = new Servicios('productos');

window.addEventListener('DOMContentLoaded', async () => {
	form = document.querySelector('form');
	ul = document.querySelector('ul');

	listado();
});

window.editar = async function editar(id) {
	const producto = await servicioProductos.obtenerPorId(id);

	mostrar(form);

	form.nombre.value = producto.nombre;
	form.precio.value = producto.precio;
	form.descripcion.value = producto.descripcion;
}

window.listado = async function listado() {
	const productos = await servicioProductos.obtenerTodos();

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