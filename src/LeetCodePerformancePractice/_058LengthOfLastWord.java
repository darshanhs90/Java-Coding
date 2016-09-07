package LeetCodePerformancePractice;

public class _058LengthOfLastWord {
	public static void main(String[] args) {
		System.out.println(lengthOfLastWord("Hello World"));

	}
	public static int lengthOfLastWord(String s) {
		return s.split(" ").length>0?s.split(" ")[s.split(" ").length-1].length():0;
	}
}

