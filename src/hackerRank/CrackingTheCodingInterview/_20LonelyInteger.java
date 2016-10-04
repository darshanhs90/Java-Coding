package hackerRank.CrackingTheCodingInterview;

import java.util.Scanner;

public class _20LonelyInteger {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int a[] = new int[n];
		for(int a_i=0; a_i < n; a_i++){
			a[a_i] = in.nextInt();
		}
		System.out.println(findLonelyInteger(a));
	}

	private static int findLonelyInteger(int[] a) {
		int value=a[0];
		for (int i = 1; i < a.length; i++) {
			value^=a[i];
		}
		return value;
	}


}
