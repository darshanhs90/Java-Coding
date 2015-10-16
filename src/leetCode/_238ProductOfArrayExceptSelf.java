package leetCode;

import java.util.Arrays;

/*
 * Link : https://leetcode.com/problems/product-of-array-except-self/
 */

public class _238ProductOfArrayExceptSelf {
	public int[] productExceptSelfWithDivision(int[] nums) {
		int outputArray[]=new int[nums.length];
		int product=1;
		for (int i = 0; i < outputArray.length; i++) {
			product*=nums[i];
		}
		for (int i = 0; i < outputArray.length; i++) {
			
			outputArray[i]=nums[i]!=0?product/nums[i]:0;
		}
		return outputArray;
	}
	
	public static int[] productExceptSelf(int[] nums) {
		int outputArray[]=new int[nums.length];
		int p1[]=new int[nums.length];
		int p2[]=new int[nums.length];
		p1[0]=1;
		p2[p2.length-1]=1;
		
		for (int i = 0; i < outputArray.length-1; i++) {
			p1[i+1]=p1[i]*nums[i];
		}
		System.out.println(Arrays.toString(p1));
		for (int i = outputArray.length-1;i>0; i--) {
			p2[i-1]=p2[i]*nums[i];
		}
		System.out.println(Arrays.toString(p2));
		for (int i = 0; i < p2.length; i++) {
			outputArray[i]=p1[i]*p2[i];
		}
		return outputArray;
	}
	public static void main(String[] args) {
		int t1[]=new int[]{1,2,3,4};
		System.out.println(Arrays.toString(productExceptSelf(t1)));
		
	}

}