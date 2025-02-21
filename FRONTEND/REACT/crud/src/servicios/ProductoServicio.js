import PropTypes from 'prop-types';
import axios from 'axios';

class ProductoServicio {
    URL = 'http://localhost:3001/productos/';

    tipoProducto = PropTypes.shape({
        id: PropTypes.number.isRequired,
        nombre: PropTypes.string.isRequired,
        precio: PropTypes.number.isRequired,
        stock: PropTypes.number.isRequired,
        descripcion: PropTypes.string,
    });

    tipoProductos = PropTypes.arrayOf(this.tipoProducto).isRequired;

    async obtenerProductos() {
        const { data } = await axios.get(this.URL);

        return data;
    }

    async obtenerProductoPorId(id) {
        return (await axios.get(this.URL + id)).data;
    }

    async agregarProducto(producto) {
        return (await axios.post(this.URL, producto)).data;
    }

    async actualizarProducto(producto) {
        return (await axios.put(this.URL + producto.id, producto)).data;
    }

    async borrarProducto(id) {
        await axios.delete(this.URL + id);
    }
}

export const servicio = new ProductoServicio();
