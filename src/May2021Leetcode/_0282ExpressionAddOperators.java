package May2021Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0282ExpressionAddOperators {

	public static void main(String[] args) {
		System.out.println(addOperators("123", 6));
		System.out.println(addOperators("232", 8));
		System.out.println(addOperators("105", 5));
		System.out.println(addOperators("00", 0));
		System.out.println(addOperators("3456237490", 9191));
	}

	public static List<String> addOperators(String num, int target) {
		List<String> output = new ArrayList<String>();
		dfs(0, 0l, 0l, "", num, target, output);
		return output;
	}

	public static void dfs(int index, long eval, long prevVal, String expr, String num, int target,
			List<String> output) {
		if (index == num.length()) {
			if (eval == target) {
				output.add(expr);
			}
			return;
		}

		if (eval > Integer.MAX_VALUE)
			return;

		String str = "";
		for (int i = index; i < num.length(); i++) {
			str += num.charAt(i);

			if (str.length() > 1 && str.charAt(0) == '0')
				return;

			long val = Long.parseLong(str);

			if (expr.length() == 0) {
				dfs(i + 1, val, val, expr + val, num, target, output);
			} else {
				dfs(i + 1, eval + val, val, expr + "+" + val, num, target, output);
				dfs(i + 1, eval - val, -val, expr + "-" + val, num, target, output);
				dfs(i + 1, eval - prevVal + prevVal * val, prevVal * val, expr + "*" + val, num, target, output);
			}
		}
	}

}
