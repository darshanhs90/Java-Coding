package FacebookPrep;

import java.util.ArrayList;
import java.util.List;

public class _0022GenerateParentheses {

	public static void main(String[] args) {
		System.out.println(generateParenthesis(3));
		System.out.println(generateParenthesis(1));
	}

	public static List<String> generateParenthesis(int n) {
		List<String> list = new ArrayList<String>();
		generateParentheseis(0, 0, "", n, list);
		return list;
	}

	public static void generateParentheseis(int left, int right, String currString, int n, List<String> list) {
		if (left == right && left == n) {
			list.add(currString);
			return;
		}
		if (right > left || left > n || right > n)
			return;
		generateParentheseis(left + 1, right, currString + "(", n, list);
		generateParentheseis(left, right + 1, currString + ")", n, list);
	}
}
