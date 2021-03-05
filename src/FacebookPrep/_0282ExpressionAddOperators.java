package FacebookPrep;

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
		dfs(num, "", 0, 0l, 0l, target, output);
		return output;
	}

	public static void dfs(String num, String expression, int index, long prevNum, long evaluatedVal, int target,
			List<String> output) {
		if (index == num.length()) {
			if (evaluatedVal == target && expression.length() > num.length()) {
				output.add(expression);
			}
			return;
		}

		if (evaluatedVal > Integer.MAX_VALUE)
			return;

		for (int i = index; i < num.length(); i++) {
			String currNum = num.substring(index, i + 1);
			long currNumVal = Long.parseLong(currNum);

			if (currNum.length() > 1 && currNum.charAt(0) == '0')
				return;

			if (expression.length() == 0) {
				dfs(num, expression + currNum, i + 1, evaluatedVal + currNumVal, evaluatedVal + currNumVal, target,
						output);
			} else {
				dfs(num, expression + "+" + currNum, i + 1, currNumVal, evaluatedVal + currNumVal, target, output);

				dfs(num, expression + "-" + currNum, i + 1, -currNumVal, evaluatedVal - currNumVal, target, output);

				dfs(num, expression + "*" + currNum, i + 1, prevNum * currNumVal,
						evaluatedVal + prevNum * currNumVal - prevNum, target, output);
			}
		}
	}

}
