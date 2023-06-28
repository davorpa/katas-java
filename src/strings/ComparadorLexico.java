package strings;

/**
 * A. Hacer una comparación lexicográfica de una cadena de caracteres.
 */
public class ComparadorLexico
{
	public static void main(String[] args) {
		testEquals("abc", "abc");
		testEquals("ab", "a");
		testEquals("abc", "ABC");
	}


	static void testEquals(String str, String other) {
		boolean equals = str != null && str.equals(other);
		System.out.format("La cadena de caracteres '%s' es %s a '%s'%n",
				str,
				equals ? "equivalente lexicograficamente" : "distinta lexicograficamente",
				other);
	}
}
