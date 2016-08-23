package hackerRank.Hack40_101;

import java.util.Scanner;

public class _02LazyMayorAndLasers {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N=scanner.nextInt();
		int[] height=new int[N+1];
		height[0]=0;
		int[] mainHeight=new int[N+1];
		mainHeight[0]=0;
		
		for (int i = 1; i <=N; i++) {
			height[i]=scanner.nextInt();
			mainHeight[i]=height[i];
		}
		int M=scanner.nextInt();
		int[] lasers=new int[M];
		for (int i = 0; i < lasers.length; i++) {
			lasers[i]=scanner.nextInt();
		}
		for (int i = lasers.length-1; i >=0; i--) {
			int diff=1;
			for (int j = lasers[i]-1; j >0; j--) {
				if(mainHeight[j]>diff && height[j]>diff)
				{
					height[j]=diff;
				}
				diff+=1;
			}
		}
		int sum=0;
		for (int i = 0; i <=N; i++) {
			sum+=height[i];
		}
		System.out.println(sum);
	}
}

