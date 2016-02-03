package hackerRank.Algorithms.Search;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/challenges/connected-cell-in-a-grid
 */
public class _05ConnectedCellInGrid {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		int m=Integer.parseInt(scanner.nextLine());
		int n=Integer.parseInt(scanner.nextLine());
		int inputArray[][]=new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				inputArray[i][j]=scanner.nextInt();
			}
		}
		//first scan each row
		//get the start point by checking all its neighbors
		//if its a start point,find its neighbors count using dfs
		//get max value
		getMaxGridCount(inputArray);

		printArray(inputArray);
	}

	private static void getMaxGridCount(int[][] inputArray) {
		for (int i = 0; i < inputArray.length; i++) {
			for (int j = 0; j < inputArray.length; j++) {
				if(i==0)
				{

				}
				else{

				}
			}
		}

	}

	private static void printArray(int[][] inputArray) {
		for (int i = 0; i < inputArray.length; i++) {
			System.out.println(Arrays.toString(inputArray[i]));
		}
	}
}
