package May2021PrepLeetcode;

import java.util.ArrayList;
import java.util.List;

public class _0022GenerateParentheses {

	public static void main(String[] args) {
		System.out.println(generateParenthesis(3));
		System.out.println(generateParenthesis(1));
	}

	public static List<String> generateParenthesis(int n) {
		List<String> output = new ArrayList<String>();
		dfs(0, 0, "", n, output);
		return output;
	}

	public static void dfs(int left, int right, String currString, int n, List<String> output) {
		if (left == right && left == n) {
			output.add(currString);
			return;
		}

		if (left > n || right > left)
			return;
		dfs(left + 1, right, currString + "(", n, output);
		dfs(left, right + 1, currString + ")", n, output);
	}
}
