package careerCup;

import java.util.Arrays;

/*
 * Link: http://www.careercup.com/question?id=67700
 * Given an array of red, green and blue balls arrange them in groups of all red together, greens together and blue together
 * Do in a single scan of the array.
 * This is same as You have an array containing only '0's, '1's and '2's. Club same items together in single scan.
 */
public class _14googleCareerCup {

	public static void main(String[] args) {
		int inputArray[]=new int[]{ 0,1,0,2,2,0,1,1,0 };
		System.out.println(Arrays.toString((inputArray)));
		System.out.println(Arrays.toString(sortArray(inputArray)));
	}

	private static int[] sortArray(int[] inputArray) {
		int i=0,j=0,k=inputArray.length-1;
		for (int l = 0; l < inputArray.length; l++) {
				if(inputArray[j]==0)
				{
					//swap ith and jth element
					inputArray[i]=inputArray[i]^inputArray[j];
					inputArray[j]=inputArray[i]^inputArray[j];
					inputArray[i]=inputArray[i]^inputArray[j];
					i++;
					j++;	
				}
				else if(inputArray[j]==1)
				{
					j++;
				}
				else{
					inputArray[j]=inputArray[j]^inputArray[k];
					inputArray[k]=inputArray[j]^inputArray[k];
					inputArray[j]=inputArray[j]^inputArray[k];
					k--;
				}
		}
		return inputArray;
	}




}
