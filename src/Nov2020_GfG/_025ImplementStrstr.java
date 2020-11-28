package Nov2020_GfG;

public class _025ImplementStrstr {

	public static void main(String[] args) {
		System.out.println(strstr("GeeksForGeeks", "Fr"));
		System.out.println(strstr("GeeksForGeeks", "For"));
		System.out.println(strstr("aaaaaaaaaaaaaab", "aaaab"));
	}

	static int strstr(String str, String target) {
		for (int i = 0; i <= str.length() - target.length(); i++) {
			boolean stringMatches = true;
			for (int j = i; j-i < target.length(); j++) {
				if (str.charAt(j) != target.charAt(j - i)) {
					stringMatches = false;
					break;
				}
			}
			if (stringMatches)
				return i;
		}
		return -1;
	}
}
