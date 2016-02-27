package hackerRank.Algorithms.BitManipulation;

import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/challenges/sansa-and-xor
 */
public class _04SansaAndXOR {

	public static void main(String ards[])
	{
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		int noOfTestCases=scanner.nextInt();
		for (int i = 0; i < noOfTestCases; i++) {
			int N=(scanner.nextInt());
			int inputArray[]=new int[N];
			for (int j = 0; j < N; j++) {
				inputArray[j]=scanner.nextInt();
			}
			System.out.println(findsubArrays(inputArray));
		}
	}

	private static int findsubArrays(int[] inputArray) {
		if(inputArray.length%2==0)
			return 0;
		else
		{
			int output=0;
			for (int i = 0; i < inputArray.length; i=i+2) {
				output=output^inputArray[i];
			}
			return output;
		}
	}
}
