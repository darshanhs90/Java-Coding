package Leetcode2020Nov;

import java.util.ArrayList;
import java.util.List;

public class _0412FizzBuzz {

	public static void main(String[] args) {
		System.out.println(fizzBuzz(15));
	}

	public static List<String> fizzBuzz(int n) {
		List<String> output = new ArrayList<String>();
		for (int i = 1; i <= n; i++) {
			StringBuilder out = new StringBuilder();
			if (i % 3 == 0) {
				out = out.append("Fizz");
			}
			if (i % 5 == 0) {
				out = out.append("Buzz");
			}
			output.add(out.length() > 0 ? out.toString() : String.valueOf(i));
		}
		return output;
	}
}
