export interface Alerta {
    tipo: 'success' | 'danger' | 'info' | 'warning';
    mensaje: string;
}