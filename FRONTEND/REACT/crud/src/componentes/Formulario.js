import { useNavigate, useParams } from "react-router";
import Boton from "./Boton";
import LabelInput from "./LabelInput";
import { servicio } from "../servicios/ProductoServicio";
import { useEffect, useState } from "react";
import PropTypes from 'prop-types';

const PRODUCTO_VACIO = { id: '', nombre: '', precio: '', stock: '', descripcion: '' };

export default function Formulario({ onProductosCambio }) {
    const [producto, setProducto] = useState(PRODUCTO_VACIO);

    const { id } = useParams();
    const navegar = useNavigate();

    const idNumber = +id;

    useEffect(() => {
        if (idNumber) {
            (async () => setProducto(await servicio.obtenerProductoPorId(idNumber)))();
        } else {
            setProducto(PRODUCTO_VACIO);
        }
    }, [idNumber]);

    async function guardar() {
        if (idNumber) {
            await servicio.actualizarProducto(producto);
        } else {
            await servicio.agregarProducto(producto);
        }

        onProductosCambio();

        navegar('/listado');
    }

    function cambioProducto(e) {
        setProducto({ ...producto, [e.target.id]: e.target.value });
    }

    return (
        <form>
            <h1>Formulario</h1>

            <LabelInput etiqueta="Id" atributos={{ id: 'id', readOnly: true, value: producto.id }} />
            <LabelInput etiqueta="Nombre" atributos={{ id: 'nombre', required: true, minLength: 3, value: producto.nombre, onChange: cambioProducto }} />
            <LabelInput etiqueta="Precio" tipo="number" atributos={{ id: 'precio', required: true, step: 0.01, min: 0, value: producto.precio, onChange: cambioProducto }} />
            <LabelInput etiqueta="Stock" tipo="number" atributos={{ id: 'stock', required: true, min: 0, value: producto.stock, onChange: cambioProducto }} />
            <LabelInput etiqueta="Descripción" tipo="textarea" atributos={{ id: 'descripcion', value: producto.descripcion, onChange: cambioProducto }} />

            <Boton etiqueta="Guardar" tipo="boton" onPulsacion={guardar} />
        </form>
    );
}

Formulario.propTypes = {
    onProductosCambio: PropTypes.func
};