import PropTypes from 'prop-types';

export default function LabelInput({ etiqueta, tipo = "text", atributos = {} }) {
    return (
        <div className="row mb-3">
            <label htmlFor={atributos.id} className="col-sm-2 col-form-label">{etiqueta}</label>
            <div className="col-sm">
                { tipo === 'textarea' ? 
                    <textarea {...atributos} className="form-control" /> : 
                    <input type={tipo} {...atributos} className="form-control"></input>
                }
                <div className="invalid-feedback">
                    this.mensajeError
                </div>
            </div>
        </div>
    );
}

LabelInput.defaultProps = {
    tipo: "text"
};

LabelInput.propTypes = {
    etiqueta: PropTypes.string.isRequired,
    tipo: PropTypes.string,
    atributos: PropTypes.object
};