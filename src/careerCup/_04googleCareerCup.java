package careerCup;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/*
 * Link: http://www.geeksforgeeks.org/find-k-such-that-all-elements-in-kth-row-are-0-and-kth-column-are-1-in-a-boolean-matrix/
 * Given a Boolean Matrix, find k such that all elements in k’th row are 0 and k’th column are 1.
 * 
 */
public class _04googleCareerCup {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		Integer n=Integer.parseInt(scanner.nextLine());
/*
4
1,0,0,0
1,1,1,0
1,1,0,0
1,1,1,0
*/		
		
/*		
5
0,1,1,0,1
0,0,0,0,0
1,1,1,0,0
1,1,1,1,0
1,1,1,1,1
*/
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
		int rowSumArray[]=new int[inputArray.length];
		int colSumArray[]=new int[inputArray.length];
		Arrays.fill(rowSumArray,0);
		Arrays.fill(colSumArray,0);
		for (int i = 0; i < colSumArray.length; i++) {
			
			for (int j = 0; j < colSumArray.length; j++) {
				rowSumArray[i]+=inputArray[i][j];
				colSumArray[j]+=inputArray[i][j];
			}
		}
		
		for (int i = 0; i < colSumArray.length; i++) {
			for (int j = 0; j < colSumArray.length; j++) {
				if(rowSumArray[i]-inputArray[i][j]==0 && colSumArray[j]-inputArray[i][j]==inputArray.length-1)
					return i;
			}
		}
		
		System.out.println(Arrays.toString(rowSumArray));
		System.out.println(Arrays.toString(colSumArray));
		return -1;
	}

	private static void printArray(int[][] inputArray) {
		for (int i = 0; i < inputArray.length; i++) {
			System.out.println(Arrays.toString(inputArray[i]));
		}

	}


}
