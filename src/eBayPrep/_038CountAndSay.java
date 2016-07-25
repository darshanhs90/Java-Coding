package eBayPrep;

public class _038CountAndSay {

	public static void main(String[] args) {
		System.out.println(countAndSay(1));
		System.out.println(countAndSay(2));
		System.out.println(countAndSay(3));
		System.out.println(countAndSay(4));
		System.out.println(countAndSay(5));
	}

	public static String countAndSay(int n) {
		String value="1";
		while(n!=1)
		{
			String str=value;
			char prevChar=str.charAt(0);
			int prevCharCount=1;
			StringBuilder sb=new StringBuilder();
			for (int i = 1; i < str.length(); i++) {
				char presentChar=str.charAt(i);
				if(prevChar==presentChar)
				{
					prevCharCount++;
				}
				else{
					sb.append(prevCharCount+""+prevChar);
					prevChar=presentChar;
					prevCharCount=1;
				}
			}
			sb.append(prevCharCount+""+prevChar);
			value=sb.toString();
			n--;
		}
		return value;
	}
}
