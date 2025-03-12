package bases;

import java.util.ArrayList;
import java.util.Arrays;

public class ArraysYColecciones {
	public static void main(String[] args) {
		int tamano = 2;
		int[] arr = new int[tamano];
		
		arr[0] = 5;
		arr[1] = 6;

		System.out.println(Arrays.toString(arr));
		System.out.println(arr.length);
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		for(int dato: arr) {
			System.out.println(dato);
		}
		
		ArrayList<Integer> coleccion = new ArrayList<>();
		
		coleccion.add(5);
		coleccion.add(2);
		coleccion.add(1);
		
		System.out.println(coleccion);
		
		for(Integer dato: coleccion) {
			System.out.println(dato);
		}
	}
}
