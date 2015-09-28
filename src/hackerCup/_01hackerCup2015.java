
package hackerCup;

import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * https://www.facebook.com/hackercup/problem/582062045257424/
 * followed by the smallest and largest numbers that can be made from the original number N,
 * using at most a single swap
 */

public class _01hackerCup2015 {

	public static void main(String[] args) {
		Scanner scanner= new Scanner(new InputStreamReader(System.in));
		int numberOfTestCases=Integer.parseInt(scanner.nextLine());
		for (int i = 0; i < numberOfTestCases; i++) {
			int inputNumber=Integer.parseInt(scanner.nextLine());
			int smallNumber=findSmallestNumber(inputNumber);
			int largeNumber=findLargestNumber(inputNumber);
			System.out.println("Case #"+(i+1)+" "+smallNumber+" "+largeNumber);
		}



	}

	private static int findLargestNumber(int inputNumber) {
		// TODO Auto-generated method stub
		return 0;
	}

	private static int findSmallestNumber(int inputNumber) {
		// TODO Auto-generated method stub
		return 0;
	}
}
