package GeeksforGeeksPractice;

/*
 * Link : http://www.geeksforgeeks.org/find-the-missing-number/
 */
public class _0106FindMissingNumber {
	public static void main(String[] args) {
		int a[] = {1, 2, 4, 5, 6};
		System.out.println(findMissingNumber(a));
	}

	private static int findMissingNumber(int[] a) {
		int max=Integer.MIN_VALUE;
		for (int i = 0; i < a.length; i++) {
			if(a[i]>max)
				max=a[i];
		}
		int sum=max*(max+1)/2;
		for (int i = 0; i < a.length; i++) {
			sum-=a[i];
		}
		return sum;
	}


}
