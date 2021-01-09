package Dec2020Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0728SelfDividingNumbers {
	public static void main(String[] args) {
		System.out.println(selfDividingNumbers(1, 22));
	}

	public static List<Integer> selfDividingNumbers(int left, int right) {
		List<Integer> out = new ArrayList<Integer>();
		for (int i = left; i <= right; i++) {
			String str = String.valueOf(i);
			boolean isValid = true;
			for (int j = 0; j < str.length(); j++) {
				char c = str.charAt(j);
				if (c == '0') {
					isValid = false;
					break;
				} else {
					if (i % (c - '0') != 0) {
						isValid = false;
						break;
					}
				}
			}
			if (isValid)
				out.add(i);
		}
		return out;
	}

}
