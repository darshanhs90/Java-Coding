package hackerRank.Algorithms.Implementation;

import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/challenges/the-grid-search
 */
public class _10GridSearch {

	public static void main(String ards[])
	{
		String[] inputMatrix = null,testMatrix = null;
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		int noOfTestCases=Integer.parseInt(scanner.nextLine());
		for (int i = 0; i < noOfTestCases; i++) {
			String rowCols[]=scanner.nextLine().split(" ");
			inputMatrix=extractMatrix(inputMatrix,rowCols,scanner);
			rowCols=scanner.nextLine().split(" ");
			testMatrix=extractMatrix(testMatrix,rowCols,scanner);
			System.out.println(checkTestInInput(inputMatrix,testMatrix)==true?"YES":"NO");

		}
	}

	private static boolean checkTestInInput(String[] inputMatrix, String[] testMatrix) {
		for (int i = 0; i <=(inputMatrix.length-testMatrix.length); i++) {
			int prevIndex=inputMatrix[i].indexOf(testMatrix[0],0);
			
			while(prevIndex!=-1)
			{	
				int counter=0;
				int k=i;
				for (int j = 0; j < testMatrix.length; j++) {
					if(inputMatrix[k].substring(prevIndex,prevIndex+testMatrix[0].length()).contentEquals(testMatrix[j]))
					{
						counter++;
					}
					else{
						break;
					}
					k++;
				}
				if(counter==testMatrix.length)
					return true;
				else
					prevIndex=inputMatrix[i].indexOf(testMatrix[0],prevIndex+1);
			}
		}
		return false;
	}

	private static String[] extractMatrix(String[] inputMatrix, String[] rowCols,Scanner scanner) {
		inputMatrix=new String[Integer.parseInt(rowCols[0])];
		for (int i = 0; i < Integer.parseInt(rowCols[0]); i++) {
			inputMatrix[i]=scanner.nextLine();	
		}
		return inputMatrix;
	}
}
