package hackerRank.Algorithms.Search;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/challenges/maximise-sum
 * https://www.quora.com/What-is-the-logic-used-in-the-HackerRank-Maximise-Sum-problem
 */
public class _03MaximiseSum {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		int noOfTestCases=1;//scanner.nextInt();
		for (int i = 0; i < noOfTestCases; i++) {
			int N=scanner.nextInt();
			int M=scanner.nextInt();
			int inputArray[]=new int[N];
			for (int j = 0; j < inputArray.length; j++) {
				inputArray[j]=scanner.nextInt();
			}
			System.out.println(findSubMatrixSum(inputArray,M));
		}
	}

	private static int findSubMatrixSum(int[] inputArray, int m) {
		int curr = 0;
		int prefix[]=new int[inputArray.length];
		for(int i = 0; i < inputArray.length; i ++) {
			curr = (inputArray[i] % m + curr) % m;
			prefix[i] = curr;
		}
		int ret = 0;
		for(int i = 0; i < inputArray.length; i ++) {
			for(int j = i-1; j >= 0; j --) {
				ret = Math.max(ret, (prefix[i] - prefix[j] + m) % m);
			}
			ret = Math.max(ret, prefix[i]); 
		}
		return ret;
	}
}
