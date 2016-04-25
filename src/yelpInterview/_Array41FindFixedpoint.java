package yelpInterview;

public class _Array41FindFixedpoint {
	public static void main(String a[]){
		int[] inputArray=new int[]{-10, -5, 0, 3, 7};
		System.out.println(findFixedPoint(inputArray));
		inputArray=new int[]{0, 2, 5, 8, 17};
		System.out.println(findFixedPoint(inputArray));
		inputArray=new int[]{-10, -5, 3, 4, 7, 9};
		System.out.println(findFixedPoint(inputArray));
	}

	private static int findFixedPoint(int[] inputArray) {
		return findFixedPointUtil(inputArray,0,inputArray.length-1);
	}

	private static int findFixedPointUtil(int[] inputArray, int low, int high) {
		if(low<=high)
		{
			int mid=(low+high)/2;
			if(inputArray[mid]==mid)
				return mid;
			if(inputArray[mid]>mid)
			{
				return findFixedPointUtil(inputArray,low,mid-1);
			}
			else{
				return findFixedPointUtil(inputArray,mid+1,high);				
			}
		}
		return -1;
	}


}