package Nov2020_GfG;

public class _018DecodeThePattern {

	public static void main(String[] args) {
		System.out.println(findNthCountAndSay(1));
		System.out.println(findNthCountAndSay(2));
		System.out.println(findNthCountAndSay(3));
		System.out.println(findNthCountAndSay(4));
		System.out.println(findNthCountAndSay(5));
	}

	static String findNthCountAndSay(int n) {
		if (n == 1)
			return "1";
		return findNthCountAndSay("1", n - 1);
	}

	static String findNthCountAndSay(String currString, int n) {
		if (n == 0)
			return currString;
		int count = 1;
		char prevChar = currString.charAt(0);
		String str = "";
		for (int i = 1; i < currString.length(); i++) {
			char currChar = currString.charAt(i);
			if (prevChar == currChar)
				count++;
			else {
				str += count + "" + prevChar;
				prevChar = currChar;
				count = 1;
			}
		}
		str += count + "" + prevChar;
		return findNthCountAndSay(str, n - 1);
	}

}
