package PracticeLeetCode;

public class _345ReverseVowelsOfString {
	public static void main(String[] args) {
		System.out.println(reverseVowels("hello"));
		System.out.println(reverseVowels("leetcode"));
	}
	public static String reverseVowels(String s) {
		if(s==null||s.length()<=1)
			return s;
		int left=0,right=s.length()-1;
		char strArr[]=s.toCharArray();
		while(left<right)
		{
			while(left<right && !isVowel(strArr[left]))
			{
				left++;
			}
			while(left<right && !isVowel(strArr[right]))
			{
				right--;
			}	
			if(left<right)
			{
				char temp=strArr[left];
				strArr[left]=strArr[right];
				strArr[right]=temp;
				left++;
				right--;
			}
		}
		return new String(strArr);
	}
	private static boolean isVowel(char c) {
		return (c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||c=='A'||c=='E'||c=='I'||c=='O'||c=='U');
	}
}
