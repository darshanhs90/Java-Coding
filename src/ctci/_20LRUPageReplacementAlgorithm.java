package ctci;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;


/*Implementation of LRU Page Replacement Algorithm*/
public class _20LRUPageReplacementAlgorithm{

	public static void main(String[] args) {
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		String inputArray[]=scanner.nextLine().split(",");
		int frameLength=Integer.parseInt(scanner.nextLine());
		scanner.close();
		for (int i = 0; i < inputArray.length; i++) {
			System.out.print(inputArray[i]+" ");
		}
		performLRUReplacement(inputArray,frameLength);
	}

	private static void performLRUReplacement(String[] inputArray,
			int frameLength) {
		String frameArray[]=new String[frameLength];
		Arrays.fill(frameArray," ");
		for (int i = 0; i < inputArray.length; i++) {
			String element=inputArray[i];
			int position=-1;
			if((position=checkFrameArray(frameArray,element))!=-1){
				frameArray=replaceElementPosition(position,element,frameArray);
			}
			else{
				frameArray=appendToStart(frameArray,element);
			}
			System.out.println(Arrays.toString(frameArray));
		}
	}

	private static String[] appendToStart(String[] frameArray,String element) {
		String newArray[]=new String[frameArray.length];
		Arrays.fill(newArray, " ");
		newArray[0]=element;
		for (int i = 1; i <= frameArray.length-1; i++) {
			newArray[i]=frameArray[i-1];
		}
		return newArray;
	}

	private static String[] replaceElementPosition(int position,
			String element, String[] frameArray) {
		String newArray[]=new String[frameArray.length];
		newArray[0]=element;
		int newArrayCounter=1;
		for (int i = 0;i<frameArray.length; i++) {
			if(!frameArray[i].contentEquals(element))
			{
				newArray[newArrayCounter]=frameArray[i];
				newArrayCounter++;
			}
		}
		return newArray;
	}

	private static int checkFrameArray(String[] frameArray, String element) {
		for (int i = 0; i < frameArray.length; i++) {
			if(frameArray[i].contentEquals(element))
				return i;
		}
		return -1;
	}

}