package LeetCodePerformancePractice;

import java.util.Arrays;
import java.util.Comparator;

public class _179LargestNumber {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		System.out.println(largestNumber(new int[]{3, 30, 34, 5, 9}));
	}
	public static String largestNumber(int[] nums) {
		String[] str=new String[nums.length];
		for (int i = 0; i < str.length; i++) {
			str[i]=nums[i]+"";
		}
		Arrays.sort(str,new Comparator<String>() {

			@Override
			public int compare(String a, String b) {
				return (b+a).compareTo(a+b);
			}
		});
		StringBuilder sb=new StringBuilder();
		for (int i = 0; i < str.length; i++) {
			sb.append(str[i]);
		}
		while(sb.length()>1 &&sb.charAt(0)=='0')
			sb.deleteCharAt(0);
		return sb.toString();


	}
}