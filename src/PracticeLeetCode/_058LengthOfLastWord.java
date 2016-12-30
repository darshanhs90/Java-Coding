package PracticeLeetCode;

public class _058LengthOfLastWord {
	public static void main(String[] args) {
		System.out.println(lengthOfLastWord("Hello Worlsd"));
	}
	public static int lengthOfLastWord(String s) {
		String[] strArr=s.trim().split(" ");
		return strArr.length>0?strArr[strArr.length-1].length():0;
	}
}

