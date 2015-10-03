package careerCup;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/*
 * Link: http://www.geeksforgeeks.org/find-k-such-that-all-elements-in-kth-row-are-0-and-kth-column-are-1-in-a-boolean-matrix/
 * Given a Boolean Matrix, find k such that all elements in k’th row are 0 and k’th column are 1.
 * 
 */
public class _04googleCareerCup {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		Integer n=Integer.parseInt(scanner.nextLine());
		/*4
		1,0,0,0
		1,1,1,0
		1,1,0,0
		1,1,1,0*/		
		String inputStringArray[]=new String[n];
		for (int i = 0; i < n; i++) {
			inputStringArray[i]=scanner.nextLine();
		}
		scanner.close();
		int inputArray[][]=new int[n][n];
		for (int i = 0; i < inputStringArray.length; i++) {
			String splitArray[]=inputStringArray[i].split(",");
			for (int j = 0; j < splitArray.length; j++) {
				inputArray[i][j]=Integer.parseInt(splitArray[j]);
			}
		}

		printArray(inputArray);
		System.out.println(findIndexLong(inputArray));

	}

	private static int findIndexLong(int[][] inputArray) {

		return 0;
	}

	private static void printArray(int[][] inputArray) {
		for (int i = 0; i < inputArray.length; i++) {
			System.out.println(Arrays.toString(inputArray[i]));
		}

	}


}
