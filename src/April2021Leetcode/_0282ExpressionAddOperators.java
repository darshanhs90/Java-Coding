package April2021Leetcode;

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
		List<String> out = new ArrayList<String>();
		if (num == null || num.length() == 0)
			return out;
		dfs(0, 0l, 0l, "", num, target, out);
		return out;
	}

	public static void dfs(int index, long evaluatedVal, long prevVal, String expression, String num, int target,
			List<String> output) {
		if (index == num.length()) {
			if (evaluatedVal == target) {
				output.add(expression);
			}
			return;
		}

		if (evaluatedVal > Integer.MAX_VALUE)
			return;
		String str = "";
		for (int i = index; i < num.length(); i++) {
			str += num.charAt(i);
			if (str.length() > 1 && str.charAt(0) == '0')
				return;
			long currVal = Long.parseLong(str);
			if (expression.length() == 0) {
				dfs(i + 1, currVal, currVal, expression + str, num, target, output);
			} else {
				dfs(i + 1, evaluatedVal + currVal, currVal, expression + "+" + str, num, target, output);

				dfs(i + 1, evaluatedVal - currVal, -currVal, expression + "-" + str, num, target, output);

				dfs(i + 1, evaluatedVal - prevVal + prevVal * currVal, prevVal * currVal, expression + "*" + str, num,
						target, output);
			}
		}
	}

}
