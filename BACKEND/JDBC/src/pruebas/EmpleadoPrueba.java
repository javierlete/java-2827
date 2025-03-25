package pruebas;

import java.math.BigDecimal;
import java.util.ArrayList;

import entidades.Empleado;
import entidades.EmpleadoIndefinido;
import entidades.EmpleadoPorHoras;

class EmpleadoPrueba {
	public static void main(String[] args) {
		ArrayList<Empleado> empleados = new ArrayList<>();
		
		empleados.add(new EmpleadoIndefinido(null, "Indefinido Indefinidez", null, null, new BigDecimal(12345), 14));
		empleados.add(new EmpleadoPorHoras(null, "Horis Horez", null, null, 50, new BigDecimal(20)));
		
		BigDecimal total = BigDecimal.ZERO;
		
		for(Empleado e: empleados) {
			System.out.println(e);
			System.out.println(e.getSueldo());
			
			total = total.add(e.getSueldo());
		}
		
		System.out.println(total);
	}
}
