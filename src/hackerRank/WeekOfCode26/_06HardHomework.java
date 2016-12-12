package hackerRank.WeekOfCode26;

import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/contests/w26/challenges/hard-homework
 */
public class _06HardHomework {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		double max=Double.MIN_VALUE;
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < n; j++) {
				if(i+j>=n)
					break;
				int k=n-i-j;
				max=Math.max(max, Math.sin(i)+Math.sin(j)+Math.sin(k));
			}
		}
		System.out.printf("%.9f", max);
	}
}

