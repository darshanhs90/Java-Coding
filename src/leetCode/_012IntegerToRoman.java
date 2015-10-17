package leetCode;

/*
 * Link : https://leetcode.com/problems/palindrome-number/
 */

public class _012IntegerToRoman {
	public static String intToRoman(int num) {
		 String symbol[]={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};    
	     int value[]=    {1000,900,500,400, 100, 90,  50, 40,  10, 9,   5,  4,   1};
	     String str="";
	     if(num>0)
	     {
	    	for (int i = 0; i < value.length; i++) {
				while(num>=value[i])
				{
					num-=value[i];
					str+=symbol[i];
				}
			} 
	    	 
	     }
		return str;
	}

	public static void main(String[] args) {
		System.out.println(intToRoman(3999))	;
	}
}