package May2021GoogLeetcode;

import java.util.ArrayList;
import java.util.List;

public class _0022GenerateParentheses {

	public static void main(String[] args) {
		System.out.println(generateParenthesis(3));
		System.out.println(generateParenthesis(1));
	}

	public static List<String> generateParenthesis(int n) {
		List<String> list = new ArrayList<String>();
		dfs(0, 0, n, "", list);
		return list;
	}

	public static void dfs(int left, int right, int n, String str, List<String> list) {
		if (left == n && left == right) {
			list.add(str);
			return;
		}
		if (left > n || right > n || right > left)
			return;
		dfs(left + 1, right, n, str + "(", list);
		dfs(left, right + 1, n, str + ")", list);
	}
}
