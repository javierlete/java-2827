import PropTypes from 'prop-types';

class ProductoServicio {
    PRODUCTOS = [
        { id: 1, nombre: 'Producto 1', precio: 100, stock: 10, descripcion: 'Descripción del producto 1' },
        { id: 2, nombre: 'Producto 2', precio: 200, stock: 20, descripcion: 'Descripción del producto 2' },
        { id: 3, nombre: 'Producto 3', precio: 300, stock: 30, descripcion: 'Descripción del producto 3' },
    ];

    tipoProducto = PropTypes.shape({
        id: PropTypes.number.isRequired,
        nombre: PropTypes.string.isRequired,
        precio: PropTypes.number.isRequired,
        stock: PropTypes.number.isRequired,
        descripcion: PropTypes.string,
    });

    tipoProductos = PropTypes.arrayOf(this.tipoProducto).isRequired;

    obtenerProductos() {
        return this.PRODUCTOS;
    }

    obtenerProductoPorId(id) {
        return this.PRODUCTOS.find(producto => producto.id === id);
    }

    borrarProducto(id) {
        this.PRODUCTOS = this.PRODUCTOS.filter(producto => producto.id !== id);
    }
}

export const servicio = new ProductoServicio();
