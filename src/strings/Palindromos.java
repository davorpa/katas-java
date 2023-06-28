package strings;

/**
 * C. Determinar si una palabra es palíndromo.
 */
public class Palindromos
{
	public static void main(String[] args) {
		testPalindromo("abc");
		testPalindromo("aba");
	}


	static void testPalindromo(String str) {
		boolean pass = isPalindromo(str);
		System.out.format("¿Es palindromo '%s'? %s%n", str, pass);
	}


	static boolean isPalindromo(String str) {
		for (int i = 0; i < str.length() / 2; i++) {
			char natural = str.charAt(i);
			char reversed = str.charAt(str.length() - i - 1);
			if (natural != reversed) {
				return false;
			}
		}
		return true;
	}
}
