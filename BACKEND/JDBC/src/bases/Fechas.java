package bases;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Fechas {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Date d = new Date(2025 - 1900, 3 - 1, 14);

		System.out.println(d.getYear());
		System.out.println(d.getMonth());
		
		GregorianCalendar gc = new GregorianCalendar(2025, 3, 14);
		
		System.out.println(gc.get(Calendar.YEAR));
		System.out.println(gc.get(Calendar.MONTH));
		System.out.println(gc.get(Calendar.DAY_OF_MONTH));
		
		LocalDateTime ld = LocalDateTime.of(2025, 3, 14, 10, 24);
		
		System.out.println(ld);
	}
}
