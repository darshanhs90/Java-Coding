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
		
		return fibonacci(n);
	}

	private static int fibonacci(Integer n) {
		if(n==0||n==1)
			return 1;
		else return fibonacci(n-1)+fibonacci(n-2);
	}
	

	
 }