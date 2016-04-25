package yelpInterview;

public class _Array33FindRowsWithMaxOnes {
	public static void main(String a[]){
		int inputArray[][]=new int[][]{ {0, 0, 0, 1},
			{0, 1, 1, 1},
			{1, 1, 1, 1},
			{0, 0, 0, 0}};
			System.out.println(findMaxOnes(inputArray));
	}

	private static int findMaxOnes(int[][] inputArray) {
		int count=0;
		int outputIndex=-1;
		for (int i = 0; i < inputArray.length; i++) {
			int index=findStartPoint(inputArray[i],0,inputArray[0].length-1,1);
			if(index!=-1)
			{
				if(count<inputArray[0].length-index)
				{
					count=inputArray[0].length-index;
					outputIndex=i;
				}
			}
		}
		return outputIndex;
	}

	private static int findStartPoint(int[] arr,int low,int high,int key) {
		if(low<=high){
			int mid=(low+high)/2;
			if((mid==0 ||arr[mid-1]<arr[mid]) && arr[mid]==key)
				return mid;
			if(arr[mid]<key){
				return findStartPoint(arr, mid+1, high, key);
			}
			else{
				return findStartPoint(arr, low, mid-1, key);
			}
		}
		return -1;
	}
}