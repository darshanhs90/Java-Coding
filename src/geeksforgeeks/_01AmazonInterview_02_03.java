package geeksforgeeks;

import java.util.Arrays;
import java.util.Random;



/*
 * http://www.geeksforgeeks.org/amazon-interview/
 *  A sorted array has been rotated r times to the left. Find r in least possible time.
 */
public class _01AmazonInterview_02_03 {
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
		for (int i = 0; i < inputArray.length; i++) {
			System.out.print(inputArray[i]+" ");
		}
		System.out.println();
		int forwardCount=1,reverseCount=0;
		System.out.println("Actual R is "+r);
		for (int i = 0; i < inputArray.length; i++) {
			if(i!=inputArray.length-1 && inputArray[i+1]<inputArray[i]){
				System.out.println("Predicted R is ->"+(forwardCount));
				break;
			}
			if(inputArray[inputArray.length-i-2]>inputArray[inputArray.length-i-1]){
				System.out.println("Predicted R is <-"+(inputArray.length-1-reverseCount));
				break;
			}
			if(i==0){
				if(inputArray[inputArray.length-1]>inputArray[0]){
					System.out.println("Predicted R is 0");
					break;
				}
			}
			forwardCount++;
			reverseCount++;
		}
	}	
}
