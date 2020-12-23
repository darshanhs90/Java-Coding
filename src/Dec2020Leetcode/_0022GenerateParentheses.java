package Dec2020Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0022GenerateParentheses {

	public static void main(String[] args) {
		System.out.println(generateParenthesis(3));
		System.out.println(generateParenthesis(1));
	}

	public static List<String> generateParenthesis(int n) {
		List<String> list = new ArrayList<String>();
		generateParenthesis("", n, n, list);
		return list;
	}

	public static void generateParenthesis(String currString, int left, int right, List<String> list) {
		if (right < left || left < 0 || right < 0)
			return;
		if (left == right && left == 0) {
			list.add(currString);
			return;
		}
		generateParenthesis(currString + "(", left - 1, right, list);
		generateParenthesis(currString + ")", left, right - 1, list);
	}
}
