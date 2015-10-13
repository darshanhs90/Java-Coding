package leetCode;

/*
 * Link : https://leetcode.com/problems/length-of-last-word/
 */

public class _058LengthOfLastWord {
	public static int lengthOfLastWord(String s) {
		int length=0;
		if((length=s.split(" ").length)>0){
			return s.split(" ")[length-1].length();
		}
		else{
			return s.trim().length();
		}
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLastWord(" "));
	}
}