package Jan2021Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0022GenerateParentheses {

	public static void main(String[] args) {
		System.out.println(generateParenthesis(3));
		System.out.println(generateParenthesis(1));
	}

	public static List<String> generateParenthesis(int n) {
		List<String> output = new ArrayList<String>();
		generateParenthesis(n, n, "", output);
		return output;
	}

	public static void generateParenthesis(int left, int right, String currString, List<String> output) {
		if (right < left || left < 0 || right < 0)
			return;
		if (left == 0 && left == right) {
			output.add(currString);
			return;
		}
		generateParenthesis(left - 1, right, currString + "(", output);
		generateParenthesis(left, right - 1, currString + ")", output);
	}
}
