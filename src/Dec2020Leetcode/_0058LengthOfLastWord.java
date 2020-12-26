package Dec2020Leetcode;

public class _0058LengthOfLastWord {

	public static void main(String[] args) {
		System.out.println(lengthOfLastWord("Hello World"));
		System.out.println(lengthOfLastWord(" "));
	}

	public static int lengthOfLastWord(String s) {
		String[] sArr = s.split(" ");
		if (sArr.length == 0)
			return 0;
		return sArr[sArr.length - 1].length();
	}

}
