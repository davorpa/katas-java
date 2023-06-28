package functional;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LetterChanges
{
	public static final IntFunction<Character> mapToCharacter =
			ch -> Character.valueOf((char) ch);

	private static final Character[] ALPHABET = IntStream
			.rangeClosed('a', 'z')
			.mapToObj(mapToCharacter)
			.toArray(Character[]::new);

	private static final Character[] VOWELS = Stream
			.of('a', 'e', 'i', 'o', 'u')
			.toArray(Character[]::new);

	public static final Predicate<Character> isInAlphabet =
			(Character ch) -> Arrays.binarySearch(ALPHABET, Character.toLowerCase(ch)) >= 0;

	public static final Predicate<Character> isVowel =
			(Character ch) -> Arrays.binarySearch(VOWELS, Character.toLowerCase(ch)) >= 0;

	public static <T, R, F extends Function<? super T, ? extends R>> Function<T, R> conditional(
			Predicate<T> tester, F ifThen, F orElse) {
		return (T t) -> tester.test(t) ? ifThen.apply(t) : orElse.apply(t);
	}

	@SuppressWarnings("unchecked")
	public static <T, R, F extends Function<? super T, ? extends R>> Function<T, R> conditional(
			Predicate<T> tester, F ifThen) {
		return (Function<T, R>) conditional(tester, ifThen, Function.identity());
	}

	public static final UnaryOperator<Character> followingLetter =
			(Character ch) -> Character.valueOf((char) (ch.charValue() + 1));

	public static final UnaryOperator<Character> followingLetterInAlphabet =
			(Character ch) -> {
				ch = followingLetter.apply(ch);
				int index = Arrays.binarySearch(ALPHABET, Character.toLowerCase(ch));
				return index >= 0 ? ch : ALPHABET[0];
			};

	public static String letterChanges(String str) {
		return str.chars()
				.mapToObj(mapToCharacter)
				.map(conditional(isInAlphabet, followingLetterInAlphabet))
				.map(conditional(isVowel, Character::toUpperCase))
				.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
				.toString();
	}


	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print(letterChanges(scanner.nextLine()));
		}
	}
}
