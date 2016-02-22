package hackerRank.Algorithms.Implementation;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/challenges/matrix-rotation-algo
 */
public class _20MatrixRotation {

	public static void main(String ards[])
	{
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		int M=scanner.nextInt();
		int N=scanner.nextInt();
		int R=scanner.nextInt();
		int inputArray[][]=new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				inputArray[i][j]=scanner.nextInt();
			}
			System.out.println(Arrays.toString(inputArray[i]));
		}

		for (int i = 0; i < R; i++) {
			inputArray=rotateMatrix(inputArray);
		}
		printMatrix(inputArray);
	}

	private static int[][] rotateMatrix(int[][] inputArray) {
		
		
		
		
		
		
		
		
		return inputArray;
	}

	private static void printMatrix(int[][] inputArray) {
		for (int i = 0; i < inputArray.length; i++) {
			System.out.println(Arrays.toString(inputArray[i]).replaceAll(",","").replace("[","").replace("]",""));
		}

	}
}
