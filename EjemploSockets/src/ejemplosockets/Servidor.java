package ejemplosockets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {

	private static final boolean AUTOFLUSH = true;

	public static void main(String[] args) {
		System.out.println("Servidor arrancado en el puerto 1234");

		try (ServerSocket ss = new ServerSocket(1234);
				Socket s = ss.accept();
				PrintWriter salida = new PrintWriter(s.getOutputStream(), AUTOFLUSH);
				Scanner entrada = new Scanner(s.getInputStream())) {
			
			System.out.println("Conexión recibida");
			
			salida.println("Bienvenido al servidor MAYUSCULATOR");
			
			String texto = entrada.nextLine();
			
			System.out.println("Texto recibido");
			
			salida.println(texto.toUpperCase());
			
			System.out.println("Texto enviado");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
