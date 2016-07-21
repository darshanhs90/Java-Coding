package eBayPrep;

public class _009RomanToInteger {

	public static void main(String[] args) {
		System.out.println(romanToInt("DCXXI"));
	}
	public static int romanToInt(String s) {
		String dict[] = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
		int val[] = {1000,900,500,400,100,90,50,40,10,9,5,4,1};  
		int stringIndex=0;
		int dictIndex=0;
		int value=0;
		while(dictIndex<dict.length)
		{
			String subString="";
			int incrementValue=0;
			if(stringIndex<s.length())
			{
				subString=s.substring(stringIndex,stringIndex+1);
				incrementValue=1;
				if(subString.contentEquals(dict[dictIndex]))
				{
					stringIndex+=incrementValue;
					value+=val[dictIndex];
					continue;
				}
			}
			else
				break;
			
			if(stringIndex+1<s.length())
			{
					subString=s.substring(stringIndex, stringIndex+2);
					incrementValue=2;
					if(subString.contentEquals(dict[dictIndex]))
					{
						stringIndex+=incrementValue;
						value+=val[dictIndex];
						continue;
					}
					else{
						dictIndex++;
					}
			}
			else
				dictIndex++;
		}
		return value;
	}
}
