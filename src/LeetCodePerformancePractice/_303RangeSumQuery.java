package LeetCodePerformancePractice;

public class _303RangeSumQuery {
	public static void main(String[] args) {

	}
	public class NumArray {
		int[] numsNew;
		public NumArray(int[] nums) {
			numsNew=new int[nums.length];
			int sum=0;
			for (int i = 0; i < nums.length; i++) {
				sum+=nums[i];
				numsNew[i]=sum;
			}
		}

		public int sumRange(int i, int j) {
			return i==0?numsNew[j]:numsNew[j]-numsNew[i-1];
		}
	}


}
