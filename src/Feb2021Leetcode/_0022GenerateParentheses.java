package Feb2021Leetcode;

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

		dfs(0, 0, n, "", output);
		return output;
	}

	public static void dfs(int left, int right, int n, String currString, List<String> output) {
		if (left == right && left == n) {
			output.add(currString);
			return;
		}
		if (left > n || right > n || right > left || n <= 0)
			return;

		dfs(left + 1, right, n, currString + "(", output);
		dfs(left, right + 1, n, currString + ")", output);
	}
}
