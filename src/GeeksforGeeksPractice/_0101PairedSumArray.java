package GeeksforGeeksPractice;

import java.util.Arrays;

/*
 * Link : http://www.geeksforgeeks.org/write-a-c-program-that-given-a-set-a-of-n-numbers-and-another-number-x-determines-whether-or-not-there-exist-two-elements-in-s-whose-sum-is-exactly-x/
 */
public class _0101PairedSumArray {
	public static void main(String[] args) {
		int A[] = {1, 4, 45, 6, 10, -8};
	    int sum = 16;
	    System.out.println(checkPair(A,sum));    
	}

	private static boolean checkPair(int[] a, int sum) {
		Arrays.sort(a);
		int l=0,r=a.length-1;
		while(l<r){
			if(a[l]+a[r]==sum)
				return true;
			else if(a[l]+a[r]>sum)
				r--;
			else
				l++;
		}
		
		
		
		
		
		return false;
	}



}
