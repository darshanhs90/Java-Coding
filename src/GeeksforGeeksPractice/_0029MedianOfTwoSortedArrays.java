package GeeksforGeeksPractice;

public class _0029MedianOfTwoSortedArrays {

	public static void main(String[] args) {

		int arr1[] = {1, 12, 15, 26, 38};
		int arr2[] = {2, 13, 17, 30, 45};
		System.out.println(findMedian(arr1,arr2));


	}

	private static int findMedian(int[] arr1, int[] arr2) {

		int size1=arr1.length;
		int size2=arr2.length;
		int count=(size1+size2)/2;
		int firstPointer=0,secondPointer=0;
		for (int i = 0; i < count; i++) {
			if(firstPointer<size1 && secondPointer<size2)
			{
				if(arr1[firstPointer]<arr2[secondPointer])
				{
					firstPointer++;
				}
				else{
					secondPointer++;
				}
			}
			else{
				if(firstPointer>size1)
				{
					firstPointer++;
				}
				else{
					secondPointer++;
				}
			}
		}
		
		if(firstPointer<size1 && secondPointer<size2)
		{
			return arr1[firstPointer]<arr2[secondPointer]?arr1[firstPointer]:arr2[secondPointer];
		}
		else{
			if(firstPointer>size1)
				return arr2[secondPointer];
			else
				return arr1[firstPointer];
		}
	}
}
