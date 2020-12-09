package Nov2020_FBPrep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _048StrobogrammaticNumberII {

	public static void main(String[] args) {
		System.out.println(findStrobogrammatic(1));
		System.out.println(findStrobogrammatic(2));
		System.out.println(findStrobogrammatic(3));
		System.out.println(findStrobogrammatic(4));
	}

	public static List<String> findStrobogrammatic(int n) {
		List<String> out = new ArrayList<String>();
		return findStrobogrammatic(n, n);
	}

	public static List<String> findStrobogrammatic(int n, int m) {
		if (n == 0)
			return new ArrayList<String>(Arrays.asList(""));
		if (n == 1)
			return new ArrayList<String>(Arrays.asList("0", "1", "8"));

		List<String> list = findStrobogrammatic(n - 2, m);
		List<String> output = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			String s = list.get(i);
			if (n != m)
				output.add("0" + s + "0");
			output.add("1" + s + "1");
			output.add("6" + s + "9");
			output.add("8" + s + "8");
			output.add("9" + s + "6");
		}

		return output;

	}

}
