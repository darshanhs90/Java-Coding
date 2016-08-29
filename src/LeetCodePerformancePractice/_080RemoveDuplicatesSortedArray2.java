package LeetCodePerformancePractice;

public class _080RemoveDuplicatesSortedArray2 {
	public static void main(String[] args) {

	}
	public static int removeDuplicates(int[] nums) {
		if(nums==null||nums.length==0)
			return 0;
		int index=1;
		int element=nums[0];
		int elementCount=1;
		for (int i = 1; i < nums.length; i++) {
			if(nums[i]==element)
			{
				if(elementCount<2){
					elementCount++;
					nums[index]=nums[i];
					index++;
				}
			}
			else{
				element=nums[i];
				elementCount=1;
				nums[index]=nums[i];
				index++;
			}
		}
		return index;
	}
}
