package hackerRank.WeekOfCode28;

import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/contests/w28/challenges/boat-trip
 */
public class _01BoatTrips {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c = in.nextInt();
        int m = in.nextInt();
        int[] p = new int[n];
        int maxCapacity=m*c;
        for(int p_i=0; p_i < n; p_i++){
            p[p_i] = in.nextInt();
            if(p[p_i]>maxCapacity)
            {
            	System.out.println("No");
            	System.exit(0);
            }
        }
        System.out.println("Yes");
    }
}

