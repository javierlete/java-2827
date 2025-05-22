'use strict';

const URL = '/api/v2'
const URL_MENSAJES = URL + '/mensajes/'
const URL_USUARIOS = URL + '/usuarios/';
const URL_TOKENS = URL + '/token/';

const TAMANO_PAGINA = 20;

let numero_pagina = 0;
let ultima = false;

let ul;
let masMensajes;
let formRegistro;

window.addEventListener('DOMContentLoaded', async () => {
	formRegistro = document.querySelector('#registro form');

	ul = document.querySelector('#mensajes ul');
	ul.innerHTML = '';

	await cargarMensajes();

	masMensajes = document.querySelector('#mas-mensajes');

	masMensajes.addEventListener('click', evento => {
		evento.preventDefault();

		numero_pagina++;

		cargarMensajes();
	});

	mostrar('mensajes');
});

async function cargarMensajes() {
	if (ultima) {
		return;
	}

	const respuesta = await fetch(`${URL_MENSAJES}?page=${numero_pagina}&size=${TAMANO_PAGINA}`);
	const resultado = await respuesta.json();

	ultima = resultado.last;

	if (ultima) {
		masMensajes.remove();
	}

	resultado.content.forEach(mensaje => {
		const li = document.createElement('li');

		li.innerHTML = `
			${mensaje.usuarioNombre}, ${mensaje.fecha}, ${mensaje.texto}
		`;

		ul.appendChild(li);
	});
}

async function registrarse() {
	const usuario = {
		nombre: formRegistro.nombre.value,
		email: formRegistro.email.value,
		password: formRegistro.password.value
	};

	const respuestaToken = await fetch(`${URL_TOKENS}csrf`);
	const token = await respuestaToken.json();
	
	const respuesta = await fetch(URL_USUARIOS, {
		method: 'POST',
		body: JSON.stringify(usuario),
		headers: {
			'Content-type': 'application/json',
			"X-CSRF-TOKEN": token.csrfToken
		}
	});

	if (respuesta.ok) {
		const usuarioRecibido = await respuesta.json();
		console.log(usuarioRecibido);
	} else {
		alert('Ha habido un problema con la petición');
		console.error(respuesta);
	}
}

function mostrar(capa) {
	document.querySelectorAll('main section').forEach(
		section => section.style.display = 'none');

	document.getElementById(capa).style.display = 'block';
}