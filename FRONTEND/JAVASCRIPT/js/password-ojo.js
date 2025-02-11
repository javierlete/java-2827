'use strict';

window.addEventListener('DOMContentLoaded', () => {
    const passwords = document.querySelectorAll('[type=password]');

    passwords.forEach(password => {
        const ojo = document.createElement('button');

        ojo.type = 'button';

        ojo.innerHTML = '<strong>OJO</strong>';

        ojo.addEventListener('click', () => {
            password.type = 'text';
        });

        password.insertAdjacentElement('afterend', ojo);
    });
});
