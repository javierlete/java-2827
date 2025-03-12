package bases;

import java.util.Scanner;

public class LeerConsola {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Dime tu nombre: ");
		String linea = sc.nextLine();
		
		System.out.println("Hola " + linea);
		
		sc.close();
	}
}
