/**
 *
 */
package fechas;

import java.time.LocalDate;

/**
 * Dada la fecha de nacimiento de una persona,
 * determinar si la persona al día de hoy es menor de edad, adulto, o adulto mayor.
 *
 * @author davorpa
 */
public class DeterminaFranjaEdad
{
	private static final long EDAD_LEGAL_ADULTO = 18;
	private static final long EDAD_LEGAL_SENIOR = 62;


	public static void main(String[] args) {
		testFranjaEdad(LocalDate.of(2023, 5, 23));
		testFranjaEdad(LocalDate.of(2020, 8, 23));
		testFranjaEdad(LocalDate.of(1983, 8, 23));
		testFranjaEdad(LocalDate.of(1948, 5, 1));
	}


	static void testFranjaEdad(LocalDate fechaNacimiento) {
		LocalDate now = LocalDate.now();
		int diff = now.getYear() - fechaNacimiento.getYear();

		if (diff < EDAD_LEGAL_ADULTO) {
			System.out.format("Parece que la persona que nació el %s es menor de edad.%n", fechaNacimiento);
		} else if (diff < EDAD_LEGAL_SENIOR) {
			System.out.format("Parece que la persona que nació el %s es adulto.%n", fechaNacimiento);
		} else {
			System.out.format("Parece que la persona que nació el %s es jubileta.%n", fechaNacimiento);
		}
	}
}
