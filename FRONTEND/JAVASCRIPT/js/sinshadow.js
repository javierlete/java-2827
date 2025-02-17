class Titulo extends HTMLElement {
    get texto() {
        return this.getAttribute('texto');
    }
    connectedCallback() {
        this.innerHTML = `<h1 class="externo">${this.texto}</h1>`;
    }
}

customElements.define('jl-titulo', Titulo);
