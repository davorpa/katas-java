package devengos;

/**
 * Se dispone de 1'000.000 (P) de pesos el cual se deposita en una entidad
 * financiera que le pagará un interés mensual del 2.5% (i) sobre la cantidad
 * inicial acumulada cada mes. ¿Cuánto se tendrá al final de 1 año(n-en meses)?
 *
 * - Aplicando la fórmula: F = P * ( 1+i )^n
 */
public class Main {

    public static void main(String[] args) {
        Deposito deposito = new Deposito(1_000_000.0);
        CalculadoraDevengo calculadora = new CalculadoraDevengo(2.5);

        double totalDevengado = calculadora.calcularTotalDevengado(deposito, 12);

        System.out.printf("%f%n", totalDevengado);
    }

}
