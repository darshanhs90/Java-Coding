package LeetCodePractice;

public class _11ContainerMostWater {

	public static void main(String[] args) {
		System.out.println(maxArea(new int[]{}));
	}
	public static int maxArea(int[] height) {
		if(height.length==0||height.length==1)
			return 0;
		int max=Integer.MIN_VALUE;
		int left=0,right=height.length-1;
		while(left<right)
		{	
			int area=(right-left)*Math.min(height[left], height[right]);
			max=Math.max(max, area);
			if(height[left]>height[right])
			{
				right--;
			}
			else
				left++;
		}
		return max;
	}
}
