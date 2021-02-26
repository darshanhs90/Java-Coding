package FacebookPrep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0247StrobogrammaticNumberII {

	public static void main(String[] args) {
		System.out.println(findStrobogrammatic(2));
		System.out.println(findStrobogrammatic(3));
	}

	public static List<String> findStrobogrammatic(int n) {
		return strobo(n, n);
	}

	public static List<String> strobo(int m, int n) {
		if (m == 0)
			return new ArrayList<String>(Arrays.asList(""));

		if (m == 1)
			return new ArrayList<String>(Arrays.asList("1", "8", "0"));

		List<String> list = strobo(m - 2, n);
		List<String> output = new ArrayList<String>();

		for (int i = 0; i < list.size(); i++) {
			String str = list.get(i);

			if (m != n) {
				output.add("0" + str + "0");
			}

			output.add("1" + str + "1");
			output.add("6" + str + "9");
			output.add("9" + str + "6");
			output.add("8" + str + "8");
		}
		return output;
	}

}
