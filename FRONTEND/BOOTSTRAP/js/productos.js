'use strict';

addEventListener('DOMContentLoaded', async () => {
    fichas();
});

function ver(seccion) {
    document.querySelectorAll('main>section').forEach(section => section.style.display = 'none');
    document.getElementById(seccion).style.display = 'block';
}

async function fichas() {
    const respuesta = await fetch('json/productos.json');

    console.log(respuesta);

    const productos = await respuesta.json();

    console.log(productos);

    const divFichas = document.querySelector('#fichas>div');

    divFichas.innerHTML = '';

    productos.forEach(producto => {
        console.log(producto);

        const col = document.createElement('div');

        col.className = 'col';

        col.innerHTML =
            `
                <div class="card h-100">
                    <img src="https://picsum.photos/400/300?${producto.id}" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">${producto.nombre}</h5>
                        <p class="card-text">${producto.descripcion}</p>
                    </div>
                    <div class="card-footer">
                        <small class="text-body-secondary">${producto.precio}</small>
                    </div>
                </div>
            `;

        divFichas.appendChild(col);
    });

    ver('fichas');
}

async function admin() {
    const respuesta = await fetch('json/productos.json');

    console.log(respuesta);

    const productos = await respuesta.json();

    console.log(productos);

    const tbody = document.querySelector('#admin tbody');

    tbody.innerHTML = '';

    productos.forEach(producto => {
        console.log(producto);

        const tr = document.createElement('tr');

        tr.innerHTML =
            `
                <td>${producto.id}</td>
                <td>${producto.nombre}</td>
                <td>${producto.descripcion}</td>
                <td>${producto.precio}</td>
                <td>${producto.stock}</td>
                <td>
                    <button class="btn btn-primary">Editar</button>
                    <button class="btn btn-danger">Eliminar</button>
                </td>
            `;

        tbody.appendChild(tr);
    });

    ver('admin');
}