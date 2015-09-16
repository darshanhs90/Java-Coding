package ctci;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;


/*Implementation of CTCI 4.1*/
public class _21FifoPageReplacementAlgorithm{

	public static void main(String[] args) {
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		String inputArray[]=scanner.nextLine().split(",");
		int frameLength=Integer.parseInt(scanner.nextLine());
		scanner.close();
		for (int i = 0; i < inputArray.length; i++) {
			System.out.print(inputArray[i]+" ");
		}
		performFIFOReplacement(inputArray,frameLength);

	}

	private static void performFIFOReplacement(String[] inputArray,
			int frameLength) {
		String frameArray[]=new String[frameLength];
		Arrays.fill(frameArray," ");
		for (int i = 0; i < inputArray.length; i++) {
			String element=inputArray[i];
			if(checkElement(frameArray,element)==-1)
			{
				frameArray=appendToStart(frameArray,element);
			}
			System.out.println(Arrays.toString(frameArray));
		}

	}

	private static String[] appendToStart(String[] frameArray, String element) {
		String newArray[]=new String[frameArray.length];
		Arrays.fill(newArray," ");
		newArray[0]=element;
		for (int i = 1; i < newArray.length; i++) {
			newArray[i]=frameArray[i-1];
		}
		return newArray;
	}

	private static int checkElement(String[] frameArray, String element) {
		for (int i = 0; i < frameArray.length; i++) {
			if(frameArray[i].contentEquals(element))
				return i;
		}
		
		return -1;
	}
}