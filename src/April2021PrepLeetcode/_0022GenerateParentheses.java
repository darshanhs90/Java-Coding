package April2021PrepLeetcode;

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
		generateParenthesis(0, 0, n, "", output);
		return output;
	}

	public static void generateParenthesis(int left, int right, int n, String str, List<String> output) {
		if (left == right && left == n) {
			output.add(str);
			return;
		}

		if (right > left || left > n || right > n)
			return;

		generateParenthesis(left + 1, right, n, str + "(", output);
		generateParenthesis(left, right + 1, n, str + ")", output);
	}
}
