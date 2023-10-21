package Oct2023Leetcode;

public class _0058LengthOfLastWord {

	public static void main(String[] args) {
		System.out.println(lengthOfLastWord("Hello World"));
		System.out.println(lengthOfLastWord(" "));
	}

	public static int lengthOfLastWord(String s) {
		s = s.trim();
		String[] arr = s.split(" ");
		return arr.length > 0 ? arr[arr.length - 1].length() : 0;
	}

}
