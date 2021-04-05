package Mar2021Leetcode;

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

	public static void dfs(int index, long evaluatedVal, long prevNum, String expression, String num, int target,
			List<String> list) {
		if (index == num.length()) {
			if (evaluatedVal == target && expression.length() > num.length()) {
				list.add(expression);
			}
			return;
		}

		if (index >= num.length())
			return;

		for (int i = index; i < num.length(); i++) {
			String str = num.substring(index, i + 1);
			long currNum = Long.parseLong(str);

			if (str.length() > 1 && str.charAt(0) == '0')
				return;

			if (expression.length() == 0) {
				// c == +
				dfs(i + 1, evaluatedVal + currNum, currNum, expression + currNum, num, target, list);
			} else {
				// c == +
				dfs(i + 1, evaluatedVal + currNum, currNum, expression + "+" + currNum, num, target, list);

				// c == -
				dfs(i + 1, evaluatedVal - currNum, -currNum, expression + "-" + currNum, num, target, list);

				// c == *
				dfs(i + 1, evaluatedVal - prevNum + prevNum * currNum, prevNum * currNum, expression + "*" + currNum,
						num, target, list);
			}
		}
	}

}
