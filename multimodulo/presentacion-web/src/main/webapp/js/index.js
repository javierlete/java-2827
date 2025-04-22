'use strict';

const url = 'http://www.multimodulo.com/api/productos/'
const formatoEuro = new Intl.NumberFormat('es-ES', {
  style: 'currency',
  currency: 'EUR',
  useGrouping: true,
});

window.addEventListener('DOMContentLoaded', async () => {
	const respuesta = await fetch(url);
	const productos = await respuesta.json();
	
//	console.log(productos); // NOSONAR
	
	const ul = document.querySelector('ul');
	
	ul.innerHTML = '';
	
	productos.forEach(p => {
		console.log(p);
		console.log(formatoEuro.format(p.precio));
		
		const li = document.createElement('li');
		li.innerHTML = `${p.nombre}: ${formatoEuro.format(p.precio)}`;
		
		ul.appendChild(li);
	});
});