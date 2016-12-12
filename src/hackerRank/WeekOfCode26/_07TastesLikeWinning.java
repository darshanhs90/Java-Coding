package hackerRank.WeekOfCode26;

import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/contests/w26/challenges/hard-homework
 */
public class _07TastesLikeWinning {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m=in.nextInt();
		m=(int) Math.pow(2, m);
		long value=calculateCombination(m);
		long value2=calculateCombination(m-n);
		long value3=calculateCombination(n);
		long output=value/(value2*value3);
		output=output%(1000000000+7);
		System.out.println(output);
		
	}

	private static long calculateCombination(int n) {
		long value=1;
		for (int i = 1; i <=n; i++) {
			value=value*i;
		}
		return value;
	}
}

