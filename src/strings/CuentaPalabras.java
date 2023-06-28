package strings;

/**
 * D. Contar la cantidad de palabras que hay en una frase.
 */
public class CuentaPalabras
{
	public static void main(String[] args) {
		testCuentaPalabras("abc");
		testCuentaPalabras("");
		testCuentaPalabras("abc    def    ");
	}


	static void testCuentaPalabras(String str) {
		int count = contarPalabras(str);
		System.out.format("'%s'? está formado de %d palabras.%n", str, count);
	}


	static int contarPalabras(String str) {
		if (str.isBlank()) {
			return 0;
		}
		return str.trim().split("[\\s]+").length;
	}
}
