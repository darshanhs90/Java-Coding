package PracticeLeetCode;

public class _345ReverseVowelsOfString {
	public static void main(String[] args) {
		System.out.println(reverseVowels("hello"));
		System.out.println(reverseVowels("leetcode"));
	}
	public static String reverseVowels(String s) {
		int left=0,right=s.length()-1;
		char[] c=s.toCharArray();
		while(left<right)
		{
			while(left<right && !isVowel(c[left]))
			{
				left++;
			}
			while(left<right && !isVowel(c[right]))
			{
				right--;
			}
			if(left<right)
			{
				char temp=c[right];
				c[right]=c[left];
				c[left]=temp;
				left++;
				right--;
			}
		}
		return new String(c);
		
	}
	private static boolean isVowel(char c) {
		return c=='A'||c=='a'||c=='E'||c=='e'
				||c=='I'||c=='i'||c=='O'||c=='o'||c=='U'||c=='u';
	}
}
