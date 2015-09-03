package geeksforgeeks;

import java.io.InputStreamReader;
import java.util.Scanner;


/*
 * http://www.geeksforgeeks.org/amazon-interview-set-20/
 * In matrix A[m][n] each row is sorted and each column is sorted,
 * write a function which checks whether a number exists in this matrix or not.
 */;
 public class _01AmazonInterview_20_01 {
	 public static void main(String[] args) {
		int inputMatrix[][]={{1,4,5,9},
							{10,14,19,27},
							{12,16,21,30},
							{19,45,91,99}};
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		int elementCheck=Integer.parseInt(scanner.nextLine());
		scanner.close();
		System.out.println("Element found : "+checkElement(inputMatrix,elementCheck));
	 }

	private static boolean checkElement(int[][] inputMatrix, int elementCheck) {
		// TODO Auto-generated method stub
		int rowIndex=-1,colIndex=-1;
		
		for (int i = 0; i < inputMatrix.length; i++) {
			//get the row number
			if(inputMatrix[i][0]<=elementCheck && elementCheck<=inputMatrix[i][inputMatrix[0].length-1]){
				rowIndex=i;
				break;
			}
		}
		for (int i = 0; i < inputMatrix[0].length; i++) {
			//get the col number
			if(inputMatrix[0][i]<=elementCheck && elementCheck<=inputMatrix[inputMatrix.length-1][i]){
				colIndex=i;
				break;
			}
		}
		if(rowIndex!=-1 && colIndex!=-1 && inputMatrix[rowIndex][colIndex]==elementCheck){
			return true;
		}
		return false;
	}

 }