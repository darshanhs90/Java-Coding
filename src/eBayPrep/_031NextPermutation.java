package eBayPrep;

public class _031NextPermutation {

	public static void main(String[] args) {
		nextPermutation(new int[]{1,2,3,4});
	}

	public static void nextPermutation(int[] nums) {
		StringBuilder sb=new StringBuilder();
		for (int i = 0; i < nums.length; i++) {
			sb.append(nums[i]);
		}
		printPermutation("",sb.toString());
	}

	private static void printPermutation(String prefix, String str) {
		if(str.length()==0){
			System.out.println(prefix);
			return;
		}
		
		for (int i = 0; i < str.length(); i++) {
			printPermutation(prefix+str.charAt(i), str.substring(0,i)+str.substring(i+1));
		}
	}
}
