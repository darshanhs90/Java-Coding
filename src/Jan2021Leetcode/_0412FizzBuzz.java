package Jan2021Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0412FizzBuzz {

	public static void main(String[] args) {
		System.out.println(fizzBuzz(15));
	}

	public static List<String> fizzBuzz(int n) {
		List<String> output = new ArrayList<String>();
		for (int i = 1; i <= n; i++) {
			String str = "";
			if (i % 3 == 0) {
				str+="Fizz";
			}
			if (i % 5 == 0) {
				str+="Buzz";
			}
			if (str.length() == 0)
				str = String.valueOf(i);

			output.add(str);
		}
		return output;
	}
}
