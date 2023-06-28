package functional;

import java.util.Optional;
import java.util.Scanner;
import java.util.function.DoubleUnaryOperator;


/**
 * Crear calculadora de tipo de cambio.
 *
 * Debe pedir monto a cambiar. Luego mostrar 2 opciones:
 *
 * - Cambio de euros a dólares.
 * - Cambio de dólares a euros.
 *
 * Que imprima el resultado del cambio.
 */
public class CurrencyExchangeCalculator
{
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in))
		{
			double amount = promptAmount(scanner);

			promptConvertOperation(scanner)
				.map(operation -> operation.applyAsDouble(amount))
				.map(convertedAmount -> String.format("El monto convertido es: %f", convertedAmount))
				.ifPresent(System.out::println);
		}
	}

	private static double promptAmount(Scanner scanner) {
		while (true) {
			try {
				System.out.print("Introduzca una cantidad monetaria: ");
				return Double.parseDouble(scanner.nextLine().trim());
			} catch (Exception e) {
				System.out.println("Se esperaba un número.");
			}
		}
	}

	private static Optional<DoubleUnaryOperator> promptConvertOperation(Scanner scanner) {
		while (true) {
			System.out.println("1. Dólares a Euros.");
			System.out.println("2. Euros a Dólares.");
			System.out.println("0. Salir.");
			System.out.println("-------------------");
			System.out.print  ("   Opción: ");
			String option = scanner.nextLine().trim();

			if ("0".equalsIgnoreCase(option)) { // exit
				return Optional.empty();
			}
			if ("1".equalsIgnoreCase(option)) { // USA->EUR
				return Optional.of(US_DOLLAR_TO_EUROS);
			}
			if ("2".equalsIgnoreCase(option)) { // EUR->USA
				return Optional.of(EUROS_TO_US_DOLLAR);
			}

			System.out.println("Se esperaba una de las opciones anteriores.");
		}
	}

	private static final DoubleUnaryOperator US_DOLLAR_TO_EUROS =
			(double amount) -> amount * 1.09;

	private static final DoubleUnaryOperator EUROS_TO_US_DOLLAR =
			(double amount) -> amount * 0.92;

}
