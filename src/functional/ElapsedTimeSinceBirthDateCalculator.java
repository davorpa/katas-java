package functional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.BiFunction;

public class ElapsedTimeSinceBirthDateCalculator
{
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in))
		{
			LocalDate birthDate = promptForBirthDate(scanner);

			Map<Integer, Option> options = new LinkedHashMap<>();
			options.put(1, new Option("years", Optional.of(ChronoUnit.YEARS::between)));
			options.put(2, new Option("months", Optional.of(ChronoUnit.MONTHS::between)));
			options.put(3, new Option("weeks", Optional.of(ChronoUnit.MONTHS::between)));
			options.put(4, new Option("days", Optional.of(ChronoUnit.WEEKS::between)));
			options.put(0, new Option("Exit", Optional.empty()));

			Optional<Option> selectedOption;
			while((selectedOption = selectMenuOption(scanner, options)).isPresent()) { // No exit option
				selectedOption
					.map(option -> String.format("It past %d %s since your birthday.",
							option.action.get().apply(birthDate, LocalDate.now()),
							option.label))
					.ifPresent(System.out::println);
			}
		}
	}


	private static LocalDate promptForBirthDate(Scanner scanner) {
		final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		while (true) {
			System.out.print("Enter your birthdate (dd/MM/yyyy): ");
			try {
				return LocalDate.parse(scanner.nextLine().trim(), dtf);
			} catch (NoSuchElementException | DateTimeParseException e) {
				System.out.println("A date was expected.");
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
			System.out.println("------------------------------");
			for (Map.Entry<Integer, Option> entry : options.entrySet()) {
				Option option = entry.getValue();
				String label = option.label;
				if (option.action.isPresent()) {
					label = String.format("Compute %s of life since your birthday", label);
				}
				System.out.format("%d. %s.%n", entry.getKey(), label);
			}
			System.out.println("------------------------------");
			System.out.print  ("   Option? ");

			// prompt for menu option
			int selectedOptionIdx;
			try {
				selectedOptionIdx = Integer.parseInt(scanner.nextLine().trim());
				if (!options.containsKey(selectedOptionIdx)) {
					throw new NoSuchElementException();
				}
			} catch (NoSuchElementException | IllegalArgumentException e) {
				System.out.println("A valid menu option from previous list was expected.");
				continue;
			}

			// select option record
			Option selectedOption = options.get(selectedOptionIdx);
			if (selectedOption.action.isEmpty()) { //is exit option
				return Optional.empty();
			}
			return Optional.of(selectedOption);
		}
	}


	private static class Option
	{
		public final String label;
		public final Optional<BiFunction<LocalDate, LocalDate, Long>> action;

		public Option(String label, Optional<BiFunction<LocalDate, LocalDate, Long>> action) {
			this.label = label;
			this.action = action;
		}
	}
}


