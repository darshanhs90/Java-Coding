package hackerRank.CrackingTheCodingInterview;

import java.util.Scanner;

public class _18RecursionDavisStaircase {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int s = in.nextInt();
		for(int a0 = 0; a0 < s; a0++){
			int n = in.nextInt();
			System.out.println(findStairWays(0,n));
		}
	}

	private static int findStairWays(int curr,int n) {
		if(curr>n)
			return 0;
		if(curr==n)
			return 1;
		int count1=0,count2=0,count3=0;
		if((curr+1)<=n)
			count1+=findStairWays(curr+1,  n);
		if((curr+2)<=n)
			count2+=findStairWays(curr+2, n);
		if((curr+3)<=n)
			count3+=findStairWays(curr+3, n);
		return count1+count2+count3;
	}



}
