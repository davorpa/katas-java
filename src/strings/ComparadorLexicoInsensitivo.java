package strings;

/**
 * B. Lo mismo del punto A, pero sin tener en cuenta mayúsculas y minúsculas.
 */
public class ComparadorLexicoInsensitivo
{
	public static void main(String[] args) {
		testEquals("abc", "abc");
		testEquals("ab", "a");
		testEquals("abc", "ABC");
	}


	static void testEquals(String str, String other) {
		boolean equals = str != null && str.equalsIgnoreCase(other);
		System.out.format("La cadena de caracteres '%s' es %s a '%s'%n",
				str,
				equals ? "equivalente lexicograficamente" : "distinta lexicograficamente",
				other);
	}
}
