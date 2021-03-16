package Feb2021Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0412FizzBuzz {

	public static void main(String[] args) {
		System.out.println(fizzBuzz(15));
	}

	public static List<String> fizzBuzz(int n) {
		List<String> output = new ArrayList<String>();
		for (int i = 1; i <= n; i++) {
			boolean isPowerOf3 = i % 3 == 0;
			boolean isPowerOf5 = i % 5 == 0;

			if (isPowerOf3 && isPowerOf5) {
				output.add("FizzBuzz");
			} else if (isPowerOf5) {
				output.add("Buzz");
			} else if (isPowerOf3) {
				output.add("Fizz");
			} else {
				output.add(String.valueOf(i));
			}
		}
		return output;
	}
}
