package PracticeLeetCode;

public class _008atoi {
	public static void main(String[] args) {
		System.out.println(myAtoi("9223372036854775809"));
	}
	public static int myAtoi(String str) {
		if(str==null||str.length()==0)
			return 0;
		str=str.trim();
		boolean isNegative=false;
		int i=0;
		if(str.charAt(0)=='+')
		{
			i++;
		}
		else if(str.charAt(0)=='-')
		{
			isNegative=true;
			i++;
		}
		double result=0;
		while(i<str.length() && str.charAt(i)>='0' && str.charAt(i)<='9')
		{
			result=result*10+Character.getNumericValue(str.charAt(i));
			i++;
		}
		if(isNegative)
			result=-result;
		if(result>Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
		else if(result<Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
		return (int)result;

asd
	}




}
