package leetCode;

/*
 * Link : https://leetcode.com/problems/move-zeroes/
 */

public class _013RomanToInteger {
	public static int romanToInt(String s) {
		int value=0;
		Integer prevValue=null;
		if(s.length()!=0)
		{	
			for (int i = s.length()-1; i>=0;i--) {
				int romanValue=romanTable(s.charAt(i));
				System.out.println(value);
				if(prevValue==null)
				{
					prevValue=romanValue;
					value+=romanValue;
				}
				else{
					if(prevValue>romanValue)
					{
						value-=romanValue;
					}
					else{
						value+=romanValue;
						prevValue=romanValue;
					}
				}
			}
		}
		return value;
	}
	public static int romanTable(char c){
		int num = 0;
		switch(c){
		case 'I':
			num = 1;
			break;
		case 'V':
			num = 5;
			break;
		case 'X':
			num = 10;
			break;
		case 'L':
			num = 50;
			break;
		case 'C':
			num = 100;
			break;
		case 'D':
			num = 500;
			break;
		case 'M':
			num = 1000;
			break;
		default:
			num = 0;
			break;
		}
		return num;
	}
	

	public static void main(String[] args) {
		System.out.println(romanToInt("MMMMCMXCIX"));
	}
}