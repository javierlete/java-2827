import Boton from "./Boton";
import LabelInput from "./LabelInput";

export default function Formulario() {
    return (
        <form>
            <h1>Formulario</h1>

            <LabelInput etiqueta="Id" atributos={{readOnly: true}} />
            <LabelInput etiqueta="Nombre" atributos={{required: true, minLength: 3}} />
            <LabelInput etiqueta="Precio" tipo="number" atributos={{required: true, step: 0.01, min: 0}}/>
            <LabelInput etiqueta="Stock" tipo="number" atributos={{required: true, min: 0}} />
            <LabelInput etiqueta="Descripción" tipo="textarea" />

            <Boton etiqueta="Guardar" tipo="boton" />
        </form>
    );
}