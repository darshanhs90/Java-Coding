package May2021Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0022GenerateParentheses {

	public static void main(String[] args) {
		System.out.println(generateParenthesis(3));
		System.out.println(generateParenthesis(1));
	}

	public static List<String> generateParenthesis(int n) {
		List<String> output = new ArrayList<String>();
		if (n <= 0)
			return output;
		dfs(0, 0, "", n, output);
		return output;
	}

	public static void dfs(int left, int right, String str, int n, List<String> output) {
		if (left == right && left == n) {
			output.add(str);
			return;
		}

		if (left > n || right > left)
			return;
		dfs(left + 1, right, str + "(", n, output);
		dfs(left, right + 1, str + ")", n, output);
	}
}
