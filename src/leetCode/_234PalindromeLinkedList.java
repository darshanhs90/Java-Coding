package leetCode;

/*
 * Link : https://leetcode.com/problems/reverse-integer/
 */

public class _234PalindromeLinkedList {
	public static int reverse(int x) {
		String input=String.valueOf(x);
		String output = null;
		boolean negative=false;
		if(input.contains("-"))
		{
			StringBuffer sb=new StringBuffer(input);
			output=sb.reverse().toString().replace("-","");
			negative=true;
		}
		else{
			StringBuffer sb=new StringBuffer(input);
			output=sb.reverse().toString();
		}
		if(output.length()>10)
			return 0;
		else if(output.length()==10)
		{
			if(negative)
				return checkRange(output,(Integer.MIN_VALUE+"").replace("-",""))==true?Integer.parseInt("-"+output):0;
				else
					return checkRange(output,Integer.MAX_VALUE+"")==true?Integer.parseInt(output):0;		
		}
		return negative==true?Integer.parseInt("-"+output):Integer.parseInt(output);
	}

	private static boolean checkRange(String output, String value) {

		for (int i = 0; i < output.length(); i++) {
			if(Integer.parseInt(output.charAt(i)+"")>Integer.parseInt(value.charAt(i)+""))
				return false;
			else 
				if(Integer.parseInt(output.charAt(i)+"")<Integer.parseInt(value.charAt(i)+""))
					return true;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(reverse(-2147483412));
		System.out.println(reverse(-123));
	}

}