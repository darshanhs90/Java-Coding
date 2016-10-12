package PracticeLeetCode;

public class _013RomanToInteger {

	public static void main(String[] args) {
		System.out.println(romanToInt("MMMCMXCIX"));
	}

	static int[] nums=new int[]{1,4,5,9,10,40,50,90,100,400,500,900,1000};
	static String[] digits=new String[]{"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};

	public static int romanToInt(String s) {
		if(s==null||s.length()==0)
			return 0;
		int stringIndex=0;
		int index=nums.length-1;
		int value=0;
		while(stringIndex<s.length() && index<nums.length)
		{
			String s1="",s2="";
			if((stringIndex+1 )<s.length())
			{
				s1=s.charAt(stringIndex)+""+s.charAt(stringIndex+1);
			}
			s2=s.charAt(stringIndex)+"";

			if(s1.contentEquals(digits[index]))
			{
				value+=nums[index];
				stringIndex+=2;
			}else if(s2.contentEquals(digits[index]))
			{
				stringIndex++;
				value+=nums[index];
			}
			else{
				index--;
			}
		}
		return value;
	}


}
