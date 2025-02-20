
import PropTypes from 'prop-types';
import { NavLink } from 'react-router';

export default function Boton({ etiqueta, tipo = 'a', aspecto = 'primary', ruta = '#', onPulsacion }) {
    return (
        <>
            {tipo === 'a' ?
                <NavLink to={ruta} className={'btn btn-sm btn-' + aspecto}>{etiqueta}</NavLink> :
                <button type="button" className={'btn btn-sm btn-' + aspecto} onClick={onPulsacion}>{etiqueta}</button>
            }
        </>
    );
}

Boton.defaultProps = {
    aspecto: "primary"
};

Boton.propTypes = {
    etiqueta: PropTypes.string.isRequired,
    aspecto: PropTypes.string,
    ruta: PropTypes.string,
    tipo: PropTypes.oneOf(['a', 'button']),
    onPulsacion: PropTypes.func
};