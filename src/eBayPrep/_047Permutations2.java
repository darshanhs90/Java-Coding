package LeetCodePractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _047Permutations2 {

	public static void main(String[] args) {
		permuteUnique(new int[]{1,1,2});
	}
	static List<List<Integer>> output;
	static Set<String> set;
	public static List<List<Integer>> permuteUnique(int[] nums) {
		output=new ArrayList<>();
		set=new HashSet<>();
		String str=(Arrays.toString(nums).replace(" ", "").replace("[", "").replace("]", "").replace(",", ""));
		permuteString("",str);
		System.out.println(output);
		return output;
	}

	private static void permuteString(String prefix, String str) {
		if(str.length()==0)
		{	
			List<Integer> list=new ArrayList<>();
			if(!set.contains(prefix)){
				for (int i = 0; i < prefix.length(); i++) {
					list.add(Integer.parseInt(prefix.charAt(i)+""));
				}
				output.add(list);
				set.add(prefix);
			}
			return;
		}
		for (int i = 0; i < str.length(); i++) {
			permuteString(prefix+str.charAt(i),str.substring(0,i)+str.substring(i+1));
		}

	}
}
