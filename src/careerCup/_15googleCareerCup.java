package careerCup;

import java.util.Arrays;

/*
 * Link: http://www.careercup.com/question?id=83696
 * 1. 2 huge files A and B are in sorted order. Make a combined file C which contains the total sorted order. 
 * 2. Extrapolate this to 1000s of sorted files containing millions of entries. Generate the combined sorted file as output
 */
public class _15googleCareerCup {

	public static void main(String[] args) {
		int inputArray1[]=new int[]{ 1,3,5,7,9,10,23,25 };
		int inputArray2[]=new int[]{ 2,4,6,100 };
		System.out.println(Arrays.toString(sortArray(inputArray1,inputArray2)));	

	}
	private static int[] sortArray(int[] inputArray1,int[] inputArray2) {
		int outputArray[]=new int[inputArray1.length+inputArray2.length];
		//use heap to get min element,use a pointer to the arary to pickout the next element and put that to heap
		//also a counter for output element index
		//Merge sort used here
		int index1=0,index2=0;
		for (int i = 0; i < outputArray.length; i++) {
			if(index1<inputArray1.length && index2<inputArray2.length){
				if(inputArray1[index1]<inputArray2[index2])
				{
					outputArray[i]=inputArray1[index1];
					index1++;
				}
				else{
					outputArray[i]=inputArray2[index2];
					index2++;
				}
			}
			else{
				if(index1<inputArray1.length)
				{
					outputArray[i]=inputArray1[index1];
					index1++;
				}
				else{
					outputArray[i]=inputArray2[index2];
					index2++;
				}
			}
		}
		return outputArray;
	}


}
