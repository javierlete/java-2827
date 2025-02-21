import { servicio } from "../servicios/ProductoServicio";
import Boton from "./Boton";
import PropTypes from "prop-types";

export default function Fila({ producto, onProductoBorrado }) {
    function borrarProducto() {
        if (window.confirm(`¿Estás seguro de borrar el producto ${producto.id}?`)) {
            servicio.borrarProducto(producto.id).then(
                () => onProductoBorrado(producto.id)
            );
        }
    }

    return (
        <tr>
            <td>{producto.id}</td>
            <td>{producto.nombre}</td>
            <td>{producto.descripcion}</td>
            <td>{producto.precio}</td>
            <td>{producto.stock}</td>
            <td>
                <Boton etiqueta="Editar" ruta={'/formulario/' + producto.id} />
                <Boton etiqueta="Borrar" tipo="button" aspecto="danger" onPulsacion={borrarProducto} />
            </td>
        </tr>
    );
}

Fila.propTypes = {
    producto: servicio.tipoProducto,
    onProductoBorrado: PropTypes.func
};