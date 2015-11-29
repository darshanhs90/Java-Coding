package GeeksforGeeksPractice;

/*
 * Link: http://www.geeksforgeeks.org/check-for-majority-element-in-a-sorted-array/
 */
public class _0115CheckMajorityElementArray {
	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 3, 3, 3, 10};
		int x = 3;
		System.out.println(checkMajority(arr,x));
		arr = new int[]{1, 1, 2, 4, 4, 4, 6, 6};
		x = 4;
		System.out.println(checkMajority(arr,x));
		arr = new int[]{1, 1, 1, 2, 2};
		x = 1;
		System.out.println(checkMajority(arr,x));
	}

	private static boolean checkMajority(int[] arr, int x) {
		int count=0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]==x)count++;
		}
		return count>arr.length/2?true:false;
	}



}
