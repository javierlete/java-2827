package ejemplosockets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

	private static final boolean AUTOFLUSH = true;

	public static void main(String[] args) {
		System.out.println("Servidor arrancado en el puerto 1234");

		try (
				Socket s = new Socket("localhost", 1234);
				PrintWriter salida = new PrintWriter(s.getOutputStream(), AUTOFLUSH);
				Scanner entrada = new Scanner(s.getInputStream())) {
			
			System.out.println(entrada.nextLine());
			
			salida.println("Prueba de texto a poner en mayúsculas");
			
			System.out.println(entrada.nextLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
