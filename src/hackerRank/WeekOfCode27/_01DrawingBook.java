package hackerRank.WeekOfCode27;

import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/contests/w27/challenges/drawing-book
 */
public class _01DrawingBook {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int p = in.nextInt();
		// your code goes here

		System.out.println(Math.min(n/2-(p/2), p/2));
	}
}

