package functional;

import java.util.Scanner;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class WordCount
{
	private static final Pattern WORDS_PATTERN = Pattern.compile("\\s+");

	private static final Predicate<String> isBlank = String::isBlank;

	private static final Predicate<String> hasLength = isBlank.negate();

	public static long wordCount(String str) {
		return WORDS_PATTERN
				.splitAsStream(str)
				.filter(hasLength)
				.count();
	}

	public static void main(String[] args) {
		try (Scanner s = new Scanner(System.in)) {
			System.out.print(wordCount(s.nextLine()));
		}
	}

}
