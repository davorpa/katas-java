package underageds;

import java.util.ArrayList;
import java.util.List;

/**
 * De un conjunto de edades de personas, extraer las personas que son menores de edad.
 */
public class UnderagedsApp
{
	public static void main(String[] args) {
		Persona[] personas = {
			new Persona("Persona 1", 16),
			new Persona("Persona 2", 40),
			new Persona("Persona 3", 5),
			new Persona("Persona 4", 18),
			new Persona("Persona 5", 21),
			new Persona("Persona 6", 36)
		};

		print(extraerUnderAgeds_Arrays(personas));

		print(extraerUnderAgeds_ArrayList(personas));
	}


	static Persona[] extraerUnderAgeds_Arrays(Persona[] personas) {
		int size = 0;

		// search
		Persona[] temp = new Persona[personas.length];
		for (Persona persona : personas) {
			if (persona.isUnderAged(UnderagedsApp::getLegalAge)) {
				temp[size] = persona;
				size++;
			}
		}

		// copy chopped with desired length
		Persona[] underaged = new Persona[size];
		for (int i = 0; i < size; i++) {
			underaged[i] = temp[i];
		}

		return underaged;
	}


	static List<Persona> extraerUnderAgeds_ArrayList(Persona[] personas) {
		// create a empty list with full size
		List<Persona> underaged = new ArrayList<>(personas.length);
		// search
		for (Persona persona : personas) {
			if (persona.isUnderAged(UnderagedsApp::getLegalAge)) {
				underaged.add(persona);
			}
		}
		return underaged;
	}


	static int getLegalAge() {
		return 18;
	}


	static void print(Persona[] array) {
		for (Persona item : array) {
			print(item);
		}
	}

	static void print(List<Persona> list) {
		for (int i = 0; i < list.size(); i++) {
			print(list.get(i));
		}
	}

	static void print(Persona persona) {
		if (persona == null) {
			System.out.println("<null>");
			return;
		}
		System.out.format("%s :: %d%n", persona.getNombre(), persona.getEdad());
	}
}
