package yelpInterview;

public class _Array50CommonElements3Arrays {
	public static void main(String a[]){
		int ar1[] = {1, 5, 10, 20, 40, 80};
		int ar2[] = {6, 7, 20, 80, 100};
		int ar3[] = {3, 4, 15, 20, 30, 70, 80, 120};
		printCommonElements(ar1,ar2,ar3);
		System.out.println();
		ar1 = new int[]{1, 5, 5};
		ar2 = new int[]{3, 4, 5, 5, 10};
		ar3 = new int[]{5, 5, 10, 20};
		printCommonElements(ar1,ar2,ar3);
	}

	private static void printCommonElements(int[] ar1, int[] ar2, int[] ar3) {
		int firstPointer=0,secondPointer=0,thirdPointer=0;
		while(firstPointer<ar1.length && secondPointer<ar2.length && thirdPointer<ar3.length)
		{
			if(ar1[firstPointer]==ar2[secondPointer] && ar1[firstPointer]==ar3[thirdPointer])
			{
				System.out.print(ar1[firstPointer]+",");
				firstPointer++;secondPointer++;thirdPointer++;
			}
			else if(ar1[firstPointer]<ar2[secondPointer]){
				firstPointer++;
			}else if(ar2[secondPointer]<ar3[thirdPointer]){
				secondPointer++;
			}else{
				thirdPointer++;
			}
		}
	}

}