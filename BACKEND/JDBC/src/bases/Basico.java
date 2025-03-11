package bases;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Basico {

	public static void main(String[] args) {
		int x = 5;
		String texto = "Javier";
		
		System.out.println(texto.toUpperCase());
		
		double d1 = 0.1, d2 = 0.2;
		
		System.out.println(d1 + d2);
		
		BigDecimal bd1 = new BigDecimal("0.1");
		BigDecimal bd2 = new BigDecimal("0.2");
		
		System.out.println(bd1.add(bd2));
		
		bd1 = new BigDecimal("10");
		bd2 = new BigDecimal("3");
		
		System.out.println(10.0/3.0);
		System.out.println(bd1.divide(bd2, 2, RoundingMode.HALF_UP));
		
		
	}

}
