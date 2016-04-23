package yelpInterview;

import java.util.Arrays;

public class _Array15SortArray012 {
	public static void main(String a[]){
		int inputArray[] = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
		System.out.println(Arrays.toString(sortArray(inputArray)));
		inputArray = new int[]{0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
		System.out.println(Arrays.toString(sortArrayDutch(inputArray)));
	}

	private static int[] sortArrayDutch(int[] inputArray) {
		int low=0,mid=0,high=inputArray.length-1;
		while(mid<=high)
		{
			switch(inputArray[mid])
			{
			case 0:inputArray[low]=inputArray[mid]^inputArray[low];
			inputArray[mid]=inputArray[mid]^inputArray[low];
			inputArray[low]=inputArray[mid]^inputArray[low];
			low++;mid++;
			break;
			case 1:mid++;break;
			case 2:inputArray[high]=inputArray[mid]^inputArray[high];
			inputArray[mid]=inputArray[mid]^inputArray[high];
			inputArray[high]=inputArray[mid]^inputArray[high];
			high--;;break;
			}
		}
		return inputArray;
	}






	private static int[] sortArray(int[] inputArray) {
		int noOfZeros=0,noOfOnes=0,noOfTwos=0;
		for (int i = 0; i < inputArray.length; i++) {
			if(inputArray[i]==0)
				noOfZeros++;
			else if(inputArray[i]==1)
				noOfOnes++;
			else
				noOfTwos++;
		}
		for (int i = 0; i < inputArray.length; i++) {
			if(noOfZeros>0){
				inputArray[i]=0;
				noOfZeros--;
			}
			else if(noOfOnes>0){
				inputArray[i]=1;
				noOfOnes--;
			}
			else
				inputArray[i]=2;
		}
		return inputArray;
	}

}