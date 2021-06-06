package June2021GoogLeetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class _0022GenerateParentheses {

	public static void main(String[] args) {
		System.out.println(generateParenthesis(3));
		System.out.println(generateParenthesis(1));
	}

	public static List<String> generateParenthesis(int n) {
		if (n <= 0)
			return new ArrayList<String>();
		HashSet<String> out = new HashSet<String>();
		dfs(0, 0, "", n, out);
		return new ArrayList<String>(out);
	}

	public static void dfs(int left, int right, String str, int n, HashSet<String> out) {
		if (right > left || left > n || right > n)
			return;
		if (left == right && left == n) {
			out.add(str);
			return;
		}

		dfs(left + 1, right, str + "(", n, out);
		dfs(left, right + 1, str + ")", n, out);
	}
}
