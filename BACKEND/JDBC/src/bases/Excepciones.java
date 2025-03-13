package bases;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Excepciones {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {

			int[] arr = { 1, 2, 3, 4 };

			System.out.println(Arrays.toString(arr));

			buscarPorPosicion(sc, arr);

		} catch (Exception e) {
			System.out.println("Error no esperado");
		}
	}

	private static void buscarPorPosicion(Scanner sc, int[] arr) {
		int posicion;
		try {
			posicion = sc.nextInt();

			if (posicion < arr.length) {
				System.out.println(arr[posicion]);
			} else {
				System.out.println("El índice está fuera de límites");
			}
		} catch (InputMismatchException e) {
			System.out.println("No es un número");
		} finally {
			System.out.println("Me ejecuto siempre");
		}
	}
}
