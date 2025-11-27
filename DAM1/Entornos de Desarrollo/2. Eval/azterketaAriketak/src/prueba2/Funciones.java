package prueba2;

public class Funciones {

	public int addIfPositive(int a, int b) {
		if (a > 0 && b > 0) {
			return a + b;
		}
		return 0;
	}

	public boolean isEven(int number) {
		if (number % 2 == 0) {
			return true;
		}
		return false;
	}

	public int[] filterPositiveNumbers(int[] numbers) {
		int count = 0;
		for (int num : numbers) {
			if (num > 0) {
				count++;
			}
		}
		int[] positiveNumbers = new int[count];
		int index = 0;
		for (int num : numbers) {
			if (num > 0) {
				positiveNumbers[index++] = num;
			}
		}
		return positiveNumbers;
	}

	public int maxOfTwo(int a, int b) {
		if (a > b) {
			return a;
		} else {
			return b;
		}
	}

	public boolean isPalindrome(String str) {
		String reversed = new StringBuilder(str).reverse().toString();
		if (str.equals(reversed)) {
			return true;
		}
		return false;
	}

	public String[] filterStringsByLength(String[] words, int minLength) {
		int count = 0;
		for (String word : words) {
			if (word.length() >= minLength) {
				count++;
			}
		}
		String[] filteredWords = new String[count];
		int index = 0;
		for (String word : words) {
			if (word.length() >= minLength) {
				filteredWords[index++] = word;
			}
		}
		return filteredWords;
	}

	public int countOccurrences(int[] numbers, int target) {
		int count = 0;
		for (int num : numbers) {
			if (num == target) {
				count++;
			}
		}
		return count;
	}

	public boolean hasDuplicate(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[i] == numbers[j]) {
					return true;
				}
			}
		}
		return false;
	}

	public int sumArray(int[] numbers) {
		int sum = 0;
		for (int num : numbers) {
			if (num > 0) {
				sum += num;
			}
		}
		return sum;
	}

	public boolean isAdult(int age) {
		if (age >= 18) {
			return true;
		}
		return false;
	}

}
