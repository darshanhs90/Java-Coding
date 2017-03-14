package hackerRank.WeekOfCode30;

import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/contests/w30/challenges/candy-replenishing-robot
 */
public class _01CandyReplenishingRobot {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int t = in.nextInt();
        int[] c = new int[t];
        for(int c_i=0; c_i < t; c_i++){
            c[c_i] = in.nextInt();
        }
        // your code goes here
        
        long curr=n,added=0;
        for (int i = 0; i < c.length; i++) {
			curr-=c[i];
			if(i!=c.length-1 && curr<5)
			{
				added+=(n-curr);
				curr+=(n-curr);
			}
		}
        System.out.println(added);
        
    }
}

