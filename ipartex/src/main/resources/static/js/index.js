'use strict';

const URL = '/api/v2'
const URL_MENSAJES = URL + '/mensajes/'
const TAMANO_PAGINA = 20;

let numero_pagina = 0;
let ul;

window.addEventListener('DOMContentLoaded', async () => {
	ul = document.querySelector('#mensajes');
	ul.innerHTML = '';

	await cargarMensajes();
	
	const masMensajes = document.querySelector('#mas-mensajes');
	
	masMensajes.addEventListener('click', evento => {
		evento.preventDefault();
		
		numero_pagina++;
		
		cargarMensajes();
	});
});

async function cargarMensajes() {
    const respuesta = await fetch(`${URL_MENSAJES}?page=${numero_pagina}&size=${TAMANO_PAGINA}`);
    const resultado = await respuesta.json();

    resultado.content.forEach(mensaje => {
        const li = document.createElement('li');

        li.innerHTML = `
			${mensaje.usuarioNombre}, ${mensaje.fecha}, ${mensaje.texto}
		`;

        ul.appendChild(li);
    });
}
