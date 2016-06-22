package LeetCodePractice;

import java.util.Arrays;

public class _242ValidAnagram{
	public static void main(String[] args) {
		System.out.println(isAnagram("anagram","nagaram"));
		System.out.println(isAnagram("rat","car"));
		
	}
	public static boolean isAnagram(String s, String t) {
		char[] arr1=s.toCharArray();
		Arrays.sort(arr1);
		s=new String(arr1);
		arr1=t.toCharArray();
		Arrays.sort(arr1);
		t=new String(arr1);
		return s.contentEquals(t);
	}
}

