package hackerRank.WeekOfCode30;

import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/contests/w30/challenges/find-the-minimum-number
 */
public class _02FindTheMinimumNumber {



	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		StringBuilder sb=new StringBuilder();
		int forwardBraces=0;
		for (int i = 0; i <n-1; i++) {
			if(i<n-2){
				sb.append("min(int, ");
				forwardBraces++;
			}
			else
			{
				sb.append("min(int, int)");
			}
		}
		for (int i = 0; i < forwardBraces; i++) {
			sb.append(")");
		}
		System.out.println(sb.toString());
	}
}

