import { servicio } from "../servicios/ProductoServicio";
import Boton from "./Boton";
import Fila from "./Fila";

export default function Listado({ productos }) {
    return (
        <table className="table table-hover table-bordered table-striped">
            <thead className="table-secondary">
                <tr>
                    <th>Id</th>
                    <th>Nombre</th>
                    <th>Descripción</th>
                    <th>Precio</th>
                    <th>Stock</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                {productos.map(producto => 
                    <Fila key={producto.id} producto={producto} />
                )}
            </tbody>
            <tfoot className="table-secondary">
                <tr>
                    <td colSpan="5">Total: 3 productos</td>
                    <td>
                        <Boton etiqueta="Añadir" ruta="/formulario" />
                    </td>
                </tr>
            </tfoot>
        </table>
    );
}

Listado.propTypes = {
    productos: servicio.tipoProductos
};
