package PracticeLeetCode;

public class _058LengthOfLastWord {
	public static void main(String[] args) {
		System.out.println(lengthOfLastWord("Hello Worlsd"));
	}
	public static int lengthOfLastWord(String s) {
		if(s==null||s.length()==0)
			return 0;
		String[] sArr=s.trim().split(" ");
		return sArr[sArr.length-1].length();
	}
}

