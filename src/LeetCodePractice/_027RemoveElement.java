package LeetCodePractice;

public class _027RemoveElement {

	public static void main(String[] args) {
		System.out.println(removeElement(new int[]{3,2,2,3},3));
	}

	public static int removeElement(int[] nums, int val) {
		int valPointer=0;
		for (int i = 0; i < nums.length; i++) {
			if(nums[i]!=val)
			{
				nums[valPointer]=nums[i];
				valPointer++;
			}
		}
		return valPointer;
	}
}
