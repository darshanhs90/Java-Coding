package Nov2020_GoogPrep;

import java.util.ArrayList;
import java.util.List;

public class _051GenerateParentheses {

	public static void main(String[] args) {
		System.out.println(generateParenthesis(3));
		System.out.println(generateParenthesis(1));
	}

	public static List<String> generateParenthesis(int n) {
		List<String> output = new ArrayList<String>();
		if (n == 0)
			return output;
		generateParenthesis("", 0, 0, n, output);
		return output;
	}

	public static void generateParenthesis(String currString, int left, int right, int n, List<String> output) {
		if (left == n && right == n) {
			output.add(currString);
			return;
		}
		if (right > left || left < 0 || right < 0 || left > n || right > n)
			return;
		generateParenthesis(currString + "(", left + 1, right, n, output);
		generateParenthesis(currString + ")", left, right + 1, n, output);
	}
}
