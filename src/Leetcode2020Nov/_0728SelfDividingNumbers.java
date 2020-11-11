package Leetcode2020Nov;

import java.util.ArrayList;
import java.util.List;

public class _0728SelfDividingNumbers {
	public static void main(String[] args) {
		System.out.println(selfDividingNumbers(1, 22));
	}

	public static List<Integer> selfDividingNumbers(int left, int right) {
		List<Integer> output = new ArrayList<Integer>();
		for (int i = left; i <= right; i++) {
			char[] cArray = String.valueOf(i).toCharArray();
			boolean dividesNum = true;
			for (int j = 0; j < cArray.length; j++) {
				if (cArray[j] == '0' || i % Integer.parseInt(cArray[j] + "") != 0) {
					dividesNum = false;
				}
			}
			if (dividesNum) {
				output.add(i);
			}
		}
		return output;
	}
}
