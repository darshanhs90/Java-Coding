package June2021GoogLeetcode;

import java.util.ArrayList;
import java.util.List;

public class _0412FizzBuzz {

	public static void main(String[] args) {
		System.out.println(fizzBuzz(15));
	}

	public static List<String> fizzBuzz(int n) {
		List<String> list = new ArrayList<String>();
		for (int i = 1; i <= n; i++) {
			StringBuilder sb = new StringBuilder();
			if (i % 3 == 0)
				sb.append("Fizz");
			if (i % 5 == 0)
				sb.append("Buzz");
			if (sb.length() == 0)
				sb.append(i + "");
			list.add(sb.toString());
		}
		return list;
	}
}
