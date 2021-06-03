package May2021GoogLeetcode;

public class _0294FlipGameII {

	public static void main(String[] args) {
		System.out.println(canWin("++++"));
		System.out.println(canWin("+"));
		System.out.println(canWin("+++++"));
	}

	public static boolean canWin(String str) {
		if (str == null || str.length() < 2)
			return false;
		return dfs(str);
	}

	public static boolean dfs(String str) {
		for (int i = 0; i < str.length() - 1; i++) {
			if (str.charAt(i) == '+' && str.charAt(i + 1) == '+') {
				String newString = str.substring(0, i) + "--" + str.substring(i + 2);
				if (!dfs(newString))
					return true;
			}
		}
		return false;
	}

}
