package yelpInterview;

public class _Leetcode05ReverseInteger {


	public static void main(String[] args) {
		//System.out.println(reverse(9646324351));
		System.out.println(reverse(-321));

	}


	@SuppressWarnings("finally")
	public static int reverse(int x) {
		try{
		String s=new StringBuilder(x+"").reverse().toString();
		if(x<0)
			return Integer.parseInt(s.substring(0, s.length()-1))*-1;
		else
			return Integer.parseInt(s);
		}catch(Exception e)
		{
			return 0;
		}
		finally {
			
		}
	}

}

