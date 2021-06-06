package June2021GoogLeetcode;

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
		dfs(0, 0l, 0l, "", num, target, out);
		return out;
	}

	public static void dfs(int index, long eval, long prev, String expr, String num, int target, List<String> out) {
		if (index == num.length()) {
			if (eval == target) {
				out.add(expr);
			}
			return;
		}

		if (eval > Integer.MAX_VALUE)
			return;

		String str = "";
		for (int i = index; i < num.length(); i++) {
			str += num.charAt(i);
			Long currVal = Long.parseLong(str);

			if (str.length() > 1 && str.charAt(0) == '0')
				break;

			if (expr.length() == 0) {
				dfs(i + 1, currVal, currVal, currVal + "", num, target, out);
			} else {
				dfs(i + 1, eval + currVal, currVal, expr + "+" + currVal, num, target, out);
				dfs(i + 1, eval - currVal, -currVal, expr + "-" + currVal, num, target, out);
				dfs(i + 1, eval + prev * currVal - prev, prev * currVal, expr + "*" + currVal, num, target, out);
			}
		}
	}

}
