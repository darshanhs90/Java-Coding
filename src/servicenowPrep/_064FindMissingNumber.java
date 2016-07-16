package servicenowPrep;

public class _064FindMissingNumber
{

	public static void main(String[] args) {
		int arr[] = {1, 2, 4, 5, 6};
		System.out.println(findMissingNum(arr));
	}

	private static int findMissingNum(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]!=i+1)
				return i+1;
		}
		return -1;
	}

	

}