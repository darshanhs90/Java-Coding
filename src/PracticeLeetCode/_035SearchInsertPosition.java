package PracticeLeetCode;

public class _035SearchInsertPosition {
	public static void main(String[] args) {
		System.out.println(searchInsert(new int[] {1,3,5,6}, 5));
		System.out.println(searchInsert(new int[] {1,3,5,6}, 2));
		System.out.println(searchInsert(new int[] {1,3,5,6}, 7));
		System.out.println(searchInsert(new int[] {1,3,5,6}, 0));
	}
	
    public static int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
			if(nums[i] == target || target < nums[i])
			{
				return i;
			}
		}
        return nums.length;
    }
	
}

