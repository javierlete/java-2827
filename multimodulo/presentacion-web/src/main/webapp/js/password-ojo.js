'use strict';

if (!navigator.userAgent.includes('Edg')) {
	window.addEventListener('DOMContentLoaded', () => {
		const passwords = document.querySelectorAll('[type=password]');

		passwords.forEach(password => {
			password.classList.add('border-end-0');

			const ojo = document.createElement('button');

			ojo.type = 'button';
			ojo.className = 'input-group-text border-start-0';
			ojo.style.backgroundColor = getComputedStyle(password).getPropertyValue('background-color');

			ojo.innerHTML = '<i class="bi bi-eye-slash"></i>';

			ojo.addEventListener('click', () => {
				password.type = password.type === 'password' ? 'text' : 'password';

				ojo.innerHTML = password.type === 'password' ? '<i class="bi bi-eye-slash"></i>' : '<i class="bi bi-eye"></i>';
			});

			const inputGroup = document.createElement('div');

			inputGroup.classList.add('input-group');
			inputGroup.classList.add('mb-3');

			password.insertAdjacentElement('afterend', inputGroup);

			inputGroup.appendChild(password);

			password.insertAdjacentElement('afterend', ojo);
		});
	});
}