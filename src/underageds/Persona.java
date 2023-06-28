package underageds;

import java.util.function.IntSupplier;

public class Persona {

	private final String nombre;
	private final int edad;


	public Persona(String nombre, int edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
	}


	public String getNombre() {
		return nombre;
	}


	public int getEdad() {
		return edad;
	}


	public boolean isUnderAged(IntSupplier legalAge) {
		return this.edad < legalAge.getAsInt();
	}
}
