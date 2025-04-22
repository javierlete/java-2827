const url = 'http://www.multimodulo.com/api';

export class Servicios {
	constructor(conjunto) {
		this.conjunto = conjunto;
	}
	
	async obtenerTodos() {
		const respuesta = await fetch(`${url}/${this.conjunto}`);
		return await respuesta.json();
	}
	
	async obtenerPorId(id) {
		const respuesta = await fetch(`${url}/${this.conjunto}/${id}`);
		return await respuesta.json();
	}
	
	async borrar(id) {
		const respuesta = await fetch(`${url}/${this.conjunto}/${id}`, { method: 'DELETE' })
		
		if(!respuesta.ok) {
			throw respuesta.statusText;
		}
	}
}