package careerCup;

import java.util.Arrays;
import java.util.Random;

/*
 * Link: http://www.careercup.com/question?id=291796
 * Given an array of numbers
 * write a function which will return another array containing the elements of the previous array but in random order.
 */
public class _26googleCareerCup {
	public static void main(String[] args) {
		int inputArray[]=new int[]{5,3,7,10};
		System.out.println(Arrays.toString(inputArray));
		System.out.println(Arrays.toString(randomiseArray(inputArray)));
	}
	public static int[] randomiseArray(int[] inputArray){
		Random r=new Random();
		int[] outputArray=new int[inputArray.length];
		for (int i = 0; i < inputArray.length; i++) {
			int index=r.nextInt(inputArray.length-i);
			outputArray[i]=inputArray[index];
			inputArray[index]=inputArray[index]^inputArray[inputArray.length-i-1];
			inputArray[inputArray.length-i-1]=inputArray[index]^inputArray[inputArray.length-i-1];
			inputArray[index]=inputArray[index]^inputArray[inputArray.length-i-1];
		}
		return outputArray;
	}
	
	


}
