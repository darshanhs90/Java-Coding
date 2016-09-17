package LeetCodePerformancePractice;

public class _345ReverseVowelsOfString {
	public static void main(String[] args) {
		System.out.println(reverseVowels("hello"));
		System.out.println(reverseVowels("leetcode"));
	}
	public static String reverseVowels(String s) {
		return reverseVowel(s.toCharArray(),0,s.length()-1);
	}
	private static String reverseVowel(char[] c, int i, int j) {
		while(i<j)
		{
			while(i<j && i<c.length && !isVowel(c[i])){
				i++;
			}
			while(i<j && j>=0 && !isVowel(c[j])){
				j--;
			}
			if(i<j && i<c.length && j>=0)
			{
				char c1=c[i];
				c[i]=c[j];
				c[j]=c1;
				i++;
				j--;
			}
		}
		return new String(c);
	}
	private static boolean isVowel(char c) {
		return c=='a'||c=='A'||c=='e'||c=='E'||c=='i'||c=='I'||c=='o'||c=='O'||c=='u'||c=='U';
	}
}
