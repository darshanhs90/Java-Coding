package PracticeLeetCode;

public class _345ReverseVowelsOfString {
	public static void main(String[] args) {
		System.out.println(reverseVowels("hello"));
		System.out.println(reverseVowels("leetcode"));
	}

	public static String reverseVowels(String s) {
		int startIndex = 0;
		int endIndex = s.length() - 1;
		char[] cArr = s.toCharArray();
		while(startIndex < endIndex)
		{
			boolean isStartVowel = isVowel(cArr[startIndex]);
			boolean isEndVowel = isVowel(cArr[endIndex]);
			if(isStartVowel && isEndVowel)
			{
				char c = cArr[startIndex];
				cArr[startIndex] = cArr[endIndex];
				cArr[endIndex] = c;
				startIndex ++ ;
				endIndex --;
			}
			else if(!isStartVowel)
			{
				startIndex++;
			}
			else
			{
				endIndex--;
			}
		}
		return new String(cArr);
	}

	public static boolean isVowel(char c)
	{
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
				|| c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
	}

}
