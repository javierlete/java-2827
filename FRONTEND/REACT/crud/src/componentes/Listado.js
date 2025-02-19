import Boton from "./Boton";
import Fila from "./Fila";

export default function Listado() {
    const filas = [];

    for (let i = 0; i < 3; i++) {
        filas.push(<Fila key={i} />);
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
                {filas}
            </tbody>
            <tfoot className="table-secondary">
                <tr>
                    <td colSpan="5">Total: 3 productos</td>
                    <td>
                        <Boton etiqueta="Añadir" />
                    </td>
                </tr>
            </tfoot>
        </table>
    );
}