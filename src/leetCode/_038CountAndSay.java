package leetCode;

	import java.math.BigInteger;

/*
 * Link : https://leetcode.com/problems/count-and-say/
 */

public class _038CountAndSay {
	public static String countAndSay(int n) {
		BigInteger start=new BigInteger("1");
		for (int i = 0; i < n-1; i++) {
			//System.out.println(start);
			String numberString=String.valueOf(start);
			char prevChar=' ';
			int prevCharCount=0;
			//boolean ended=true;
			StringBuffer sb=new StringBuffer();
			for (int j = 0; j < numberString.length(); j++) {
				if(prevChar==' ')
				{
					prevCharCount=1;
					prevChar=numberString.charAt(j);
				}
				else{
					if(prevChar==numberString.charAt(j))
					{
						prevCharCount++;
					}
					else{
						sb.append(prevCharCount+""+prevChar);
						prevChar=numberString.charAt(j);
						prevCharCount=1;
					}
				}
			}
			sb.append(prevCharCount+""+prevChar);
			start=new BigInteger(sb.toString());
			System.out.println(start);
		}
		return start.toString();
	}
	public static void main(String[] args) {
		System.out.println(countAndSay(1));
	}
}