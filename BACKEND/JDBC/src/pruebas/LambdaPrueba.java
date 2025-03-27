package pruebas;

import java.util.Scanner;
import java.util.function.DoubleBinaryOperator;

public class LambdaPrueba {
	private static final Scanner SC = new Scanner(System.in);

	private static final double dividir(double a, double b) {
		return a / b;
	}
	
	public static void main(String[] args) {
		System.out.print("Dime op1: ");
		double op1 = Double.parseDouble(SC.nextLine());

		System.out.print("Dime op: ");
		char op = SC.nextLine().charAt(0);

		DoubleBinaryOperator operacion = switch (op) {
		case '+' -> (a, b) -> a + b;
		case '-' -> (a, b) -> a - b;
		case '*' -> (a, b) -> a * b;
		case '/' -> LambdaPrueba::dividir;
		default -> throw new IllegalArgumentException("Operación no reconocida");
		};
		
		System.out.print("Dime op2: ");
		double op2 = Double.parseDouble(SC.nextLine());

		System.out.println(operacion.applyAsDouble(op1, op2));
	}
}
