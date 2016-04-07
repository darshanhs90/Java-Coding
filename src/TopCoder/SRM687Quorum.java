package TopCoder;

import java.util.Arrays;

/*
 * SRM 687 Div2
 * Link:
 */



public class SRM687Quorum {
	public static void main(String[] args) {
		System.out.println(count(new int[]{50,2,9,49,38,1},5));
	}
	public static int count(int[] arr, int k){
		Arrays.sort(arr);
		int count=0;
		for (int i = 0; i <k; i++) {
			count+=arr[i];
		}	
		return count;
	}

}
