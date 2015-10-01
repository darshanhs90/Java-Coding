package careerCup;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/*
 * Link: http://codereview.stackexchange.com/questions/75819/efficiently-squaring-each-element-in-a-sorted-array-keeping-it-sorted
 */
public class _02googleCareerCup {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		String inputStringArray[]="-6,-5,-4,-3,-2,-1,3,5,7".split(",");//scanner.nextLine().split(",");
		scanner.close();
		int inputSortedArray[]=new int[inputStringArray.length];
		for (int i = 0; i < inputSortedArray.length; i++) {
			inputSortedArray[i]=Integer.parseInt(inputStringArray[i]);
		}
		System.out.println(Arrays.toString(inputSortedArray));
		int outputSortedArray[]=squareSorted(inputSortedArray);
		System.out.println(Arrays.toString(outputSortedArray));
	}

	private static int[] squareSorted(int[] inputSortedArray) {
		int sum=inputSortedArray[0],index=0;
		if(sum>=0)
			index=0;
		else{
			index=doSearch(inputSortedArray);
			System.out.println(index);
		}
		return  doMerge(index,inputSortedArray);
	}

	private static int[] doMerge(int index, int[] inputSortedArray) {
		int startIndex=0,endIndex=inputSortedArray.length-1;
		int leftIndex=index-1;
		int rightIndex=index;
		int outputArray[]=new int[inputSortedArray.length];
		int outputIndex=0;
		while(outputIndex<inputSortedArray.length){
			if(leftIndex>=startIndex && rightIndex<=endIndex)
			{
				if(-1*inputSortedArray[leftIndex]<inputSortedArray[rightIndex]){
					outputArray[outputIndex]=(int) Math.pow(inputSortedArray[leftIndex],2);
					outputIndex++;
					leftIndex--;
				}
				else{
					outputArray[outputIndex]=(int) Math.pow(inputSortedArray[rightIndex],2);
					outputIndex++;
					rightIndex++;
				}
			}
			else{
				if(leftIndex>=startIndex)
				{
					outputArray[outputIndex]=(int) Math.pow(inputSortedArray[leftIndex],2);
					outputIndex++;
					leftIndex--;
				}
				else{
					outputArray[outputIndex]=(int) Math.pow(inputSortedArray[rightIndex],2);
					outputIndex++;
					rightIndex++;
				}
			}
			
		}
		return outputArray;
	}

	private static int doSearch(int[] inputSortedArray) {//change to binary search
		for (int i = 1; i < inputSortedArray.length; i++) {
			if(inputSortedArray[i-1]<0 && inputSortedArray[i]>=0)
				return i;
		}
		return 0;
	}
}
