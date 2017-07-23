package hackerRank.WeekOfCode34;

import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/contests/w30/challenges/candy-replenishing-robot
 */
public class _01OnceInATram {
	static String onceInATram(int x) {
		// Complete this function

		while(true){
			x++;
			if(isLucky(x)){
				return String.valueOf(x);
			}
		}
	}

	private static boolean isLucky(int x) {
		String s=String.valueOf(x);
		int leftHalf=0,rightHalf=0;
		for (int i = 0; i < s.length(); i++) {
			if(i<3){
				leftHalf+=Character.getNumericValue(s.charAt(i));
			}
			else{
				rightHalf+=Character.getNumericValue(s.charAt(i));
			}
		}
		return leftHalf==rightHalf;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int x = in.nextInt();
		String result = onceInATram(x);
		System.out.println(result);
	}
}
