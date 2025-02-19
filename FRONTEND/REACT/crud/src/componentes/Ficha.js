import { servicio } from '../servicios/ProductoServicio';

export default function Ficha({ producto }) {
    return (
        <div className="col">
            <div className="card h-100">
                <img src={'https://picsum.photos/400/300?' + producto.id} className="card-img-top" alt="..." />
                <div className="card-body">
                    <h5 className="card-title">{producto.nombre}</h5>
                    <p className="card-text">{producto.descripcion}</p>
                </div>
                <div className="card-footer">
                    <small className="text-body-secondary">{producto.precio}</small>
                </div>
            </div>
        </div>
    );
}

Ficha.propTypes = {
    producto: servicio.tipoProducto
};
