package bases;

public class SwitchMejorado {
	public static void main(String[] args) {
		int opcion = 2;

		switch (opcion) {
		case 1:
			System.out.println("UNO");
			break;
		case 2:
			System.out.println("DOS");
			break;
		default:
			System.out.println("NI IDEA");
		}

		switch (opcion) {
		case 1 -> System.out.println("UNO");
		case 2 -> System.out.println("DOS");
		default -> System.out.println("NI IDEA");
		}

		int mes = 5;

		int dias = switch (mes) {
		case 2 -> 28;
		case 4, 6, 9, 11 -> 30;
		default -> 31;
		};

		System.out.println(dias);
	}
}
