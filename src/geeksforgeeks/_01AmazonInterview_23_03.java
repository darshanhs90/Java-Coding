package geeksforgeeks;

import java.io.InputStreamReader;
import java.util.Scanner;






/*
 * http://www.geeksforgeeks.org/amazon-interview-set-23/
 * Give a Building with n floor. A person can take 1 step or 2 step to climb.
 * Find the number of ways to reach nth floor. Code was required
 */;
 public class _01AmazonInterview_23_03 {
	 public static void main(String[] args) {
		 Scanner scanner =new Scanner(new InputStreamReader(System.in));
		 Integer n=Integer.parseInt(scanner.nextLine());
		 scanner.close();
		 System.out.println(getWays(n));
	 }

	private static int getWays(Integer n) {
		// TODO Auto-generated method stub
		float oneStepCount=getCombination(n,1);
		float twoStepCount=getCombination(n,2);
		
		return (int)(oneStepCount+twoStepCount)/2;
	}

	private static float getCombination(Integer n, int i) {
		// TODO Auto-generated method stub
		float numerator=1.0f;
		for (int j = 1; j <=n; j++) {
			numerator*=j;
		}
		for (int j = 1; j <=i; j++) {
			numerator/=j;
		}
		for (int j = 1; j <=(n-i); j++) {
			numerator/=j;
		}
		return numerator;
	}
 }