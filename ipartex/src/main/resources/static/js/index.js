'use strict';

const URL = '/api/v2'
const URL_MENSAJES = URL + '/mensajes/'

window.addEventListener('DOMContentLoaded', async () => {
	const respuesta = await fetch(URL_MENSAJES);
	const resultado = await respuesta.json();
	
	const ul = document.querySelector('#mensajes');
	
	ul.innerHTML = '';
	
	resultado.content.forEach(mensaje => {
		const li = document.createElement('li');
		
		li.innerHTML = `
			${mensaje.usuarioNombre}, ${mensaje.fecha}, ${mensaje.texto}
		`;
		
		ul.appendChild(li);
	});
});