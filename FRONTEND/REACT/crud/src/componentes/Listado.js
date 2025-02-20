import { servicio } from "../servicios/ProductoServicio";
import Boton from "./Boton";
import Fila from "./Fila";
import PropTypes from "prop-types";

export default function Listado({ productos, onProductosCambio }) {
    
    function refrescarListado(id) {
        console.log(`Refrescar listado sin el producto ${id}`);

        onProductosCambio();
    }

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
                    <Fila key={producto.id} producto={producto} onProductoBorrado={refrescarListado} />
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
    productos: servicio.tipoProductos,
    onProductosCambio: PropTypes.func
};
