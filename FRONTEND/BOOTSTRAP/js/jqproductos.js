'use strict';

const URL_PRODUCTOS = '/productos/';

$(function () {
    fichas();

    $('#formulario form').on('submit', guardar);
});

function ver(seccion) {
    $('main>section').hide();
    $('#' + seccion).show();
}

function fichas() {
    $.getJSON(URL_PRODUCTOS).then(
        function (productos) {
            console.log(productos);

            var $divFichas = $('#fichas>div').empty();

            $(productos).each(function () {
                var producto = this;

                console.log(producto);

                $(`<div class="col">
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
                    `).appendTo($divFichas);
            });

            ver('fichas');
        }
    );
}


function admin() {
    $.getJSON(URL_PRODUCTOS).then(function (productos) {
        console.log(productos);

        $('#admin tbody tfoot td:first-of-type').text(`Total: ${productos.length} productos`);

        $('#admin tbody').empty();

        $(productos).each(function () {
            var producto = this;

            console.log(producto);

            $(`<tr>
                <td>${producto.id}</td>
                <td>${producto.nombre}</td>
                <td>${producto.descripcion}</td>
                <td>${producto.precio}</td>
                <td>${producto.stock}</td>
                <td>
                    <a href="javascript:formulario(${producto.id})" class="btn btn-primary">Editar</a>
                    <a href="javascript:borrar(${producto.id})" class="btn btn-danger">Eliminar</a>
                </td>
            `).appendTo('#admin tbody');
        });

        ver('admin');
    });
}

function formulario(id) {
    if (id) {
        $.getJSON(URL_PRODUCTOS + id).then(function (producto) {
            console.log(producto);

            $('input#idproducto').val(producto.id);
            $('input#nombre').val(producto.nombre);
            $('input#precio').val(producto.precio);
            $('input#stock').val(producto.stock);
            $('textarea#descripcion').val(producto.descripcion);
        });

    } else {
        $('#formulario input, #formulario textarea').val('');
        // $('#formulario form')[0].reset();
    }

    ver('formulario');
}
async function borrar(id) {
    $.ajax(URL_PRODUCTOS + id, {
        method: 'DELETE'
    }).then(function (datos, estado, jqXHR) {
        console.log(datos, estado, jqXHR);

        if (jqXHR.status >= 200 && jqXHR.status < 300) {
            admin();
        } else {
            alert('Error');
        }
    });
}

async function guardar(evento) {
    evento.preventDefault();

    if (!$('#formulario form')[0].checkValidity()) {
        $('#formulario form').addClass('was-validated');
        return;
    }

    var producto = {
        nombre: $('input#nombre').val(),
        precio: $('input#precio').val(),
        stock: $('input#stock').val(),
        descripcion: $('textarea#descripcion').val(),
    };

    $('input#idproducto').val() && (producto.id = $('input#idproducto').val());

    console.log(producto);

    $.ajax(URL_PRODUCTOS + $('input#idproducto').val(), {
        method: producto.id ? 'PUT' : 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        data: JSON.stringify(producto)
    }).then(function (datos, estado, jqXHR) {
        console.log(datos, estado, jqXHR);

        if (jqXHR.status >= 200 && jqXHR.status < 300) {
            admin();
        } else {
            alert('Error');
        }
    });
}