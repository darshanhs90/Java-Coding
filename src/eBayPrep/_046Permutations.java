package eBayPrep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _046Permutations {

	public static void main(String[] args) {
		permute(new int[]{1,2,3});
	}
	static List<List<Integer>> outputList;
	public static List<List<Integer>> permute(int[] nums) {
		outputList=new ArrayList<>();
		printPermutations("",Arrays.toString(nums).replace(", ", "").replace("[", "").replace("]", ""));
		return outputList;

	}
	private static void printPermutations(String prefix,String str) {
		if(str.length()==0){
			List<Integer> aList=new ArrayList<>();
			for (int i = 0; i < prefix.length(); i++) {
				aList.add(Integer.parseInt(prefix.charAt(i)+""));
			}
			outputList.add(aList);
		}

		for (int i = 0; i < str.length(); i++) {
			printPermutations(prefix+str.charAt(i), str.substring(0,i)+str.substring(i+1));
		}
	}
}
