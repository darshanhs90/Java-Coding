package yelpInterview;

public class _Array27SearchElementSortedArray {
	public static void main(String a[]){
		int arr1[] = {4, 5, 6, 7, 8, 9, 1, 2, 3};
		System.out.println(searchElement(arr1,0,arr1.length-1,3));
	}

	private static int searchElement(int[] arr1,int low,int high, int key) {
		if(low<=high)
		{
			int mid=(low+high)/2;
			if(arr1[mid]==key)
				return mid;

			if(arr1[low]<=arr1[mid])//low to mid is sorted &&key lies in that range
			{
				if(key>=arr1[low] && key<=arr1[mid])
					return searchElement(arr1, low, mid-1, key);
				return searchElement(arr1, mid+1, high, key);
			}
			if(key>=arr1[mid] && key<=arr1[high])
				return searchElement(arr1, mid+1, high, key);
			return searchElement(arr1, low, mid-1, key);
		}
		return -1;
	}




}