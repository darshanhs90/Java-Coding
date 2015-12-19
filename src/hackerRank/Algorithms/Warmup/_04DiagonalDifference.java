package hackerRank.Algorithms.Warmup;

import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/challenges/diagonal-difference
*/
public class _04DiagonalDifference {

	public static void main(String args[])
	{
		Scanner scanner =new Scanner(new InputStreamReader(System.in));
		int N=Integer.parseInt(scanner.nextLine());
		int[][] inputArray=new int[N][N];
		for (int i = 0; i < N; i++) {
			String strArray[]=scanner.nextLine().split(" ");
			for(int j=0;j<strArray.length;j++)
			{
				inputArray[i][j]=Integer.parseInt(strArray[j]);
			}						
		}
		int leftSum=0,rightSum=0;
		for(int k=0;k<N;k++)
		{
			leftSum+=inputArray[k][k];
			rightSum+=inputArray[k][N-k-1];
		}
		System.out.println(Math.abs(leftSum-rightSum));
	}
}
