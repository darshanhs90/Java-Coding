package LeetCodePractice;

import java.math.BigInteger;

public class _08StringtoInteger_atoi {

	public static void main(String[] args) {
		System.out.println(myAtoi("123"));
	}
	public static int myAtoi(String str) {
		str=str.trim();
		if(str.length()==0)
			return 0;
		StringBuilder output=new StringBuilder();
		int count=0;
		for (int i = 0; i < str.length(); i++) {
			char c=str.charAt(i);
			if(c=='-' || c=='+' )
			{	
				if(count>0)
					break;
				output.append(c);
				count++;
			}
			else if(Character.isDigit(c)){
				output.append(c);
				count++;
			}
			else {
				break;
			}
		}

		if(output.toString().length()==0)
			return 0;
		try{
			BigInteger b=new BigInteger(output.toString());
			if(b.compareTo(new BigInteger(Integer.MAX_VALUE+""))==1)
			{
				return Integer.MAX_VALUE;
			}
			else if(b.compareTo(new BigInteger(Integer.MIN_VALUE+""))==-1)
			{
				return Integer.MIN_VALUE;
			}
			long  value=Long.parseLong(output.toString());
			if(value>Integer.MAX_VALUE)
				return Integer.MAX_VALUE;
			else if(value<Integer.MIN_VALUE)
				return Integer.MIN_VALUE;

			return Integer.parseInt(output.toString());
		}catch(NumberFormatException e){
			return 0;
		}
	}
}
