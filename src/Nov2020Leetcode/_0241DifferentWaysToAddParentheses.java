package Nov2020Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0241DifferentWaysToAddParentheses {

	public static void main(String[] args) {
		System.out.println(diffWaysToCompute("2-1-1"));
		System.out.println(diffWaysToCompute("2*3-4*5"));

	}

	public static List<Integer> diffWaysToCompute(String input) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c == '+' || c == '-' || c == '*') {
				String leftPart = input.substring(0, i);
				String rightPart = input.substring(i + 1);
				List<Integer> listLeft = diffWaysToCompute(leftPart);
				List<Integer> listRight = diffWaysToCompute(rightPart);
				for (Integer left : listLeft) {
					for (Integer right : listRight) {
						if (c == '+') {
							list.add(left + right);
						} else if (c == '-') {
							list.add(left - right);
						} else if (c == '*') {
							list.add(left * right);
						}
					}
				}
			}
		}
		if (list.size() == 0)
			list.add(Integer.parseInt(input));
		return list;
	}

}
