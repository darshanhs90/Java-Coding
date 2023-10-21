package Oct2023Leetcode;

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
		dfs("", 0, 0, n, output);
		return output;
	}

	public static void dfs(String currString, int left, int right, int n, List<String> output) {
		if (left == n && right == n) {
			output.add(currString);
			return;
		}
		if (right > left || left > n || right > n)
			return;
		dfs(currString + "(", left + 1, right, n, output);
		dfs(currString + ")", left, right + 1, n, output);
	}
}
