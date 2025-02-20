import { useParams } from "react-router";
import Boton from "./Boton";
import LabelInput from "./LabelInput";
import { servicio } from "../servicios/ProductoServicio";

export default function Formulario() {
    const { id } = useParams();

    const idNumber = +id;

    let producto = {};

    if (idNumber) {
        producto = servicio.obtenerProductoPorId(idNumber);
    }

    return (
        <form>
            <h1>Formulario</h1>

            <LabelInput etiqueta="Id" atributos={{ id: 'id', readOnly: true, defaultValue: producto.id }} />
            <LabelInput etiqueta="Nombre" atributos={{ id: 'nombre', required: true, minLength: 3, defaultValue: producto.nombre }} />
            <LabelInput etiqueta="Precio" tipo="number" atributos={{ id: 'precio', required: true, step: 0.01, min: 0, defaultValue: producto.precio }} />
            <LabelInput etiqueta="Stock" tipo="number" atributos={{ id: 'stock', required: true, min: 0, defaultValue: producto.stock }} />
            <LabelInput etiqueta="Descripción" tipo="textarea" atributos={{ id: 'descripcion', defaultValue: producto.descripcion }} />

            <Boton etiqueta="Guardar" tipo="boton" />
        </form>
    );
}