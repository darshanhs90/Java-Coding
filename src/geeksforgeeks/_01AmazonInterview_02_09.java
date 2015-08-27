package geeksforgeeks;

import java.util.Arrays;
import java.util.Random;

/*
 * http://www.geeksforgeeks.org/amazon-interview/
 * Find an element in a sorted rotated integer array.
 */
public class _01AmazonInterview_02_09 {
	public static void main(String[] args) {
		int inputArray[]=new int[10];
		for (int i = 0; i < inputArray.length; i++) {
			inputArray[i]=new Random().nextInt(10);
		}
		Arrays.sort(inputArray);
		for (int i = 0; i < inputArray.length; i++) {
			System.out.print(inputArray[i]+" ");
		}
		System.out.println();
		int r=new Random().nextInt(10);
		for (int j = 0; j <r; j++) {
			int[] newArray=Arrays.copyOf(inputArray,inputArray.length);
			for (int i = 0; i < inputArray.length; i++) {
				if(i==0)
					inputArray[i]=newArray[inputArray.length-1];
				else
					inputArray[i]=newArray[i-1];
			}
		}

		System.out.println("Element found is : "+findElement(6,inputArray));
		System.out.println("Element found is : "+findElement(12,inputArray));
		System.out.println("Element found is : "+findElement(2,inputArray));
		
	}

	private static boolean findElement(int element, int[] inputArray) {

		for (int i = 0; i < inputArray.length; i++) {
			System.out.print(inputArray[i]+" ");
		}
		for (int i = 0; i <= inputArray.length/2; i++) {
			if(element==inputArray[inputArray.length-1-i]){
				return true;		
			}
			if(element==inputArray[i]){
				return true;
			}
		}		
		return false;
	}
}
