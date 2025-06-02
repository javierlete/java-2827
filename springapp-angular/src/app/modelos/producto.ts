import { Categoria } from "./categoria";

export interface Producto {
    id: number;
    nombre: string;
    precio: number;
    descripcion?: string | null;

    categoria: Categoria;
}
