package LeetCodePractice;

import java.util.Arrays;

public class _033SearchInRotatedSortedArray {

	public static void main(String[] args) {
		nextPermutation(new int[]{1,1,5});
		//nextPermutation(new int[]{1,2,3,4,1});
		//nextPermutation(new int[]{1,1,1,5});

	}

	public static void nextPermutation(int[] nums) {
		String str=Arrays.toString(nums);
		String queryString=(str.replace(" ","").replace("[","").replace("]", "").replace(",", ""));
		Arrays.sort(nums);
		System.out.println("QueryString : "+queryString);
		String sortedString=(Arrays.toString(nums).replace(" ","").replace("[","").replace("]", "").replace(",", ""));
		System.out.println("Sorted String : "+sortedString);
		generatePermutations("",sortedString,queryString);
		if(output==null || output.length()==0)
		{
			output=sortedString;
		}
		for (int i = 0; i < nums.length; i++) {
			nums[i]=Integer.parseInt(output.charAt(i)+"");
		}
		System.out.println(Arrays.toString(nums));
	}
	static boolean next=false,outputFound=false;;
	static String output;
	private static void generatePermutations(String prefix,String str,String query) {
		int n=str.length();
		if(n==0){
			if(next && !outputFound)
			{
				output=prefix;
				next=false;
				outputFound=true;
			}
			if(prefix.contentEquals(query))
				next=true;
		}
		else
			for (int i = 0; i < n; i++) {
				generatePermutations(prefix+str.charAt(i), str.substring(0,i)+str.substring(i+1),query);
			}

	}
}
