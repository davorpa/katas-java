package buscapalabras;

import java.util.Arrays;
import java.util.Objects;

/**
 * Hacer un programa que indique el índice de un elemento dado de un arreglo de cadenas de caracteres.
 */
public class BuscaPalabras
{
	public static void main(String[] args) {
		String[] palabras = {"limon", "melon", "naranja", "fresa"};
		testBuscarPalabra("fresa", palabras);
		testBuscarPalabra("cereza", palabras);
	}


	static void testBuscarPalabra(String palabra, String[] palabras) {
		int index = buscarPalabra(palabra, palabras);
		System.out.format("La palabra '%s' %s %s%n",
				palabra,
				index == -1 ? "no se encuentra en el conjunto:" : "está en la posición " + index + " del conjunto:",
				Arrays.toString(palabras));
	}


	static int buscarPalabra(String palabra, String[] palabras)
	{
		for (int i = 0; i < palabras.length; i++) {
			if (Objects.equals(palabras[i], palabra)) {
				return i; // found at index i
			}
		}
		return -1; // not found
	}
}
