package hackerRank.WeekOfCode32;

import java.util.Arrays;
import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/contests/w30/challenges/candy-replenishing-robot
 */
public class _02FightTheMonsters {
	static int getMaxMonsters(int n, int hit, int t, int[] h){
		int count=0,index=0,output=0;
		while(count<t)
		{
			if((h[index]-hit)<=0)
			{
				index++;
				output++;
			}
			else{
				h[index]=h[index]-hit;
			}
			count++;
		}
		return output;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int hit = in.nextInt();
		int t = in.nextInt();
		int[] h = new int[n];
		for(int h_i=0; h_i < n; h_i++){
			h[h_i] = in.nextInt();
		}
		Arrays.sort(h);
		int result = getMaxMonsters(n, hit, t, h);
		System.out.println(result);
	}
}
