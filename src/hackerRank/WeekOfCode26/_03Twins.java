package hackerRank.WeekOfCode26;

import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/contests/w26/challenges/twins
 */
public class _03Twins {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		//find prime nos between n and m
		//n/i -1 until m/2 
		boolean[] b=new boolean[m-n+1];
		for (int j = 2; j <=m/2; j++) {
			int index=(n/j)+1==1?2:(n/j)+1;
			while(index*j<=m)
			{	
				if(index*j>=n)
				{
					b[index*j-n]=true;
				}
				index++;
			}
		}
		int count=0;
		for (int i = 0; i < b.length-2; i++) {
			if(b[i]==false &&b[i+2]==false)
			{
				count++;
			}
		}
		if(n==1 && count>0)
			count--;
		System.out.println(count);
	}
}

