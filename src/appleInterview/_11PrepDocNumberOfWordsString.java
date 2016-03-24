package appleInterview;

import java.util.Arrays;

public class _11PrepDocNumberOfWordsString {
	public static void main(String[] args) {
		String str="Alive is     asd awesome ";
		System.out.println(countWords(str));
	}

	private static int countWords(String str) {
		str=str.replaceAll("//s+", " ");
		String arr[]=str.split(" +");
		System.out.println(Arrays.toString(arr));
		return arr.length;
	}
}
