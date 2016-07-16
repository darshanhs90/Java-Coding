package servicenowPrep;

public class _062OddOccuringNumber
{

	public static void main(String[] args) {
		int[] arr=new int[]{1,2,4,8,4,3,3,8,1};
		System.out.println(oddOccuringNumber(arr));
	}

	private static int oddOccuringNumber(int[] arr) {
		int number=arr[0];
		for (int i =1; i < arr.length; i++) {
			number=number^arr[i];
		}
		return number;
	}



}