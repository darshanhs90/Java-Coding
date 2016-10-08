package PracticeLeetCode;

public class _058LengthOfLastWord {
	public static void main(String[] args) {
		System.out.println(lengthOfLastWord("Hello World"));
	}
	public static int lengthOfLastWord(String s) {
		if(s==null||s.length()==0)
			return 0;
		String []arr=s.split(" ");
		if(arr.length>0)
			return arr[arr.length-1].length();
		return 0;
	}
}

