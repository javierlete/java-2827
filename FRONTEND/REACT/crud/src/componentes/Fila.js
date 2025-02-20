import { servicio } from "../servicios/ProductoServicio";
import Boton from "./Boton";

export default function Fila({ producto }) {
    return (
        <tr>
            <td>{producto.id}</td>
            <td>{producto.nombre}</td>
            <td>{producto.descripcion}</td>
            <td>{producto.precio}</td>
            <td>{producto.stock}</td>
            <td>
                <Boton etiqueta="Editar" ruta={'/formulario/' + producto.id} />
                <Boton etiqueta="Borrar" aspecto="danger" />
            </td>
        </tr>
    );
}

Fila.propTypes = {
    producto: servicio.tipoProducto
};