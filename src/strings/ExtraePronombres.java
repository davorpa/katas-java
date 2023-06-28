package strings;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * E. Dado un texto, extraer en una cadena de caracteres todos los pronombres mencionados.
 */
public class ExtraePronombres
{
	public static void main(String[] args) {
		testExtraerPronombres("Ella estaba dormida y él acostado junto a ellos");
		testExtraerPronombres("");
		testExtraerPronombres("abc    def    ");
	}


	private static final String[] PRONOMBRES = {
			"Yo", "Tú", "Él", "Ella", "Nosotros", "Vosotros", "Nosotras", "Vosotras", "Ellos", "Ellas"
	};


	static void testExtraerPronombres(String str) {
		String[] matches = extraerPronombres(str);
		System.out.format("En '%s'? se encuentran los pronombres: %s%n", str, Arrays.toString(matches));
	}


	static String[] extraerPronombres(String str) {
		if (str.isBlank()) {
			return new String[0];
		}

		String[] words = str.trim().split("[\\s]+");
		Set<String> found = new LinkedHashSet<>(); // Set => filtrar duplicados, LinkedHashSet => mantener orden de insercion
		for (String word : words) {
			for (String pronombre : PRONOMBRES) {
				if (pronombre.equalsIgnoreCase(word)) {
					found.add(pronombre);
				}
			}
		}
		return found.toArray(String[]::new); // pasar a array
	}
}
