import Boton from "./Boton";

export default function Fila() {
    return (
        <tr>
            <td>producto.id</td>
            <td>producto.nombre</td>
            <td>producto.descripcion</td>
            <td>producto.precio</td>
            <td>producto.stock</td>
            <td>
                <Boton etiqueta="Editar" ruta="/formulario" />
                <Boton etiqueta="Borrar" aspecto="danger" />
            </td>
        </tr>
    );
}
