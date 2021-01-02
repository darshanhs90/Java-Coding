package Dec2020Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0241DifferentWaysToAddParentheses {

	public static void main(String[] args) {
		System.out.println(diffWaysToCompute("2-1-1"));
		System.out.println(diffWaysToCompute("2*3-4*5"));
	}

	public static List<Integer> diffWaysToCompute(String input) {
		List<Integer> output = new ArrayList<Integer>();
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (Character.isDigit(c)) {
				continue;
			} else {
				List<Integer> leftParts = diffWaysToCompute(input.substring(0, i));
				List<Integer> rightParts = diffWaysToCompute(input.substring(i + 1, input.length()));
				for (Integer leftPart : leftParts) {
					for (Integer rightPart : rightParts) {
						switch (c) {
						case '+':
							output.add(leftPart + rightPart);
							break;
						case '-':
							output.add(leftPart - rightPart);
							break;
						case '*':
							output.add(leftPart * rightPart);
							break;
						}
					}
				}
			}
		}
		if (output.size() == 0)
			output.add(Integer.parseInt(input));
		return output;
	}

}
