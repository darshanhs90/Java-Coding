package LeetCodePractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _046Permutations {

	public static void main(String[] args) {
		permute(new int[]{1,2,3});
	}
	static List<List<Integer>> output;
	public static List<List<Integer>> permute(int[] nums) {
		output=new ArrayList<>();
		String str=(Arrays.toString(nums).replace(" ", "").replace("[", "").replace("]", "").replace(",", ""));
		permuteString("",str);
		return output;
	}

	private static void permuteString(String prefix, String str) {
		if(str.length()==0)
		{	
			List<Integer> list=new ArrayList<>();
			for (int i = 0; i < prefix.length(); i++) {
				list.add(Integer.parseInt(prefix.charAt(i)+""));
			}
			output.add(list);
			return;
		}
		for (int i = 0; i < str.length(); i++) {
			permuteString(prefix+str.charAt(i),str.substring(0,i)+str.substring(i+1));
		}

	}
}
