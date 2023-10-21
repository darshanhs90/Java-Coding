package Oct2023Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0412FizzBuzz {

	public static void main(String[] args) {
		System.out.println(fizzBuzz(15));
	}

	public static List<String> fizzBuzz(int n) {
		List<String> output = new ArrayList<String>();
		for (int i = 1; i <= n; i++) {
			boolean isDivisibleBy3 = i % 3 == 0;
			boolean isDivisibleBy5 = i % 5 == 0;
			if (isDivisibleBy3 && isDivisibleBy5) {
				output.add("FizzBuzz");
			} else if (isDivisibleBy3) {
				output.add("Fizz");
			} else if (isDivisibleBy5) {
				output.add("Buzz");
			} else {
				output.add(String.valueOf(i));
			}
		}
		return output;
	}
}
