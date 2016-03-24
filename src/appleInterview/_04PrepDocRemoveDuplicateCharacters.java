package appleInterview;

public class _04PrepDocRemoveDuplicateCharacters {
	public static void main(String[] args) {
		String str="aaaassssdeeefgddaa";
		System.out.println(removeChars(str));
	}

	private static String removeChars(String str) {
		char c=str.charAt(0);
		for (int j = 1; j < str.length(); j++) {
			char newChar=str.charAt(j);
			if(c==newChar)
			{
				str=str.substring(0,j)+str.substring(j+1);
				j--;
			}
			else{
				c=newChar;
			}
		}
		return str;
	}
}
