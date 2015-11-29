package GeeksforGeeksPractice;

/*
 * http://www.geeksforgeeks.org/leaders-in-an-array/
 */
public class _011LeadersOfArray {
	public static void main(String[] args) {
		int arr[] =  {16, 17, 4, 3, 5, 2};
		printLeaders(arr);
	}

	private static void printLeaders(int[] arr) {
		int max=Integer.MIN_VALUE;
		for (int i = arr.length-1; i >=0; i--) {
			if(arr[i]>max)
			{
				System.out.println(arr[i]);
				max=arr[i];
			}
		}
		
	}

	
}
