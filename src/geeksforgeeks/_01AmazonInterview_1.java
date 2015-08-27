package geeksforgeeks;

import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * http://www.geeksforgeeks.org/count-total-set-bits-in-all-numbers-from-1-to-n/
 */
public class _01AmazonInterview_1 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		int N=Integer.parseInt(scanner.nextLine());
		scanner.close();
		int noOfOnes=0;
		for (int i = 1; i <=N; i++) {
			noOfOnes+=Integer.bitCount(i);
		}
		System.out.println(noOfOnes);
	}
}
