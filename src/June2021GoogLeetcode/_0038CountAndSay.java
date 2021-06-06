package June2021GoogLeetcode;

public class _0038CountAndSay {

	public static void main(String[] args) {
		System.out.println(countAndSay(1));
		System.out.println(countAndSay(4));
	}

	public static String countAndSay(int n) {
		if (n == 1)
			return "1";
		StringBuilder sb = new StringBuilder("1");
		int count = 1;
		while (count < n) {
			String startingString = sb.toString();
			sb = new StringBuilder();
			char prevChar = startingString.charAt(0);
			int counter = 1;
			for (int i = 1; i < startingString.length(); i++) {
				char currChar = startingString.charAt(i);
				if (prevChar == currChar) {
					counter++;
				} else {
					sb = sb.append(counter + "" + prevChar);
					prevChar = currChar;
					counter = 1;
				}
			}
			sb = sb.append(counter + "" + prevChar);
			count++;
		}
		return sb.toString();
	}

}
