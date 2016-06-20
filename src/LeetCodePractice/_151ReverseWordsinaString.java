package LeetCodePractice;

public class _151ReverseWordsinaString {
	public static void main(String[] args) {
		System.out.println(reverseWords("the sky     is blue"));
	}
	public static String reverseWords(String s) {
		s=s.replaceAll("[ ]+", " ").trim();
		String arr[]=s.split(" ");
		StringBuilder sb=new StringBuilder("");
		for (int i = arr.length-1; i >=0; i--) {
			sb.append(arr[i]);
			if(i!=0)
				sb.append(" ");
		}
		return sb.toString();
	}
}

