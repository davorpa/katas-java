package functional.atm;

import java.util.Scanner;

@FunctionalInterface
interface DoublePrompter
{
	double promptForDouble(Scanner scanner, String prompt);
}