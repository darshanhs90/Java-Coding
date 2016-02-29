package hackerRank.Algorithms.BitManipulation;

import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/challenges/flipping-bits
 */
public class _05FlippingBits {

	public static void main(String ards[])
	{
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		int noOfTestCases=Integer.parseInt(scanner.nextLine().trim());
		for (int i = 0; i < noOfTestCases; i++) {
			BigInteger input=new BigInteger(scanner.nextLine().trim());
			input=input.subtract(new BigInteger("4294967295"));
			System.out.println(input.abs());
		}
	}
}
