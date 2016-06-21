package LeetCodePractice;

import java.util.HashSet;

public class _202HappyNumber {
	public static void main(String[] args) {
		System.out.println(isHappy(18));
		System.out.println(isHappy(19));
	}
	public static boolean isHappy(int n) {
		boolean exit=false;
		HashSet<Integer> set=new HashSet<>();
		while(!exit)
		{
			char arr[]=(n+"").toCharArray();
			int sum=0;
			for (int i = 0; i < arr.length; i++) {
				sum+=(Integer.parseInt(arr[i]+"")*Integer.parseInt(arr[i]+""));
			}
			if(sum==1)
				return true;
			if(set.contains(sum))
				return false;
			else{
				set.add(sum);
				n=sum;
			}
		}
		return exit;
	}
}

