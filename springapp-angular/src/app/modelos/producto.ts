import { Categoria } from "./categoria";

export interface Producto {
    id?: number; // El ID puede ser nulo al crear un nuevo producto
    nombre: string;
    precio: number;
    descripcion?: string | null;

    categoria: Categoria;
}
