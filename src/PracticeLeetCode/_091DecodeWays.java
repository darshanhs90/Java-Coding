package PracticeLeetCode;

public class _091DecodeWays {
	public static void main(String[] args) {
		System.out.println(numDecodings("12"));
	}
	public static int numDecodings(String s) {
		if(s==null||s.length()==0)
			return 0;
		if(s.length()==1 && s.charAt(0)!='0')
			return 1;
		int dp[]=new int[s.length()];
		if(s.charAt(0)=='0')
			dp[0]=0;
		else
			dp[0]=1;
		String st=s.substring(0,2);
		if(Integer.parseInt(st)>26)
		{
			if(s.charAt(1)=='0')
				dp[1]=0;
			else
				dp[1]=1;
		}
		else{
			if(s.charAt(1)=='0')
				dp[1]=1;
			else
				dp[1]=2;
		}

		for (int i = 2; i < dp.length; i++) {
			if(s.charAt(i)!='0')
				dp[i]=dp[i-1];
			st=s.substring(i-1,i+1);
			if(Integer.parseInt(st)>=10 && Integer.parseInt(st)<=26)
				dp[i]+=dp[i-2];
		}
		return dp[dp.length-1];		
	}

}
