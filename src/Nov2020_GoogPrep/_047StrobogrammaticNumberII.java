package Nov2020_GoogPrep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _047StrobogrammaticNumberII {

	public static void main(String[] args) {
		System.out.println(findStrobogrammatic(1));
		System.out.println(findStrobogrammatic(2));
		System.out.println(findStrobogrammatic(3));
		System.out.println(findStrobogrammatic(4));
	}

	public static List<String> findStrobogrammatic(int n) {
		return helper(n, n);
	}

	public static List<String> helper(int n, int m) {
		if (n == 0)
			return new ArrayList<String>(Arrays.asList(""));
		else if (n == 1)
			return new ArrayList<String>(Arrays.asList("0", "1", "8"));

		List<String> list = helper(n - 2, m);
		List<String> output = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			String str = list.get(i);
			if (n != m)
				output.add("0" + str + "0");
			output.add("1" + str + "1");
			output.add("6" + str + "9");
			output.add("8" + str + "8");
			output.add("9" + str + "6");
		}
		return output;
	}
}
