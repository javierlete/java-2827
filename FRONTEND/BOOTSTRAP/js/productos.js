'use strict';

const URL_PRODUCTOS = '/productos/';

addEventListener('DOMContentLoaded', async () => {
    fichas();

    document.querySelector('#formulario form').addEventListener('submit', guardar);
});

function ver(seccion) {
    document.querySelectorAll('main>section').forEach(section => section.style.display = 'none');
    document.getElementById(seccion).style.display = 'block';
}

async function fichas() {
    const respuesta = await fetch(URL_PRODUCTOS);

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
    const respuesta = await fetch(URL_PRODUCTOS);

    console.log(respuesta);

    const productos = await respuesta.json();

    console.log(productos);

    const tbody = document.querySelector('#admin tbody');

    tbody.nextElementSibling.querySelector('td:first-of-type').innerText = `Total: ${productos.length} productos`;

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
                    <a href="javascript:formulario(${producto.id})" class="btn btn-primary">Editar</a>
                    <a href="javascript:borrar(${producto.id})" class="btn btn-danger">Eliminar</a>
                </td>
            `;

        tbody.appendChild(tr);
    });

    ver('admin');
}

async function formulario(id) {
    const form = document.querySelector('#formulario form');
    
    if(id) {
        const respuesta = await fetch(URL_PRODUCTOS + id);
        const producto = await respuesta.json();

        console.log(producto);

        form.idproducto.value = producto.id;
        form.nombre.value = producto.nombre;
        form.precio.value = producto.precio;
        form.descripcion.value = producto.descripcion;
        form.stock.value = producto.stock;
    } else {
        form.reset();
    }

    ver('formulario');
}
async function borrar(id) {
    const respuesta = await fetch(URL_PRODUCTOS + id, {
        method: 'DELETE'
    });

    if(respuesta.ok) {
        admin();
    } else {
        alert('Error');
    }
}

async function guardar(evento) {
    evento.preventDefault();

    const form = document.querySelector('#formulario form');

    if (!form.checkValidity()) {
        form.classList.add('was-validated');
        return;
    }

    const producto = {
        nombre: form.nombre.value,
        precio: form.precio.value,
        descripcion: form.descripcion.value,
        stock: form.stock.value
    };

    form.idproducto.value && (producto.id = form.idproducto.value);

    console.log(producto);

    const respuesta = await fetch(URL_PRODUCTOS + form.idproducto.value, {
        method: producto.id ? 'PUT' : 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(producto)
    });

    if(respuesta.ok) {
        admin();
    } else {
        alert('Error');
    }
}