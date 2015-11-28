package GeeksforGeeksPractice;

/*
 * Link : http://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
 */
public class _0093LongestContigousSubArray {
	public static void main(String[] args) {
		int a[]={-2, -3, 4, -1, -2, 1, 5, -3};
		System.out.println(calculateLongest(a));
	}

	private static int calculateLongest(int[] a) {
		int max_so_far=0,max_ending_here=0;
		
		for (int i = 0; i < a.length; i++) {
			max_ending_here=max_ending_here+a[i];
			if(max_ending_here<0)
				max_ending_here=0;
			if(max_so_far<max_ending_here)
				max_so_far=max_ending_here;	
		}
		return max_so_far;
	}


}
