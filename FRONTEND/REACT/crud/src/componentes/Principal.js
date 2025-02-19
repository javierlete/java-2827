import { servicio } from "../servicios/ProductoServicio";
import Ficha from "./Ficha";

export default function Principal({ productos }) {
    const fichas = [];

    for (const producto of productos) {
        fichas.push(<Ficha key={producto.id} producto={producto} />);
    }

    return (
        <div className="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-4 row-cols-xl-5 row-cols-xxl-6 g-4">
            {fichas}
        </div>
    );
}

Principal.propTypes = {
    productos: servicio.tipoProductos
};