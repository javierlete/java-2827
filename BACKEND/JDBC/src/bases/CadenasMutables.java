package bases;

public class CadenasMutables {
	public static void main(String[] args) {
		int x = 5;

		String log = "";

		log += "Hola\n";
		log += "Qué tal\n";
		log += "El valor de x es " + x + ".\n";

		log = new StringBuffer(log).append("El valor de y es ").append(x).append(".\n").toString();

		System.out.println(log);
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("Hola\n");
		sb.append("Qué tal\n");
		sb.append("El valor de x es ");
		sb.append(x);
		sb.append(".\n");
		
		String logNuevo = sb.toString();
		
		System.out.println(logNuevo);
		
		System.out.println("lakjdflkjasdfasd\nlñaksjdlgkahsdklgads\n");
		
		System.out.println("""
				laksdjflkasd
				laksjdlkas
				kljasdhkljhds
				""");
	}
}
