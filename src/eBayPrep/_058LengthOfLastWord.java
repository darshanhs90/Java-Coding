package eBayPrep;

public class _058LengthOfLastWord {


	public static void main(String[] args) {
		System.out.println(lengthOfLastWord(" "));
		System.out.println(lengthOfLastWord("Hello world"));
	}

	public static int lengthOfLastWord(String s) {
		String  arr[]=s.split(" ");
		return arr.length>0?arr[arr.length-1].length():0;
	}
}

