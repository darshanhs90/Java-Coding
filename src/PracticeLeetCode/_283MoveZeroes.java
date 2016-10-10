package PracticeLeetCode;

public class _283MoveZeroes {
	public static void main(String[] args) {
		moveZeroes(new int[]{1, 0, 0, 3, 12});
		moveZeroes(new int[]{0, 1, 0, 3, 12});
	}
	public static void moveZeroes(int[] nums) {
		if(nums==null||nums.length<2)
			return;
		int index=0;
		for (int i = 0; i < nums.length; i++) {
			if(nums[i]!=0){
				nums[index]=nums[i];
				index++;
			}
		}
		for (int i = index; i < nums.length; i++) {
			nums[i]=0;
		}
	}

}
