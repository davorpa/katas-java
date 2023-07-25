package pulsaciones;

import java.time.LocalDate;

/**
 * Calcular el número de pulsaciones que una persona debe tener por cada 10
 * segundos de ejercicio, si la fórmula es:
 *
 * num. Pulsaciones = (220 - edad)/10
 */
public class Main {

    public static void main(String[] args) {
        Persona persona = new Persona(LocalDate.of(1983, 8, 18));

        CalculadoraPulsaciones calculadora = new CalculadoraPulsaciones();
        double numPulsaciones = calculadora.calcularNumeroDePulsaciones(persona);

        System.out.println(numPulsaciones);
    }

}
