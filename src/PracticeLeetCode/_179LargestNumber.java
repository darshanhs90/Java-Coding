package PracticeLeetCode;

import java.awt.List;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

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
        if(nums==null||nums.length==0)
        	return "";
        LinkedList<String> list=new LinkedList();
        for (int i = 0; i < nums.length; i++) {
			list.add(nums[i]+"");
		}
        Collections.sort(list,new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return (o1+o2).compareTo(o2+o1);
			}
		});
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i));
		}
        while(sb.length()>1 && sb.charAt(0)=='0')
        	sb.deleteCharAt(0);
        return sb.toString();
    }
}