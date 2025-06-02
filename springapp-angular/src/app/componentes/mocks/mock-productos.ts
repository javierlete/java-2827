import { Producto } from "../../modelos/producto";

export const PRODUCTOS: Producto[] = [
    { "id": 2, "nombre": "Portátil", "precio": 1234.00, "descripcion": "", 
      "categoria": { "id": 2, "nombre": "Informática", "descripcion": null }
    }, 
    { "id": 3, "nombre": "Nevera", "precio": 345.00, "descripcion": "", 
      "categoria": { "id": 3, "nombre": "Electrónica", "descripcion": null } 
    }
  ]