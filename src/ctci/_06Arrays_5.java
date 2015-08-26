package ctci;

import java.io.InputStreamReader;
import java.util.Scanner;


/*Implementation of CTCI 1.6*/
public class _06Arrays_5 {
	public static void main(String args[]){
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		int noOfRows=Integer.parseInt(scanner.nextLine());
		int inputArray[][]=new int[noOfRows][noOfRows];
		for(int i=0;i<noOfRows;i++){
			String rowString=scanner.nextLine();
			String columnArray[]=rowString.split(" ");
			for (int j = 0; j < columnArray.length; j++) {
				inputArray[i][j]=Integer.parseInt(columnArray[j]);
			}
		}
		scanner.close();
		for(int i=0;i<noOfRows;i++){
			for (int j = 0; j < noOfRows; j++) {
				System.out.print(inputArray[i][j]+" ");
			}
			System.out.println();
		}
		int[][] outputArray=rotateMatrix(inputArray);

	}

	public static int[][] rotateMatrix(int[][] inputArray) {
		int noOfRows=inputArray.length;
		int layers=noOfRows/2;
		int outputArray[][]=new int[noOfRows][noOfRows];
			for (int i = 0; i < layers; i++) {
				int index=noOfRows-2*layers;
				for (int j = 0; j <noOfRows; j++) {
					//outputArray[][]
				}
				
				
				
				
				
				
				
				
			}
		
		
		
		
		
		return null;
	}
	public static int[][] rotateMatrixInPlace(int[][] inputArray) {
		int noOfRows=inputArray.length;
		int layers=noOfRows/2;
		int outputArray[][]=new int[noOfRows][noOfRows];
			for (int i = 0; i < layers; i++) {
				
				
				
				
				
				
				
				
				
			}
		
		
		
		
		
		return null;
	}


}
