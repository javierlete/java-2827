class Titular extends HTMLElement {
    static observedAttributes = ['texto'];
    
    constructor() {
        super();

        const shadow = this.attachShadow({ mode: 'open', attachShadow: false });

        this._h1 = document.createElement('h1');
        this._h1.className = 'peligro';

        this._h1.style.border = '1px solid black';

        console.log(this);

        shadow.appendChild(this._h1);
    }

    attributeChangedCallback(name, oldValue, valorNuevo) {
        this._texto = valorNuevo;
        this._actualizar();
    }
    connectedCallback() {
        this._actualizar();
    }
    
    get texto() {
        return this._texto;
    }
    set texto(v) {
        this.setAttribute('texto', v);
    }

    _actualizar() {
        this._h1.innerText = this._texto;
    }
}

customElements.define('jl-titular', Titular);
