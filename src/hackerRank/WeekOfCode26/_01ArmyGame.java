package hackerRank.WeekOfCode26;

import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/contests/w26/challenges/game-with-cells
 */
public class _01ArmyGame {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int rows = (n%2) + (n/2);
	    int cols = (m%2) + (m/2);
	    System.out.println(rows*cols);
	}
}

//2 2->1
