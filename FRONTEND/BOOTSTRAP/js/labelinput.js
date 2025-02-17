class LabelInput extends HTMLElement {
    get elemento() {
        return this.getAttribute('tipo') === 'textarea' ? 'textarea' : 'input';
    }

    get id() {
        return this.getAttribute('id');
    }

    get etiqueta() {
        return this.getAttribute('etiqueta');
    }

    get tipo() {
        return this.getAttribute('tipo');
    }

    get unidades() {
        return this.hasAttribute('unidades') ? `step="${this.getAttribute('unidades')}"`: '';
    }

    get minimo() {
        return this.hasAttribute('minimo') ? `min="${this.getAttribute('minimo')}"`: '';
    }

    get soloLectura() {
        return this.hasAttribute('soloLectura') ? 'readonly': '';
    }
    get requerido() {
        return this.hasAttribute('requerido') ? 'required': '';
    }

    get longitudMinima() {
        if (this.hasAttribute('longitudMinima')) {
            return 'minlength="' + this.getAttribute('longitudMinima') + '"';
        } else {
            return '';
        }
    }

    get mensajeError() {
        return this.getAttribute('mensajeError');
    }
    connectedCallback() {
        this.innerHTML = `
        <div class="row mb-3">
            <label for="${this.id}" class="col-sm-2 col-form-label">${this.etiqueta}</label>
            <div class="col-sm">
                <${this.elemento} type="${this.tipo}" ${this.minimo} ${this.unidades} ${this.soloLectura} ${this.requerido} ${this.longitudMinima} class="form-control" id="${this.id}"></${this.elemento}>
                <div class="invalid-feedback">
                    ${this.mensajeError}
                </div>
            </div>
        </div>
        `;
    }
}

customElements.define('jl-labelinput', LabelInput);
