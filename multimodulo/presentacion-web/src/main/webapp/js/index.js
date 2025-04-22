import { Servicios } from './servicios.js';

let form;
let ul;
let capaListado;
let capaFormulario;

const formatoEuro = new Intl.NumberFormat('es-ES', {
	style: 'currency',
	currency: 'EUR',
	useGrouping: true,
});

const servicioProductos = new Servicios('productos');

window.addEventListener('DOMContentLoaded', async () => {
	capaListado = document.querySelector('#listado');
	capaFormulario = document.querySelector('#formulario')
	
	form = document.querySelector('form');
	ul = document.querySelector('ul');

	form.addEventListener('submit', guardar);

	listado();
});

window.editar = async function editar(id) {
	if (id) {
		const producto = await servicioProductos.obtenerPorId(id);

		form.nombre.value = producto.nombre;
		form.precio.value = producto.precio;
		form.descripcion.value = producto.descripcion;
	} else {
		form.reset();
	}
	
	mostrar(capaFormulario);
}

window.listado = async function listado() {
	const productos = await servicioProductos.obtenerTodos();

	mostrar(capaListado);

	ul.innerHTML = '';

	productos.forEach(p => {
		const li = document.createElement('li');
		li.innerHTML = `
				${p.nombre}: ${formatoEuro.format(p.precio)}
				<a href="javascript:editar(${p.id})">[Editar]</a>
				<a href="javascript:borrar(${p.id})">[Borrar]</a>
			`;

		ul.appendChild(li);
	});
}

window.borrar = async function borrar(id) {
	await servicioProductos.borrar(id);

	listado();
}

function mostrar(capa) {
	const capas = document.querySelectorAll('main > *');

	capas.forEach(e => e.style.display = 'none');

	capa.style.display = null;
}

async function guardar(evento) {
	evento.preventDefault();

	const producto = {
		nombre: form.nombre.value,
		precio: +form.precio.value,
		descripcion: form.descripcion.value,
	};

	await servicioProductos.insertar(producto);

	listado();
}