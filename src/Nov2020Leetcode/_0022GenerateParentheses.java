package Nov2020Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0022GenerateParentheses {

	public static void main(String[] args) {
		System.out.println(generateParenthesis(3));
		System.out.println(generateParenthesis(1));
	}

	public static List<String> generateParenthesis(int n) {
		String str = "(";
		List<String> list = new ArrayList<String>();
		for (int i = 1; i <= n; i++) {
			generateParenthesis(str, i, 0, n, list);
			str += "(";
		}
		return list;
	}

	public static void generateParenthesis(String str, int leftBraces, int rightBraces, int n, List<String> list) {
		if (rightBraces > leftBraces || leftBraces > n || rightBraces > n)
			return;
		if (leftBraces == rightBraces && leftBraces == n) {
			if (!list.contains(str))
				list.add(str);
			return;
		}
		generateParenthesis(str + "(", leftBraces + 1, rightBraces, n, list);
		generateParenthesis(str + ")", leftBraces, rightBraces + 1, n, list);
	}
}
