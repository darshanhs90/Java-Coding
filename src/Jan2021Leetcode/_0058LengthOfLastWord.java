package Jan2021Leetcode;

public class _0058LengthOfLastWord {

	public static void main(String[] args) {
		System.out.println(lengthOfLastWord("Hello World"));
		System.out.println(lengthOfLastWord(" "));
	}

	public static int lengthOfLastWord(String s) {
		s.trim();
		String[] sArr = s.split(" ");
		return sArr.length == 0 ? 0 : sArr[sArr.length - 1].length();
	}

}
