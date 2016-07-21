package LeetCodePractice;

public class _058LengthOfLastWord {


	public static void main(String[] args) {
		System.out.println(lengthOfLastWord(" "));
		System.out.println(lengthOfLastWord("Hello world"));
	}

	public static int lengthOfLastWord(String s) {
		if(s.split(" ").length==0)
			return 0;
		return s.split(" ")[s.split(" ").length-1].length();
	}
}

