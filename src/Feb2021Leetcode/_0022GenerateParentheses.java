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
		dfs(0, 0, "", n, output);
		return output;
	}

	public static void dfs(int left, int right, String currString, int n, List<String> output) {
		if (right > left || n < 0 || left > n || right > n)
			return;
		if (left == right && left == n) {
			output.add(currString);
			return;
		}

		dfs(left + 1, right, currString + "(", n, output);
		dfs(left, right + 1, currString + ")", n, output);
	}
}
