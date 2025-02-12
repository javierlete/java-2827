'use strict';

addEventListener('DOMContentLoaded', async () => {
    const respuesta = await fetch('json/productos.json');

    console.log(respuesta);

    const productos = await respuesta.json();

    console.log(productos);

    const fichas = document.querySelector('#fichas>div');

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

        fichas.appendChild(col);
    });
});