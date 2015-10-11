package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Link : https://leetcode.com/problems/pascals-triangle-ii/
 */

public class _119PascalsTriangle2 {
	public static List<Integer> getRow(int rowIndex) {
		List<Integer> outputList=new ArrayList<>();
		for (int i = 0; i <=rowIndex; i++) {
			outputList.add((int) calculateCombination(rowIndex,i));
		}
		return outputList;
	}

	private static long calculateCombination(int n, int k) {	
		long ans=1;
	    k=k>n-k?n-k:k;
	    int j=1;
	    for(;j<=k;j++,n--)
	    {
	        if(n%j==0)
	        {
	            ans*=n/j;
	        }else
	        if(ans%j==0)
	        {
	            ans=ans/j*n;
	        }else
	        {
	            ans=(ans*n)/j;
	        }
	    }
	    return ans;
	}


	public static void main(String[] args) {
		System.out.println(Arrays.toString(getRow(13).toArray()));
	}
}