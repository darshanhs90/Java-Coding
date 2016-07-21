package eBayPrep;

public class _011ContainerMostWater {

	public static void main(String[] args) {
		System.out.println(maxArea(new int[]{}));
	}
	public static int maxArea(int[] height) {
		if(height.length==0||height.length==1)
			return 0;
		int maxValue=Integer.MIN_VALUE;
		int left=0,right=height.length-1;
		int minHeight=0;
		while(left<right)
		{
			minHeight=Math.min(height[left], height[right]);
			int areaVal=minHeight*Math.abs(left-right);
			maxValue=Math.max(areaVal, maxValue);
			if(height[left]>height[right])
			{
				right--;
			}
			else
			{
				left++;
			}
		}
		return maxValue;
	}
}
