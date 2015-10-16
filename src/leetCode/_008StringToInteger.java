package leetCode;

/*
 * Link : https://leetcode.com/problems/string-to-integer-atoi/
 */

public class _008StringToInteger{
	public static int myAtoi(String str) {	
		
		str=str.trim();
		if(str.length()==0)
			return 0;
		
		boolean negative=false;
		if(str.charAt(0)=='-')
		{
			negative=true;
			str=str.substring(1);
			if(str.length()==0)
				return 0;
		}
		else if(str.charAt(0)=='+')
		{
			str=str.substring(1);
			if(str.length()==0)
				return 0;
		}
		System.out.println(str);
		for (int i = 0; i < str.length(); i++) {
			if((int)str.charAt(i)<48 || (int)str.charAt(i)>57)
			{
				str=str.substring(0,i);
				System.out.println(str);
				if(str.length()==0)
					return 0;
				break;
			}
		}
		if(negative)
		{
			if(str.length()>10||Long.parseLong(str)>=(2147483648l))
				return 0;
			else
				return -1*Integer.parseInt(str);
		}
		else{
			if(str.length()>10||Long.parseLong(str)>Integer.MAX_VALUE)
				return 0;
			else
				return Integer.parseInt(str);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(myAtoi("2147483648"));
	}
}