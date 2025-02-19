
import PropTypes from 'prop-types';
import { NavLink } from 'react-router';

export default function Boton({ etiqueta, tipo = 'a', aspecto = 'primary', ruta = '#' }) {
    return (
        <>
            {tipo === 'a' ?
                <NavLink to={ruta} className={'btn btn-sm btn-' + aspecto}>{etiqueta}</NavLink> :
                <button className={'btn btn-' + aspecto}>{etiqueta}</button>
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
    tipo: PropTypes.oneOf(['a', 'button'])
};