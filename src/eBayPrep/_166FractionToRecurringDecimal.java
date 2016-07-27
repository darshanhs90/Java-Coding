package eBayPrep;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _166FractionToRecurringDecimal {

	public static void main(String[] args) {
		System.out.println(fractionToDecimal(1,2));
		System.out.println(fractionToDecimal(-2,1));
		System.out.println(fractionToDecimal(2,3));
		System.out.println(fractionToDecimal(13,7));
		System.out.println(fractionToDecimal(4,333));
	}
	public static String fractionToDecimal(int numerator, int denominator) {
		long a=numerator;
		long b=denominator;
		double val=a/(double)b;
		System.out.println(val);
		String str=String.valueOf(val);
		StringBuilder sb=new StringBuilder();
		String arr[]=str.split("\\.");
		sb.append(arr[0]);
		Set<String> set=new HashSet<>();
		str=arr[1];
		if(str.length()!=1){
			for (int i = 0; i < str.length(); i++) {
				if(set.contains(str.charAt(i)+""))
				{
					str=str.substring(0,i);
					break;
				}
				else{
					set.add(str.substring(0,i));
				}
			}
			sb.append(".("+str+")");
		}
		else{
			sb.append("."+str);
		}
		return sb.toString();
	}

}

