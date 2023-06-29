package functional.atm;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.function.DoubleConsumer;

/**
 * Crear un sistema para un ATM que permita:
 *
 * Definan al inicio el saldo.
 * 1. Ingresar dinero
 * 2. Retirar dinero
 * 3. Consultar Saldo
 */
public class Main
{
	public static void main(String[] args) {
		try (final Scanner scanner = new Scanner(System.in))
		{
			final DoublePrompter prompter = Main::promptForDouble;

			final Account account = new Account(
					prompter.promptForDouble(scanner, "Initial account funds"));

			final DoubleSupplier balancer = account::getFunds;
			final DoubleConsumer withdrawaller = account::withdraw;
			final DoubleConsumer depositer = account::deposit;

			final Map<Integer, Option> options = new LinkedHashMap<>();
			options.put(1, new Option("Deposit", Optional.of(() -> {
				try {
					depositer.accept(prompter.promptForDouble(scanner, "Input the amount to deposit"));
				} catch (IllegalArgumentException | IllegalStateException e) {
					System.out.println(e.getMessage());
				}
			})));
			options.put(2, new Option("Withdraw", Optional.of(() -> {
				try {
					withdrawaller.accept(prompter.promptForDouble(scanner, "Input the amount to withdraw"));
				} catch (IllegalArgumentException | IllegalStateException e) {
					System.out.println(e.getMessage());
				}
			})));
			options.put(3, new Option("See current funds", Optional.of(() ->
				System.out.format("Current funds is: %f%n", balancer.get())
			)));
			options.put(0, new Option("Exit", Optional.empty()));

			Optional<Option> selectedOption;
			while((selectedOption = selectMenuOption(scanner, options)).isPresent()) { // No exit option
				selectedOption
					.flatMap(Option::getAction)
					.ifPresent(Runnable::run); // execute action
			}
		}
	}


	private static double promptForDouble(Scanner scanner, String prompt) {
		while (true) {
			System.out.format("%s: ", prompt);
			try {
				return Double.parseDouble(scanner.nextLine().trim());
			} catch (NoSuchElementException | IllegalArgumentException e) {
				System.out.println("A decimal number was expected.");
			}
		}
	}


	private static Optional<Option> selectMenuOption(
			Scanner scanner,
			Map<Integer, Option> options)
	{
		while (true) {
			// paint menu options
			System.out.println();
			System.out.println();
			System.out.println("------------ ATM --------------");
			for (Map.Entry<Integer, Option> entry : options.entrySet()) {
				System.out.format("%d. %s%n", entry.getKey(), entry.getValue().getLabel());
			}
			System.out.println("-------------------------------");
			System.out.print  ("   Option? ");

			try {
				return Optional.ofNullable(
						// prompt for menu option and then select option
						OptionalInt.of(
							Integer.parseInt(scanner.nextLine().trim())
						)
						.stream()
						.mapToObj(options::get) // get selected option
						.filter(Objects::nonNull) // filter if option not found
						.findFirst()
						.orElseThrow(NoSuchElementException::new)
					)
					// exit option to empty option
					.filter((Option selectedOption) -> selectedOption.getAction().isPresent());
			} catch (NoSuchElementException | IllegalArgumentException e) {
				System.out.println("A valid menu option from previous list was expected.");
			} finally {
				System.out.println();
			}
		}
	}
}
