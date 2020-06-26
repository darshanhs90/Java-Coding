package PracticeLeetCode;

import java.util.Arrays;

public class _344ReverseString {
	public static void main(String[] args) {
		reverseString(new char[] {'h','e','l','l','o'});
		reverseString(new char[] {'H','a','n','n','a','h'});
	}

	public static void reverseString(char[] s) {
		int startIndex = 0;
		int endIndex = s.length - 1;
		while(startIndex < endIndex)
		{
			char temp = s[startIndex];
			s[startIndex] = s[endIndex];
			s[endIndex] = temp;
			startIndex ++;
			endIndex -- ;
		}
		System.out.println(Arrays.toString(s));
	}
}
