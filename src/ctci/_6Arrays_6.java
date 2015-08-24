package ctci;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;


/*Implementation of CTCI 1.7*/
public class _6Arrays_6 {
	public static void main(String args[]){
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		int noOfRows=Integer.parseInt(scanner.nextLine());
		int noOfColumns=Integer.parseInt(scanner.nextLine());
		
		int inputArray[][]=new int[noOfRows][noOfColumns];
		for(int i=0;i<noOfRows;i++){
			String rowString=scanner.nextLine();
			String columnArray[]=rowString.split(" ");
			for (int j = 0; j < columnArray.length; j++) {
				inputArray[i][j]=Integer.parseInt(columnArray[j]);
			}
		}
		System.out.println("********Input********");
		for(int i=0;i<noOfRows;i++){
			for (int j = 0; j < noOfColumns; j++) {
				System.out.print(inputArray[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("********Output********");
		int[][] outputArray=setZeroMatrix(inputArray);
		for(int i=0;i<noOfRows;i++){
			for (int j = 0; j < noOfColumns; j++) {
				System.out.print(outputArray[i][j]+" ");
			}
			System.out.println();
		}
	}

	public static int[][] setZeroMatrix(int[][] inputArray) {
		int noOfRows=inputArray.length;
		int noOfColumns=inputArray[0].length;
		boolean rowIndexChecker[]=new boolean[noOfRows];
		boolean columnIndexChecker[]=new boolean[noOfColumns];
		Arrays.fill(rowIndexChecker,false);
		Arrays.fill(columnIndexChecker,false);
		for (int i = 0; i < noOfRows; i++) {
			for (int j = 0; j < noOfColumns; j++) {
				if(inputArray[i][j]==0)
				{
					rowIndexChecker[i]=true;
					columnIndexChecker[j]=true;
				}
			}
		}
		for (int i = 0; i < noOfRows; i++) {
			if(rowIndexChecker[i]==true)
				Arrays.fill(inputArray[i],0);
			for (int j = 0; j < noOfColumns; j++) {
				if(columnIndexChecker[j]==true)
					inputArray[i][j]=0;
			}
		}
		
		
		
		return inputArray;
	}


}
