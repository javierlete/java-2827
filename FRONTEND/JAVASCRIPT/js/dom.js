'use strict';

window.addEventListener('DOMContentLoaded', domCargado);

function domCargado() {
    const h1 = document.querySelector('h1');

    console.log(h1.innerText);

    h1.innerText = 'Prueba de JavaScript';

    const lis = document.querySelectorAll('li');

    console.log(lis);

    let num = 1;

    for(const li of lis) {
        console.log(li.innerText);
        li.innerText += num++;
    }

    lis.forEach(li => console.log(li.innerHTML));

    const ul = document.querySelector('ul');

    const li = document.createElement('li');

    li.innerText = 'Cuatro';
    li.className = 'generado';
    li.style.backgroundColor = 'red';

    ul.appendChild(li);
}
