package googleCodeJam;

import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * Main Link: https://code.google.com/codejam/contests.html
 * Problem Link:https://code.google.com/codejam/contest/6254486/dashboard#s=p1
 */
public class _02gcjam2016Pancakes {

	static int noOfDash,noOfPlus;
	public static void main(String[] args) {
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		Integer noOfTestCases=Integer.parseInt(scanner.nextLine());
		for (int i = 0; i < noOfTestCases; i++) {
			System.out.println("Case #"+(i+1)+": "+findCount(scanner.nextLine()));
		}
		scanner.close();
	}

	private static String findCount(String nextLine) {
		noOfDash=0;
		noOfPlus=0;
		findCounts(nextLine);
		return null;
	}

	private static void findCounts(String nextLine) {
		// TODO Auto-generated method stub
		
	}


}
