package hackerRank.Algorithms.Implementation;

import java.util.Scanner;
/*
 * https://www.hackerrank.com/challenges/bon-appetit
 */
public class _28BonAppetit {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int[] c=new int[n];
		int sum=0;
		for (int i = 0; i < n; i++) {
			c[i]=in.nextInt();
			if(i!=k)
				sum+=c[i];
		}
		int bCharged=in.nextInt();
		System.out.println(bCharged!=sum/2?bCharged-(sum/2):"Bon Appetit");
	}
}
