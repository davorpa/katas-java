package smallestnumbers;

/**
 * Dado un conjunto de números, encontrar el segundo número más pequeño.
 */
public class SmallestNumbers
{

	public static void main(String[] args) {
		int[] numbers = {5, 3, 7, 2, 4, 1, 8};
		System.out.println(extractSmallestNumber(numbers));
		System.out.println(extractSecondSmallestNumber(numbers));
	}


	static int extractSecondSmallestNumber(int[] numbers) {
		checkHaveLength(numbers);
		// set first pivot
		int min = numbers[0];
		if (numbers.length == 1) { // single element
			return min;
		}
		// set two pivots when more than one element
		int min_2nd = Math.max(numbers[1], min);
		min = Math.min(numbers[1], min);
		// search for pivot changes
		for (int index = 2; index < numbers.length; index++) {
			final int num = numbers[index];
			// swap pivots accordingly
			if (num < min_2nd) {
				min_2nd = num;
			}
			if (num < min) {
				min_2nd = min;
				min = num;
			}
		}
		return min_2nd;
	}


	static int extractSmallestNumber(int[] numbers) {
		checkHaveLength(numbers);
		// set initial pivot (the result)
		int min = numbers[0];
		// search for pivot changes
		for (int index = 1; index < numbers.length; index++) {
			final int num = numbers[index];
			// swap pivot accordingly
			if (num < min) {
				min = num;
			}
		}
		return min;
	}


	static void checkHaveLength(int[] numbers) {
		if (numbers == null || numbers.length == 0) {
			throw new IllegalArgumentException("'numbers' to extract must have length");
		}
	}
}
