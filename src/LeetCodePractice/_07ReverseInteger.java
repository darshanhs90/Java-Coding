package LeetCodePractice;

public class _07ReverseInteger {

	public static void main(String[] args) {
		System.out.println(reverse(123));
		System.out.println(reverse(-123));		
	}
	public static int reverse(int x) {
		try{
			if(x<0)
			{
				return -1*Integer.parseInt(new StringBuilder(new String(x+"").substring(1)).reverse().toString());
			}
			else{
				return Integer.parseInt(new StringBuilder(new String(x+"")).reverse().toString());
			}
		}catch(NumberFormatException e){
			return 0;
		}
	}
}
