package eBayPrep;

import java.util.Arrays;
import java.util.Comparator;

public class _179LargestNumber {
	public static void main(String[] args) {
		System.out.println(largestNumber(new int[]{3, 30, 34, 5, 9}));
		System.out.println(largestNumber(new int[]{0,0}));
	}

	public static String largestNumber(int[] nums) {
		String[] arr=new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			arr[i]=String.valueOf(nums[i]);
		}
		Arrays.sort(arr,new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				String leftRight=o1+o2;
				String rightLeft=o2+o1;
				return -leftRight.compareTo(rightLeft);
			}
		});
		StringBuilder sb=new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]);
		}
		while(sb.length()>1 && sb.charAt(0)=='0')
			sb=sb.deleteCharAt(0);
		return sb.toString();
	}
}

