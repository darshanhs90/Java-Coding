package yelpInterview;

public class _Array28PrintCombinationsOfRElements {
	public static void main(String a[]){
		int arr1[] = {1, 2, 3, 4,5} ;
		printCombinations(arr1,3);
	}

	private static void printCombinations(int[] arr1, int r) {
		int data[]=new int[r];
		printCombinationUtil(arr1,arr1.length,r,0,data,0);
	}

	private static void printCombinationUtil(int arr[], int n, int r, int index, int data[], int i) {
		if (index == r)
		{
			for (int j=0; j<r; j++)
				System.out.print(data[j]);
			System.out.println();
			return;
		}
		if (i >= n)
			return;
		data[index] = arr[i];
		printCombinationUtil(arr, n, r, index+1, data, i+1);
		printCombinationUtil(arr, n, r, index, data, i+1);
	}


}