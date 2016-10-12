package PracticeLeetCode;

public class _091DecodeWays {
	public static void main(String[] args) {
		System.out.println(numDecodings("12"));
	}
	public static int numDecodings(String s) {
		if(s==null||s.length()==0||s.charAt(0)=='0')
			return 0;
		if(s.length()==1)
			return 1;
		int dp[]=new int[s.length()];
		dp[0]=1;
		String str=s.substring(0,2);
		if(Integer.parseInt(str)>26)
		{
			if(str.charAt(1)=='0')
				dp[1]=0;
			else
				dp[1]=1;
		}
		else{
			if(str.charAt(1)=='0')
				dp[1]=1;
			else
				dp[1]=2;
		}
		for (int i = 2; i < s.length(); i++) {
			if(s.charAt(i)!='0')
				dp[i]=dp[i-1];
			str=s.substring(i-1,i+1);
			if(Integer.parseInt(str)>=10 && Integer.parseInt(str)<=26 )
				dp[i]+=dp[i-2];
		}
		return dp[dp.length-1];

	}

}
