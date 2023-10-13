package Oct2023Leetcode;

import java.util.Arrays;

public class _0344ReverseString {

	public static void main(String[] args) {
		reverseString(new char[] { 'h', 'e', 'l', 'l', 'o' });
		reverseString(new char[] { 'h', 'a', 'n', 'n', 'a', 'H' });
	}

	public static void reverseString(char[] s) {
		int left = 0, right = s.length - 1;
		while (left < right) {
			char temp = s[right];
			s[right] = s[left];
			s[left] = temp;
			left++;
			right--;
		}
		System.out.println(Arrays.toString(s));
	}
}
