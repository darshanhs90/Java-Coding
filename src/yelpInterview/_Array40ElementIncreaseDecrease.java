package yelpInterview;

public class _Array40ElementIncreaseDecrease {
	public static void main(String a[]){
		int[] inputArray=new int[]{8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1};
		System.out.println(findElement(inputArray));
		inputArray=new int[]{1, 3, 50, 10, 9, 7, 6};
		System.out.println(findElement(inputArray));
		inputArray=new int[]{10, 20, 30, 40, 50};
		System.out.println(findElement(inputArray));
		inputArray=new int[]{120, 100, 80, 20, 0};
		System.out.println(findElement(inputArray));
	}

	private static int findElement(int[] inputArray) {
		return findElementUtil(inputArray,0,inputArray.length-1);
	}

	private static int findElementUtil(int[] inputArray, int low, int high) {
		if(low==high)
			return inputArray[low];
		if(low+1==high)
			return Math.max(inputArray[low], inputArray[high]);
		if(low<=high){
			int mid=(low+high)/2;
			if((inputArray[mid]>inputArray[mid-1]) && (inputArray[mid]>inputArray[mid+1]))
				return inputArray[mid];
			else if((inputArray[mid]<inputArray[mid+1]))
				return findElementUtil(inputArray,mid+1,high);
			else
				return findElementUtil(inputArray,low,mid-1);
		}
		return -1;
	}

}