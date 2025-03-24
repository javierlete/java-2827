package entidades;

import java.math.BigDecimal;

public class CategoriaPrueba {

	public static void main(String[] args) {
		Categoria informatica = new Categoria(1L, "Informática", "Cacharritos varios");
		
		System.out.println(informatica);
		
		Producto portatil = new ProductoPerecedero(1L, "Portátil", new BigDecimal("1234"), null, null, informatica);
		
		System.out.println(portatil);
	}

}
