'use strict';

window.addEventListener("DOMContentLoaded", () => {
	const inputs = document.querySelectorAll('input[type=number]');
	
	inputs.forEach(input => {
		const btnMenos = input.parentElement.children[0];
		const btnMas = input.parentElement.children[2];
		
		btnMenos.addEventListener('click', () => input.value--);
		btnMas.addEventListener('click', () => input.value++);
	});
});