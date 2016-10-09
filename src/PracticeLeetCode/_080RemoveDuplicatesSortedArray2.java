package PracticeLeetCode;

public class _080RemoveDuplicatesSortedArray2 {
	public static void main(String[] args) {
		System.out.println(removeDuplicates(new int[]{1,1,1,2,2,3}));
	}
	public static int removeDuplicates(int[] nums) {
		if(nums==null||nums.length==0)
			return 0;
		int currElement=nums[0],currCount=1;
		int index=1;
		for (int i = 1; i < nums.length; i++) {
			if(nums[i]==currElement)
			{
				if(currCount==1)
				{
					currCount++;
					nums[index]=currElement;
					index++;
				}
			}
			else{
				currElement=nums[i];
				currCount=1;
				nums[index]=currElement;
				index++;
			}
		}
		return index;
	}
}
